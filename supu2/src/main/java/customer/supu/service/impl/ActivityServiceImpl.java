package customer.supu.service.impl;

import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.domain.Activity;
import customer.supu.domain.LotteryRecord;
import customer.supu.domain.PrizeStore;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.mapper.ActivityMapper;
import customer.supu.mapper.EmployeeMapper;
import customer.supu.mapper.LotteryRecordMapper;
import customer.supu.mapper.PrizeStoreMapper;
import customer.supu.po.Employee;
import customer.supu.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity> implements IActivityService{

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private LotteryRecordMapper lotteryRecordMapper;

    @Autowired
    private PrizeStoreMapper prizeStoreMapper;


    @Override
    public PageResponse selectAllByList(Activity activity) {
        List<Activity> activityList = activityMapper.selectPage(activity);
        for(Activity a : activityList){
            a.setStartDate(DateTimeUtil.timemillonToStr(Long.parseLong(a.getStartDate()) ,"yyyy-MM-dd HH:mm:ss"));
            a.setEndDate(DateTimeUtil.timemillonToStr(Long.parseLong(a.getEndDate()) ,"yyyy-MM-dd HH:mm:ss"));
        }
        int count = activityMapper.selectPageCount(activity);
        PageResponse response = new PageResponse();
        response.setRecords(activityList);
        response.setTotal(count);
        return response;
    }

    @Override
    public Activity queryActivityWithPrize(String activityId , String openId) {
        Activity activity = activityMapper.selectWithPrize(activityId);
        Employee employee = employeeMapper.selectByOpenid(openId);
        if(employee != null && employee.getEmployeeid() > 0){
            Map<String , Object> map = new HashMap<>();
            map.put("activityId",activityId);
            map.put("userId",employee.getEmployeeid());
            int joinNum = lotteryRecordMapper.selectJoinNum(map);
            activity.setUseNum(joinNum);
        }else{
            activity.setUseNum(0);
        }

        return activity;
    }


    @Override
    public PageResponse joinActivity(String openId, String activityId) {
        //判断是否拥有参加权限
        //1.是否绑定手机号码
        Employee employee = employeeMapper.selectByOpenid(openId);
        if(employee == null || employee.getMobilephone() == null){
            //没有权限
            return ResultCodeEnum.UN_BIND_PHONE.getResponse();
        }else{
            Activity activity = activityMapper.selectById(activityId);
            long now = System.currentTimeMillis();
            if(now < Long.parseLong(activity.getStartDate()) || now > Long.parseLong(activity.getEndDate())){
                //不在活动时间范围内
                return ResultCodeEnum.OUT_TIME.getResponse();
            }

            Map<String , Object> map = new HashMap<>();
            map.put("activityId",activityId);
            map.put("userId",employee.getEmployeeid());
            map.put("nowDay",DateTimeUtil.getDateWithoutTime(new Timestamp(System.currentTimeMillis())));
            int joinNum = lotteryRecordMapper.selectJoinNum(map);
            if(joinNum >= activity.getDescription()){
                //超出抽奖次数
                return ResultCodeEnum.OUT_NUMBER.getResponse();
            }else{
                //开始抽奖
                PrizeStore prizeStore = startJoin(activityId, employee.getEmployeeid() + "");
                if(prizeStore != null){
                    prizeStore.setStock(null);
                    prizeStore.setProbability(null);
                    prizeStore.setMax(null);
                    prizeStore.setStock(null);
                    return ResultCodeEnum.SUCCESS.getResponse(prizeStore);
                }else{
                    return ResultCodeEnum.FAIL.getResponse();
                }
            }
        }

    }

    /*
     * @author ll
     * @Description 抽奖
     * @date 2018/10/30 16:14
     * @param [activityId, userId]
     * @return customer.supu.domain.PrizeStore
     */
    private PrizeStore startJoin(String activityId , String userId){
        synchronized (activityId){
            //查出所有可用奖品
            List<PrizeStore> prizeStoreList = prizeStoreMapper.selectActivePrize(activityId);
            List<Integer> list = new ArrayList<>();
            int total = 0;
            list.add(total);
            if(prizeStoreList.size() > 0){
                for(int i = 0 ; i < prizeStoreList.size() ; i++){
                    PrizeStore prizeStore = prizeStoreList.get(i);
                        total += prizeStore.getProbability();
                        list.add(total);
                }
            }
            Random random = new Random();
            int result = random.nextInt(total);
            PrizeStore prizeStore = null;
            for(int i = 1 ; i < list.size() ; i++){
                if(result >= list.get(i-1) && result < list.get(i)){
                    prizeStore = prizeStoreList.get(i-1);
                    break;
                }
            }
            if(prizeStore != null){
                //奖品数量-1      type == 2是谢谢参与 不用-1
                if(prizeStore.getType() != 2){
                    PrizeStore p = new PrizeStore();
                    p.setId(prizeStore.getId());
                    p.setStock(prizeStore.getStock() - 1);
                    prizeStoreMapper.update(p);
                }
                //插入中奖纪录
                LotteryRecord record = new LotteryRecord();
                record.setCreateDate(System.currentTimeMillis() + "");
                record.setUserId(Integer.parseInt(userId));
                // 1 中奖 2 已兑奖
                record.setStatus(1);
                record.setPrizeId(prizeStore.getId());
                lotteryRecordMapper.insert(record);
                return prizeStore;
            }
        }
        return null;
    }


    @Override
    public PageResponse queryMyPrize(String openId, String activityId) {
        Employee employee = employeeMapper.selectByOpenid(openId);
        if(employee == null || employee.getMobilephone() == null){
            //没有权限
            return ResultCodeEnum.UN_BIND_PHONE.getResponse();
        }else{
            Map<String , Object> map = new HashMap<>();
            map.put("activityId",activityId);
            map.put("userId",employee.getEmployeeid());
            List<LotteryRecord> lotteryRecords = lotteryRecordMapper.selectMyPrize(map);
            return ResultCodeEnum.SUCCESS.getResponse(lotteryRecords);
        }
    }

    @Override
    public PageResponse queryRecordList(Map<String , Object> map) {
        List<LotteryRecord> recordList = lotteryRecordMapper.selectPageWithPrize(map);
        for(LotteryRecord l : recordList){
            l.setCreateDate(DateTimeUtil.timemillonToStr(Long.parseLong(l.getCreateDate()) ,"yyyy-MM-dd HH:mm:ss"));
        }
        int count = lotteryRecordMapper.selectCountWithPrize(map);
        PageResponse response = new PageResponse();
        response.setRecords(recordList);
        response.setTotal(count);
        return response;
    }
}

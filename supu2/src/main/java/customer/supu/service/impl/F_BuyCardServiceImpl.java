package customer.supu.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.po.Page;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CoachDao;
import customer.supu.dao.CourseExcGroupDao;
import customer.supu.dao.CourseExcTimeDao;
import customer.supu.dao.CourseStudioTimeDao;
import customer.supu.dao.EmployeeBuyCardDao;
import customer.supu.dao.EmployeeBuyCourseDao;
import customer.supu.dao.MemberCardDao;
import customer.supu.dao.StoreDao;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseExcTimeDto;
import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.dto.StoreDto;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;
import customer.supu.po.Coach;
import customer.supu.po.CourseExcGroup;
import customer.supu.po.CourseExcGroupExample;
import customer.supu.po.CourseExcTime;
import customer.supu.po.CourseExcTimeExample;
import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeBuyCardExample;
import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeBuyCourseExample;
import customer.supu.po.MemberCard;
import customer.supu.po.MemberCardExample;
import customer.supu.po.MemberCardExample.Criteria;
import customer.supu.service.CourseService;
import customer.supu.service.F_BuyCardService;
/**
 * 会员购买业务实现类
 * @author Administrator
 *
 */
@Service
public class F_BuyCardServiceImpl implements F_BuyCardService{

	@Autowired
	private MemberCardDao memberCardDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private CourseExcGroupDao courseExcGroupDao;


	@Autowired
	private CoachDao coachDao;


	@Autowired
	private  EmployeeBuyCardDao  employeeBuyCardDao;


	@Autowired
	private EmployeeBuyCourseDao employeeBuyCourseDao;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseExcTimeDao courseExcTimeDao;

	@Autowired
	private CourseStudioTimeDao courseStudioTimeDao;

	/**
	 * 查询所有会员卡
	 */
	@Override
	public List<MemberCard> selectAllByList(Page page,String cardtype) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("isuse", DataValidEnum.EFFECT.getCode());
		map.put("start", Integer.valueOf(page.getOffset()));
		map.put("end", Integer.valueOf(page.getLimit()));
		//判断会员卡类型不为空
		if (StringUtils.hasText(cardtype)) {
			String[] type=cardtype.split("[,，]");
			map.put("cardtype", type);
		}else{
			map.put("cardtype", null);
		}
		return memberCardDao.selectMcardByList(map);
	}

	/**
	 * 查询适用会员卡的所有门店
	 * @param  membercardid
	 */
	@Override
	public List<StoreDto> selectStoreByMembercardId(Integer membercardId) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (membercardId!=null) {
			map.put("membercardId", membercardId);
		}
		// 查询
		return storeDao.selectAllStore(map);
	}

	/**
	 * 查询适用会员卡的所有门店数量
	 * @param  membercardid
	 */
	@Override
	public Integer countByMembercardId(Integer membercardId) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (membercardId!=null) {
			map.put("membercardId", membercardId);
		}
		return storeDao.countByList(map);
	}

	/**
	 * 查询所有门店的精品团课(训练营)
	 */
	@Override
	public List<CourseExcGroupDto> selectCourseGroupList(Page page)throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (page.getOffset()!=null && page.getLimit()!=null) {
			map.put("start", Integer.parseInt(page.getOffset()));
			map.put("end", Integer.parseInt(page.getLimit()));
		}
		//查询所有训练营
		List<CourseExcGroupDto> list= courseExcGroupDao.selectAllCourseGroupList(map);
		//获取精品团课排期
		if (CollectionUtils.isNotEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {

				CourseExcGroupDto courseExcGroupDto=list.get(i);
				//获取该训练营  周几有课
				List<CourseExcTimeDto> dtos=courseService.selectExctimeByCourseId(courseExcGroupDto.getCourseid(),courseExcGroupDto.getSdate(),courseExcGroupDto.getEdate());
				courseExcGroupDto.setCourseExcTimeDtos(dtos);
			}
		}
		//设置一对多教练名称
		list=this.setCoachName(list);
		return list;
	}


	/**
	 * 获取训练营的 （周几） 开始结束  时间
	 * @param courseId
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws Exception
	 */
	public CourseExcGroupDto selectCourseGroupById(Integer courseId,String startDate,String endDate)throws Exception{
		CourseExcGroupDto courseExcGroupDto=new CourseExcGroupDto();

		//根据courseid 查询训练营排期
		List<CourseExcTimeDto> dtos=courseService.selectExctimeByCourseId(courseId,DateTimeUtil.getDateWithoutTime(startDate),DateTimeUtil.getDateWithoutTime(endDate));
		courseExcGroupDto.setCourseExcTimeDtos(dtos);
		/*CourseExcTimeExample example=new CourseExcTimeExample();
		example.createCriteria().andCourseidEqualTo(courseId).andStartdateEqualTo(startDate).andEnddateEqualTo(endDate);
		//根据课程id开始日期和结束日期  查出该课程在该日期下的  排期时间
		List<CourseExcTime> courseExcTimeList= courseExcTimeDao.selectByExample(example);

		//如果排期时间不为空，去除
		if(CollectionUtils.isNotEmpty(courseExcTimeList)){
			CourseExcTime courseExcTime= courseExcTimeList.get(0);
			List<CourseExcTimeDto> dtos=courseService.selectExctimeByCourseId(courseExcTime.getCourseid(),courseExcTime.getStartdate(),courseExcTime.getEnddate());
			courseExcGroupDto.setCourseExcTimeDtos(dtos);
		}*/
		return courseExcGroupDto;
	}

	/**
	 * 设置教练名称
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<CourseExcGroupDto> setCoachName(List<CourseExcGroupDto> list) throws Exception{
		if(CollectionUtils.isEmpty(list)){
			return list;
		}
		//遍历精品课程，查出课程对应的教练名称
		for(int i=0;i<list.size();i++){
			StringBuffer buffer=new StringBuffer();

			//获取课程的教练ids  例子：1,2,3
			String coachIds=list.get(i).getCoachs();
			if(StringUtils.hasText(coachIds)){
				//spilt成数组
				String[] coachIdss=coachIds.split("[,，]");

				//遍历数组
				for(int j=0;j<coachIdss.length;j++){
					Map<String,Object> map=new HashMap<String,Object>();

					//教练id
					map.put("coachId", coachIdss[j]);
					//查询教练信息
					Coach coach=coachDao.selectCoachById(map);

					if(coach !=null){
						buffer.append(coach.getNickname()+",");
					}
				}


				//设置教练名称
				list.get(i).setCoachnames(buffer.substring(0,buffer.length()-1));


			}

		}
		return list;
	}


    /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean hasBuyCard(HttpSession session,Integer memberCardid) throws Exception{
		Integer userId=(Integer) session.getAttribute("employeeId");
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		Date d=new Date();
		//用户id   且判断过期
		example.createCriteria().andUseridEqualTo(userId).andExpiretimeGreaterThan(new Date()).andBuytimeLessThanOrEqualTo(d).andMcardidNotEqualTo(memberCardid).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		List<EmployeeBuyCard> buCardList=employeeBuyCardDao.selectByExample(example);
     	if(CollectionUtils.isNotEmpty(buCardList)){
    		if(buCardList.size()>0){
    			throw new Exception("您已经购买同类型会员卡");
    		}

    	}

    	return false;
    }

    /**
     * 判断会员是否已经购买此精品团课
     * @param session
     * @param courseId  精品团课id
     * @param type  精品团课类型  type=2
     * @param startDate  开始日期
     * @param endDate  结束日期
     * @return
     * @throws Exception
     */
    public boolean hasBuyGroupCourse(HttpSession session,Integer courseId,Date startDate,Date endDate) throws Exception{



    	  Integer userId=(Integer) session.getAttribute("employeeId");
    	  EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();
          //根据 用户id，课程id以及课程类型     查出该用户是否购买了该训练营
          example.createCriteria().andUseridEqualTo(userId).andCourseidEqualTo(courseId).
          andCoursetypeEqualTo(CourseTypeEnum.COURSEGROUP.getCode()).andStatusEqualTo(DataValidEnum.EFFECT.getCode())
          .andStartdateEqualTo(startDate).andEnddateEqualTo(endDate);

          // 查询 是否购买该课程
          List<EmployeeBuyCourse> isBuyCourse=employeeBuyCourseDao.selectByExample(example);

          //Iterator<EmployeeBuyCourse> l=isBuyCourse.iterator();
          if(CollectionUtils.isNotEmpty(isBuyCourse)){
        	  throw new Exception("您已经购买此训练营");
          }

          //如果已购买的人数 >=该训练营的最大人数
          if(countEmployeeBuyCoursePeople(courseId,startDate,endDate)>=countCourseGroupPeople(courseId)){
	      	  throw new Exception("训练营已满");
	       }


          //开始日期已经修改，请重新进入训练营页面支付
          //isUpdDate(courseId, startDate, endDate);
    	   return false;
    }

    /**
     * 后台日期是否被修改过，如果修改了，需要从训练营列表页面重新进入
     * 根据课程id和课程开始结束时间 查询 排期表  是否存在
     * 存在则正确，不存在表示已经重新排期过；
     */
    public void isUpdDate(Integer courseId,Date startDate,Date endDate) throws Exception{
    	CourseExcTimeExample example=new CourseExcTimeExample();
    	example.createCriteria().andCourseidEqualTo(courseId).andStartdateEqualTo(startDate).andEnddateEqualTo(endDate);
    	Integer count=courseExcTimeDao.countByExample(example);
    	if(count<=0){
    		throw new Exception("后台日期已经被修改，请重新从训练营列表进入");
    	}

    }



    /**
     * 根据课程id  返回购买该训练营的人数
     * @param courseId
     * @param  startDate开始日期
     * @param  endDate结束日期
     * @return
     * @throws Exception
     */
    public Integer countEmployeeBuyCoursePeople(Integer courseId,Date startDate,Date endDate)throws Exception{
    	EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();
    	example.createCriteria().andCourseidEqualTo(courseId).
    	andCoursetypeEqualTo(CourseTypeEnum.COURSEGROUP.getCode()).andStartdateEqualTo(startDate).andEnddateEqualTo(endDate);
    	int count=employeeBuyCourseDao.countByExample(example);
    	return count;

    }

    /**
     * 根据课程id  返回该训练营的最大人数
     * @param courseId
     * @return
     * @throws Exception
     */
    public Integer countCourseGroupPeople(Integer courseId)throws Exception{

    	Integer count=0;
    	CourseExcGroup courseExcGroup=courseExcGroupDao.selectByPrimaryKey(courseId);
    	if(null !=courseExcGroup && null != courseExcGroup.getMaxpeople()){
    		count=courseExcGroup.getMaxpeople();
    	}
    	return count;
    }


	/**
	 * 查询所有工作室课程
	 */
	@Override
	public List<CourseExcGroupDto> selectCourseStudioList(Page page)throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (page.getOffset()!=null && page.getLimit()!=null) {
			map.put("start", Integer.parseInt(page.getOffset()));
			map.put("end", Integer.parseInt(page.getLimit()));
		}
		//查询
		List<CourseExcGroupDto> list= courseExcGroupDao.selectFontWxStudioList(map);
		return list;
	}

	/**
	 * 根据工作室课程id 查询某课程每一天 所有课程时间列表
	 * @param courseId  工作室课程id
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudioTimeDto> selectTimeListByStudioId(Integer courseId)throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("courseId", courseId);
		List<CourseStudioTimeDto> dtos=courseStudioTimeDao.selectTimeListByCourseId(map);
		return dtos;
	}
}

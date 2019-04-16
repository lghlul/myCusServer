package customer.supu.service;

import customer.supu.common.po.PageResponse;
import customer.supu.domain.Activity;

import java.util.Map;


public interface IActivityService extends IBaseService<Activity>{

    /*
     * @author ll
     * @Description 活动列表分页(后台)
     * @date 2018/10/31 10:55
     * @param [activity]
     * @return customer.supu.common.po.PageResponse
     */
    PageResponse selectAllByList(Activity activity);

    /*
     * @author ll
     * @Description 活动详情 (附带奖品列表 前台使用)
     * @date 2018/10/31 10:55
     * @param [activityId]
     * @return customer.supu.domain.Activity
     */
    Activity queryActivityWithPrize(String activityId , String openId);

    /*
     * @author ll
     * @Description 参与抽奖(前台使用)
     * @date 2018/10/31 10:55
     * @param [openId, activityId]
     * @return customer.supu.common.po.PageResponse
     */
    PageResponse joinActivity(String openId , String activityId);

    /*
     * @author ll
     * @Description 查找我的奖品 (前台使用)
     * @date 2018/10/31 10:56
     * @param [openId, activityId]
     * @return customer.supu.common.po.PageResponse
     */
    PageResponse queryMyPrize(String openId , String activityId);

    /*
     * @author ll
     * @Description 中奖列表（后台使用）
     * @date 2018/11/2 15:44
     * @param []
     * @return customer.supu.common.po.PageResponse
     */
    PageResponse queryRecordList(Map<String , Object> map);

}

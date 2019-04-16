package customer.supu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import customer.supu.common.po.Page;
import customer.supu.dto.CourseExcGroupDto;
import customer.supu.dto.CourseStudioTimeDto;
import customer.supu.dto.StoreDto;
import customer.supu.po.MemberCard;

/**
 * 会员购买业务接口
 * @author Administrator
 *
 */
public interface F_BuyCardService {

	/**
	 * 查询所有会员卡
	 */
	public List<MemberCard> selectAllByList(Page page,String cardtype) throws Exception;

	/**
	 * 查询适用会员卡的所有门店
	 * @param  membercardid
	 */
	public List<StoreDto> selectStoreByMembercardId(Integer membercardId)throws Exception;

	/**
	 * 查询适用会员卡的所有门店数量
	 * @param  membercardid
	 */
	public Integer countByMembercardId(Integer membercardId)throws Exception;
	/**
	 * 查询所有门店的精品团课
	 */
	public List<CourseExcGroupDto> selectCourseGroupList(Page page)throws Exception;

    /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean hasBuyCard(HttpSession session,Integer memberCardid) throws Exception;

    /**
     * 判断会员是否已经购买此精品团课
     * @param session
     * @param courseId  精品团课id
     * @param type  精品团课类型  type=2
     * @return
     * @throws Exception
     */
    public boolean hasBuyGroupCourse(HttpSession session,Integer courseId,Date startDate,Date endDate) throws Exception;


	/**
	 * 获取训练营的 （周几） 开始结束  时间
	 * @param courseId
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws Exception
	 */
	public CourseExcGroupDto selectCourseGroupById(Integer courseId,String startDate,String endDate)throws Exception;

	/**
	 * 查询所有工作室课程
	 */
	public List<CourseExcGroupDto> selectCourseStudioList(Page page)throws Exception;

	/**
	 * 根据工作室课程id 查询某课程每一天 所有课程时间列表
	 * @param courseId  工作室课程id
	 * @return
	 * @throws Exception
	 */
	public List<CourseStudioTimeDto> selectTimeListByStudioId(Integer courseId)throws Exception;
}

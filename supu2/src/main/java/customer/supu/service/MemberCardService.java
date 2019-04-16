package customer.supu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;


import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.dto.MemberCardDto;
import customer.supu.po.Employee;
import customer.supu.po.MemberCard;
import customer.supu.po.Order;


public interface MemberCardService {

	/**
	 * 查询所有会员卡
	 */
	public List<MemberCard> selectAllByList(Page page) throws Exception;


	/**
	 * 添加保存
	 */
	public void addSave(MemberCard memberCard)throws Exception;


	/**
	 * 编辑保存
	 */
	public void editSave(MemberCard memberCard)throws Exception;

	/**
	 * 获取所有未启用的会员卡
	 * @return
	 * @throws Exception
	 */
	public List<MemberCard> selectEnabledMemberCardList() throws Exception;



	/**
	 * 获取所有启用的会员卡
	 * @return
	 * @throws Exception
	 */
	public List<MemberCard> selectMemberCardList() throws Exception;


	/**
	 * 根据会员表里的会员卡id  查询该会员选择了哪些会员卡
	 * @param map
	 * @return
	 */
	//public List<MemberCardDto> selectMcardChecked(String chooseMcode)throws Exception ;
	/**
	 * 根据ids查询持有会员卡
	 * @param chooseMcode
	 * @return
	 * @throws Exception
	 */
	public List<MemberCard> selectMemberCardByIds(String chooseMcode) throws Exception;

	/**
	 * 将会员卡类型插入基础数据表
	 */
	public Integer insertMemberCardType(String basictype,String title)throws Exception;



	/**
	 * 根据id查询会员卡信息
	 * @param id
	 * @return
	 */
	public MemberCard selecMemberCardInfoById(Integer id)throws Exception;

	  /**
	   * 根据会员卡id删除会员卡
	   */
	  public void deleteCard(Integer id)throws Exception;

	  /**
	     * 根据用户id查询会员卡，并标记该用户是否购买该会员卡
	     * @param id
	     * @return
	     * @throws Exception
	     */
	 public List<MemberCardDto> selectMcardByUserId(Integer userId) throws Exception;

	 /**
		 * 查询会员卡信息 ，并且标记是否已经过期
		 * @param id 会员卡id
		 * @param session
		 * @return
		 * @throws Exception
		 */
	public MemberCardDto selecMCardInfoById(Integer id,HttpSession session)throws Exception;



	  /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean isBuyCard(HttpSession session) throws Exception;


    /**
     * 用户购买会员卡成功后
     * @param session
     * @param orderNumber 订单号
     * @throws Exception
     */

    public void employeeBuyCard(Integer userId,String orderNumber,Integer mCardId) throws Exception;


    /**
     * 用户购买课程 成功后
     * @param courseId 课程id
     * @param type 类型：0 表示 私教课    1：表示精品团课
     * @param totalClass 购买了几节课（私教）
     * @param orderNumber 订单号
     * @param  amount 金额
     * @throws Exception
     */
    public void employeeBuyCourse(Integer courseId,Integer type,Integer totalClass,String orderNumber,Integer userId,Integer isexperience,Date startDate,Date endDate) throws Exception;

    /**
     * 添加订单表
     * @param record
     * @throws Exception
     */
    public void addOrder(Order record) throws Exception;


    /**
     * 根据订单id 查询订单信息
     * @param order_Id 订单id
     * @return
     * @throws Exception
     */
    public Order selectOrder(Order record)throws Exception;



    /**
     * 根据微信openId获取登陆信息
     * @param openId
     * @return
     * @throws Exception
     */
    public Employee selectEmployeeByOpenId(String openId)throws Exception;





    /*
     * @author ll
     * @Description 用户购买私教课
     * @date 2018/11/5 15:22
     * @param [employeeBuyPri]
     * @return void
     */
	public PageResponse userBuyCourse(EmployeeBuyPri employeeBuyPri , String orderNumber) throws Exception;

}

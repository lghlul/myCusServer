package customer.supu.service;


import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.UserData;




public interface UserService {
	/**
	 * 查询所有会员
	 */
	public PageResponse selectAllByList(Page page, EmployeeBuyCard employeeBuyCard) throws Exception;

	/**
	 * 添加保存
	 */
	public void addSave(EmployeeBuyCard employeeBuyCard)throws Exception;


	/*/**
	 * 编辑保存
	 *//*
	public void editSave(MemberDto member)throws Exception;


	*//**
	 * 根据id查询会员信息
	 * @param id
	 * @return
	 *//*
	public Member selectMemberById(Integer id) throws Exception;

	   *//**
     * 购买会员卡之后，添加成员表
     *//*
    public void  insertMember(Date addTime,Integer memberCardId,String mobile)throws Exception;


	*//**
	 * 根据电话号码查询会员
	 * @param mobile
	 * @return
	 * @throws Exception
	 *//*
   public Member selectMemberByMobile(String mobile)throws Exception;

   *//**
    * 根据电话  更新 会员表的  会员过期时间
    * @param mobile 电话号码
    * @param dateExpireTime  过期时间
    *//*
   public void updMemberByMobile(String mobile,Date dateExpireTime)throws Exception;*/


	/**
	 * 根据id查询会员信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserData  selectMemberById(Integer id,Integer org) throws Exception;
	
	
	/**
	 * 	到普通用户中去查询 id
	 * @param id
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public UserData  selectuserById(Integer id) throws Exception;
	
	
	/**
	 * 	到会员用户中去查询 id
	 * @param id
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public UserData  selectvipById(Integer org) throws Exception;
	
	public void editsavevip(EmployeeBuyCard member) throws Exception ;
	public void editsaveuser(EmployeeBuyCard member) throws Exception ;
	/**
	 * 编辑保存
	 * @param member
	 * @throws Exception
	 */
	public void editSave(EmployeeBuyCard member)throws Exception;


	int delete(Integer id);

}

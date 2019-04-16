package customer.supu.service.impl;

import java.util.Date;
import java.util.List;


import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.StringUtils;
import customer.supu.common.utils.Utility;
import customer.supu.dao.EmployeeBuyCardDao;
import customer.supu.dao.EmployeeDao;
import customer.supu.dao.UserDao;
import customer.supu.jenum.DataValidEnum;
import customer.supu.jenum.MemberSourceEnum;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeBuyCardExample;
import customer.supu.po.EmployeeBuyCardExample.Criteria;
import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeExample;

import customer.supu.po.MemberCard;
import customer.supu.po.UserData;
import customer.supu.po.UserPO;
import customer.supu.service.F_LoginService;
import customer.supu.service.MemberCardService;
import customer.supu.service.MemberMiddleCardService;
import customer.supu.service.MemberService;
import customer.supu.service.UserService;

@Service
public class UserServiceImpl implements UserService{

//	@Autowired
//	private EmployeeBuyCardDao employeeBuyCardDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private EmployeeDao employeeDao;
	
	private UserData userData = null;
/*
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberMiddleCardDao memberMiddleCardDao;

	@Autowired
	private MemberMiddleCardService memberMiddleCardService;

	@Autowired
	private F_LoginService f_LoginService;

	@Autowired
	private EmployeeBuyCardDao employeeBuyCardDao;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * 查询所有会员
	 */
	@Override
	public PageResponse selectAllByList(Page page,  EmployeeBuyCard employeeBuyCard) throws Exception {

		PageResponse pageResponse=new PageResponse();
//		//创建查询对象
//		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
//		Criteria contion=example.createCriteria();
//		//给查询条件赋值
//		contion.andStatusEqualTo(DataValidEnum.EFFECT.getCode());
//
//		//判断会员名称是否为空
//		if (StringUtils.hasText(employeeBuyCard.getMembername())) {
//			contion.andMembernameLike("%"+employeeBuyCard.getMembername()+"%");
//		}
//		//如果电话不为空
//		if (StringUtils.hasText(employeeBuyCard.getPhonenumber())) {
//			contion.andPhonenumberLike("%"+employeeBuyCard.getPhonenumber()+"%");
//		}
		userData = new UserData();
		if(employeeBuyCard.getId()!=null) {
			userData.setId(employeeBuyCard.getId().toString());
		}
		userData.setName(employeeBuyCard.getMembername());
		userData.setOrg(employeeBuyCard.getOrg());
		userData.setPhone(employeeBuyCard.getPhonenumber());
		//总数
		int count = userDao.countByExample(userData);
		//分页条件
		userData.setLimitStart(Integer.valueOf(page.getOffset()));
		userData.setLimitEnd(Integer.valueOf(page.getLimit()));
//		example.setOrderByClause("addtime desc");

		List<UserPO> membersList=userDao.selectByExample(userData);
		pageResponse.setRecords(membersList);//数据
		pageResponse.setTotal(count);//总数
		return pageResponse;
	}

	/**
	 * 添加保存
	 */
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addSave(EmployeeBuyCard employeeBuyCard) throws Exception {

		//查询该号码是否已经添加过，如果添加过，则抛出异常
		selectMemberByMobile(employeeBuyCard.getPhonenumber(),employeeBuyCard.getMcardid(), null);

		//employeeBuyCardDao.insertSelective(employeeBuyCard);

		//插入会员和会员卡的中间表
		//addSaveMember_middle_MemberCard(member);

		// 插入注册表和会员购买会员卡表
		addEmployeeAndRegister(employeeBuyCard);
	}

	/**
	 * 插入注册表和会员购买会员卡表
	 * @param member
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void addEmployeeAndRegister(EmployeeBuyCard employeeBuyCard) throws Exception{
		EmployeeBuyCard record=new EmployeeBuyCard();


		if(null==employeeBuyCard.getMcardid() || employeeBuyCard.getMcardid()<=0){
			throw new Exception("请先添加会员卡");
		}
		//会员卡id
		record.setMcardid(employeeBuyCard.getMcardid());

		//判断是否注册

		Employee employee=selectEmployeeByPhone(employeeBuyCard.getPhonenumber());
		if(null ==employee){//需要注册

			Employee add_employee=new Employee();
			add_employee.setUsername(employeeBuyCard.getPhonenumber());
			add_employee.setPassword("123456");
			Integer id=addOutsideEmployee(add_employee);
			record.setUserid(id);

		}else{//已经注册
			record.setUserid(employee.getEmployeeid());
		}

		record.setBuytime(employeeBuyCard.getBuytime());
		record.setExpiretime(employeeBuyCard.getExpiretime());
		//成员来源:线下会员
		record.setMembersource(MemberSourceEnum.OFFLINEREG.getCode());
		record.setStatus(DataValidEnum.EFFECT.getCode());
		record.setAddtime(new Date());
		record.setMembername(employeeBuyCard.getMembername());
		record.setPhonenumber(employeeBuyCard.getPhonenumber());


		record.setStoreid(employeeBuyCard.getStoreid());

		//会员类型 ： 1：顾客  2：工作人员
		record.setMembertype(employeeBuyCard.getMembertype());

		//直接插入会员卡购买表  判断表中是否有值
		if (isBuyCard(record.getUserid(),employeeBuyCard.getMcardid())) {
			//如果购买会员卡表不为空
			EmployeeBuyCardExample example=new EmployeeBuyCardExample();
			example.createCriteria().andUseridEqualTo(record.getUserid());
			userDao.updateByExampleSelective(record, example);
			//memberDao.updateByPrimaryKeySelective(member);
		}else{//无值  直接插入

			userDao.insertSelective(record);
			//memberDao.insertSelective(member);
		}
	}




	/**
	 * 外面用户注册
	 */
	public 	Integer addOutsideEmployee(Employee employee) throws Exception {
		// 设置ecode
		employee.setEcode(employee.getUsername());
		employee.setCnname(employee.getUsername());
		employee.setFlag(DataValidEnum.EFFECT.getCode());
		employee.setPassword(Utility.getMd5Password(employee.getPassword()));
		employee.setMobilephone(employee.getUsername());
		//表示前台    注册用户
		employee.setIsback(0);

		//创建日期
		employee.setCreatedate(new Date());
		employeeDao.insertSelective(employee);
		Integer id=employee.getEmployeeid();
		return id;
	}


    /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean isBuyCard(Integer userId,Integer mcardid) throws Exception{

		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		example.createCriteria().andUseridEqualTo(userId).andMcardidEqualTo(mcardid);
		//查询
		List<UserPO> buCardList=userDao.selectByExample(userData);
     	if(CollectionUtils.isNotEmpty(buCardList)){
    		if(buCardList.size()>0){
    			return true;
    		}

    	}

    	return false;
    }
	/*/**
	 * 添加会员的时候，插入会员和会员卡的中间表
	 *//*
	public void addSaveMember_middle_MemberCard(MemberDto memberDto){
		List<memberMiddleCard> list=memberDto.getMemberMiddleCardList();
		//会员id
		Integer memberId=memberDto.getId();
		if(CollectionUtils.isNotEmpty(list)){
			for(int i=0;i<list.size();i++){

				memberMiddleCard middleCard=list.get(i);

				//如果会员卡id为空，就不插入中间表
				if(middleCard.getMembercardid() !=null && middleCard.getMembercardid()>0 ){
					if(middleCard.getBuytime()==null){
						middleCard.setBuytime(new Date());
					}

					//会员id
					middleCard.setMemberid(memberId);

					//有效
					middleCard.setStatus(DataValidEnum.EFFECT.getCode());

					memberMiddleCardDao.insertSelective(middleCard);
				}
			}
		}

	}

	*//**
	 * 编辑保存
	 *//*
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void editSave(MemberDto member) throws Exception {
		if(member.getId() ==null  || member.getId() <=0){
			throw new Exception("数据不完整，无法修改");
		}
		Member beforeMember=memberDao.selectByPrimaryKey(member.getId());
		if(beforeMember ==null){
			throw new Exception("没有该数据或数据已经被删除，无法修改");
		}
		//查询该号码是否已经添加过，如果添加过，则抛出异常
		selectMemberByMobile(member.getPhonenumber(), member.getId());



		member.setAddtime(beforeMember.getAddtime());
		member.setStatus(beforeMember.getStatus());
		//更新时间
		member.setRealsetime(new Date());
		member.setMembersource(beforeMember.getMembersource());
		memberDao.updateByPrimaryKey(member);

		//删除中间表
		memberMiddleCardService.deleteByMiddleMmberId(member.getId());

		//重新插入中间表
		addSaveMember_middle_MemberCard(member);


		//如果电话号码换了
		if(!beforeMember.getPhonenumber().equals(member.getPhonenumber())){
			//更新用户表  以及购买表的号码  以及开始  和到期结束时间
			updEmployeeMobile(beforeMember.getPhonenumber(), member.getPhonenumber(),member);

		}else{
			//如果电话没有换，只更新 购买表的号码以及开始和到期结束时间
			updEmployeeBuyCardExpireTime(null,member.getPhonenumber(), member.getBuytime(),member.getExpiretime());
		}

	}






	*//**
	 * 更新用户购买  会员卡的 的过期时间
	 *     oldmobile 旧电话号码    如果有值，表示号码修改过，需要更新购买表中的号码
	 * @param mobile
	 * @param expireTime
	 * @throws Exception
	 *//*
	public void updEmployeeBuyCardExpireTime(Integer userid,String mobile,Date buyTime,Date expireTime) throws Exception{
			Integer userId=0;
			//获取用户id
			if(null != userid && userid>0){
				 userId=userid;
			}else{
				userId=selectEmployeeByMobile(mobile);
			}

			EmployeeBuyCard record=new EmployeeBuyCard();
			record.setExpiretime(expireTime);
			record.setBuytime(buyTime);

			EmployeeBuyCardExample example=new EmployeeBuyCardExample();
			example.createCriteria().andUseridEqualTo(userId);

			employeeBuyCardDao.updateByExampleSelective(record, example);

	}

	*//**
	 * 根据电话查询用户id
	 * @param mobile
	 * @return
	 * @throws Exception
	 *//*
	public Integer selectEmployeeByMobile(String mobile) throws Exception{
		EmployeeExample example=new EmployeeExample();
		example.createCriteria().andUsernameEqualTo(mobile).andFlagEqualTo(DataValidEnum.EFFECT.getCode());

		List<Employee> employeeList=employeeDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(employeeList)){
			return employeeList.get(0).getEmployeeid();
		}else{
			throw new Exception("数据错误");
		}

	}


	/**
	 * 根据电话查询用户id  返回对象
	 * @param mobile
	 * @return
	 * @throws Exception
	 */

	public Employee selectEmployeeByPhone(String mobile) throws Exception{
		EmployeeExample example=new EmployeeExample();
		example.createCriteria().andMobilephoneEqualTo(mobile).andFlagEqualTo(DataValidEnum.EFFECT.getCode());

		List<Employee> employeeList=employeeDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(employeeList)){
			return employeeList.get(0);
		}else{
			return null;
		}

	}



	/**
	 *  在添加或者编辑之前  查询是否已经维护过该会员
	 * @param mobile  电话
	 * @param id 会员表主键id 编辑时传入,去除自己
	 * @throws Exception
	 */
	public void  selectMemberByMobile(String mobile,Integer mcardid,Integer id) throws Exception{
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		Criteria c= example.createCriteria();
		c.andPhonenumberEqualTo(mobile).andStatusEqualTo(DataValidEnum.EFFECT.getCode()).andMcardidEqualTo(mcardid);

		//编辑时传入，去除自己
		if(null !=id && id>0){
			c.andIdNotEqualTo(id);
		}

		//查询会员是否已经拥有
		List<UserPO> member=userDao.selectByExample(userData);

		//如果有值，提示已经存在
		if(CollectionUtils.isNotEmpty(member)){
			throw new Exception("该会员已经拥有这张会员卡");
		}

	}



	/*/**
	 * 根据id查询会员信息
	 * @param id
	 * @return
	 *//*
	public Member selectMemberById(Integer id) throws Exception {
		 return memberDao.selectByPrimaryKey(id);
	}





	*//**
	 * 购买会员卡之后，添加成员表
	 * @param addTime  添加时间
	 * @param memberCardId  会员卡id
	 * @param mobile 电话
	 * @throws Exception
	 *//*
    public void  insertMember(Date addTime,Integer memberCardId,String mobile)throws Exception{

    	Member record=new Member();
    	record.setAddtime(addTime);
    	record.setStatus(DataValidEnum.EFFECT.getCode());
    	record.setMembername(mobile);
    	record.setPhonenumber(mobile);

    	//公众号注册
    	record.setMembersource(MemberSourceEnum.PUBLICREG.getCode());
    	memberDao.insertSelective(record);
    }

    *//**
     * 购买会员卡之后插入成员中间表
     *//*
    public void insertMemberMiddleCard(Integer memberId,Date buyTime,Integer memberCardId){
    	memberMiddleCard record=new memberMiddleCard();
    	record.setBuytime(buyTime);
    	record.setStatus(DataValidEnum.EFFECT.getCode());
    	record.setMemberid(memberId);
    	record.setMembercardid(memberCardId);

    	memberMiddleCardDao.insert(record);

    }

	*//**
	 * 根据电话号码查询会员
	 * @param mobile
	 * @return
	 * @throws Exception
	 *//*
   public Member selectMemberByMobile(String mobile)throws Exception{
	   MemberExample example=new MemberExample();
	   example.createCriteria().andPhonenumberEqualTo(mobile).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
	  List<Member> member_List=memberDao.selectByExample(example);
	  if(CollectionUtils.isNotEmpty(member_List)){
		  return member_List.get(0);
	  }
	  return null;

   }

   *//**
    * 根据电话  更新 会员表的  会员过期时间
    * @param mobile 电话号码
    * @param dateExpireTime  过期时间
    *//*
   public void updMemberByMobile(String mobile,Date dateExpireTime)throws Exception{
	   Member record=new Member();
	   record.setExpiretime(dateExpireTime);

	   MemberExample example=new MemberExample();
	   example.createCriteria().andPhonenumberEqualTo(mobile);
	   memberDao.updateByExampleSelective(record, example);

   }


*/


	/**
	 * 根据id查询会员信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserData  selectMemberById(Integer id,Integer org) throws Exception {
		 return userDao.selectByPrimaryKey(id,org);
	}

	
	
	/**
	 * 	保存普通用户表信息---普通会员
	 * @param member
	 * @throws Exception
	 */
	public void editsaveuser(EmployeeBuyCard member) throws Exception {
//		if(member.getId() ==null  || member.getId() <=0){
//			throw new Exception("数据不完整，无法修改");
//		}
		UserData beforeMember=userDao.selectvipById(member.getId());//会员表查询数据
		if(beforeMember != null){//会员表查询到数据吧当前会员---删除会员表数据
			Integer resultint = userDao.deleteByPrimaryKey(member.getId());
			if(resultint<=0) {
				throw new Exception("查询到会员的数据，但是删除会员失败");
			}
		}
//		最后都更新 用户表的数据
		UserData beforeuser=userDao.selectuserById(member.getUserid());//会员表查询数据
		if(beforeuser== null){
			throw new Exception("当前修改操作的用户，未查询到用户");
		}
		
//		保存普通用户
		Employee employee = new Employee();
		employee.setEmployeeid(member.getUserid());
		employee.setUsername(member.getMembername());
		employee.setMobilephone(member.getPhonenumber());
		employee.setIdentity(member.getIdnumber());
		Integer resultuser = employeeDao.updateByPrimaryKeySelective(employee);
		if(resultuser== null || resultuser<=0){
			throw new Exception("用户表更新用户，异常");
		}
		
	}
	
	/**
	 * 	保存修改数据--存储为会员
	 * @param member
	 * @throws Exception
	 */
	public void editsavevip(EmployeeBuyCard member) throws Exception {
//		if(member.getId() ==null  || member.getId() <=0){
//			throw new Exception("数据不完整，无法修改");
//		}
		member.setUserid(member.getId());
		UserData beforeMember=userDao.selectvipByUserId(member.getUserid());//在会员表中查询数据查询到的数据
		UserData beforuser=userDao.selectuserById(member.getId());//在用户表中查询数据查询到的数据
		
		if(beforeMember == null){
//			throw new Exception("没有该数据或数据已经被删除，无法修改");
			Integer resultvip = userDao.insertSelective(member);//当前操作的用户不在会员表中，查询到会员表中
			if(resultvip == null || resultvip < 0) {
				throw new Exception("当前用户不在会员表中，但是插入失败");
			}
		}else {
			//查询到会员已经存在，更新当前会员
			Integer resultvip = userDao.updatevip(member);
			if(resultvip == null || resultvip < 0) {
				throw new Exception("当前用户已经在会员表中，但是更新失败");
			}
		}
	}
	
	
	/**
	 * 编辑保存
	 */
	@Override
	public void editSave(EmployeeBuyCard member) throws Exception {
		if(member.getId() ==null  || member.getId() <=0){
			throw new Exception("数据不完整，无法修改");
		}
		UserData beforeMember=userDao.selectByPrimaryKey(member.getId(),member.getOrg());
		if(beforeMember ==null){
			throw new Exception("没有该数据或数据已经被删除，无法修改");
		}
		//查询该号码是否已经添加过，如果添加过，则抛出异常
		//selectMemberByMobile(member.getPhonenumber(), member.getId(),member.getMcardid());

		userDao.updateByPrimaryKeySelective(member);

//
//		//如果电话号码换了
//		if(!beforeMember.getPhonenumber().equals(member.getPhonenumber())){
//			//更新用户表
//			updEmployeeMobile(beforeMember.getPhonenumber(), member.getPhonenumber());
//
//		}

	}



	/*
	 *  在添加或者编辑之前  查询是否已经维护过该会员
	 * @param mobile  电话
	 * @param id 会员表主键id 编辑时传入,去除自己
	 * @throws Exception
	 */
	public void  selectMemberByMobile(String mobile,Integer id) throws Exception{
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		Criteria c= example.createCriteria();
		c.andPhonenumberEqualTo(mobile).andStatusEqualTo(DataValidEnum.EFFECT.getCode());

		//编辑时传入，去除自己
		if(null !=id && id>0){
			c.andIdNotEqualTo(id);
		}

		//查询会员是否已经拥有
		List<UserPO> member=userDao.selectByExample(userData);

		//如果有值，提示已经存在
		if(CollectionUtils.isNotEmpty(member)){
			throw new Exception("已经存在该会员");
		}

	}


	/**
	 * 更新用户的手机号
	 * @param oldMobile 旧手机号
	 * @param newMobile 新手机号
	 * @throws Exception
	 */
	public void updEmployeeMobile(String oldMobile,String newMobile) throws Exception{
		Employee employee_new  =selectEmployeeByPhone(newMobile);
		if(employee_new!=null){
			throw new Exception("已经有该号码，您无法变更");
		}
		Employee employee=selectEmployeeByPhone(oldMobile);
		if(employee!=null){
			employee.setEcode(newMobile);
			employee.setUsername(newMobile);
			employee.setMobilephone(newMobile);
			employee.setCnname(newMobile);
			employeeDao.updateByPrimaryKeySelective(employee);

		}
	}

	@Override
	public UserData selectuserById(Integer id) throws Exception {
		return userDao.selectuserById(id) ;
	}

	
	/**
	 * 
	 * org不为-1表示是会员 到会员表去查询这个用户org就是主键ID
	 * (non-Javadoc)
	 * @see customer.supu.service.UserService#selectvipById(java.lang.Integer)
	 */
	@Override
	public UserData selectvipById(Integer org) throws Exception {
		return userDao.selectvipById(org);
	}

	/***
	 * 根据openid绑定手机号
	 *
	 */
//	public void bindEmployeeMobile(String mobile,String openid) throws Exception{
//
//		Employee employee_new  =selectByOpenid(openid);
//
//		employeeDao.updateByPrimaryKeySelective(employee_new);
//	}


	@Override
	public int delete(Integer id) {
		return employeeDao.delete(id + "");
	}
}

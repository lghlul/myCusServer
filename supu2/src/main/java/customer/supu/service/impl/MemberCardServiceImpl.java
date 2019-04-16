package customer.supu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;


import customer.supu.common.po.PageResponse;
import customer.supu.domain.EmployeeBuyPri;
import customer.supu.jenum.*;
import customer.supu.mapper.EmployeeBuyPriMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import customer.supu.common.po.Page;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.BasicDataDao;
import customer.supu.dao.EmployeeBuyCardDao;
import customer.supu.dao.EmployeeBuyCourseDao;
import customer.supu.dao.EmployeeDao;
import customer.supu.dao.MemberCardDao;
import customer.supu.dao.MemberCardStoreDao;


import customer.supu.dao.OrderDao;
import customer.supu.dto.MemberCardDto;
import customer.supu.po.BasicData;

import customer.supu.po.Employee;
import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeBuyCardExample;
import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeBuyCourseExample;

import customer.supu.po.EmployeeExample;
import customer.supu.po.MemberCard;
import customer.supu.po.MemberCardExample;
import customer.supu.po.MemberCardStore;
import customer.supu.po.MemberCardStoreExample;
import customer.supu.po.Order;
import customer.supu.po.OrderExample;





import customer.supu.service.MemberCardService;
import customer.supu.service.MemberService;

@Service
public class MemberCardServiceImpl implements MemberCardService {

	@Autowired
	private MemberCardDao memberCardDao;

	@Autowired
	private BasicDataDao basicDataDao;

/*	@Autowired
	private MemberMiddleCardDao memberMiddleCardDao;*/

	@Autowired
	private MemberCardStoreDao memberCardStoreDao;


	@Autowired
	private  EmployeeBuyCardDao employeeBuyCardDao;

	@Autowired
	private EmployeeDao employeeDao;



	@Autowired
	private  MemberService memberService;

	@Autowired
	private  EmployeeBuyCourseDao employeeBuyCourseDao;



	@Autowired
	private OrderDao orderDao;


	@Autowired
	private EmployeeBuyPriMapper employeeBuyPriMapper;


	@Override
	public List<MemberCard> selectAllByList(Page page) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("isuse", DataValidEnum.EFFECT.getCode());
		map.put("start", Integer.valueOf(page.getOffset()));
		map.put("end", Integer.valueOf(page.getLimit()));

		return memberCardDao.selectMcardByList(map);
	}

	/**
	 * 添加会员卡
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void addSave(MemberCard memberCard) throws Exception {
		//memberCard.setIsuse(isuse)
		memberCard.setAddtime(new Date());
		memberCardDao.insertSelective(memberCard);
		//插入中间表
		insertMiddleMeAndCard(memberCard.getStores(),memberCard.getId());
	}
	/**
	 * 编辑保存会员卡
	 */
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void editSave(MemberCard memberCard) throws Exception {
		if(memberCard.getId() ==null  || memberCard.getId() <=0){
			throw new Exception("数据不完整，无法修改");
		}
		MemberCard beforeMemberCard=memberCardDao.selectByPrimaryKey(memberCard.getId());
		if(beforeMemberCard ==null){
			throw new Exception("没有该数据或数据已经被删除，无法修改");
		}

		memberCard.setAddtime(beforeMemberCard.getAddtime());

		//更新时间
		memberCard.setRealsetime(new Date());

		memberCardDao.updateByPrimaryKeyWithBLOBs(memberCard);

		//删除中间表
		deleteMiddleMeAndCard(beforeMemberCard.getId());
		//插入中间表
		insertMiddleMeAndCard(beforeMemberCard.getStores(),beforeMemberCard.getId());

	}

	/**
	 * 获取所有启用的会员卡
	 * @return
	 * @throws Exception
	 */
	public List<MemberCard> selectMemberCardList() throws Exception {
		MemberCardExample example=new MemberCardExample();
		//启用状态
		example.createCriteria().andIsuseEqualTo(DataValidEnum.EFFECT.getCode());

		example.setOrderByClause("addTime DESC");
		List<MemberCard> memberCards=memberCardDao.selectByExampleWithBLOBs(example);

		return memberCards;
	}

	/**
	 * 根据会员表里的会员卡id  查询该会员选择了哪些会员卡
	 * @param chooseMcode:会员卡id
	 * @return
	 */
/*	public List<MemberCardDto> selectMcardChecked(List<memberMiddleCard> middleList) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		String[] ids=null;

		//如果id不为空
		if(StringUtils.hasText(chooseMcode)){
			//id塞入数组
			ids=chooseMcode.split(",");

		}else{
			 ids=new String[]{"-1"};

		}
		map.put("ids", ids);

		//查询 选中的会员卡
		List<MemberCardDto> resultMemberCard=memberCardDao.selectMcardChecked(map);

		return resultMemberCard;
	}*/
	/**
	 * 根据ids查询持有会员卡
	 * @param chooseMcode
	 * @return
	 * @throws Exception
	 */
	public List<MemberCard> selectMemberCardByIds(String chooseMcode) throws Exception{
		String[] ids=chooseMcode.split(",");
		List<String> idlist=Arrays.asList(ids);
		List<Integer> id=new ArrayList<Integer>();
		if (CollectionUtils.isEmpty(idlist)) {
			id.add(-1);
		}else{
			for (int i = 0; i < idlist.size(); i++) {
				id.add(Integer.valueOf(idlist.get(i)));
			}
		}

		MemberCardExample example=new MemberCardExample();
		example.createCriteria().andIdIn(id);
		return memberCardDao.selectByExampleWithBLOBs(example);


	}

	/**
	 * 将会员卡类型插入基础数据表
	 */
	public Integer insertMemberCardType(String basictype,String title) throws Exception {
		//创建map
		Map<String,Object> map=new HashMap<String,Object>();
		//塞入值
		map.put("basictype", basictype);
		//查询
		BasicData basicdata=basicDataDao.selectMaxId(map);

		//获取最大值
		Integer value=Integer.parseInt(basicdata.getBasicvalue())+1;

		//创建基础数据对象
		BasicData data=new BasicData();
		data.setBasictype(basictype);
		data.setBasicvalue(value.toString());
		data.setDescription(basicdata.getDescription());
		data.setFlag(DataValidEnum.EFFECT.getCode());
		data.setTitle(title);
		data.setVorder(100);
		//插入数据库
		basicDataDao.insertSelective(data);

		return value;
	}

	/**
	 * 根据id查询会员卡信息
	 * @param id
	 * @return
	 */
	public MemberCard selecMemberCardInfoById(Integer id)throws Exception{
		MemberCard card= memberCardDao.selectByPrimaryKey(id);
		if(null != card){
			return card;
		}else{
			throw new Exception();
		}

	}



	/**
	 * 查询会员卡信息 ，并且标记是否已经过期
	 * @param id 会员卡id
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public MemberCardDto selecMCardInfoById(Integer id,HttpSession session)throws Exception{
		MemberCardDto memberCardDto=null;
		Map<String,Object> map=new HashMap<String,Object>();
		Integer userId=(Integer) session.getAttribute("employeeId");
		map.put("userId", userId);
		map.put("mCardId", id);

		//根据用户id和会员卡id查询会员卡信息
		List<MemberCardDto> dtos= memberCardDao.selectMcardByUserId(map);
		if(CollectionUtils.isNotEmpty(dtos)){
			//会员卡信息
			memberCardDto=dtos.get(0);

			if(null !=memberCardDto.getBuytime()){
				//月份
				Integer months=getMonths(memberCardDto.getTimelong());


				String date=DateTimeUtil.getNextDate("yyyy-MM-dd", DateTimeUtil.getDateWithoutTime(memberCardDto.getBuytime()),0, months, 0);
				//判断当前日期是否在会员卡过期日期之前
				if(DateTimeUtil.isDateBefore(DateTimeUtil.getDateWithoutTime(new Date()), date)){
					//表示该会员卡已经过期
					memberCardDto.setIsoverdue(true);
				}
			}
		}
		return memberCardDto;

	}




	/**
	 * 根据会员卡id删除会员卡
	 */
	@Override
	public void deleteCard(Integer id) throws Exception {
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		//如果过期时间小于当前时间    也就是还没有过期
		example.createCriteria().andMcardidEqualTo(id).andExpiretimeGreaterThanOrEqualTo(new Date());
	    List<EmployeeBuyCard> empBuyCards=employeeBuyCardDao.selectByExample(example);
	    if(CollectionUtils.isNotEmpty(empBuyCards)){
	    	throw new Exception("有会员持有此卡，无法删除！");
	    }


		MemberCard memberCard=new MemberCard();
		//赋值
		memberCard.setId(id);
		//status设为0
		memberCard.setIsuse(DataValidEnum.NO_EFFECT.getCode());
		//将status变为0
		memberCardDao.updateByPrimaryKeySelective(memberCard);

	/*	//查询会员卡时长
		MemberCard mrCard=selecMemberCardInfoById(id);
		//返回月份
		Integer months=getMonths(mrCard.getTimelong());
		//创建查询对象
		memberMiddleCardExample example=new memberMiddleCardExample();
		//赋值
		example.createCriteria().andMembercardidEqualTo(id).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		//根据id查询中间表是否有值
		List<memberMiddleCard> memberMiddleCards=memberMiddleCardDao.selectByExample(example);
		//判断是否为空
		if (CollectionUtils.isNotEmpty(memberMiddleCards)) {
			//判断会员卡在有效期内
			for (int i = 0; i < memberMiddleCards.size(); i++) {
				memberMiddleCard cardMemberMiddleCard =	memberMiddleCards.get(i);
				String date=DateTimeUtil.getNextDate("yyyy-MM-dd", DateTimeUtil.getDateWithoutTime(cardMemberMiddleCard.getBuytime()),   0,   months,   0);
				//判断当前日期是否在会员卡过期日期之前
				if(DateTimeUtil.isDateBefore(DateTimeUtil.getDateWithoutTime(new Date()), date)){
					throw new Exception("有会员持有此卡，无法删除！");
				}
			}
		}
		MemberCard memberCard=new MemberCard();
		//赋值
		memberCard.setId(id);
		//status设为0
		memberCard.setIsuse(DataValidEnum.NO_EFFECT.getCode());
		//将status变为0
		memberCardDao.updateByPrimaryKeySelective(memberCard);*/
	}
	/**
	 * 获取所有未启用的会员卡
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<MemberCard> selectEnabledMemberCardList() throws Exception {
		MemberCardExample example=new MemberCardExample();
		//启用状态
		example.createCriteria().andIsuseEqualTo(DataValidEnum.NO_EFFECT.getCode());

		List<MemberCard> memberCards=memberCardDao.selectByExampleWithBLOBs(example);

		return memberCards;
	}


	/**
	 * 根据编号返回会员卡时长
	 */
    public Integer getMonths(int timeLong) {
        switch (timeLong) {
            case 1 :
                return 1;
            case 2 :
                return 3;
            case 3 :
                return 6;
            case 4 :
                return 12;
            case 5 :
                return 24;
            case 6 :
                return 36;
            default :
                return 0;
        }
    }

    /**
     * 根据会员卡id删除中间表
     */
    public void deleteMiddleMeAndCard(Integer id) throws Exception{
    	MemberCardStoreExample example=new MemberCardStoreExample();
    	//赋值
    	example.createCriteria().andMembercardidEqualTo(id).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
    	//删除
    	memberCardStoreDao.deleteByExample(example);
    }

    /**
     * 会员卡-门店  插入中间表
     * @param id 会员卡号
     * @param ids[i] 门店号
     */
    public void insertMiddleMeAndCard(String stores,Integer id) throws Exception{
    	if (StringUtils.hasText(stores)) {
        	//分割
        	String[] ids=stores.split(",");
        	//判断不为空
        	if (ids!=null) {
            	//循环插入中间表
            	for (int i = 0; i < ids.length; i++) {
            		//创建中间表对象
            		MemberCardStore memberCardStore=new MemberCardStore();
            		//放入值
            		memberCardStore.setMembercardid(id);
            		memberCardStore.setStoreid(Integer.parseInt(ids[i]));
            		memberCardStore.setStatus(DataValidEnum.EFFECT.getCode());
            		//插入
            		memberCardStoreDao.insertSelective(memberCardStore);
        		}
    		}
		}
    }

    /**
     * 根据用户id查询会员卡，并标记该用户是否购买该会员卡
     * @param id
     * @return
     * @throws Exception
     */
    public List<MemberCardDto> selectMcardByUserId(Integer userId) throws Exception{
    	Map<String,Object> map=new HashMap<String,Object>(); 
    	map.put("userId", userId);
    	return memberCardDao.selectMcardByUserId(map);
    }


/*	*//**
	 *   查询用户的会员卡   （如果停用，前台仍然显示）
	 * @param map
	 * @return
	 * @throws Exception
	 *//*
    public List<MemberCardDto> selectHasMcardByUserId(Integer userId) throws Exception{
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("userId", userId);
    	return memberCardDao.selectHasMcardByUserId(map);
    }*/

    /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean isBuyCard(HttpSession session) throws Exception{
		Integer userId=(Integer) session.getAttribute("employeeId");
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		Date d=new Date();
		//用户id   且判断过期
		example.createCriteria().andUseridEqualTo(userId).andExpiretimeGreaterThan(new Date()).andStatusEqualTo(DataValidEnum.EFFECT.getCode()).andBuytimeLessThanOrEqualTo(d);
		List<EmployeeBuyCard> buCardList=employeeBuyCardDao.selectByExample(example);
     	if(CollectionUtils.isNotEmpty(buCardList)){
    		if(buCardList.size()>0){
    			return true;
    		}

    	}

    	return false;
    }

    /**
     * 根据用户id 判断是否购买会员卡
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean hasBuyCard(Integer userId,Integer memberCardid) throws Exception{
		//Integer userId=(Integer) session.getAttribute("employeeId");
		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		Date d=new Date();
		//用户id   且判断过期
		example.createCriteria().andUseridEqualTo(userId).andExpiretimeGreaterThan(new Date()).andBuytimeLessThanOrEqualTo(d).andMcardidNotEqualTo(memberCardid).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		List<EmployeeBuyCard> buCardList=employeeBuyCardDao.selectByExample(example);
     	if(CollectionUtils.isNotEmpty(buCardList)){
    		if(buCardList.size()>0){
    			return true;
    		}

    	}

    	return false;
    }
    /**
     * 用户购买会员卡成功后
     * @param session
     * @param orderNumber 订单号      //会员卡id   未加   ，当会员卡为多张的时候，需要加
     * @throws Exception
     */
    @Transactional(rollbackFor=Throwable.class)
    public void employeeBuyCard(Integer userId,String orderNumber,Integer mCardId) throws Exception{
    	System.out.println("进入了————employeeBuyCard方法");
		//Integer userId=(Integer) session.getAttribute("employeeId");
		System.out.println("userId=="+userId);

		//查询会员卡信息，包括有效的月份
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mCardId", mCardId);
		MemberCardDto cardDto=memberCardDao.selectMcardInfo(map);
		//System.out.println("登陆request的userId=="+request.getSession().getAttribute("employeeId"));
		if(null == cardDto){
			throw new Exception();
		}



		//支付成功后根据订单号    更新订单状态
		updOrderState(orderNumber);

		//获取该会员卡的有效时间
		Integer month=MemberCardExpireTimeEnum.getMonth(cardDto.getMonth());




		EmployeeBuyCardExample example=new EmployeeBuyCardExample();
		//根据用户名查询是否购买会员卡
		example.createCriteria().andUseridEqualTo(userId);
		//是否拥有会员卡
		List<EmployeeBuyCard> result_list =employeeBuyCardDao.selectByExample(example);

		//获取用户名 （电话号码）
		//String username=(String) session.getAttribute("username");
		String username=username(userId);
		System.out.println("username=="+username);
		//表示之前已经购买过会员卡，那么更新有效时间就行
		if(CollectionUtils.isNotEmpty(result_list)){
		       EmployeeBuyCard record=	result_list.get(0);

		        Calendar cal = Calendar.getInstance();
		        //设置过期时间
		        cal.setTime(record.getExpiretime());

		       //日期加上几个月      表示获取会员卡过期时间
		    	cal.add(Calendar.MONTH, month);

		        record.setExpiretime(cal.getTime());
				employeeBuyCardDao.updateByPrimaryKeySelective(record);

		}else{//没有购买过会员卡 就添加
			Calendar cal = Calendar.getInstance();

			//日期加上几个月      表示获取会员卡过期时间
	    	cal.add(Calendar.MONTH, month);
			Date dateExpireTime= cal.getTime();

			//获取当前时间
			Date buyTime=new Date();

			EmployeeBuyCard record=new EmployeeBuyCard();
			record.setBuytime(buyTime);
			record.setExpiretime(dateExpireTime);
			record.setMcardid(cardDto.getId());
			record.setUserid(userId);
			record.setStatus(DataValidEnum.EFFECT.getCode());
			record.setAddtime(buyTime);
			record.setPhonenumber(username);
			record.setMembername(username);
			record.setMembersource(MemberSourceEnum.PUBLICREG.getCode());

			//会员类型，默认为顾客
			record.setMembertype(MemberTypeEnum.CUSTOMER.getCode());

			employeeBuyCardDao.insertSelective(record);

			//添加成员表
			//先要查询是否已经有该会员，如果没有就插入，有就不需要
		/*	if(null ==memberService.selectMemberByMobile(username)){
				 memberService.insertMember(buyTime,cardDto.getId(),username);
			}else{
				//更新member 表中 的过期   时间
				memberService.updMemberByMobile(username, dateExpireTime);//username就是电话号码

			}*/
		}

    }

    public String username(Integer userId){
    	Employee employee=employeeDao.selectByPrimaryKey(userId);
    	return employee.getUsername();
    }

    /**
     * 根据订单号更新    订单状态
     * @param orderNumber
     */
    public void updOrderState(String  orderNumber){

    	Order record=new Order();
    	//状态为成功
    	record.setIssuccess(DataValidEnum.EFFECT.getCode());

    	//record.setAmount(amount);
    	record.setBuytime(new Date());

    	OrderExample example=new OrderExample();
    	//订单号
    	example.createCriteria().andOrdernumberEqualTo(orderNumber);
    	orderDao.updateByExampleSelective(record, example);

    }


    /**
     * 用户购买课程 成功后
     * @param courseId 课程id
     * @param type 类型：0 表示 私教课    1：表示精品团课   2:表示工作室
     * @param totalClass 购买了几节课（私教）
     * @param orderNumber 订单号
     * @param  isexperience 是否为体验课 (只有私教课传入)
     * @param  startDate 开始日期（训练营时候传入）
     * @param  endDate 结束日期（训练营时候传入）
     * @throws Exception
     */
    @Transactional(rollbackFor=Throwable.class)
    public void employeeBuyCourse(Integer courseId,Integer type,Integer totalClass,String orderNumber,Integer userId,Integer isexperience,
    		Date startDate,Date endDate) throws Exception{
    	//Integer userId=(Integer) session.getAttribute("employeeId");
    	System.out.println("进入employeeBuyCourse，订单"+orderNumber);
  /*  	if(type!=0 && type !=1){
    		throw new Exception();
    	}*/
    	System.out.println("type="+type);
    	//更新订单状态
    	updOrderState(orderNumber);

    	System.out.println("updOrderState完毕");
    	EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();
    	//根据 用户id，课程id以及课程类型
    	example.createCriteria().andUseridEqualTo(userId).andCourseidEqualTo(courseId).andCoursetypeEqualTo(type);

    	// 查询 是否购买该课程或工作室
    	List<EmployeeBuyCourse> isBuyCourse=employeeBuyCourseDao.selectByExample(example);

    	if(CollectionUtils.isNotEmpty(isBuyCourse)){
    		//如果是同一个私教课或工作室，再购买一次,就加    总计课程

        	if(type==CourseTypeEnum.PRICOACH.getCode()  || type== CourseTypeEnum.STUDIO.getCode()){//私教课或者工作室
        		System.out.println("重复购买私教课或者工作室");
        		EmployeeBuyCourse buyCourse=isBuyCourse.get(0);

        		//如果已经购买相同的私教课   ,那就在私教课上直接添加
        		totalClass=buyCourse.getTotalclass()+totalClass;
        		buyCourse.setBuytime(new Date());
        		buyCourse.setTotalclass(totalClass);
        		employeeBuyCourseDao.updateByPrimaryKeySelective(buyCourse);

        	}else{

        		//表示训练营课程（精品团课）;直接再添加一条记录
        		InsertEmployeeBuyCourse(courseId, type, totalClass, userId, isexperience, startDate, endDate);
        	}

    	}else{

    		//如果为空，表示用户第一次购买该课程，添加
    		InsertEmployeeBuyCourse(courseId, type, totalClass, userId, isexperience, startDate, endDate);
    	}
    	//私教
		//SendAiliDaYuMsg.send(null, buyCourseDto.getPhonenumber(), "SMS_105885089", buyCourseDto.getCoachname(),(String)session.getAttribute("username"));

    }


    /**
     * 添加课程
     * @param courseId 课程id
     * @param type 类型：0 表示 私教课    1：表示精品团课
     * @param totalClass 购买了几节课（私教）
     * @param orderNumber 订单号
     * @param  isexperience 是否为体验课 (只有私教课传入)
     * @param  startDate 开始日期（训练营时候传入）
     * @param  endDate 结束日期（训练营时候传入）
     */
    public void InsertEmployeeBuyCourse(Integer courseId,Integer type,Integer totalClass,Integer userId,Integer isexperience,Date startDate,Date endDate){

    	EmployeeBuyCourse buyCourse=new EmployeeBuyCourse();
    	buyCourse.setBuytime(new Date());
    	buyCourse.setCourseid(courseId);
    	buyCourse.setCoursetype(type);
    	buyCourse.setStatus(1);
    	buyCourse.setTotalclass(totalClass);
    	buyCourse.setUserid(userId);
    	//是否为体验课（只有私教课有）
    	buyCourse.setIsexperience(isexperience);

    	//开始日期（只有训练营有开始结束日期）
    	buyCourse.setStartdate(startDate);
    	buyCourse.setEnddate(endDate);
    	employeeBuyCourseDao.insertSelective(buyCourse);
    }

    /**
     * 添加订单表
     * @param record
     * @throws Exception
     */
    public void addOrder(Order record) throws Exception{
    	orderDao.insertSelective(record);
    }


    /**
     * 根据订单id 查询订单信息
     * @param order_Id 订单id
     * @return
     * @throws Exception
     */
    public Order selectOrder(Order record)throws Exception{
    	System.out.println("进入了————selectOrder方法="+record.getOrdernumber());
    	OrderExample example=new OrderExample();
    	example.createCriteria().andOrdernumberEqualTo(record.getOrdernumber());
    	List<Order> resultOrders=orderDao.selectByExample(example);
    	System.out.println("进入了————selectOrder2方法");
    	if(CollectionUtils.isNotEmpty(resultOrders)){
    		System.out.println("list有值");
    		return resultOrders.get(0);
    	}
    	System.out.println("null");
    	return null;

    }


    /**
     * 根据微信openId获取登陆信息
     * @param openId
     * @return
     * @throws Exception
     */
    public Employee selectEmployeeByOpenId(String openId)throws Exception{
//    	EmployeeExample example=new EmployeeExample();
//    	example.createCriteria().andOpenidEqualTo(openId).andFlagEqualTo(DataValidEnum.EFFECT.getCode());
		Employee employee=employeeDao.selectByOpenid(openId);

		if(employee != null){
			return  employee;
		}
		else{
			return null;
		}
	}


	@Override
	public PageResponse userBuyCourse(EmployeeBuyPri employeeBuyPri , String orderNumber) throws Exception {
		updOrderState(orderNumber);

		EmployeeBuyPri buyPri = new EmployeeBuyPri();
		buyPri.setUserId(employeeBuyPri.getUserId());
		buyPri.setCoachId(employeeBuyPri.getCoachId());
		buyPri.setCourseId(employeeBuyPri.getCourseId());
		int count = employeeBuyPriMapper.selectPageCount(buyPri);
		int i = 0;
		//查询是否购买过 该私教
		if(count > 0){
			//购买过  更新数量
			i = employeeBuyPriMapper.updateBuyPriByCourse(employeeBuyPri);
		}else{
			//没有购买过
			i = employeeBuyPriMapper.insert(employeeBuyPri);
		}

		if(i > 0){
			return ResultCodeEnum.SUCCESS.getResponse();
		}else{
			return ResultCodeEnum.FAIL.getResponse();
		}

		/*if(employeeBuyPriMapper.insert(employeeBuyPri) > 0){
			return ResultCodeEnum.SUCCESS.getResponse();
		}else{
			return ResultCodeEnum.FAIL.getResponse();
		}*/


	}
}

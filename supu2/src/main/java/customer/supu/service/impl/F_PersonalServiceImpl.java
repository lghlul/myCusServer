package customer.supu.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import customer.supu.controller.F_LoginController;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.MapOfDistanceUtil;
import customer.supu.common.utils.OpenDoorHttpPost;
import customer.supu.common.utils.OpenDoorUtil;

import customer.supu.dao.CourseExcGroupDao;
import customer.supu.dao.EmployeeAppointCourseDao;
import customer.supu.dao.EmployeeBuyCourseDao;
import customer.supu.dao.EmployeeDao;
import customer.supu.dto.MemberCardDto;
import customer.supu.dto.OpenDoorDto;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;
import customer.supu.jenum.OpenDoorMsgEnum;
import customer.supu.jenum.StoreStatusEnum;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeAppointCourseExample;
import customer.supu.po.EmployeeBuyCourse;
import customer.supu.po.EmployeeBuyCourseExample;
import customer.supu.po.Store;
import customer.supu.service.F_PersonalService;
import customer.supu.service.MemberCardService;
import customer.supu.service.StoreService;


@Service
public class F_PersonalServiceImpl implements F_PersonalService{

	private Logger logger = Logger.getLogger(F_PersonalServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private EmployeeBuyCourseDao employeeBuyCourseDao;
	@Autowired
	private CourseExcGroupDao courseExcGroupDao;

	@Autowired
	private EmployeeAppointCourseDao employeeAppointCourseDao;

	@Autowired
	private StoreService storeService;
	/**
	 * 查询用户信息
	 * @return
	 */
	public Employee selectEmployeeInfo(HttpSession session) throws Exception{

		Integer employeeid=(Integer) session.getAttribute("employeeId");
		return employeeDao.selectByPrimaryKey(employeeid);
	}


	/**
	 * 根据用户id查询会员卡，并标记是否购买
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<MemberCardDto>  selectMcardByUserId(HttpSession session) throws Exception{

		Integer employeeid=(Integer) session.getAttribute("employeeId");

		List<MemberCardDto>  mList=memberCardService.selectMcardByUserId(employeeid);

		//标记购买
	/*	if(CollectionUtils.isNotEmpty(mList)){
			for(int i=0;i<mList.size();i++){
				MemberCardDto memberCard=memberCardService.selecMCardInfoById(mList.get(i).getId(), session);
				mList.set(i, memberCard);
			}
		}
*/
		return mList;
	}


	/**
	 * 用户开门
	 * @throws Exception
	 */
	public void  opendoor(HttpSession session,double lng,double lat) throws Exception{

		//获取用户id
		Integer employeeid=(Integer) session.getAttribute("employeeId");

		//是否购买会员卡
		Boolean buyCardResult= memberCardService.isBuyCard(session);//没有购买会员卡


		//购买会员卡  或者购买私教课   或者购买精品团课 任意一项满足就可以开门
		if(buyCardResult || isBuyGroupCourse(employeeid)==0 || isBuyPriCourse(employeeid)==0){
			//out_of_distance(lng, lat);
			//访问开锁接口
			if (lng>180 && lat>180) {
				throw new Exception("您手机不支持定位");
			}

			String lock_sn = out_of_distance(lng, lat);
			if("".equals(lock_sn)){
				throw new Exception("您距离我们太远了，请离我们更近一点!");
			}
			String[] snArr = lock_sn.split(";");

//			String  result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/openlock.html?appid="
//						+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
//						"WMJ16882104");

			String  result=null;
			for(String sn:snArr) {
				result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/openlock.html?appid="
								+ OpenDoorUtil.getAppId() + "&&appsecret=" + OpenDoorUtil.getAppSecret() + "",
						sn);
				System.out.println(result);
			}

		/*	String  result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/postlock.html?appid="
					+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
					"WMJ16882104");*/


			//验证开锁是否正确
			
			try {
				getOpenDoorDtoByJSON(result);
			} catch (Exception e) {
				// TODO: handle exception
				String  result1=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/openlock.html?appid="
						+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
						lock_sn);
				getOpenDoorDtoByJSON(result1);
			}

		}else{
			//都不满足  ，则提示没有购买会员卡,没有权限开门
			throw new Exception("您没有开门权限，可以购买会员或课程获取权限");

		}

	}

	public static void main(String[] args) throws Exception {
        String  result=null;
        String lock_sn = "WMJ16882703";
//		// 开锁
		try {
			 result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/openlock.html?appid="
					+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
					"WMJ16882703");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
//
//		// 查询锁状态

		try {
			  result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/lockstate.html?appid="
					+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
					"WMJ16882703");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String[] aa = {"1","2","2","2","2","2"};
//		System.out.println(aa[2]);

//		String aa = "daigen";
//		System.out.println(aa.substring(aa.indexOf("dai")+"dai".length(),aa.indexOf("xx")));


		/*try {
			String  result=OpenDoorHttpPost.sendPost("https://www.wmj.com.cn/api/postlock.html?appid="
					+OpenDoorUtil.getAppId()+"&&appsecret="+OpenDoorUtil.getAppSecret()+"",
					"WMJ16882493");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		/*Store store = new Store();
		store.setProvince("江苏省");
		store.setCity("南京市");
		store.setRegion("秦淮区");
		store.setAddress("光华路147号");
		Map<String, BigDecimal> dismap=MapOfDistanceUtil.getLatAndLngByAddress(getdetailAddress1(store));
		System.out.println(dismap);*/



	}

	public static String getdetailAddress1(Store store)throws Exception{

		StringBuffer buffer=new StringBuffer();
		if (StringUtils.hasText(store.getProvince())) {
			buffer.append(store.getProvince());
		}
		if (StringUtils.hasText(store.getCity())) {
			buffer.append(store.getCity());
		}
		if (StringUtils.hasText(store.getRegion())) {
			buffer.append(store.getCity());
		}
		if (StringUtils.hasText(store.getAddress())) {
			buffer.append(store.getAddress());
		}

		return buffer.toString();

	}



	/**
	 * 根据手机和门店之间的距离，判断能否开门
	 * @param lng
	 * @param lat
	 * @throws Exception
	 */
	public String out_of_distance(double lng,double lat) throws Exception{
		String lock_sn="";
//		if (lng>180 && lat>180) {
//			throw new Exception("您手机不支持定位");
//		}else{
			//创建map
			Map<String, BigDecimal> dismap=new HashMap<String,BigDecimal>();
			//获取开业门店
			List<Store> stores=storeService.selectOpendStore(StoreStatusEnum.BUSINESS.getCode());
			if (CollectionUtils.isNotEmpty(stores)) {
				for (Store store : stores) {
					//拼接门店详细地址
					//经度纬度
					logger.info("地址"+getdetailAddress(store));
					if(store.getLatitude()==0||store.getLongitude()==0){
						dismap=MapOfDistanceUtil.getLatAndLngByAddress(getdetailAddress(store));
						store.setLatitude(dismap.get("lat").doubleValue());
						store.setLongitude(dismap.get("lng").doubleValue());
						storeService.editSave(store);
					}else{
						dismap.put("lat", new BigDecimal(store.getLatitude()));
						dismap.put("lng", new BigDecimal(store.getLongitude()));
					}
					//计算手机与门店之间距离
					logger.info("未转换用户经纬度:"+lat+","+lng);
					double[] latAndLng=MapOfDistanceUtil.map_tx2bd(lat, lng);
					logger.info("门店经纬度:"+dismap.get("lng").doubleValue()+","+dismap.get("lat").doubleValue());
					logger.info("用户经纬度:"+latAndLng[1]+","+latAndLng[0]);
					Double dis=MapOfDistanceUtil.distanceOfTwoPoints(dismap.get("lng").doubleValue(), dismap.get("lat").doubleValue(), latAndLng[1], latAndLng[0]);
					System.out.println(dis);
					if (dis <= 500) {
						//throw new Exception("您距离我们太远了，请离我们更近一点!");
						if("铭苑广场".equals(store.getAddress().trim())){
							lock_sn="WMJ16882436";
							break;
						}else if("光华路147号".equals(store.getAddress().trim())){
							lock_sn="WMJ16882104";
							break;
						}else if("中山门大街99号".equals(store.getAddress().trim())){
							lock_sn="WMJ16882431";
							break;
						}else if("金源百货市场".equals(store.getAddress().trim())){
							lock_sn="WMJ16882493";
							break;
						}else if("仙林大学城".equals(store.getAddress().trim())){
							lock_sn="WMJ16882709;WMJ16882742";
							break;
						}else if("西桐路10-25号银龙景苑商业街".equals(store.getAddress().trim())){
							lock_sn="WMJ16882703";
							break;
						}


					}
				}
			}
//			if (CollectionUtils.isNotEmpty(stores)) {
//				Store store=stores.get(0);
//				//拼接门店详细地址
//				//经度纬度
//				dismap=MapOfDistanceUtil.getLatAndLngByAddress(getdetailAddress(store));
//				//计算手机与门店之间距离
//				double[] latAndLng=MapOfDistanceUtil.map_tx2bd(lat, lng);
//				Double dis=MapOfDistanceUtil.distanceOfTwoPoints(dismap.get("lng").doubleValue(), dismap.get("lat").doubleValue(), latAndLng[1], latAndLng[0]);
//				System.out.println(dis);
//				if (dis>500) {
//					throw new Exception("您距离我们太远了，请离我们更近一点!");
//				}
//			}
//		}
		return lock_sn;
	}

	/**
	 * 获取门店详细地址
	 */
	public static String getdetailAddress(Store store)throws Exception{

		StringBuffer buffer=new StringBuffer();
		if (StringUtils.hasText(store.getProvince())) {
			buffer.append(store.getProvince());
		}
		if (StringUtils.hasText(store.getCity())) {
			buffer.append(store.getCity());
		}
		if (StringUtils.hasText(store.getRegion())) {
			buffer.append(store.getCity());
		}
		if (StringUtils.hasText(store.getAddress())) {
			buffer.append(store.getAddress());
		}

		return buffer.toString();

	}
	/**
	 * 验证开锁是否正确
	 * @param result
	 * @return
	 * @throws Exception
	 */
	 public static OpenDoorDto getOpenDoorDtoByJSON(String result) throws Exception{
		 //将string类型转换成  json对象
		 JSONObject jsonObject=JSONObject.fromObject(result);

		 //将jso对象强制转换成  对象
		 OpenDoorDto dto=(OpenDoorDto) JSONObject.toBean(jsonObject,OpenDoorDto.class);
		 if(null !=dto){
			 //表示开门成功
			 if(dto.getState().equals(OpenDoorMsgEnum.SUCCESS.getCode().toString())
					 && dto.getState_code()==OpenDoorMsgEnum.SUCCESS.getCode()){

				 return dto;

			 }else{
				 //开门失败，返回失败信息
				 String failMsg= OpenDoorMsgEnum.getName(dto.getState_code());
				 throw new Exception(failMsg==null ? "很遗憾，系统问题导致开门失败，请联系工作人员":failMsg);
			 }
		 }else{
			 throw new Exception("很遗憾，系统问题导致开门失败，请联系工作人员");
		 }
		 //return dto;

	 }


	/**
	 * 训练营:又开始结束时间，所以判断是否在开始或结束之间，从而判断是否有权限开门
	 *
	 * 是否购买了精品团课，且结束时间大于当前时间
	 * @param employeeid
	 * @return   result 0 表示可以开门    1：表示精品团课已经过期无法再上或者没有购买
	 * @throws Exception
	 */
	public Integer isBuyGroupCourse(Integer employeeid)throws Exception{
		Integer  result= 1;

		//获取 yyyy-MM-hh格式的数据
		Date d=DateTimeUtil.getDateWithoutTime(DateTimeUtil.getDateWithoutTime(new Date()));
		//long d_time=d.getTime();
		EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();



		//查询训练营时间     训练营开始时间<=当前时间<=训练营结束时间，才有权限开门
		example.createCriteria().andUseridEqualTo(employeeid).andCoursetypeEqualTo(CourseTypeEnum.COURSEGROUP.getCode())
		.andEnddateGreaterThanOrEqualTo(d).andStartdateLessThanOrEqualTo(d);
		//example.setOrderByClause("buyTime desc");
		//查询精品团课
		List<EmployeeBuyCourse> list_buycourse=employeeBuyCourseDao.selectByExample(example);
		if(CollectionUtils.isEmpty(list_buycourse)){

			//没有购买课程
			result=1;

		}else{
			result=0;
	/*		//遍历精品团课，
			for(int i=0;i<list_buycourse.size();i++){
				EmployeeBuyCourse buyCourse=list_buycourse.get(i);
				//查询精品团课
				CourseExcGroup courseExcGroup=courseExcGroupDao.selectByPrimaryKey(buyCourse.getCourseid());
				//在课程   开始结束之间之内  才能开门
				if(null !=courseExcGroup && null !=courseExcGroup.getEnddate() && null !=courseExcGroup.getStartdate()
						&& courseExcGroup.getStartdate().getTime()<=d_time
						&& courseExcGroup.getEnddate().getTime()>=d_time){

					//赋值0表示拥有 开门权限
					result=0;
					break;
				}
			}*/

		}

		return result;
	}




	/**
	 * 判断是否购买私教课  和 判断是否购买工作室
	 *  1：查询是否购买私教或工作室
	 *  2：私教或工作室上了几节课
	 *
	 *
	 * @param employeeid
	 * @return  result 0 表示可以开门    1：表示私教课已经上完了，无法获得开门权限
	 */
	public Integer  isBuyPriCourse(Integer employeeid) throws Exception{
		Integer  result= 1;

		//Date d=new Date();
		EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();

		example.createCriteria().andUseridEqualTo(employeeid).
		andCoursetypeIn(Arrays.asList(new Integer[]{CourseTypeEnum.PRICOACH.getCode(),CourseTypeEnum.STUDIO.getCode()}));


		example.setOrderByClause("buyTime desc");
		//查询私教课
		List<EmployeeBuyCourse> list_buycourse=employeeBuyCourseDao.selectByExample(example);
		if(CollectionUtils.isEmpty(list_buycourse)){
			//result=1;//没有购买课程
			return result;
		}else{
			//购买多个私教课或工作室，满足一个就可以开门

			//遍历用户所买的课程或工作室    看是否已经上完
			for(int i=0;i<list_buycourse.size();i++){

				//获取当前购买私教课或工作室的信息
				EmployeeBuyCourse buyCourse=list_buycourse.get(i);

				//如果为体验课,那么购买七天后开门失效
				if(null != buyCourse.getIsexperience() && buyCourse.getIsexperience()==1){

					//购买时间+7天
					Calendar c=Calendar.getInstance();
					c.setTime(buyCourse.getBuytime());
					c.add(java.util.Calendar.DAY_OF_MONTH, 7);

					//七天后的日期  如果超过当前日期，表示有权限开门；
					//如果七天后的日期在当前日期之前，没有权限开门；     重新循环；
					if(c.getTime().before(new Date())){
						continue;
					}
				}

		/*		String date_string=DateTimeUtil.getDateWithoutTime(d);

				//获取当前日期  2017-08-10
				Date date_withoutTime=DateTimeUtil.getDateWithoutTime(date_string);

				//获取时分10：30
				String time=DateTimeUtil.getCurrTime_withoutSec(d);


				//查询预约表有没有预约  ，且预约的年月日=当前时间    以及  预约开始时间<当前时分<预约结束时间
				EmployeeAppointCourseExample appointCourseExample=new EmployeeAppointCourseExample();
				appointCourseExample.createCriteria().andUseridEqualTo(employeeid).andCourseidEqualTo(buyCourse.getCourseid()).andTypeEqualTo(CourseTypeEnum.PRICOACH.getCode()).
				andAppointtimeEqualTo(date_withoutTime).andStarttimeLessThanOrEqualTo(time).andEndtimeGreaterThan(time);

				//又符合条件的可以开门
				Integer count=employeeAppointCourseDao.countByExample(appointCourseExample);

				if(count>0){
					//赋值0表示拥有 开门权限
					result=0;

					break;
				}*/
				//查询该私教课程 预约了几节课程
				EmployeeAppointCourseExample appointCourseExample=new EmployeeAppointCourseExample();

				//.andAddtimeLessThanOrEqualTo(d)
				//appointCourseExample.createCriteria().andCourseidEqualTo(buyCourse.getCourseid()).andTypeEqualTo(CourseTypeEnum.PRICOACH.getCode());
				//根据课程id,课程类型（分为私教课和工作室）
				appointCourseExample.createCriteria().andCourseidEqualTo(buyCourse.getCourseid()).
				andTypeEqualTo(buyCourse.getCoursetype()).andStatusEqualTo(DataValidEnum.EFFECT.getCode());

				//已经上过的    预约课程数
				Integer count=employeeAppointCourseDao.countByExample(appointCourseExample);

				if(buyCourse.getTotalclass()>count){//表示购买的还没有上完,可以开门
					//赋值0表示拥有 开门权限
					result=0;

					break;
				}
			}

		}

		return result;

	}



	/**
	 * 判断该用户是否购买私教课
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public boolean isBuyPriCoach(HttpSession session) throws Exception{
		//获取用户id
		Integer employeeid=(Integer) session.getAttribute("employeeId");

		//EmployeeBuyCourse buyCourse=new EmployeeBuyCourse();
		EmployeeBuyCourseExample example=new EmployeeBuyCourseExample();
		example.createCriteria().andUseridEqualTo(employeeid).andCoursetypeEqualTo(CourseTypeEnum.PRICOACH.getCode());
		List<EmployeeBuyCourse> e_list= employeeBuyCourseDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(e_list)&& e_list.size()>0){
			return true;
		}else{
			return false;
		}

	}




}

package customer.supu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CoachTimeDao;
import customer.supu.dto.CoachTimeDetailDto;
import customer.supu.dto.CoachTimeDto;
import customer.supu.dto.CoachTimeEditDto;
import customer.supu.jenum.CourseDateTypeEnum;
import customer.supu.jenum.DateDayEnum;
import customer.supu.po.Coach;
import customer.supu.po.CoachTime;
import customer.supu.po.CoachTimeExample;
import customer.supu.service.PriCourseTimeService;

@Service
public class PriCourseTimeServiceImpl implements PriCourseTimeService{

	@Autowired
	private  CoachTimeDao coachTimeDao;

	/**
	 * 保存
	 * @param coachTimeDto
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void addSave(CoachTimeDto coachTimeDto) throws Exception{
	/*	if(coachTimeDto.getType()==CourseDateTypeEnum.DAY.getCode()){//每天

		}else if(coachTimeDto.getType()==CourseDateTypeEnum.WEEK.getCode()){//每周

		}else if(coachTimeDto.getType()==CourseDateTypeEnum.SPECIFIEDDATE.getCode()){//指定时间

		}*/
		addTime(coachTimeDto);

	}



	/**
	 * 添加选择时间类型
	 * @param coachTimeDto
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public  void addTime(CoachTimeDto coachTimeDto) throws Exception{
		List<Coach> coachList= coachTimeDto.getCoachs();

		if(CollectionUtils.isNotEmpty(coachList)){

			//获取当前年月  如：2017-08
			//String yearMoonth=getCurrentYmonth();
			String yearMoonth=coachTimeDto.getSelectymonth();
			//循环教练
			for(int i=0;i<coachList.size();i++){
				//获取教练id
				Coach coach=coachList.get(i);
				if(null ==coach.getId()){
					continue ;
				}

				//查询该教练当月 是否已经设置过  时间了
				List<CoachTime> coachTimeList=coachTimeList(coach.getId(), yearMoonth);

				//为空表示没有设置过
				if(CollectionUtils.isEmpty(coachTimeList)){
					//获取批量添加单独值
					List<CoachTimeDetailDto> coachTimeList_add= coachTimeDto.getCoachTimeList();

					//设置coachId到每一个批量插入的list中
					coachTimeList_add=setCoachId(coachTimeList_add, coach.getId(),coachTimeDto.getSelectymonth());


					if(CollectionUtils.isNotEmpty(coachTimeList_add)){
						//for(int j=0;j<coachTimeList_add.size();j++){

						//批量添加
							if(coachTimeList_add.get(0).getType()==CourseDateTypeEnum.DAY.getCode()){//每天
								addDay(coachTimeList_add,coachTimeDto.getSelectymonth());
							}else if(coachTimeList_add.get(0).getType()==CourseDateTypeEnum.WEEK.getCode()){//每周

							}else if(coachTimeList_add.get(0).getType()==CourseDateTypeEnum.SPECIFIEDDATE.getCode()){//指定时间
								specifiedDate(coachTimeList_add);
							}
						//}
					}

				}else{//已经设置过时间了
					throw new Exception("教练:【"+coach.getCoachname()+"】已经设置过时间，请单独前往编辑页面设置！");
				}



			}
		}

	}

	/**
	 * 根据指定日期来插入
	 * @throws Exception
	 */
	public void  specifiedDate(List<CoachTimeDetailDto> coachTimeList_add) throws Exception{

		if(CollectionUtils.isNotEmpty(coachTimeList_add)){

			for(int i=0;i<coachTimeList_add.size();i++){
				//获取开始结束时间对象
				CoachTimeDetailDto dto= coachTimeList_add.get(i);
				if(!(null !=dto && StringUtils.hasText(dto.getStartTime()) && StringUtils.hasText(dto.getEndTime())) ){
					//没有开始和结束时间就移除
					coachTimeList_add.remove(i);
					i--;
				}

			}

		}
		if(CollectionUtils.isNotEmpty(coachTimeList_add)){
			//批量添加
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("list", coachTimeList_add);
			coachTimeDao.insertCourseTimeList(map);
		}

	}







	/**
	 * 每天
	 * @param coachTimeList_add
	 * getSelectymonth:选择的月份  塞入批量提交
	 * @throws Exception
	 */
	public void addDay(List<CoachTimeDetailDto> coachTimeList_add,String getSelectymonth) throws Exception{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd");

		List<CoachTimeDetailDto> resultList=new ArrayList<CoachTimeDetailDto>();
		//获取这个月所有的日期
		List<Date> l_date=getAllTheDateOftheMonth(new Date());
		//遍历日期
		for(Date date: l_date){
			//每天添加的开始结束时间  不为空
			if(CollectionUtils.isNotEmpty(coachTimeList_add)){

				for(int i=0;i<coachTimeList_add.size();i++){

					//获取开始结束时间对象
					CoachTimeDetailDto dto= coachTimeList_add.get(i);
					if(null !=dto && StringUtils.hasText(dto.getStartTime()) && StringUtils.hasText(dto.getEndTime()) ){
						CoachTimeDetailDto result_dto=new CoachTimeDetailDto();
						//获取到该日期的日子
						String day=dateFormat.format(date);

						//塞进数据库

						result_dto.setDay(day);
						result_dto.setAddTime(new Date());
						result_dto.setCoachId(dto.getCoachId());
						result_dto.setEndTime(dto.getEndTime());
						result_dto.setSelectYmonth(dto.getSelectYmonth());
						result_dto.setStartTime(dto.getStartTime());
						result_dto.setType(dto.getType());


						resultList.add(result_dto);


					}else{//没有开始和结束时间就移除
						coachTimeList_add.remove(i);
						i--;
					}


				}

			}
		}
		if(CollectionUtils.isNotEmpty(resultList)){
			//批量添加
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("list", resultList);
			coachTimeDao.insertCourseTimeList(map);
		}
	}


	/**
	 * 将批量插入的list赋值 教练id 以及选择年月
	 * @param coachTimeList_add
	 * @return
	 */
	public List<CoachTimeDetailDto> setCoachId(List<CoachTimeDetailDto> coachTimeList_add,Integer coachId,String yearMoonth){
		Date d=new Date();
		if(CollectionUtils.isNotEmpty(coachTimeList_add)){
			for(int i=0;i<coachTimeList_add.size();i++){
				coachTimeList_add.get(i).setCoachId(coachId);

				//选择年月
				coachTimeList_add.get(i).setSelectYmonth(yearMoonth);
				//当前时间
				coachTimeList_add.get(i).setAddTime(d);
			};

		}
		return coachTimeList_add;

	}
	/**
	 * 根据教练id和日期                  查询该教练当月 是否已经设置过  时间了
	 * @param coachId
	 * @return
	 */
	public List<CoachTime> coachTimeList(Integer coachId,String selectymonth){
		CoachTimeExample example=new CoachTimeExample();
		example.createCriteria().andCoachidEqualTo(coachId).andSelectymonthEqualTo(selectymonth);
		return coachTimeDao.selectByExample(example);
	}

	//获取当前年月   2017-08
	public String  getCurrentYmonth(){
		Date d=new Date();
		SimpleDateFormat yMonth=new SimpleDateFormat("yyyy-MM");
		return yMonth.format(d);
	}



	/**
	 * 获取当月的所有日期
	 * @param date
	 * @return
	 */
	private static List<Date> getAllTheDateOftheMonth(Date date) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		int month = cal.get(Calendar.MONTH);
		while(cal.get(Calendar.MONTH) == month){
			list.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}


	/**
	 * 添加周
	 * @param coachTimeList_add
	 */
	public void addWeek(List<CoachTimeDetailDto> coachTimeList_add){
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd");

		//获取这个月所有的日期
		List<Date> l_date=getAllTheDateOftheMonth(new Date());
		//遍历日期
		for(Date date: l_date){
			//每天添加的开始结束时间  不为空
			if(CollectionUtils.isNotEmpty(coachTimeList_add)){
				for(int i=0;i<coachTimeList_add.size();i++){
					//获取开始结束时间对象
					CoachTimeDetailDto dto= coachTimeList_add.get(i);

					//获取当前日期的周
					int week=DateTimeUtil.getDayOfWeek(date);

					//和前台传来的对比，如果相等
					if(dto.getWeek()==week){
						//dto
					}

				/*	//开始结束时间
					if(null !=dto && StringUtils.hasText(dto.getStartTime()) && StringUtils.hasText(dto.getEndTime())){

						//获取当前日期是周几
						int week=DateTimeUtil.getDayOfWeek(date);
						//如果相等
						if(dto.getWeek()==week){

						}

						//获取到该日期的日子
						String day=dateFormat.format(date);
						//塞进数据库
						dto.setDay(day);
					}else{
						coachTimeList_add.remove(i);
						i--;
					}*/

				}

			}

		}

		//批量添加
	}

	/**
	 * 获取教练的  时间
	 * @param coachId  教练id
	 * @param date 日期
	 * @return
	 * @throws Exception
	 */
	public CoachTimeEditDto selectPriCourseTime (Integer coachId,String date) throws Exception{
		//获取年月
		String selectYmonth=getCurrentYmonth(date);

		CoachTimeExample example=new CoachTimeExample();

		//根据教练id和年月查询   私教的时间
		example.createCriteria().andCoachidEqualTo(coachId).andSelectymonthEqualTo(selectYmonth);

		example.setOrderByClause("DAY ASC, starttime ASC");//顺序排列
		List<CoachTime> list_coachTime=coachTimeDao.selectByExample(example);

		//将该月每天的时间都放在对象中
		CoachTimeEditDto dto=selectPriCourseDtoTime(list_coachTime);
		return dto;

	}

	public CoachTimeEditDto selectPriCourseDtoTime(List<CoachTime> coachTimeList ) throws Exception{

		CoachTimeEditDto dto=new CoachTimeEditDto();

		List<CoachTime> coachTimeAddList01=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList02=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList03=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList04=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList05=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList06=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList07=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList08=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList09=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList10=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList11=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList12=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList13=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList14=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList15=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList16=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList17=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList18=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList19=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList20=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList21=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList22=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList23=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList24=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList25=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList26=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList27=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList28=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList29=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList30=new ArrayList<CoachTime>();
		List<CoachTime> coachTimeAddList31=new ArrayList<CoachTime>();
		if(CollectionUtils.isNotEmpty(coachTimeList)){
			for(int i=0;i<coachTimeList.size();i++){
				//获取时间对象
				CoachTime coachTime=coachTimeList.get(i);
				//1号
				if(coachTime.getDay().equals(DateDayEnum.First.getDesc())){
					//添加教练时间

					coachTimeAddList01.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Second.getDesc())){

					coachTimeAddList02.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Third.getDesc())){

					coachTimeAddList03.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Fouth.getDesc())){
					//清空list
					coachTimeAddList04.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Fifth.getDesc())){

					coachTimeAddList05.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Sixth.getDesc())){

					coachTimeAddList06.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Seventh.getDesc())){

					coachTimeAddList07.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Eighth.getDesc())){

					coachTimeAddList08.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Ninth.getDesc())){
					//清空list

					coachTimeAddList09.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Tenth.getDesc())){

					coachTimeAddList10.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Eleventh.getDesc())){

					coachTimeAddList11.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twelfth.getDesc())){
					coachTimeAddList12.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Thirteenth.getDesc())){

					coachTimeAddList13.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Fourteenth.getDesc())){

					coachTimeAddList14.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Fifteenth.getDesc())){

					coachTimeAddList15.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Sixteenth.getDesc())){

					coachTimeAddList16.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Seventeenth.getDesc())){

					coachTimeAddList17.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Eighteenth.getDesc())){

					coachTimeAddList18.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Nineteenth.getDesc())){

					coachTimeAddList19.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentieth.getDesc())){

					coachTimeAddList20.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentyfirst.getDesc())){

					coachTimeAddList21.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentysecond.getDesc())){

					coachTimeAddList22.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentythird.getDesc())){

					coachTimeAddList23.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentyfourth.getDesc())){

					coachTimeAddList24.add(coachTime);


				}else if(coachTime.getDay().equals(DateDayEnum.Twentyfifth.getDesc())){

					coachTimeAddList25.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Twentysixth.getDesc())){

					coachTimeAddList26.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Twentyeventh.getDesc())){

					coachTimeAddList27.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Twentyeighth.getDesc())){

					coachTimeAddList28.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Twentyninth.getDesc())){

					coachTimeAddList29.add(coachTime);
				}else if(coachTime.getDay().equals(DateDayEnum.Thirtieth.getDesc())){

					coachTimeAddList30.add(coachTime);

				}else if(coachTime.getDay().equals(DateDayEnum.Thirtyfirst.getDesc())){

					coachTimeAddList31.add(coachTime);

				}

			}
		}




		dto.setCoachTimeList01(coachTimeAddList01);
		dto.setCoachTimeList02(coachTimeAddList02);
		dto.setCoachTimeList03(coachTimeAddList03);
		dto.setCoachTimeList04(coachTimeAddList04);
		dto.setCoachTimeList05(coachTimeAddList05);
		dto.setCoachTimeList06(coachTimeAddList06);
		dto.setCoachTimeList07(coachTimeAddList07);
		dto.setCoachTimeList08(coachTimeAddList08);
		dto.setCoachTimeList09(coachTimeAddList09);
		dto.setCoachTimeList10(coachTimeAddList10);
		dto.setCoachTimeList11(coachTimeAddList11);
		dto.setCoachTimeList12(coachTimeAddList12);
		dto.setCoachTimeList13(coachTimeAddList13);
		dto.setCoachTimeList14(coachTimeAddList14);
		dto.setCoachTimeList15(coachTimeAddList15);
		dto.setCoachTimeList16(coachTimeAddList16);
		dto.setCoachTimeList17(coachTimeAddList17);
		dto.setCoachTimeList18(coachTimeAddList18);
		dto.setCoachTimeList19(coachTimeAddList19);
		dto.setCoachTimeList20(coachTimeAddList20);
		dto.setCoachTimeList21(coachTimeAddList21);
		dto.setCoachTimeList22(coachTimeAddList22);
		dto.setCoachTimeList23(coachTimeAddList23);
		dto.setCoachTimeList24(coachTimeAddList24);
		dto.setCoachTimeList25(coachTimeAddList25);
		dto.setCoachTimeList26(coachTimeAddList26);
		dto.setCoachTimeList27(coachTimeAddList27);
		dto.setCoachTimeList28(coachTimeAddList28);
		dto.setCoachTimeList29(coachTimeAddList29);
		dto.setCoachTimeList30(coachTimeAddList30);
		dto.setCoachTimeList31(coachTimeAddList31);

		dto=setCount(dto);
		return dto;

	}


	public CoachTimeEditDto setCount(CoachTimeEditDto dto){
		//记录  前台索引
		Integer count=0;
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList01())){
			count+=dto.getCoachTimeList01().size();

		}else{
			//没有值前台会空出一个
			count=count+1;
		}
		dto.setCount1(count);

		//2
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList02())){
			count+=dto.getCoachTimeList02().size();

		}else{

			count=count+1;
		}
		dto.setCount2(count);


		//3
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList03())){
			count+=dto.getCoachTimeList03().size();

		}else{

			count=count+1;
		}
		dto.setCount3(count);


		//4
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList04())){
			count+=dto.getCoachTimeList04().size();

		}else{

			count=count+1;
		}
		dto.setCount4(count);


		//5
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList05())){
			count+=dto.getCoachTimeList05().size();

		}else{
			count=count+1;
		}
		dto.setCount5(count);

		//6
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList06())){
			count+=dto.getCoachTimeList06().size();

		}else{
			count=count+1;
		}
		dto.setCount6(count);


		//7
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList07())){
			count+=dto.getCoachTimeList07().size();

		}else{
			count=count+1;
		}
		dto.setCount7(count);


		//8
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList08())){
			count+=dto.getCoachTimeList08().size();

		}else{
			count=count+1;
		}
		dto.setCount8(count);



		//9
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList09())){
			count+=dto.getCoachTimeList09().size();

		}else{
			count=count+1;
		}
		dto.setCount9(count);



		//10
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList10())){
			count+=dto.getCoachTimeList10().size();

		}else{
			count=count+1;
		}
		dto.setCount10(count);



		//11
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList11())){
			count+=dto.getCoachTimeList11().size();

		}else{
			count=count+1;
		}
		dto.setCount11(count);


		//12
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList12())){
			count+=dto.getCoachTimeList12().size();

		}else{
			count=count+1;
		}
		dto.setCount12(count);



		//13
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList13())){
			count+=dto.getCoachTimeList13().size();

		}else{
			count=count+1;
		}
		dto.setCount13(count);



		//14
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList14())){
			count+=dto.getCoachTimeList14().size();

		}else{
			count=count+1;
		}
		dto.setCount14(count);



		//15
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList15())){
			count+=dto.getCoachTimeList15().size();

		}else{
			count=count+1;
		}
		dto.setCount15(count);


		//16
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList16())){
			count+=dto.getCoachTimeList16().size();

		}else{
			count=count+1;
		}
		dto.setCount16(count);



		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList17())){
			count+=dto.getCoachTimeList17().size();

		}else{
			count=count+1;
		}
		dto.setCount17(count);


		//18
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList18())){
			count+=dto.getCoachTimeList18().size();

		}else{
			count=count+1;
		}
		dto.setCount18(count);

		//19
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList19())){
			count+=dto.getCoachTimeList19().size();

		}else{
			count=count+1;
		}
		dto.setCount19(count);

		//20
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList20())){
			count+=dto.getCoachTimeList20().size();

		}else{
			count=count+1;
		}
		dto.setCount20(count);

		//21
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList21())){
			count+=dto.getCoachTimeList21().size();

		}else{
			count=count+1;
		}
		dto.setCount21(count);
		//22
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList22())){
			count+=dto.getCoachTimeList22().size();

		}else{
			count=count+1;
		}
		dto.setCount22(count);

		//23
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList23())){
			count+=dto.getCoachTimeList23().size();

		}else{
			count=count+1;
		}
		dto.setCount23(count);

		//24
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList24())){
			count+=dto.getCoachTimeList24().size();

		}else{
			count=count+1;
		}
		dto.setCount24(count);

		//25
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList25())){
			count+=dto.getCoachTimeList25().size();

		}else{
			count=count+1;
		}
		dto.setCount25(count);

		//26
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList26())){
			count+=dto.getCoachTimeList26().size();

		}else{
			count=count+1;
		}
		dto.setCount26(count);


		//27
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList27())){
			count+=dto.getCoachTimeList27().size();

		}else{
			count=count+1;
		}
		dto.setCount27(count);

		//28
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList28())){
			count+=dto.getCoachTimeList28().size();

		}else{
			count=count+1;
		}
		dto.setCount28(count);




		//29
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList29())){
			count+=dto.getCoachTimeList29().size();

		}else{
			count=count+1;
		}
		dto.setCount29(count);

		//30
		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList30())){
			count+=dto.getCoachTimeList30().size();

		}else{
			count=count+1;
		}
		dto.setCount30(count);

		//31

		if(CollectionUtils.isNotEmpty(dto.getCoachTimeList31())){
			count+=dto.getCoachTimeList31().size();

		}else{
			count=count+1;
		}
		dto.setCount31(count);





		return dto;
	}
	/**
	 * 获取   年月时间
	 * @param date
	 * @return
	 */
	public String getCurrentYmonth(String date){
		if(!StringUtils.hasText(date)){
			Date d=new Date();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
			return dateFormat.format(d);
		}

		return date;

	}


	/**
	 * 编辑保存
	 * @param coachTimeDto
	 * @throws Exception
	 */
	public void editSave(CoachTimeDto coachTimeDto,String date) throws Exception{
		List<CoachTimeDetailDto> detailDtoList=coachTimeDto.getCoachTimeList();
		Date d=new Date();
		//获取教练，编辑只会有一个教练
		List<Coach> coachs=coachTimeDto.getCoachs();
		Integer coachId=coachs.get(0).getId();
		//先删除
		delCoachTime(coachId, date);

		if(CollectionUtils.isNotEmpty(detailDtoList)){
			for(int i=0;i<detailDtoList.size();i++){
				//获取 每天  开始时间结束时间对象
				CoachTimeDetailDto dto= detailDtoList.get(i);
				//如果开始时间和结束时间都有值
				if(StringUtils.hasText(dto.getStartTime())&&StringUtils.hasText(dto.getEndTime())){
					//塞入时间和 coachId
					dto.setCoachId(coachId);
					//塞入年月
					dto.setSelectYmonth(date);

					dto.setAddTime(d);

				}else{
					detailDtoList.remove(i);
					i--;
				}
			}
		}

		if(CollectionUtils.isNotEmpty(detailDtoList)){
			//批量添加
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("list", detailDtoList);
			coachTimeDao.insertCourseTimeList(map);
		}


	}


	/**
	 * 删除教练时间
	 * @param coachId  教练id
	 * @param date  选择 年月   2018-08
	 * @throws Exception
	 */
	public void delCoachTime(Integer coachId,String date)throws Exception{
		CoachTimeExample example=new CoachTimeExample();
		//根据教练时间和选择年月
		example.createCriteria().andCoachidEqualTo(coachId).andSelectymonthEqualTo(date);
		coachTimeDao.deleteByExample(example);

	}

	/**
	 * 查询教练   各个月份的时间
	 * @param coachId 根据教练id查询
	 * @param selectYmonth  根据选择月份查询  2018-07
	 * @return
	 * @throws Exception
	 */
	public  PageResponse selectCoachTimeList(Page page,Integer coachId,String selectYmonth) throws Exception{
		PageResponse pageResponse=new PageResponse();
		Map<String,Object> map=new HashMap<String,Object>();

		//教练id作为条件查询
		if(coachId!=null){
			map.put("coachId",coachId);
		}

		//选择的年月作为条件查询
		if(StringUtils.hasText(selectYmonth)){
			map.put("selectYmonth",selectYmonth);
		}
		map.put("start", Integer.parseInt(page.getOffset()));
		map.put("end", Integer.parseInt(page.getLimit()));
		int count = coachTimeDao.countList(map);
		List<CoachTimeDto> timeDtos=coachTimeDao.selectCoachTimeList(map);
		pageResponse.setTotal(count);
		pageResponse.setRecords(timeDtos);
		return pageResponse;

	}


}

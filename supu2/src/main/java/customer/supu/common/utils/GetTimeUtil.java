package customer.supu.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import customer.supu.dto.DateTimeDto;

public class GetTimeUtil {
	//小时
	private static List<String> selectHours=Arrays.asList(new String[]{"01","02","03","04","05","06","07","08","09","10","11",
		"12","13","14","15","16","17","18","19","20","21","22","23","24"});

	//分钟
	private  static List<String> selectMiutes=Arrays.asList(new String[]{"00","05","10","15","20","25","30","35","40","45","50","55"});

	//月
	private  static List<String> selectMonths=Arrays.asList(new String[]{"01","02","03","04","05","06","07","08","09","10","11",
		"12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});


	//月
	private  static List<String> selectTime=Arrays.asList(new String[]{"07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00",
		"12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00"});
	/**
	 * 获取小时
	 * @return
	 */
	public static List<String> selectHours(){

		return selectHours;

	}
	/**
	 * 获取时间
	 * @return
	 */
	public static List<String> selectTime(){

		return selectTime;

	}
	/**
	 * 获取小时选中
	 * @param value
	 * @return
	 */
	public static List<DateTimeDto> selectHoursChecked(String value){
		List<DateTimeDto> dateTimeDtos=new ArrayList<DateTimeDto>();
		if(StringUtils.hasText(value)){
			for(int i=0;i<selectHours.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectHours.get(i));
				if(value.equals(selectHours.get(i))){
					dto.setChecked(true);
				}
				dateTimeDtos.add(dto);
			}
		}else{
			for(int i=0;i<selectHours.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectHours.get(i));
				dateTimeDtos.add(dto);
			}

		}

		return dateTimeDtos;

	}

	/**
	 * 获取月份
	 * @return
	 */
	public static List<String> selectMonths(){

		return selectMonths;

	}

	/**
	 * 获取月份选中
	 * @param value
	 * @return
	 */
	public static List<DateTimeDto> selectMonthsChecked(String value){

		List<DateTimeDto> dateTimeDtos=new ArrayList<DateTimeDto>();
		if(StringUtils.hasText(value)){
			for(int i=0;i<selectMonths.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectMonths.get(i));
				if(value.equals(selectMonths.get(i))){
					dto.setChecked(true);
				}
				dateTimeDtos.add(dto);
			}
		}else{
			for(int i=0;i<selectMonths.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectMonths.get(i));
				dateTimeDtos.add(dto);
			}
		}

		return dateTimeDtos;

	}


	/**
	 * 获取分钟
	 * @return
	 */
	public static List<String> selectMiutes(){

		return selectMiutes;

	}

	/**
	 * 获取分钟选中
	 * @return
	 */
	public static List<DateTimeDto> selectMiutesChecked(String value){

		List<DateTimeDto> dateTimeDtos=new ArrayList<DateTimeDto>();
		if(StringUtils.hasText(value)){
			for(int i=0;i<selectMiutes.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectMiutes.get(i));
				if(value.equals(selectMiutes.get(i))){
					dto.setChecked(true);
				}
				dateTimeDtos.add(dto);
			}
		}else{
			for(int i=0;i<selectMiutes.size();i++){
				DateTimeDto dto=new DateTimeDto();
				dto.setValue(selectMiutes.get(i));
				dateTimeDtos.add(dto);
			}
		}

		return dateTimeDtos;

	}

}

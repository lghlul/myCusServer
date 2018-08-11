package com.cad.utils;

import java.text.DecimalFormat;

/**
 * 
 * @author Lu
 * @Description: 数据格式转换工具类
 * @Package com.cad.utils
 * @date 2017年5月6日 下午9:58:13 
 * @version V1.0
 */
public class DataFormatUtil {
	/**
	 * 
	* @Title: doubleFormat 
	* @Description: 小数点精确
	* @param @param d
	* @param @return    设定文件 
	* @return double    返回类型 
	* @throws
	 */
	public static double doubleFormat(double d) {
		DecimalFormat df = new DecimalFormat("#.00000000");
		return Double.parseDouble(df.format(d));
	}
	
	/**
	 * 
	* @Title: intFarmat 
	* @Description: int类型转换  000,000,000 
	* @param @param i
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String intFarmat(int i){
		String s = String.valueOf(i);
		char[] charArray = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int j = charArray.length ; j>0 ; j--){
			sb.append(charArray[j-1]);
			if((charArray.length - (j - 1))%3 == 0)
				sb.append(",");
		}
		String result = sb.reverse().toString();
		if(s.length() % 3 == 0){
			result = result.substring(1,result.length());
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(DataFormatUtil.intFarmat(0));
	}
}
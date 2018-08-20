package com.cad.utils;
/**
 * 
 * @author Lu
 * @Description: 常量工具类
 * @Package com.cad.utils
 * @date 2017年5月6日 下午9:58:30 
 * @version V1.0
 */
public interface ConstantUtil {
	
	/**
	 * 
	 * @author Lu
	 * @Description: 压力转换
	 * @Package com.cad.utils
	 * @date 2017年5月6日 下午9:49:20 
	 * @version V1.0
	 */
	interface PressureChage{
		public static double PROPORTION_1 = 1.0;
		public static double PROPORTION_2 = 0.1;
		public static double PROPORTION_3 = 100.0;
		public static double PROPORTION_4 = 1000.0;
		public static double PROPORTION_5 = 1000.0;
		public static double PROPORTION_6 = 100000.0;
		public static double PROPORTION_7 = 0.98692327;
		public static double PROPORTION_8 = 750.06168270000001;
		public static double PROPORTION_9 = 2088.5435121199998;
		public static double PROPORTION_10 = 14.50377439;
		public static double PROPORTION_11 = 29.529987510000002;
		public static double PROPORTION_12 = 1.01971621;
		public static double PROPORTION_13 = 10197.162129779999;
		public static double PROPORTION_14 = 10197.162129779999;
	}
	
	/**
	 * 
	 * @author Lu
	 * @Description: 缓存key
	 * @Package com.cad.utils
	 * @date 2017年5月6日 下午9:49:28 
	 * @version V1.0
	 */
	interface CacheKey{
		/**
		 * 公差查询key
		 */
		public static String DEVIATION_LIST_KEY = "deviation_list";
		
		/**
		 * 所有公差field
		 */
		public static String DEVIATION_OFTEN = "deviation_often";
		
		/**
		 * 常用公差field
		 */
		public static String DEVIATION_ALL = "deviation_all";
		
		/**
		 * 气缸压力key
		 */
		public static String PRESSURE_LIST_KEY = "pressure_list";
		
		/**
		 * 缸径field
		 */
		public static String BORE_SIZE = "bore_size";
		
		/**
		 * 气压field
		 */
		public static String PRESSURE_SIZE = "pressure_size";
		
		/**
		 * 气缸压力值key
		 */
		public static String PRESSURE_VALUE_KEY = "pressure_value";
		
		/**
		 * 工程材料key
		 */
		public static String PROJECT_MATERIAL_KEY = "project_material";
		
		/**
		 * 中国
		 */
		public static String PROJECT_MATERIAL_CHINA_KEY = "project_material_china";
		
		/**
		 * 美国
		 */
		public static String PROJECT_MATERIAL_USA_KEY = "project_material_usa";
		
		/**
		 * 西班牙
		 */
		public static String PROJECT_MATERIAL_SPAIN_KEY = "project_material_spain";
		
		/**
		 * 土耳其
		 */
		public static String PROJECT_MATERIAL_TURKEY_KEY = "project_material_turkey";
		
		/**
		 * 墨西哥
		 */
		public static String PROJECT_MATERIAL_MEXICO_KEY = "project_material_mexico";
		
		/**
		 * 印度
		 */
		public static String PROJECT_MATERIAL_INDIA_KEY = "project_material_india";
		
		/**
		 * 德国
		 */
		public static String PROJECT_MATERIAL_GERMANY_KEY = "project_material_germany";
	}

	interface Page{
		public static final String INDEX = "index";

		public static final String LOGIN = "login";
	}


	public static final String SESSION_USER = "user";
	
	
}

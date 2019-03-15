package com.answer.utils;

public interface Constant {
	
	public static byte ANSWER_RIGHT = 1;
	
	public static byte ANSWER_WRONG = 2;
	
	/**
	 * 错题删除状态
	 */
	public static byte DEL_STATUS = 2;
	/**
	 * 可用正常状态的工号
	 */
	public static byte JOBNUM_UNUSER = 1;
	/**
	 * 不可用状态的工号
	 */
	public static byte JOBNUM_USELESS = 2;
	
	/**
	 * 对战房间没有计分
	 */
	public static byte ROOM_STATUS_NOT_COUNT = 1;
	/**
	 * 对战房间已经计分
	 */
	public static byte ROOM_STATUS_COUNT = 2;


	/**
	 * 考试练习未结束
	 */
	byte TRAIN_STATUS_UN_FINISH = 1;

	/**
	 * 考试练习结束
	 */
	byte TRAIN_STATUS_FINISH = 2;
	
	public static interface returnCode {
		/**
		 * 没有绑定工号
		 */
		public static final int NO_JOBNUM = 10001;
		
		
		/**
		 * 无效工号 或者已被绑定
		 */
		public static final int USELESS_JOBNUM = 10002;
		/**
		 * 每天最多绑定3次  明日再试
		 */
		public static final int BIND_OVER_THREE = 10003;
		
		/**
		 * 不能重复绑定
		 */
		public static final int NO_BIND_REPEAT = 10004;
		
		/**
		 * 练习模式结束
		 */
		public static final int QUES_FINISH = 10005;
		
		/**
		 * 无效session(重新登录)
		 */
		public static final int SESSOIN_TIMEOUT = 10000;
		/**
		 * 无效code
		 */
		public static final int CODE_NOT_USE = 40029;
		/**
		 * 服务器异常
		 */
		public static final int SERVER_EXCEPTION = -1;
		/**
		 * 签到失败
		 */
		public static final int SIGN_FAIL = 9999;
		/**
		 * 操作失败  不是本人错题
		 */
		public static final int OPER_FAIL = 9998;
		
		/**
		 * 不存在 查无此数据
		 */
		public static final int NOT_EXIST = 9997;
		
		
		/**
		 * 暂无数据
		 */
		public static final int NO_DATA = 2;
		/**
		 * 积分不够
		 */
		public static final int SCORE_NOT_ENOUGH = 9996;
		
		
		/**
		 * 已经签到
		 */
		public static final int IS_SIGN = 9995;
		
		
		
		/**
		 * 不在线
		 */
		public static final int NOT_ONLINE = 9994;
		
	}

	public static interface url {
		/**
		 * 获取openID
		 */
		public static final String GET_OPENID_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
	}
	
	public static interface score{
		public static int TEN = 10;
		
		public static int FIVE = 5;

		public static float SIGN_SCORE = 1;
		//public static float SIGN_SCORE = 0.1f;
	}
}

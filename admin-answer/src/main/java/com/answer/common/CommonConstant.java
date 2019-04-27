package com.answer.common;

/**
 * CommonConstant
 *
 * @author wangshuohe
 * @date 2018/04/20
 */
public abstract class CommonConstant {
	

	public interface Str{
		String ADMIN = "admin";
	}

	public interface Common{
		Integer offset = 0;
		Integer limit = 10;

		Byte ACTIVITY_STATUS_UN_START = 1;
		Byte ACTIVITY_STATUS_START = 2;
		Byte ACTIVITY_STATUS_END = 3;

		/**
		 * 删除状态
		 */
		Byte DEL_STATUS = 2;

		/**
		 * 正常状态
		 */
		Byte NORMAL_STATUS = 1;

		/**
		 * 工号 未绑定状态
		 */
		Byte JOBNUM_UN_BIND = 1;

		/**
		 * 工号 绑定状态
		 */
		Byte JOBNUM_BIND = 2;
	}
}

package com.answer.common;

import com.answer.domain.BaseDomain;

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
	}
}

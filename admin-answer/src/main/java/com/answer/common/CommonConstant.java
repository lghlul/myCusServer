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


	public static void pageHandler(BaseDomain domain){
		if(domain.getLimit() == null){
			if(domain.getPageSize() == null){
				domain.setLimit(CommonConstant.Common.limit);
			}else{
				domain.setLimit(domain.getPageSize());
			}
		}

		if(domain.getOffSet() == null){
			if(domain.getPageNo() == null){
				domain.setOffSet(CommonConstant.Common.offset);
			}else{
				domain.setOffSet((domain.getPageNo() - 1) * domain.getLimit());
			}
		}
	}



}

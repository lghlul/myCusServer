package com.cad.service;


import com.cad.domain.CodeManage;

import java.util.Map;

/**
 * 
 * @author Lu
 * @Description: 访问量
 * @Package com.cad.service
 * @date 2017年5月6日 下午10:00:35 
 * @version V1.0
 */
public interface ICodeManageService {
	public int addCodeManage(CodeManage codeManage);

	public boolean checkCodeExist(Map<String , Object> map);
}

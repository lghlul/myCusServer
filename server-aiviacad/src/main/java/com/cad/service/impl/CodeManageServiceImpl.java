package com.cad.service.impl;

import com.cad.domain.CodeManage;
import com.cad.mapper.CodeManageMapper;
import com.cad.mapper.VisitMapper;
import com.cad.service.ICodeManageService;
import com.cad.service.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CodeManageServiceImpl implements ICodeManageService {

	@Autowired
	private CodeManageMapper codeManageMapper;

	public int addCodeManage(CodeManage codeManage) {
		codeManage.setCreateTime(System.currentTimeMillis());
		return codeManageMapper.insertCodeManage(codeManage);
	}


	public boolean checkCodeExist(Map<String, Object> map) {
		List<CodeManage> list = codeManageMapper.query(map);
		if(list == null || list.size() < 1){
			return false;
		}else{
			return true;
		}
	}


	public List<CodeManage> query(Map<String, Object> map) {
		List<CodeManage> list = codeManageMapper.query(map);
		return list;
	}
}
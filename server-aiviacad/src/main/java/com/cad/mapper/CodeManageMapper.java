package com.cad.mapper;

import com.cad.domain.CodeManage;

import java.util.List;
import java.util.Map;

public interface CodeManageMapper {
	 int insertCodeManage(CodeManage codeManage);

	 List<CodeManage> query(Map<String , Object> map);
}

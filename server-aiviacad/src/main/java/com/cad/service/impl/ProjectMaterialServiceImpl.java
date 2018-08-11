package com.cad.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cad.cache.CacheProjectMaterialHelper;
import com.cad.domain.ProjectMaterial;
import com.cad.mapper.ProjectMaterialMapper;
import com.cad.service.IProjectMaterialService;

@Service
public class ProjectMaterialServiceImpl implements IProjectMaterialService {
	
	@Autowired
	private CacheProjectMaterialHelper cacheProjectMaterialHelper;


	public ProjectMaterial getProjectMaterialValue(int pm_id) {
		return cacheProjectMaterialHelper.getPmValue(pm_id);
	}

	public List<List<ProjectMaterial>> getProjectMaterial() {
		List<List<ProjectMaterial>> result = cacheProjectMaterialHelper.getProjectMaterialList();
		return result;
	}


}
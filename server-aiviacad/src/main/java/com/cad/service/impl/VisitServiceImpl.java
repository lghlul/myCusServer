package com.cad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cad.mapper.VisitMapper;
import com.cad.service.IVisitService;

@Service
public class VisitServiceImpl implements IVisitService {

	@Autowired
	private VisitMapper visitMapper;

	public int getVisitCount() {
		int count = this.visitMapper.findVisitCount();
		return count;
	}
	
}
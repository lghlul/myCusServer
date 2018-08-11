package com.cad.mapper;

import com.cad.domain.Visit;

public interface VisitMapper {
	public void insertVisit(Visit visit);
	
	public int findVisitCount();

}

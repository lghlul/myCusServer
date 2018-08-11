package com.cad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cad.cache.CachePressureHelper;
import com.cad.domain.Pressure;
import com.cad.service.IPressureService;

@Service
public class PressureServiceImpl implements IPressureService{

  @Autowired
  private CachePressureHelper cachePressureHelper;

  public List<Pressure> getBoreSize(){
    return this.cachePressureHelper.getBoreSize();
  }

  public List<Pressure> getValue(Pressure pressure) {
    return this.cachePressureHelper.getPressureValue(pressure);
  }

  public List<Pressure> getPressureSize() {
	  return this.cachePressureHelper.getPressureSize();
  }
}

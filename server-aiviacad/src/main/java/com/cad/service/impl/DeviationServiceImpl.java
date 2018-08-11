package com.cad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cad.cache.CacheDeviationHelper;
import com.cad.domain.Deviation;
import com.cad.mapper.DeviationMapper;
import com.cad.service.IDeviationService;

@Service
public class DeviationServiceImpl implements IDeviationService {

	@Autowired
	private DeviationMapper deviationMapper;
	
	@Autowired
	private CacheDeviationHelper cacheDeviationHelper;

	public List<Deviation> getDeviation(Deviation deviation) {
		List<Deviation> list = cacheDeviationHelper.getDeviationList(deviation);
		return list;
	}

	public Deviation getDeviationValue(Deviation deviation) {
		if (deviation.getSize_value().equals("0")){
			deviation.setHave_zero("1");
		}else {
			deviation.setHave_zero("0");
		}
		Deviation d = this.deviationMapper.findDeviationValue(deviation);
		if ((d == null) || (d.getValue_one() == null) || (d.getValue_two() == null)) {
			d = new Deviation();
			d.setValue_one("null");
			d.setValue_two("null");
		}
		return d;
	}
}
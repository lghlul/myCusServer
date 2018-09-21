package com.lu.service.impl;

import com.lu.mapper.BaseMapper;
import com.lu.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ym on 2018/4/11
 */
@Service
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public T selectByPrimaryKey(String id) {
		return baseMapper.selectByPrimaryKey(id);
	}
}

package com.lu.service;


/**
 * Created by ym on 2018/4/11
 */
public interface BaseService<T> {
	T selectByPrimaryKey(String id);
}

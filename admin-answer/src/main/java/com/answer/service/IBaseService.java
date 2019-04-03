package com.answer.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {

    int add(T t);

    int edit(T t);

    List<T> queryPageByMap(Map<String, Object> map);

    int queryPageCounteByMap(Map<String, Object> map);

    List<T> queryPage(T t);

    PageInfo<T> page(T t);

    int queryPageCount(T t);

    T queryById(String id);

    int deleteById(String id);

    int delete(T t);

    int deleteByMap(Map<String, Object> map);


    List<T> query(T t);

}
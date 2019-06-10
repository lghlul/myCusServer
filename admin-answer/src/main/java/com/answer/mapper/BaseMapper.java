package com.answer.mapper;

import com.answer.common.PageQuery;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

    T selectById(String id);

    List<T> selectPage(T t);

    int selectPageCount(T t);

    List<T> selectPageByMap(Map<String, Object> map);

    int selectPageCountByMap(Map<String, Object> map);

    int insert(T t);

    int update(T t);

    int deleteById(String id);

    int delete(T t);

    int deleteByMap(Map<String, Object> map);

    List<T> select(T t);

    List<T> list(PageQuery pageQuery);

}
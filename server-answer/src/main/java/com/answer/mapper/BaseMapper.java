package com.answer.mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/9 10:09
 * @Modified By：
 */
public interface BaseMapper<T> {
    int insert(T t);
    List<T> list(T t);
    List<T> listByMap(Map<String , Object> map);
    T read(String id);
}

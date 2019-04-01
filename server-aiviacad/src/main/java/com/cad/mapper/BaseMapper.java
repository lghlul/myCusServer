package com.cad.mapper;


public interface BaseMapper<T> {

    T selectById(String id);

    int insert(T t);

    int update(T t);


}
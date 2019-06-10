package com.answer.service.impl;

import java.util.List;
import java.util.Map;

import com.answer.common.PageQuery;
import com.answer.mapper.BaseMapper;
import com.answer.service.IBaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T> implements IBaseService<T>{

    @Autowired
    private BaseMapper<T> baseMapper;

    public int add(T t){
        return baseMapper.insert(t);
    }

    public int edit(T t){
        return baseMapper.update(t);
    }

    public List<T> queryPageByMap(Map<String, Object> map){
        return baseMapper.selectPageByMap(map);
    }

    @Override
    public int queryPageCounteByMap(Map<String, Object> map) {
        return baseMapper.selectPageCountByMap(map);
    }

    public List<T> queryPage(T t){
        return baseMapper.selectPage(t);
    }

    public T queryById(String id){
        return baseMapper.selectById(id);
    }

    public int deleteById(String id){
        return baseMapper.deleteById(id);
    }

    public int delete(T t){
        return baseMapper.delete(t);
    }

    public int deleteByMap(Map<String, Object> map){
        return baseMapper.deleteByMap(map);
    }

    @Override
    public List<T> query(T t) {
        return baseMapper.select(t);
    }

    @Override
    public int queryPageCount(T t) {
        return baseMapper.selectPageCount(t);
    }

    @Override
    public PageInfo<T> page(T t) {
        return null;
    }

    @Override
    public PageInfo<T> list(PageQuery pageQuery) {
        return null;
    }
}
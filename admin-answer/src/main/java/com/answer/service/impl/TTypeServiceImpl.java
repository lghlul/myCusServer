package com.answer.service.impl;

import com.answer.domain.TType;
import com.answer.mapper.TTypeMapper;
import com.answer.service.ITTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTypeServiceImpl extends BaseServiceImpl<TType> implements ITTypeService{

    @Autowired
    private TTypeMapper typeMapper;

    @Override
    public List<TType> selectByPId(Long pid) {
        return typeMapper.selectByPId(pid);
    }
}

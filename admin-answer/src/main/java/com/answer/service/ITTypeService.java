package com.answer.service;

import com.answer.domain.TType;

import java.util.List;

public interface ITTypeService extends IBaseService<TType>{
    List<TType> selectByPId(Long pid);
}

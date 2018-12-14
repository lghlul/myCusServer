package com.answer.service;

import com.answer.domain.TUser;

import java.util.List;
import java.util.Map;

public interface ITUserService extends IBaseService<TUser>{
    List<TUser> answerCount(Map<String , Object> map);
}

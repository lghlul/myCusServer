package com.answer.mapper;

import com.answer.domain.TUser;

import java.util.List;
import java.util.Map;

public interface TUserMapper extends BaseMapper<TUser>{

    List<TUser> selectAnswerCount(Map<String , Object> map);

    TUser selectByOpenID(String openID);

}
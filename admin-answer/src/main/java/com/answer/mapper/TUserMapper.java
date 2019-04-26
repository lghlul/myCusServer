package com.answer.mapper;

import com.answer.domain.TUser;
import com.answer.domain.query.UserQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TUserMapper extends BaseMapper<TUser>{

    List<TUser> selectAnswerCount(Map<String , Object> map);

    TUser selectByOpenID(String openID);

    List<TUser> list(UserQuery userQuery);

    List<TUser> listAnswerCount(@Param("users") List<TUser> users ,@Param("startTime") Long startTime ,@Param("endTime") Long endTime);

}
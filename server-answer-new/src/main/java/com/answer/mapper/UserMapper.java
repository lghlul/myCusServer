package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.User;

public interface UserMapper {
    User queryUserByOpenID(String openID);

    int addUser(User paramUser);

    int updateUser(User user);

    float queryScore(String openID);

    List<User> queryRank(Map<String, Object> map);

    int queryMyRank(float score);

    int queryUserCount();

    List<User> queryUserByScore(float score);

    void updateScore(User user);
}

package com.answer.service;

import com.answer.domain.Result;
import com.answer.domain.User;

import java.math.BigInteger;

public interface IUserService {
    User getUserByOpenID(String paramString);

    Result registerUser(User paramUser);

    Result getScore(String wxSession);

    Result editUser(String wxSession, String userImg, String userName);

    Result getRankList(String wxSession, int pageNo, int pageSize);

    Result checkJobNum(String wxSession);

    Result bindJobNum(String wxSession, String jobNum);

    Result getUserInfo(String wxSession);

    Result createRoom(String wxSession, long typeID);

    void updateScore(String openID , Float modifyScore , String modifyName, BigInteger goodsID);


}

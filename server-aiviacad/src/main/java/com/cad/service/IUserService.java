package com.cad.service;


import com.cad.domain.User;
import com.cad.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface IUserService {


    int searchCount(Map<String , Object> map);

    int register(User user);

    User userLogin(String userAccount , String userPwd);

    int updatePwd(String userId, String userOldPwd , String userPwd);

    int updatePwdByEmail(String email , String userPwd);

    List<User> searchByMap(Map<String , Object> map);

}

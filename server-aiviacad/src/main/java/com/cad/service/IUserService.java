package com.cad.service;


import com.cad.domain.User;

import java.util.Map;

public interface IUserService {


    public int searchCount(Map<String , Object> map);


    public int register(User user);


    public User userLogin(String userAccount , String userPwd);

}

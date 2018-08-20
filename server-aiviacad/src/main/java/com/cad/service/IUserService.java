package com.cad.service;


import com.cad.domain.User;

public interface IUserService {


    public int queryAccountCount(String userAccount);


    public int register(User user);


    public User userLogin(String userAccount , String userPwd);

}

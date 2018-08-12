package com.cad.service.impl;

import com.cad.domain.User;
import com.cad.mapper.UserMapper;
import com.cad.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    public int queryAccountCount(String userAccount) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("userAccount",userAccount);
        int count = this.userMapper.searchCount(map);
        return count;
    }

    public int register(User user) {
        int count = this.userMapper.insert(user);
        return count;
    }
}
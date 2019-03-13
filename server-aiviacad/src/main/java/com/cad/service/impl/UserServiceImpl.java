package com.cad.service.impl;

import com.cad.constant.ResultCode;
import com.cad.domain.Result;
import com.cad.domain.User;
import com.cad.mapper.UserMapper;
import com.cad.service.IBaseService;
import com.cad.service.IUserService;
import com.cad.utils.CodeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    public int searchCount(Map<String , Object> map) {
        int count = this.userMapper.searchCount(map);
        return count;
    }

    public int register(User user) {
        user.setUserPwd(DigestUtils.md5Hex(user.getUserPwd()));
        int count = this.userMapper.insert(user);
        return count;
    }


    public User userLogin(String userAccount, String userPwd) {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("userPwd",DigestUtils.md5Hex(userPwd));
        map.put("userAccount",userAccount);
        List<User> userList = this.userMapper.search(map);
        if(userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }


    public int updatePwd(String userId, String userOldPwd, String userPwd) {
        User user = userMapper.selectById(userId);
        if(user.getUserPwd().equals(DigestUtils.md5Hex(userOldPwd))){
            User u = new User();
            u.setUserPwd(DigestUtils.md5Hex(userPwd));
            u.setUserId(userId);
            userMapper.update(u);
            return ResultCode.SUCCESS;
        }else{
            return ResultCode.OLD_PWD_ERROR;
        }

    }

    public List<User> searchByMap(Map<String, Object> map) {
        List<User> userList = userMapper.search(map);
        return userList;
    }


    public int updatePwdByEmail(String email, String userPwd) {
        User u = new User();
        u.setUserPwd(DigestUtils.md5Hex(userPwd));
        u.setEmail(email);
        return userMapper.updateByEmail(u);
    }
}
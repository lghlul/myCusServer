package com.cad.mapper;


import com.cad.domain.User;

import java.util.Map;

public interface UserMapper {

    public int insert(User user);

    public int searchCount(Map<String , Object> map);
}

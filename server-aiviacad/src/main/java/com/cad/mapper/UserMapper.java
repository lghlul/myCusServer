package com.cad.mapper;


import com.cad.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public int insert(User user);

    public int searchCount(Map<String , Object> map);

    public List<User> search(Map<String , Object> map);
}

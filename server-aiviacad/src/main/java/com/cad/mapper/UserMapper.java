package com.cad.mapper;


import com.cad.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User>{

    int searchCount(Map<String , Object> map);

    List<User> search(Map<String , Object> map);

    int updateByEmail(User user);

}

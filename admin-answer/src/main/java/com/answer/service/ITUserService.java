package com.answer.service;

import com.answer.domain.TUser;
import com.answer.domain.query.UserQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ITUserService extends IBaseService<TUser>{
    List<TUser> answerCount(Map<String , Object> map);

    PageInfo<TUser> listReport(UserQuery userQuery);
}

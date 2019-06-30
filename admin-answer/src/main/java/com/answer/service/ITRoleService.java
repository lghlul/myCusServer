package com.answer.service;

import com.answer.domain.TRole;

public interface ITRoleService extends IBaseService<TRole>{
    TRole readByName(String roleName);
}

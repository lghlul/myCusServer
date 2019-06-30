package com.answer.mapper;

import com.answer.domain.TRole;

public interface TRoleMapper extends BaseMapper<TRole>{

    TRole readByName(String roleName);

}
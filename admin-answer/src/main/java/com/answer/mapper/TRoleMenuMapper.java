package com.answer.mapper;

import com.answer.domain.TRoleMenu;

import java.util.List;

public interface TRoleMenuMapper extends BaseMapper<TRoleMenu>{

    void batchSave(List<TRoleMenu> roleMenuList);

}
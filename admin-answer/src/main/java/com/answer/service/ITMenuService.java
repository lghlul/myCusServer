package com.answer.service;

import com.answer.domain.TMenu;
import com.answer.domain.TRoleMenu;

import java.util.List;

public interface ITMenuService extends IBaseService<TMenu>{

     List<TMenu> queryAdminMenu(long roleId);

     List<TMenu> listByRoleId(Long roleId);

     void updateRoleMenu(List<TRoleMenu> roleMenus);
}

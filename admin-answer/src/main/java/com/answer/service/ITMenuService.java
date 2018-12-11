package com.answer.service;

import com.answer.domain.TMenu;

import java.util.List;

public interface ITMenuService extends IBaseService<TMenu>{

    public List<TMenu> queryAdminMenu(long roleId);
}

package com.answer.service.impl;

import com.answer.domain.TMenu;
import com.answer.mapper.TMenuMapper;
import com.answer.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements ITMenuService{

    @Autowired
    private TMenuMapper menuMapper;


    @Override
    public List<TMenu> queryAdminMenu(long roleId) {
        List<TMenu> tMenus = menuMapper.selectAdminMenu(roleId, 0l);
        for(TMenu menu : tMenus){
            List<TMenu> childList = menuMapper.selectAdminMenu(roleId, menu.getMenuId());
            menu.setChildren(childList);
        }
        return tMenus;
    }
}

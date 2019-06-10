package com.answer.service.impl;

import com.answer.domain.TMenu;
import com.answer.domain.TRoleMenu;
import com.answer.domain.query.RoleMenuQuery;
import com.answer.mapper.TMenuMapper;
import com.answer.mapper.TRoleMenuMapper;
import com.answer.service.ITMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements ITMenuService{

    @Autowired
    private TMenuMapper menuMapper;

    @Autowired
    private TRoleMenuMapper roleMenuMapper;


    @Override
    public List<TMenu> queryAdminMenu(long roleId) {
        List<TMenu> tMenus = menuMapper.selectAdminMenu(roleId, 0l);
        for(TMenu menu : tMenus){
            List<TMenu> childList = menuMapper.selectAdminMenu(roleId, menu.getMenuId());
            menu.setChildren(childList);
        }
        return tMenus;
    }


    @Override
    public List<TMenu> listByRoleId(Long roleId) {
        List<TMenu> list = menuMapper.list(null);
        Map<Long , TMenu> map = new HashMap<>();
        if(roleId != null){
            RoleMenuQuery roleMenuQuery = new RoleMenuQuery();
            roleMenuQuery.setRoleId(roleId);
            List<TRoleMenu> menuList = roleMenuMapper.list(roleMenuQuery);
            if(menuList != null && menuList.size() > 0){
                Set<Long> menuSet = new HashSet<>();
                for (TRoleMenu tRoleMenu : menuList) {
                    menuSet.add(tRoleMenu.getMenuId());
                }
                if(list != null && list.size() > 0){
                    for (TMenu tMenu : list) {
                        if(menuSet.contains(tMenu.getMenuId())){
                            tMenu.setCheckIs(true);
                        }
                        if(tMenu.getParentId() == 0){
                            map.put(tMenu.getMenuId() , tMenu);
                        }
                    }
                    for (TMenu tMenu : list) {
                        if(tMenu.getParentId() != 0){
                            TMenu pMenu = map.get(tMenu.getParentId());
                            List<TMenu> children = pMenu.getChildren();
                            if (children == null){
                                children = new ArrayList<>();
                            }
                            children.add(tMenu);
                            pMenu.setChildren(children);
                        }
                    }
                    return new ArrayList<>(map.values());
                }
            }
        }
        return null;
    }

    @Override
    public void updateRoleMenu(List<TRoleMenu> roleMenus) {
        if(roleMenus.size() > 0){
            Long roleId = roleMenus.get(0).getRoleId();
            TRoleMenu roleMenu = new TRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenuMapper.delete(roleMenu);
            roleMenuMapper.batchSave(roleMenus);
        }

    }
}

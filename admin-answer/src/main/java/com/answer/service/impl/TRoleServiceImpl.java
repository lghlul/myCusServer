package com.answer.service.impl;

import com.answer.common.PageQuery;
import com.answer.domain.TRole;
import com.answer.domain.TRoleMenu;
import com.answer.domain.TUser;
import com.answer.mapper.TRoleMapper;
import com.answer.mapper.TRoleMenuMapper;
import com.answer.service.ITMenuService;
import com.answer.service.ITRoleMenuService;
import com.answer.service.ITRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class TRoleServiceImpl extends BaseServiceImpl<TRole> implements ITRoleService{

    @Autowired
    private TRoleMapper roleMapper;


    @Autowired
    private ITMenuService menuService;


    @Autowired
    private TRoleMenuMapper roleMenuMapper;

    @Override
    public PageInfo<TRole> list(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getOffset(), pageQuery.getLimit());
        if (pageQuery.getSortField() != null) {
            PageHelper.orderBy(pageQuery.getSortField() + " " + pageQuery.getSortDir());
        }
        List<TRole> list = this.roleMapper.list(pageQuery);
        PageInfo<TRole> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    public int add(TRole tRole) {
        int i = roleMapper.insert(tRole);
        updateRoleMenu(tRole);
        return i;
    }

    @Override
    public int edit(TRole tRole) {
        updateRoleMenu(tRole);
        return super.edit(tRole);
    }

    private void updateRoleMenu(TRole tRole) {
        if(tRole.getRoleMenus() != null && tRole.getRoleMenus().size() > 0){
            Long roleId = tRole.getRoleId();
            if(tRole.getRoleMenus() != null && tRole.getRoleMenus().size() > 0) {
                for (TRoleMenu roleMenu : tRole.getRoleMenus()) {
                    roleMenu.setRoleId(tRole.getRoleId());
                }
            }
            TRoleMenu roleMenu = new TRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenuMapper.delete(roleMenu);
            roleMenuMapper.batchSave(tRole.getRoleMenus());
        }

    }

    @Override
    public TRole readByName(String roleName) {
        return roleMapper.readByName(roleName);
    }
}

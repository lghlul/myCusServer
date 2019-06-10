package com.answer.service.impl;

import com.answer.common.PageQuery;
import com.answer.domain.TRole;
import com.answer.domain.TUser;
import com.answer.mapper.TRoleMapper;
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
}

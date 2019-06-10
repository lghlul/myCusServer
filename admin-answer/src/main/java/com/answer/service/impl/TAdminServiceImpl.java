package com.answer.service.impl;

import com.answer.common.PageQuery;
import com.answer.domain.TAdmin;
import com.answer.mapper.TAdminMapper;
import com.answer.service.ITAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TAdminServiceImpl extends BaseServiceImpl<TAdmin> implements ITAdminService{

    @Autowired
    private TAdminMapper adminMapper;
    @Override
    public PageInfo<TAdmin> list(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getOffset(), pageQuery.getLimit());
        if (pageQuery.getSortField() != null) {
            PageHelper.orderBy(pageQuery.getSortField() + " " + pageQuery.getSortDir());
        }
        List<TAdmin> admins = adminMapper.list(pageQuery);
        //得到分页的结果对象
        PageInfo<TAdmin> pageInfo = new PageInfo<>(admins);
        return pageInfo;
    }
}

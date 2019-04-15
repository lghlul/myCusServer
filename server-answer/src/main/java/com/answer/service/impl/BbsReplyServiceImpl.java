package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.BbsReply;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.BbsReplyMapper;
import com.answer.service.IBbsReplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BbsReplyServiceImpl implements IBbsReplyService {

    @Autowired
    private BbsReplyMapper bbsUserMapper;

    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public PageInfo<BbsReply> page(BbsReply bbsUser, String wxSession) {
        if (wxSession != null) {
            WXSessionCache session = this.cacheHelper.getSession(wxSession);
            bbsUser.setCreator(session.getOpenID());
        }
        PageHelper.startPage(bbsUser.getOffset(), bbsUser.getLimit());
        if (bbsUser.getSortField() != null) {
            PageHelper.orderBy(bbsUser.getSortField() + " " + bbsUser.getSortDir());
        }
        List<BbsReply> bbsUserList = bbsUserMapper.selectPage(bbsUser);
        //得到分页的结果对象
        PageInfo<BbsReply> pageInfo = new PageInfo<>(bbsUserList);
        return pageInfo;
    }

    @Override
    public int save(BbsReply bbsUser, String wxSession) {
        bbsUser.setCreateTime(System.currentTimeMillis());
        WXSessionCache session = this.cacheHelper.getSession(wxSession);
        bbsUser.setCreator(session.getOpenID());
        return bbsUserMapper.insert(bbsUser);
    }
}

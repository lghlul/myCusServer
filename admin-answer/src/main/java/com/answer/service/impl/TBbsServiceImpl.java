package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.common.CommonConstant;
import com.answer.domain.*;
import com.answer.mapper.TBbsMapper;
import com.answer.mapper.TBbsReplyMapper;
import com.answer.service.IBbsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TBbsServiceImpl extends BaseServiceImpl<Bbs> implements IBbsService {

    @Autowired
    private TBbsMapper bbsMapper;
    @Autowired
    private TBbsReplyMapper bbsReplyMapper;


    @Autowired
    private CacheHelper cacheHelper;


    @Override
    public PageInfo<Bbs> page(Bbs bbs) {
        PageHelper.startPage(bbs.getOffset(), bbs.getLimit());
        if (bbs.getSortField() != null) {
            PageHelper.orderBy(bbs.getSortField() + " " + bbs.getSortDir());
        }
        List<Bbs> bbsList = bbsMapper.selectPage(bbs);
        //得到分页的结果对象
        PageInfo<Bbs> pageInfo = new PageInfo<>(bbsList);
        List<Bbs> list = pageInfo.getList();
        if(list != null){
            for(Bbs obj : list){
                TUser user = cacheHelper.getUser(obj.getCreator());
                TJobnum jobNum = cacheHelper.getJobNum(user.getJobNum());
                TOrganization org = cacheHelper.getOrg(jobNum.getOrgID());
                obj.setRealName(jobNum.getRealName());
                obj.setOrgName(org.getOrgName());
            }
        }
        return pageInfo;
    }


    @Override
    public int delete(Bbs bbs) {
        BbsReply bbsReply = new BbsReply();
        bbsReply.setBbsID(bbs.getBbsID());
        bbsReply.setDelStatus(CommonConstant.Common.DEL_STATUS);
        bbsReplyMapper.update(bbsReply);
        bbs.setDelStatus(CommonConstant.Common.DEL_STATUS);
        return bbsMapper.update(bbs);
    }
}

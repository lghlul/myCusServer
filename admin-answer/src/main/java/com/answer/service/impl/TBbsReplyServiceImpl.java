package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.common.CommonConstant;
import com.answer.domain.*;
import com.answer.mapper.TBbsReplyMapper;
import com.answer.service.IBbsReplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TBbsReplyServiceImpl extends BaseServiceImpl<BbsReply> implements IBbsReplyService {

    @Autowired
    private TBbsReplyMapper bbsReplyMapper;
    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public PageInfo<BbsReply> page(BbsReply bbsReply) {
        PageHelper.startPage(bbsReply.getOffset(), bbsReply.getLimit());
        if (bbsReply.getSortField() != null) {
            PageHelper.orderBy(bbsReply.getSortField() + " " + bbsReply.getSortDir());
        }
        List<BbsReply> replyList = bbsReplyMapper.selectPage(bbsReply);
        //得到分页的结果对象
        PageInfo<BbsReply> pageInfo = new PageInfo<>(replyList);
        List<BbsReply> list = pageInfo.getList();
        if(list != null){
            for(BbsReply obj : list){
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
    public int delete(BbsReply bbsReply) {
        bbsReply.setDelStatus(CommonConstant.Common.DEL_STATUS);
        return bbsReplyMapper.update(bbsReply);
    }
}

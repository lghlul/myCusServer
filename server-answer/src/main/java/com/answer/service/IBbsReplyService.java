package com.answer.service;


import com.answer.domain.BbsReply;
import com.github.pagehelper.PageInfo;


public interface IBbsReplyService {

	PageInfo<BbsReply> page(BbsReply bbsUser, String wxSession);

	int save(BbsReply bbsUser , String wxSession);
}


package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.Bbs;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.BbsMapper;
import com.answer.service.IBbsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BbsServiceImpl implements IBbsService {

	@Autowired
	private BbsMapper bbsMapper;

	@Autowired
	private CacheHelper cacheHelper;


	@Override
	public PageInfo<Bbs> page(Bbs bbs, String wxSession) {
		if(wxSession != null){
			WXSessionCache session = this.cacheHelper.getSession(wxSession);
			bbs.setCreator(session.getOpenID());
		}
		PageHelper.startPage(bbs.getOffset(), bbs.getLimit());
		if (bbs.getSortField() != null) {
			PageHelper.orderBy(bbs.getSortField() + " " + bbs.getSortDir());
		}
		List<Bbs> bbsList = bbsMapper.selectPage(bbs);
		//得到分页的结果对象
		PageInfo<Bbs> pageInfo = new PageInfo<>(bbsList);
		return pageInfo;
	}

	@Override
	public int save(Bbs bbs , String wxSession) {
		bbs.setCreateTime(System.currentTimeMillis());
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		bbs.setCreator(session.getOpenID());
		return bbsMapper.insert(bbs);
	}
}

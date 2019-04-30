package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.domain.TGoods;
import com.answer.domain.TOrder;
import com.answer.domain.TOrganization;
import com.answer.domain.query.OrderQuery;
import com.answer.mapper.TOrderMapper;
import com.answer.service.ITOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class TOrderServiceImpl extends BaseServiceImpl<TOrder> implements ITOrderService{

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public PageInfo<TOrder> list(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery.getOffset(), orderQuery.getLimit());
        if (orderQuery.getSortField() != null) {
            PageHelper.orderBy(orderQuery.getSortField() + " " + orderQuery.getSortDir());
        }
        List<TOrder> goodsList = orderMapper.list(orderQuery);
        //得到分页的结果对象
        PageInfo<TOrder> pageInfo = new PageInfo<>(goodsList);

        List<TOrder> list = pageInfo.getList();
        if(list != null && list.size() > 0){
            for(TOrder order : list){
                TOrganization org = cacheHelper.getOrg(order.getOrgID());
                if(org != null){
                    order.setOrgName(org.getOrgName());
                }
            }
        }


        return pageInfo;
    }
}

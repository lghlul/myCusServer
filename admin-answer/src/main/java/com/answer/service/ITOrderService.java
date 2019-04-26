package com.answer.service;

import com.answer.domain.TOrder;
import com.answer.domain.query.OrderQuery;
import com.github.pagehelper.PageInfo;

public interface ITOrderService extends IBaseService<TOrder>{
    PageInfo<TOrder> list(OrderQuery orderQuery);
}

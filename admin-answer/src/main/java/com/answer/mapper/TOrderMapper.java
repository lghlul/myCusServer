package com.answer.mapper;

import com.answer.domain.TOrder;
import com.answer.domain.query.OrderQuery;

import java.util.List;

public interface TOrderMapper extends BaseMapper<TOrder>{

    List<TOrder> list(OrderQuery orderQuery);

}
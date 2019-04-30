package com.answer.service.impl;

import com.answer.domain.TSign;
import com.answer.service.ITSignService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TSignServiceImpl extends BaseServiceImpl<TSign> implements ITSignService{
}

package com.answer.service.impl;

import com.answer.domain.TOperlog;
import com.answer.service.ITOperlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TOperlogServiceImpl extends BaseServiceImpl<TOperlog> implements ITOperlogService{
}

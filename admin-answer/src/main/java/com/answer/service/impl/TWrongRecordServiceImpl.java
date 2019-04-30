package com.answer.service.impl;

import com.answer.domain.TWrongRecord;
import com.answer.service.ITWrongRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TWrongRecordServiceImpl extends BaseServiceImpl<TWrongRecord> implements ITWrongRecordService{
}

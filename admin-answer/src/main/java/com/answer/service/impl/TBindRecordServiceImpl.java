package com.answer.service.impl;

import com.answer.domain.TBindRecord;
import com.answer.service.ITBindRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TBindRecordServiceImpl extends BaseServiceImpl<TBindRecord> implements ITBindRecordService{
}

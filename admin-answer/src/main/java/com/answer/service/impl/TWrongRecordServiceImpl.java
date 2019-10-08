package com.answer.service.impl;

import com.answer.domain.TWrongRecord;
import com.answer.mapper.TWrongRecordMapper;
import com.answer.service.ITWrongRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TWrongRecordServiceImpl extends BaseServiceImpl<TWrongRecord> implements ITWrongRecordService{

    @Autowired
    private TWrongRecordMapper wrongRecordMapper;

    @Override
    public int deleteByOpenIdAndTypeId(String openID, Long typeID) {
        return wrongRecordMapper.deleteByOpenIdAndTypeId(openID, typeID);
    }
}

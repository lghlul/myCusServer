package com.answer.service;

import com.answer.domain.TWrongRecord;

public interface ITWrongRecordService extends IBaseService<TWrongRecord>{
    int deleteByOpenIdAndTypeId(String openID , Long typeID);
}

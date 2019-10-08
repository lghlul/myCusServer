package com.answer.mapper;

import com.answer.domain.TWrongRecord;
import org.apache.ibatis.annotations.Param;

public interface TWrongRecordMapper extends BaseMapper<TWrongRecord>{
    int deleteByOpenIdAndTypeId(@Param("openID") String openID , @Param("typeID") Long typeID);
}
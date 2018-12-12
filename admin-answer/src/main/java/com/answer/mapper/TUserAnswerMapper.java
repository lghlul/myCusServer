package com.answer.mapper;

import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;

import java.util.List;
import java.util.Map;

public interface TUserAnswerMapper extends BaseMapper<TUserAnswer>{

    List<OrgCount> selectOrgCount(Map<String , Object> map);

}
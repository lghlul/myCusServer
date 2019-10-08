package com.answer.mapper;

import com.answer.domain.AnswerDetailParam;
import com.answer.domain.OrgCount;
import com.answer.domain.TUserAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TUserAnswerMapper extends BaseMapper<TUserAnswer>{

    List<OrgCount> selectOrgCount(Map<String , Object> map);
    List<TUserAnswer> answerDetailPage(AnswerDetailParam answerDetailParam);
    int answerDetailCount(AnswerDetailParam answerDetailParam);

    int updateOrgID(Map<String , Object> map);


    int deleteByOpenIdAndTypeId(@Param("openID") String openID ,@Param("typeID") Long typeID);

}
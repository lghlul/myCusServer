package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.Question;

public interface QuestionMapper {
	public Question queryQuestionByOne(Map<String, Object> paramMap);

	public int queryQuestionNumByType(long paramLong);

	public Question queryQuestionByID(long questionID);
	
	public Question queryQuestionByResultMap(long questionID);
	
	public Question queryQuestionByIndex(Map<String, Object> paramMap);
	
	public List<Question> queryQuestionAll(long typeID);

}

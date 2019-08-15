package com.answer.service;

import com.answer.domain.Result;

public interface IQuestionService {
	/**
	 * 下一题
	 * @param paramString
	 * @param paramLong
	 * @return
	 */
	public Result getQuestionByOne(String paramString, long paramLong);
	
	/**
	 * 练习模式答题
	 * @param userAnswer
	 * @return
	 */
	public Result userAnswer(String wxSession,long quesID,String answerID);
	
	/**
	 * 删除错题
	 * @param id
	 * @return
	 */
	public Result delWrongRecord(String wxSession,long id);
	
	/**
	 * 分页查询错题
	 * @param wxSession
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Result getWrongPage(String wxSession,int pageNo,int pageSize);
	
	
	public Result getWrongDetail(String wxSession,long id);
	
	
	public Result getRoomQuestion(String wxSession , long roomID);
}

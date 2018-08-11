package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.UserAnswer;

public interface UserAnswerMapper {
	/**
	 * 查询用户已答题数
	 * @param paramMap
	 * @return
	 */
	public int queryAnswerCountByUserType(Map<String, Object> paramMap);
	
	
	public int addUserAnswer(UserAnswer userAnswer);
	
	/**
	 * 已经做对多少题 100题10分
	 * @param openID
	 * @return
	 */
	public int queryAnswerRightCount(String openID);
	
	public int updateUserAnswer(String openID);
	
	
	public Long queryMaxIDByOpenID(Map<String , Object> map);
	
	
	public List<UserAnswer> queryUserAnswerByMap(Map<String , Object> map);
	
}

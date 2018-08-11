package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.User;

public interface UserMapper {
	public User queryUserByOpenID(String openID);

	public int addUser(User paramUser);
	
	public int updateUser(User user);
	
	public int queryScore(String openID);
	
	public List<User> queryRank(Map<String , Object> map);
	
	public int queryMyRank(int score);
	
	public int queryUserCount();
}

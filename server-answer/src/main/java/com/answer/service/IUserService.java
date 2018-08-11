package com.answer.service;

import com.answer.domain.Result;
import com.answer.domain.User;

public interface IUserService {
	public User getUserByOpenID(String paramString);

	public Result registerUser(User paramUser);
	
	public Result getScore(String wxSession);
	
	public Result editUser(String wxSession,String userImg,String userName);
	
	public Result getRankList(String wxSession , int pageNo , int pageSize);
	
	public Result checkJobNum(String wxSession);
	
	public Result bindJobNum(String wxSession , String jobNum);
	
	
	public Result getUserInfo(String wxSession);
	
	
	public Result createRoom(String wxSession , long typeID);
	

}

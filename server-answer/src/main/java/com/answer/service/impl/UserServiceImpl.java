package com.answer.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.domain.BindRecord;
import com.answer.domain.JobNumBean;
import com.answer.domain.Question;
import com.answer.domain.Result;
import com.answer.domain.Room;
import com.answer.domain.RoomQuestion;
import com.answer.domain.User;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.BindRecordMapper;
import com.answer.mapper.JobNumMapper;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.mapper.UserMapper;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CacheHelper cacheHelper;
	@Autowired
	private JobNumMapper jobNumMapper;
	@Autowired
	private BindRecordMapper bindRecordMapper;
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private RoomQuestionMapper roomQuestionMapper;
	@Autowired
	private QuestionMapper questionMapper;
	public User getUserByOpenID(String openID) {
		User user = this.userMapper.queryUserByOpenID(openID);
		return user;
	}

	public Result registerUser(User user) {
		user.setCreateTime(System.currentTimeMillis());
		this.userMapper.addUser(user);
		return new Result();
	}

	@Override
	public Result getScore(String wxSession) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		float score = this.userMapper.queryScore(session.getOpenID());
		Result result = new Result();
		Map<String , Object> map = new HashMap<>();
		map.put("score", score);
		result.setResultData(map);
		return result;
	}

	@Override
	public Result editUser(String wxSession,String userImg,String userName) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		User user = new User();
		user.setOpenID(session.getOpenID());
		user.setUserImg(userImg);
		user.setUserName(userName);
		this.userMapper.updateUser(user);
		return new Result();
	}

	@Override
	public Result getRankList(String wxSession , int pageNo, int pageSize) {
		Map<String,Object> map = new HashMap<>();
		map.put("start", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		//总数
		int totalCount = this.userMapper.queryUserCount();
		//分页排名列表
		List<User> userList = this.userMapper.queryRank(map);
		//遍历获取用户头像  清空openID
		if(userList != null){
			for(User u : userList){
				if(u.getUserImg() == null){
					u.setUserImg("");
				}
				if(u.getUserName() == null){
					u.setUserName("");
				}
				u.setOpenID(null);
			}
		}
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		User user = this.userMapper.queryUserByOpenID(session.getOpenID());
		//自己排名
		int myRank = this.userMapper.queryMyRank(user.getScore() + user.getUsedScore());
		List<User> users = this.userMapper.queryUserByScore(user.getScore() + user.getUsedScore());
		if(users != null && users.size() > 0){
			for(int i = 0 ; i < users.size() ; i++){
				if(users.get(i).getUserID() == user.getUserID()){
					myRank = myRank + i + 1;
					break;
				}
			}
		}

		Result result = new Result();
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("list", userList);
		resultMap.put("totalCount", totalCount);
		int pageCount = totalCount%pageSize == 0?totalCount/pageSize : (totalCount/pageSize + 1);
		resultMap.put("pageCount", pageCount);
		resultMap.put("myRank", myRank);
		
		result.setResultData(resultMap);
		return result;
	}

	@Override
	public Result checkJobNum(String wxSession) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		User user = this.userMapper.queryUserByOpenID(session.getOpenID());
		Result result = new Result();
		if(user.getJobNum() == null || "".equals(user.getJobNum())){
			result.setResultCode(Constant.returnCode.NO_JOBNUM);
		}
		return result;
	}

	@Override
	public Result bindJobNum(String wxSession, String jobNum) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		User u = this.userMapper.queryUserByOpenID(session.getOpenID());
		Result result = new Result();
		if(u.getJobNum() != null && !"".equals(u.getJobNum())){
			result.setResultCode(Constant.returnCode.NO_BIND_REPEAT);
			return result;
		}

		if(!jobNum.startsWith("0")){
			jobNum = "0" + jobNum;
		}

		BindRecord bindRecord = new BindRecord();
		bindRecord.setJobNum(jobNum);
		bindRecord.setOpenID(session.getOpenID());
		Calendar now = Calendar.getInstance();  
		bindRecord.setOperYear(now.get(Calendar.YEAR));
		bindRecord.setOperMonth((now.get(Calendar.MONTH) + 1));
		bindRecord.setOperDay(now.get(Calendar.DAY_OF_MONTH));
		bindRecord.setOperTime(now.getTimeInMillis());
		int bindCount = this.bindRecordMapper.queryRecord(bindRecord);
		Log4jUtil.info("queryRecord...bindCount=" + bindCount);
		//每天最多绑定三次   测试环境不做限制
		if(bindCount > 2){
			result.setResultCode(Constant.returnCode.BIND_OVER_THREE);
			return result;
		}
		JobNumBean jobBean = this.jobNumMapper.queryJobNumByID(jobNum);
		if(jobBean == null || jobBean.getStatus() == Constant.JOBNUM_USELESS){
			result.setResultCode(Constant.returnCode.USELESS_JOBNUM);
		}else{
			
			User user = new User();
			user.setOpenID(session.getOpenID());
			user.setJobNum(jobNum);
			//用户绑定工号
			this.userMapper.updateUser(user);
			//更新工号状态
			jobBean.setStatus(Constant.JOBNUM_USELESS);
			this.jobNumMapper.updateJobNum(jobBean);
		}
		this.bindRecordMapper.addRecord(bindRecord);
		return result;
	}

	@Override
	public Result getUserInfo(String wxSession) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		User user = this.userMapper.queryUserByOpenID(session.getOpenID());
		user.setUserID(0);
		user.setOpenID(null);
		if(user.getUserImg() == null){
			user.setUserImg("");
		}
		if(user.getUserName() == null){
			user.setUserName("");
		}
		Result result = new Result();
		result.setResultData(user);
		return result;
	}

	@Override
	public Result createRoom(String wxSession , long typeID) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		Result result = new Result();
		User user = this.userMapper.queryUserByOpenID(session.getOpenID());
		if(user.getScore() < 10){
			//积分不够
			result.setResultCode(Constant.returnCode.SCORE_NOT_ENOUGH);
			return result;
		}
		Room room = new Room();
		room.setCreateOpenID(session.getOpenID());
		room.setTypeID(typeID);
		room.setCreateTime(System.currentTimeMillis());
		roomMapper.addRoom(room);
		int count = this.questionMapper.queryQuestionNumByType(room.getTypeID());
		List<Question> list = null;
		if(count > 10){
			list = this.getQuestionListForRoom(count, room.getTypeID(), room.getRoomID());
			
		}else{
			//如果不超过10题 查所有
			list = this.questionMapper.queryQuestionAll(room.getTypeID());
			for(Question question : list){
				RoomQuestion roomQuestion = new RoomQuestion();
				roomQuestion.setRoomID(room.getRoomID());
				roomQuestion.setQuesID(question.getQuesID());
				roomQuestion.setRightAnswer(question.getRightAnswerID());
				roomQuestionMapper.addRoomQuestion(roomQuestion);
			}
		}
		
		Map<String , Object> map = new HashMap<>();
		map.put("roomID", room.getRoomID());
		result.setResultData(map);
		return result;
	}
	
	private List<Question> getQuestionListForRoom(int count,long typeID,long roomID){
		List<Question> list = new ArrayList<>();
		List<Long> indexs = new ArrayList<>();
		Random r = new Random();
		while(indexs.size() < 10){
			long i = r.nextInt(count-1);
			if(!indexs.contains(i)){
				indexs.add(i);
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("typeID", typeID);
		for(Long index : indexs){
			map.put("start", index);
			Question question = this.questionMapper.queryQuestionByIndex(map);
			list.add(question);
			RoomQuestion roomQuestion = new RoomQuestion();
			roomQuestion.setRoomID(roomID);
			roomQuestion.setQuesID(question.getQuesID());
			roomQuestion.setRightAnswer(question.getRightAnswerID());
			roomQuestionMapper.addRoomQuestion(roomQuestion);
		}
		return list;
	}

}

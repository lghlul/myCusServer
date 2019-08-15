package com.answer.service.impl;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.TrainMapper;
import com.answer.mapper.UserMapper;
import com.answer.service.ITrainService;
import com.answer.thread.ThreadCache;
import com.answer.thread.TrainThread;
import com.answer.utils.CommonUtil;
import com.answer.utils.Constant;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TrainServiceImpl implements ITrainService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);

	@Autowired
	private TrainMapper trainMapper;

	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private CacheHelper cacheHelper;

	@Autowired
	private UserMapper userMapper;



	@Override
	public Result createTrain(Train train) {
		train.setCreateTime(System.currentTimeMillis());
		WXSessionCache session = this.cacheHelper.getSession(train.getCreater());


		//获取考试配置
		Config config = cacheHelper.getConfig(Constant.ConfigKey.TRAIN_CONFIG);
		TrainConfig trainConfig = JSON.parseObject(config.getConfigValue() , TrainConfig.class);

		train.setCreater(session.getOpenID());
		train.setQuesNum(trainConfig.getQuesNum());
		trainMapper.insert(train);
		Map<String , Object> map = new HashMap<>();
		map.put("typeID" , train.getTypeID());
		map.put("size" , trainConfig.getQuesNum());
		List<Question> questions = trainMapper.queryTrainQues(map);
		if(questions != null){
			List<TrainQuestion> list = new ArrayList<>();
			for(Question question : questions){
				TrainQuestion tq = new TrainQuestion();
				tq.setQuesID(question.getQuesID());
				tq.setTrainID(train.getTrainID());
				list.add(tq);
			}
			trainMapper.insertTrainQuestion(list);
		}
		Result result = new Result();
		Map<String , Object> dataMap = new HashMap<>();
		dataMap.put("trainID" , train.getTrainID());
		dataMap.put("questions" , questions);
		dataMap.put("trainTime" , trainConfig.getTrainTime());
        dataMap.put("questionSize" , trainConfig.getQuesNum());
		result.setResultData(dataMap);


		//创建线程  到时间结束考试
		TrainThread trainThread = new TrainThread(trainMapper , train.getTrainID() , trainConfig.getTrainTime());
		ThreadCache.put(train.getTrainID() , trainThread);
		trainThread.start();
		return result;
	}


	@Override
	public Result finishTrain(Long trainID , List<TrainQuestion> list) {
		int rightNum = 0;
		Result result = new Result();
		Map<String , Object> dataMap = new HashMap<>();
		if(list != null){
			double score = 0;
			//对线程进行关闭
			TrainThread thread = ThreadCache.get(trainID);
			if(thread != null){
				thread.interrupt();
				ThreadCache.remove(trainID);
			}
			//获取考试信息
			Train trainDO = trainMapper.queryById(trainID);
			if(trainDO.getTrainStatus() == Constant.TRAIN_STATUS_FINISH){
				result.setResultCode(Constant.returnCode.TRAIN_FINISHED);
				return result;
			}

			//获取考试配置信息
			//获取考试配置
			Config config = cacheHelper.getConfig(Constant.ConfigKey.TRAIN_CONFIG);
			TrainConfig trainConfig = JSON.parseObject(config.getConfigValue() , TrainConfig.class);
			for(TrainQuestion tq : list){
				tq.setTrainID(trainID);
				Question question = this.questionMapper.queryQuestionByID(tq.getQuesID());
				if(CommonUtil.isRight(question.getRightAnswerID(), tq.getAnswerID())){
					tq.setIsRight(Constant.ANSWER_RIGHT);
					rightNum++;
					//score += trainConfig.getScore();
				}else{
					tq.setIsRight(Constant.ANSWER_WRONG);
				}
				trainMapper.updateTrainQuestion(tq);
			}
			Train train = new Train();
			train.setTrainStatus(Constant.TRAIN_STATUS_FINISH);
			train.setFinishTime(System.currentTimeMillis());
			train.setTrainID(trainID);
			train.setRightNum(rightNum);
			trainMapper.update(train);

			if(rightNum >= trainConfig.getRightNum()){
				score = trainConfig.getScore();
			}
			//更新用户积分
			User user = new User();
			user.setOpenID(trainDO.getCreater());
			user.setScore(Float.parseFloat(score + ""));
			logger.info("finishTrain userAnswer...考试结束计分user=" + JSON.toJSONString(user));
			userMapper.updateUser(user);
			//得分
			dataMap.put("score" , score);
			//正确题数
			dataMap.put("rightNum" , rightNum);
			//总题数
			dataMap.put("totalNum" , trainDO.getQuesNum());
			result.setResultData(dataMap);
		}

		return result;
	}


	@Override
	public Result getTrainList(String wxSession, Integer pageNo, Integer pageSize) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		Map<String , Object> map = new HashMap<>();
		map.put("creater" , session.getOpenID());
		map.put("offSet" ,(pageNo - 1)*pageSize );
		map.put("size" , pageSize);
		List<Train> trains = this.trainMapper.queryTrainList(map);
		int totalCount = this.trainMapper.queryTrainListCount(map);
		Map<String , Object> dataMap = new HashMap<>();
		dataMap.put("trains" , trains);
		dataMap.put("totalCount" , totalCount);
		int totalPage = totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
		dataMap.put("totalPage" , totalPage);
		Result result = new Result();
		result.setResultData(dataMap);
		return result;
	}

	@Override
	public Result getTrainDetail(String wxSession ,Long trainID) {
		Map<String , Object> map = new HashMap<>();
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		map.put("creater" , session.getOpenID());
		map.put("trainID" , trainID);
		List<Question> questions = this.trainMapper.queryTrainDetail(map);
		Result result = new Result();
		result.setResultData(questions);
		return result;
	}
}

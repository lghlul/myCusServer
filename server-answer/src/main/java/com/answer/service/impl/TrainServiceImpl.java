package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.TrainMapper;
import com.answer.service.ITrainService;
import com.answer.utils.CommonUtil;
import com.answer.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TrainServiceImpl implements ITrainService {

	@Autowired
	private TrainMapper trainMapper;

	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private CacheHelper cacheHelper;


	@Override
	public Result createTrain(Train train) {
		train.setCreateTime(System.currentTimeMillis());
		WXSessionCache session = this.cacheHelper.getSession(train.getCreater());
		train.setCreater(session.getOpenID());
		trainMapper.insert(train);
		Map<String , Object> map = new HashMap<>();
		int size = 20;
		train.setQuesNum(size);
		map.put("typeID" , train.getTypeID());
		map.put("size" , size);
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
		result.setResultData(dataMap);
		return result;
	}


	@Override
	public Result finishTrain(Long trainID , List<TrainQuestion> list) {
		int rightNum = 0;
		if(list != null){
			for(TrainQuestion tq : list){
				tq.setTrainID(trainID);
				Question question = this.questionMapper.queryQuestionByID(tq.getQuesID());
				if(CommonUtil.isRight(question, tq.getAnswerID())){
					tq.setIsRight(Constant.ANSWER_RIGHT);
					rightNum++;
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
		}
		Result result = new Result();
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

package com.answer.service.impl;

import com.answer.domain.Question;
import com.answer.domain.Result;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;
import com.answer.mapper.TrainMapper;
import com.answer.service.ITrainService;
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


	@Override
	public Result createTrain(Train train) {
		train.setCreateTime(System.currentTimeMillis());
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
		result.setResultData(questions);
		return result;
	}


	@Override
	public Result finishTrain(List<TrainQuestion> list) {
		if(list != null){
			Long trainID = 0l;
			for(TrainQuestion tq : list){
				if(trainID == 0){
					trainID = tq.getTrainID();
				}
				trainMapper.updateTrainQuestion(tq);
			}
			Train train = new Train();
			train.setTrainStatus(Constant.TRAIN_STATUS_FINISH);
			train.setFinishTime(System.currentTimeMillis());
			train.setTrainID(trainID);
			trainMapper.update(train);
		}
		Result result = new Result();
		return result;
	}
}

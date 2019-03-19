package com.answer.service;


import com.answer.domain.Result;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;

import java.util.List;

public interface ITrainService {


	Result createTrain(Train train);

	Result finishTrain(Long trainID , List<TrainQuestion> list);

	Result getTrainList(String wxSession , Integer pageNo , Integer pageSize);

	Result getTrainDetail(String wxSession , Long trainID);

}

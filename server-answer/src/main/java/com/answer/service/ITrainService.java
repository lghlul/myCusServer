package com.answer.service;


import com.answer.domain.Result;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;

import java.util.List;

public interface ITrainService {


	Result createTrain(Train train);

	Result finishTrain(List<TrainQuestion> list);

}

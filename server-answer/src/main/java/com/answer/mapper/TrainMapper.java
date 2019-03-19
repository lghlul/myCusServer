package com.answer.mapper;

import com.answer.domain.Question;
import com.answer.domain.Train;
import com.answer.domain.TrainQuestion;

import java.util.List;
import java.util.Map;

public interface TrainMapper {

	 List<Question> queryTrainQues(Map<String , Object> map);

	 int insert(Train train);

	 int insertTrainQuestion(List<TrainQuestion> list);

	 int updateTrainQuestion(TrainQuestion trainQuestion);

	 int update(Train train);

	 List<Train> queryTrainList(Map<String , Object> map);

	 int queryTrainListCount(Map<String , Object> map);


	 List<Question> queryTrainDetail(Map<String , Object> map);

}

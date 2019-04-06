package com.answer.mapper;


import com.answer.domain.ActivityQuestion;
import com.answer.domain.ActivityUserAnswer;

import java.util.List;

public interface ActivityQuestionMapper {
    List<ActivityQuestion> listByActivityID(String activityID);

    int insertUserAnswer(List<ActivityUserAnswer> list);

    ActivityQuestion readByQuesID(String quesID);

}
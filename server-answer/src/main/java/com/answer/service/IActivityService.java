package com.answer.service;


import com.answer.domain.Activity;
import com.answer.domain.ActivityQuestion;
import com.answer.domain.ActivityUserAnswer;
import com.answer.domain.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface IActivityService {

	PageInfo<Activity> page(Activity activity);

	List<ActivityQuestion> listByActivityID(String activityID);


	Result finish(List<ActivityUserAnswer> activityUserAnswers , String wxSession, Long activityID);
}


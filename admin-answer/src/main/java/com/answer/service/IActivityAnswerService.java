package com.answer.service;

import com.answer.domain.TActivityAnswer;
import com.answer.domain.UserAnswer4export;

import java.util.List;

public interface IActivityAnswerService extends IBaseService<TActivityAnswer>{
    List<UserAnswer4export> listUserAnswer4export(Long activityID);
}

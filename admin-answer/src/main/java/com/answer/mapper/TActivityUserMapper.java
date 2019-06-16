package com.answer.mapper;

import com.answer.domain.UserAnswer4export;

import java.util.List;

public interface TActivityUserMapper {
    List<UserAnswer4export> listUserAnswer4export(Long activityID);
}

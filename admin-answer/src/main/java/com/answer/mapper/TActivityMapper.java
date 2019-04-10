package com.answer.mapper;

import com.answer.domain.Activity;
import com.answer.domain.ActivityUser;
import com.answer.domain.query.ActivityUserQuery;

import java.util.List;

public interface TActivityMapper extends BaseMapper<Activity>{

    List<ActivityUser> listJoinUser(ActivityUserQuery activityUserQuery);

}
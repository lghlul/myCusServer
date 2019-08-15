package com.answer.mapper;


import com.answer.domain.Activity;

import java.util.List;

public interface ActivityMapper {
	List<Activity> selectPage(Activity activity);

	Activity selectByID(String activityID);
}

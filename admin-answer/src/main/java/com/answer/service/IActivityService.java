package com.answer.service;

import com.answer.domain.Activity;
import com.answer.domain.ActivityUser;
import com.answer.domain.query.ActivityUserQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;


public interface IActivityService extends IBaseService<Activity>{

    void insertQues(MultipartFile file, Long activityID);

    PageInfo<ActivityUser> listActivityUser(ActivityUserQuery activityUserQuery);
}

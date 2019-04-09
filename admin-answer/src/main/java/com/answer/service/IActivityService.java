package com.answer.service;

import com.answer.domain.Activity;
import org.springframework.web.multipart.MultipartFile;

public interface IActivityService extends IBaseService<Activity>{

    void insertQues(MultipartFile file, Long activityID);
}

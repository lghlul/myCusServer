package com.answer.service;

import com.answer.domain.Activity;
import com.answer.domain.ActivityUser;
import com.answer.domain.OrgReport;
import com.answer.domain.query.ActivityQuery;
import com.answer.domain.query.ActivityUserQuery;
import com.answer.domain.query.OrgReportQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IActivityService extends IBaseService<Activity>{

    void insertQues(MultipartFile file, Long activityID)throws Exception;

    PageInfo<ActivityUser> listActivityUser(ActivityUserQuery activityUserQuery);

    PageInfo<OrgReport> listOrgReport(OrgReportQuery orgReportQuery);

    PageInfo<Activity> page(ActivityQuery activityQuery);

    void delete(Long activityID);

    Activity read(Long activityID);

}

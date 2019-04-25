package com.answer.controller;

import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.Activity;
import com.answer.domain.ActivityUser;
import com.answer.domain.OrgReport;
import com.answer.domain.TActivityQuestion;
import com.answer.domain.query.ActivityUserQuery;
import com.answer.service.IActivityAnswerService;
import com.answer.service.IActivityQuestionService;
import com.answer.service.IActivityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 11:36
 * @Modified By：
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;


    @Autowired
    private IActivityQuestionService activityQuestionService;


    @GetMapping("list")
    public Object list(Activity activity) {
        PageInfo<Activity> page = activityService.page(activity);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }


    @GetMapping("listQues")
    public Object listQues(TActivityQuestion question) {
        List<TActivityQuestion> tActivityQuestions = activityQuestionService.queryPage(question);
        return ResultCodeEnum.SUCCESS.getResponse(tActivityQuestions);
    }

    @PostMapping("update")
    public Object update(Activity activity) {
        if (activity.getActivityStatus() != null) {
            if (activity.getActivityStatus() == CommonConstant.Common.ACTIVITY_STATUS_START) {
                Activity act = activityService.queryById(activity.getActivityID() + "");
                if(act.getQuesNum() == 0){
                    return ResultCodeEnum.QUES_NUM_ZERO.getResponse();
                }
                activity.setStartTime(System.currentTimeMillis());
            } else if (activity.getActivityStatus() == CommonConstant.Common.ACTIVITY_STATUS_END) {
                activity.setEndTime(System.currentTimeMillis());
            }
        }
        activityService.edit(activity);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

    @PostMapping("save")
    public Object save(Activity activity) {
        activity.setCreateTime(System.currentTimeMillis());
        activity.setActivityStatus(CommonConstant.Common.ACTIVITY_STATUS_UN_START);
        activityService.add(activity);
        return ResultCodeEnum.SUCCESS.getResponse();
    }


    @PostMapping("importQues")
    public Object importQues(MultipartFile file, Long activityID) {

        String originalFilename = file.getOriginalFilename();
        if(originalFilename.contains("xls") || originalFilename.contains("xlsx")){
            //判断活动状态
            Activity activity = activityService.queryById(activityID + "");
            if (activity.getActivityStatus() != CommonConstant.Common.ACTIVITY_STATUS_UN_START) {
                return ResultCodeEnum.ACTIVITY_START.getResponse();
            }
            activityService.insertQues(file, activityID);
            return ResultCodeEnum.SUCCESS.getResponse();
        }else{
            return ResultCodeEnum.FILE_FORMAT_ERROR.getResponse();
        }
    }


    @GetMapping("listUser")
    public Object listUser(ActivityUserQuery activityUserQuery) {
        PageInfo<ActivityUser> page = activityService.listActivityUser(activityUserQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(page.getTotal());
        pageResult.setTotalPage(page.getPages());
        pageResult.setList(page.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }


    @GetMapping("listOrgReport")
    public Object listOrgReport(Long orgID) {
        List<OrgReport> orgReports = activityService.listOrgReport(orgID);
        return ResultCodeEnum.SUCCESS.getResponse(orgReports);
    }

}

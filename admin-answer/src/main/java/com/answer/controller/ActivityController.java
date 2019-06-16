package com.answer.controller;

import com.answer.common.CommonConfig;
import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.*;
import com.answer.domain.query.ActivityQuery;
import com.answer.domain.query.ActivityUserQuery;
import com.answer.domain.query.OrgReportQuery;
import com.answer.service.IActivityAnswerService;
import com.answer.service.IActivityQuestionService;
import com.answer.service.IActivityService;
import com.github.pagehelper.PageInfo;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    private IActivityAnswerService activityAnswerService;


    @Autowired
    private IActivityQuestionService activityQuestionService;


    @GetMapping("list")
    public Object list(ActivityQuery activityQuery) {
        PageInfo<Activity> page = activityService.page(activityQuery);
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
                //activity.setStartTime(System.currentTimeMillis());
            } else if (activity.getActivityStatus() == CommonConstant.Common.ACTIVITY_STATUS_END) {
                //activity.setEndTime(System.currentTimeMillis());
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
    public Object listOrgReport(OrgReportQuery orgReportQuery) {
        PageInfo<OrgReport> orgReports = activityService.listOrgReport(orgReportQuery);
        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(orgReports.getTotal());
        pageResult.setTotalPage(orgReports.getPages());
        pageResult.setList(orgReports.getList());
        return ResultCodeEnum.SUCCESS.getResponse(pageResult);
    }


    @GetMapping("exportResult")
    public Object exportResult(Long activityID) {
        Activity activity = activityService.queryById(activityID + "");
        List<UserAnswer4export> userAnswer4exports = activityAnswerService.listUserAnswer4export(activityID);
        String fileName = activity.getActivityName() + ".xls";
        String filePath = CommonConfig.FILE_SAVE_PATH + fileName;
        WritableWorkbook workbook = null;
        try {
            workbook = Workbook.createWorkbook(new File(filePath));
            //创建新的一页
            WritableSheet sheet = workbook.createSheet(activity.getActivityName(),0);
            String [] titles = {"姓名","单位","题目","结果"};
            for(int i = 0 ; i < titles.length ; i++){
                Label label = new Label(i,0,titles[i]);
                sheet.addCell(label);
            }
            if(userAnswer4exports != null && userAnswer4exports.size() > 0){
                for(int i = 1 ; i <= userAnswer4exports.size() ; i++){
                    UserAnswer4export userAnswer4export = userAnswer4exports.get(i - 1);
                    String [] contents = {userAnswer4export.getRealName(),userAnswer4export.getOrgName(),userAnswer4export.getQuesDesc(),userAnswer4export.getIsRight() == 1?"正确":"错误"};
                    for(int j = 0 ; j < contents.length ; j++){
                        Label label = new Label(j,i,contents[j]);
                        sheet.addCell(label);
                    }
                }
            }
            workbook.write();
            workbook.close();
            return ResultCodeEnum.SUCCESS.getResponse(fileName);
            // 生成一个表格
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultCodeEnum.FAIL.getResponse();
    }

}

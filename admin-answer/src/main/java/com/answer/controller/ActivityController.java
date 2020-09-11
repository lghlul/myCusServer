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
import jxl.CellView;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.Pattern;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

        try{
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
        }catch (Exception e){
            return ResultCodeEnum.FILE_QUESTION_FORMAT_ERROR.getResponse();
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
            CellView cellView = new CellView();
            cellView.setAutosize(true); //设置自动大小
            sheet.setColumnView(1, cellView);
            sheet.setColumnView(2, cellView);
            String [] titles = {"姓名","单位","题目","结果"};
            for(int i = 0 ; i < titles.length ; i++){
                WritableCellFormat format = new WritableCellFormat(); //设置背景颜色和单元格样式
                format.setBackground(Colour.BLUE, Pattern.NONE); //设置水平位置--居中
                WritableFont font = new WritableFont(WritableFont.ARIAL,14,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
                format.setFont(font);
                Label label = new Label(i,0,titles[i] , format);
                sheet.addCell(label);
            }
            if(userAnswer4exports != null && userAnswer4exports.size() > 0){
                for(int i = 1 ; i <= userAnswer4exports.size() ; i++){
                    UserAnswer4export userAnswer4export = userAnswer4exports.get(i - 1);
                    String [] contents = {userAnswer4export.getRealName(),userAnswer4export.getOrgName(),userAnswer4export.getQuesDesc(),userAnswer4export.getIsRight() == 1?"正确":"错误"};
                    for(int j = 0 ; j < contents.length ; j++){
                        WritableCellFormat format = new WritableCellFormat();
                        format.setWrap(true);
                        if(contents[j].equals("错误")){
                            WritableFont font = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.RED);
                            format.setFont(font);
                        }else if(contents[j].equals("正确")){
                            WritableFont font = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.GREEN);
                            format.setFont(font);
                        }
                        Label label = new Label(j,i,contents[j] , format);
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


    @DeleteMapping("delete/{activityID}")
    public Object delete(@PathVariable("activityID") Long activityID) {
        Activity activity = activityService.read(activityID);
        if(activity != null && activity.getActivityStatus().intValue() == 2){
            return ResultCodeEnum.ACTIVITY_BEGINING.getResponse();
        }else{
            activityService.delete(activityID);
            return ResultCodeEnum.SUCCESS.getResponse();
        }
    }

}

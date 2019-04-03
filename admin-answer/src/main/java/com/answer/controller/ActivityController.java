package com.answer.controller;

import com.answer.common.CommonConstant;
import com.answer.common.PageResult;
import com.answer.common.ResultBean;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.Activity;
import com.answer.domain.TActivityAnswer;
import com.answer.domain.TActivityQuestion;
import com.answer.service.IActivityAnswerService;
import com.answer.service.IActivityQuestionService;
import com.answer.service.IActivityService;
import com.github.pagehelper.PageInfo;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        activityService.add(activity);
        return ResultCodeEnum.SUCCESS.getResponse();
    }


    @PostMapping("importQues")
    public Object importQues(MultipartFile file, Long activityID) {

        //判断活动状态
        Activity activity = activityService.queryById(activityID + "");
        if(activity.getActivityStatus() != CommonConstant.Common.ACTIVITY_STATUS_UN_START){
            return ResultCodeEnum.ACTIVITY_START.getResponse();
        }

        //导入前  将之前的题删除
        activityAnswerService.deleteById(activityID + "");
        activityQuestionService.deleteById(activityID + "");
        try {
            InputStream is = file.getInputStream();
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheetSize = wb.getNumberOfSheets();
            TActivityQuestion question = null;
            String rightAnswer = "";
            Map<String, Object> map = new HashMap<>();
            for (int index = 0; index < sheetSize; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    //读取第一列
                    String cellinfo = sheet.getCell(0, i).getContents().trim();
                    if (cellinfo == null || "".equals(cellinfo)) {
                        // 第一列 无数据   是答案
                        TActivityAnswer answer = new TActivityAnswer();
                        answer.setQuesID(question.getQuesID());
                        answer.setAnsDesc(sheet.getCell(2, i).getContents().trim());
                        answer.setCreateTime(System.currentTimeMillis());
                        if (answer.getAnsDesc() != null && !"".equals(answer.getAnsDesc())) {
                            answer.setActivityID(activityID);
                            activityAnswerService.add(answer);
                        }
                        map.put(sheet.getCell(1, i).getContents().trim().toUpperCase(), answer.getAnsID());
                    } else {
                        //有数据 题
                        //更新上一题的正确答案
                        if (question != null && rightAnswer != null && !"".equals(rightAnswer)) {
                            char[] chars = rightAnswer.toCharArray();
                            rightAnswer = "";
                            for (char c : chars) {
                                if (map.get(String.valueOf(c)) != null) {
                                    rightAnswer += map.get(String.valueOf(c).toUpperCase()).toString() + ",";
                                }
                            }
                            question.setRightAnswerID(rightAnswer.substring(0, rightAnswer.length() - 1));
                            //更新
                            activityQuestionService.edit(question);
                            map.clear();
                            question = null;
                            rightAnswer = "";
                        }

                        question = new TActivityQuestion();
                        question.setCreateTime(System.currentTimeMillis());
                        question.setQuesDesc(cellinfo.trim());
                        rightAnswer = sheet.getCell(1, i).getContents().trim().toUpperCase();
                        String quesType = sheet.getCell(2, i).getContents().trim().toUpperCase();
                        //题型1 单选2 多选 3判断
                        if("单选题".equals(quesType)){
                            question.setQuesType((byte) 1);
                        }else if("多选题".equals(quesType)){
                            question.setQuesType((byte) 2);
                        }else if("判断题".equals(quesType)){
                            question.setQuesType((byte) 3);
                        }
                        question.setActivityID(activityID);
                        activityQuestionService.add(question);

                    }

                }

            }
            if (question != null && rightAnswer != null && !"".equals(rightAnswer)) {
                char[] chars = rightAnswer.toCharArray();
                rightAnswer = "";
                for (char c : chars) {
                    if (map.get(String.valueOf(c)) != null) {
                        rightAnswer += map.get(String.valueOf(c)).toString() + ",";
                    }
                }
                question.setRightAnswerID(rightAnswer.substring(0, rightAnswer.length() - 1));
                //更新
                activityQuestionService.edit(question);
                map.clear();
                question = null;
                rightAnswer = "";
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return ResultCodeEnum.SUCCESS.getResponse();
    }


}

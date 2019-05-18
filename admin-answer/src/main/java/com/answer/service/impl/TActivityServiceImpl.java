package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.common.CommonConfig;
import com.answer.domain.*;
import com.answer.domain.query.ActivityQuery;
import com.answer.domain.query.ActivityUserQuery;
import com.answer.domain.query.OrgReportQuery;
import com.answer.mapper.TActivityAnswerMapper;
import com.answer.mapper.TActivityMapper;
import com.answer.mapper.TActivityQuestionMapper;
import com.answer.service.IActivityService;
import com.answer.service.ITrainConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class TActivityServiceImpl extends BaseServiceImpl<Activity> implements IActivityService {

    @Autowired
    TActivityMapper activityMapper;

    @Autowired
    TActivityAnswerMapper activityAnswerMapper;

    @Autowired
    TActivityQuestionMapper activityQuestionMapper;


    @Autowired
    private CacheHelper cacheHelper;

    @Override
    public PageInfo<Activity> page(ActivityQuery activityQuery) {
        PageHelper.startPage(activityQuery.getOffset(), activityQuery.getLimit());
        if (activityQuery.getSortField() != null) {
            PageHelper.orderBy(activityQuery.getSortField() + " " + activityQuery.getSortDir());
        }
        List<Activity> studentList = activityMapper.list(activityQuery);
        //得到分页的结果对象
        PageInfo<Activity> pageInfo = new PageInfo<>(studentList);
        return pageInfo;
    }


    @Override
    public void insertQues(MultipartFile file, Long activityID) {
        //导入前  将之前的题删除
        activityAnswerMapper.deleteById(activityID + "");
        activityQuestionMapper.deleteById(activityID + "");
        try {

            int quesNum = 0;

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
                for (int i = 1; i < sheet.getRows(); i++) {
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
                            activityAnswerMapper.insert(answer);
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
                            activityQuestionMapper.update(question);
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
                        if ("单选题".equals(quesType)) {
                            question.setQuesType((byte) 1);
                        } else if ("多选题".equals(quesType)) {
                            question.setQuesType((byte) 2);
                        } else if ("判断题".equals(quesType)) {
                            question.setQuesType((byte) 3);
                        }
                        question.setActivityID(activityID);
                        quesNum++;
                        activityQuestionMapper.insert(question);

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
                activityQuestionMapper.update(question);
                map.clear();
                question = null;
                rightAnswer = "";
            }


            String fileName = System.currentTimeMillis() + "." + file.getOriginalFilename().split("\\.")[1];
            ;
            //保存文件
            String filePath = CommonConfig.FILE_SAVE_PATH + fileName;
            File desFile = new File(filePath);
            if (!desFile.getParentFile().exists()) {
                desFile.mkdirs();
            }
            try {
                file.transferTo(desFile);
            } catch (Exception e) {
                e.printStackTrace();
            }


            //更新活动的题数
            Activity activity = new Activity();
            activity.setActivityID(activityID);
            activity.setQuesNum(quesNum);
            activity.setFileName(fileName);
            activityMapper.update(activity);


        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public PageInfo<ActivityUser> listActivityUser(ActivityUserQuery activityUserQuery) {
        PageHelper.startPage(activityUserQuery.getOffset(), activityUserQuery.getLimit());
        if (activityUserQuery.getSortField() != null) {
            PageHelper.orderBy(activityUserQuery.getSortField() + " " + activityUserQuery.getSortDir());
        }
        List<ActivityUser> activityUserList = activityMapper.listJoinUser(activityUserQuery);
        //得到分页的结果对象
        PageInfo<ActivityUser> pageInfo = new PageInfo<>(activityUserList);
        return pageInfo;
    }


    @Override
    public PageInfo<OrgReport> listOrgReport(OrgReportQuery orgReportQuery) {
        PageHelper.startPage(orgReportQuery.getOffset(), orgReportQuery.getLimit());
        if (orgReportQuery.getSortField() != null) {
            PageHelper.orderBy(orgReportQuery.getSortField() + " " + orgReportQuery.getSortDir());
        }
        List<OrgReport> orgReports = this.activityMapper.listOrgReport(orgReportQuery );
        PageInfo<OrgReport> pageInfo = new PageInfo<>(orgReports);
        if (pageInfo.getList() != null) {
            for(OrgReport orgReport : pageInfo.getList()){
                TOrganization org = cacheHelper.getOrg(orgReport.getOrgID());
                if(org != null){
                    orgReport.setOrgName(org.getOrgName());
                }
            }
        }
        return pageInfo;
    }
}

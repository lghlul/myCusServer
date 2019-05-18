package com.answer.service.impl;

import com.answer.common.CommonConfig;
import com.answer.domain.*;
import com.answer.domain.query.QuestionQuery;
import com.answer.mapper.TAnswerMapper;
import com.answer.mapper.TQuestionMapper;
import com.answer.service.ITQuestionService;
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
public class TQuestionServiceImpl extends BaseServiceImpl<TQuestion> implements ITQuestionService{

    @Autowired
    private TQuestionMapper questionMapper;

    @Autowired
    private TAnswerMapper answerMapper;

    @Override
    public PageInfo<TQuestion> list(QuestionQuery questionQuery) {
        PageHelper.startPage(questionQuery.getOffset(), questionQuery.getLimit());
        if (questionQuery.getSortField() != null) {
            PageHelper.orderBy(questionQuery.getSortField() + " " + questionQuery.getSortDir());
        }
        List<TQuestion> questionList = questionMapper.list(questionQuery);
        //得到分页的结果对象
        PageInfo<TQuestion> pageInfo = new PageInfo<>(questionList);
        return pageInfo;
    }


    @Override
    public void insertQues(MultipartFile file, Long typeID) {
        try {

            InputStream is = file.getInputStream();
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheetSize = wb.getNumberOfSheets();
            TQuestion question = null;
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
                        TAnswer answer = new TAnswer();
                        answer.setQuesID(question.getQuesID());
                        answer.setAnsDesc(sheet.getCell(2, i).getContents().trim());
                        answer.setCreateTime(System.currentTimeMillis());
                        if (answer.getAnsDesc() != null && !"".equals(answer.getAnsDesc())) {
                            answerMapper.insert(answer);
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
                            questionMapper.update(question);
                            //更新
                            map.clear();
                            question = null;
                            rightAnswer = "";
                        }

                        question = new TQuestion();
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

                        String quesExplain = sheet.getCell(3, i).getContents().trim();
                        question.setQuesExplain(quesExplain);
                        question.setTypeID(typeID);
                        questionMapper.insert(question);

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
                questionMapper.update(question);
                map.clear();
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

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}

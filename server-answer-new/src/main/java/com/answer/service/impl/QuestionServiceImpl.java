package com.answer.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.answer.domain.*;
import com.answer.mapper.*;
import com.answer.service.IUserService;
import com.answer.utils.CommonUtil;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.answer.cache.CacheHelper;
import com.answer.service.IQuestionService;
import com.answer.utils.Constant;
import com.answer.utils.DateUtil;

@Service
public class QuestionServiceImpl implements IQuestionService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserAnswerMapper userAnswerMapper;
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private WrongRecordMapper wrongRecordMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private RoomQuestionMapper roomQuestionMapper;

    @Autowired
    private QuesTypeMapper quesTypeMapper;


    public Result getQuestionByOne(String wxSession, long typeID) {
        Map<String, Object> map = new HashMap<>();
        WXSessionCache session = this.cacheHelper.getSession(wxSession);
        map.put("openID", session.getOpenID());
        map.put("typeID", typeID);

        Integer answerCount = 0;
        Integer rightCount = 0;
        String percent = "100%";
        Map<String, Object> resultMap = new HashMap<>();
        Result result = new Result();
        answerCount = this.userAnswerMapper.queryAnswerCountByUserType(map);
        map.put("isRight", 1);
        rightCount = this.userAnswerMapper.queryAnswerCountByUserType(map);
        DecimalFormat df = new DecimalFormat("######0.00");
        if(answerCount != 0){
            percent = df.format(rightCount.doubleValue() / answerCount.doubleValue() * 100) + "%";
        }else{
            percent = "0%";
        }

        int allNum = this.questionMapper.queryQuestionNumByType(typeID);
        if (answerCount >= allNum) {
            result.setResultCode(Constant.returnCode.QUES_FINISH);
            return result;
        }

        //未答 数量
        int unAnswerCount = allNum - answerCount;
        int offset = new Random().nextInt(unAnswerCount);
        Question question = questionMapper.readNext(typeID, session.getOpenID(), offset);
        resultMap.put("question", question);
        resultMap.put("percent", percent);

        resultMap.put("allNum", allNum);
        resultMap.put("answerNum", answerCount + 1);

        result.setResultData(resultMap);
        return result;
    }


    @Override
    public Result userAnswer(String wxSession, long questionID, String answerID) {
        WXSessionCache session = this.cacheHelper.getSession(wxSession);

        Map<String, Object> map = new HashMap<>();
        map.put("questionId", questionID);
        map.put("openID", session.getOpenID());
        List<UserAnswer> userAnswerList = this.userAnswerMapper.queryUserAnswerByMap(map);
        logger.info("userAnswer...userAnswerList=" + JSON.toJSONString(userAnswerList));
        if (userAnswerList == null || userAnswerList.size() < 1) {
            //将题从数据库查出
            Question question = this.questionMapper.queryQuestionByID(questionID);
            logger.info("userAnswer...question=" + JSON.toJSONString(question));
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setOpenID(session.getOpenID());
            userAnswer.setTypeID(question.getTypeID());
            userAnswer.setAnswerID(answerID);
            userAnswer.setQuestionID(questionID);

            if (CommonUtil.isRight(question.getRightAnswerID(), answerID)) {
                //答对
                userAnswer.setIsRight(Constant.ANSWER_RIGHT);
            } else {
                //答错
                userAnswer.setIsRight(Constant.ANSWER_WRONG);
                WrongRecord wrongRecord = new WrongRecord();
                wrongRecord.setOpenID(session.getOpenID());
                wrongRecord.setQuestionID(questionID);
                wrongRecord.setAnswerID(answerID);
                wrongRecord.setCreateTime(System.currentTimeMillis());
                wrongRecord.setTypeID(question.getTypeID());
                this.wrongRecordMapper.addRecord(wrongRecord);
            }
            userAnswer.setCreateTime(System.currentTimeMillis());
            logger.info("addUserAnswer...userAnswer=" + JSON.toJSONString(userAnswer));
            this.userAnswerMapper.addUserAnswer(userAnswer);
            //统计得分
            //获取练习模式配置
            Config config = cacheHelper.getConfig(Constant.ConfigKey.PRACTICE_CONFIG);
            if (config != null) {
                PractiseConfig practiseConfig = JSON.parseObject(config.getConfigValue(), PractiseConfig.class);
                logger.info("userAnswer...practiseConfig=" + JSON.toJSONString(practiseConfig));
                int rightCount = this.userAnswerMapper.queryAnswerRightCount(session.getOpenID());
                logger.info("userAnswer...rightCount=" + rightCount);
                if (rightCount >= practiseConfig.getQuesNum()) {
                    userService.updateScore(session.getOpenID(), practiseConfig.getScore(), "练习模式", null);
                    this.userAnswerMapper.updateUserAnswer(session.getOpenID());
                }
            }
        }
        return new Result();
    }


    @Override
    public Result delWrongRecord(String wxSession, long id) {
        WrongRecord wrongRecord = new WrongRecord();
        Result result = new Result();
        WrongRecord wrong = this.wrongRecordMapper.queryRecordById(id);
        logger.info("queryRecordById...wrong=" + JSON.toJSONString(wrong));
        if (wrong == null) {
            result.setResultCode(Constant.returnCode.NOT_EXIST);
            return result;
        }
        WXSessionCache session = this.cacheHelper.getSession(wxSession);
        //判断错题是否属于本人
        if (wrong.getOpenID().equals(session.getOpenID())) {
            wrongRecord.setId(id);
            wrongRecord.setStatus(Constant.DEL_STATUS);
            this.wrongRecordMapper.updateRecord(wrongRecord);
        } else {
            result.setResultCode(Constant.returnCode.OPER_FAIL);
        }
        return result;
    }


    @Override
    public Result getWrongPage(String wxSession, int pageNo, int pageSize) {
        WXSessionCache session = this.cacheHelper.getSession(wxSession);
        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("openID", session.getOpenID());
        int totalCount = this.wrongRecordMapper.queryRecordCount(session.getOpenID());
        logger.info("queryRecordCount...totalCount=" + totalCount);
        Result result = new Result();
        //暂无数据
        if (totalCount == 0) {
            result.setResultCode(Constant.returnCode.NO_DATA);
            return result;
        }
        List<WrongRecord> list = this.wrongRecordMapper.queryRecordPage(map);
        logger.info("queryRecordPage...list=" + JSON.toJSONString(list));
        if (list != null) {
            for (WrongRecord record : list) {
                //转换时间
                record.setTimeStr(DateUtil.convertByLong(record.getCreateTime()));
                //查询类型
                QuesType quesType = this.quesTypeMapper.queryQuesByID(record.getTypeID());
                QuesType parentType = this.quesTypeMapper.queryQuesByID(quesType.getParentID());
                record.setTypeDesc(parentType.getTypeName() + "-" + quesType.getTypeName());
                Question question = this.questionMapper.queryQuestionByID(record.getQuestionID());
                record.setQuesDesc(question.getQuesDesc());
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", list);
        resultMap.put("totalCount", totalCount);
        int pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
        resultMap.put("pageCount", pageCount);

        result.setResultData(resultMap);
        return result;
    }


    @Override
    public Result getWrongDetail(String wxSession, long id) {
        Result result = new Result();
        WrongRecord wrongRecord = this.wrongRecordMapper.queryRecordById(id);
        if (wrongRecord == null) {
            result.setResultCode(Constant.returnCode.NOT_EXIST);
            return result;
        }
        WXSessionCache session = this.cacheHelper.getSession(wxSession);

        if (wrongRecord.getOpenID().equals(session.getOpenID())) {
            Map<String, Object> resultMap = new HashMap<>();
            //题
            Question question = this.questionMapper.queryQuestionByResultMap(wrongRecord.getQuestionID());
            //总错题数
            int totalCount = this.wrongRecordMapper.queryRecordCount(session.getOpenID());
            Map<String, Object> param = new HashMap<>();
            param.put("openID", session.getOpenID());
            param.put("id", id);
            //当前第几题
            int currentNum = this.wrongRecordMapper.queryRecordCurrent(param);
            Integer nextID = this.wrongRecordMapper.queryRecordNextId(param);
            resultMap.put("question", question);
            resultMap.put("totalCount", totalCount);
            resultMap.put("currentNum", currentNum);
            resultMap.put("wrongAnswerID", wrongRecord.getAnswerID());
            resultMap.put("nextID", nextID == null ? 0 : nextID);
            result.setResultData(resultMap);
        } else {
            result.setResultCode(Constant.returnCode.OPER_FAIL);
        }
        return result;
    }


    @Override
    public Result getRoomQuestion(String wxSession, long roomID) {
        Result result = new Result();
        List<Question> list = this.roomQuestionMapper.selectQuestionByRoom(roomID);
        result.setResultData(list);
        return result;
    }


}

package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.service.IQuesTypeService;
import com.answer.service.IQuestionService;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/question" )
public class QuestionController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private IQuestionService questionService;
	@Autowired
	private IQuesTypeService quesTypeService;

	/**
	 * 练习模式下一题
	 * @param wxSession
	 * @param typeID  题型id
	 * @return
	 */
	@RequestMapping(value="/next",method=RequestMethod.GET)
	@ResponseBody
	public String next(String wxSession, Long typeID) {
		logger.info("next start...wxSession=" + wxSession + ",typeID=" + typeID);
		Result result = this.questionService.getQuestionByOne(wxSession, typeID);
		logger.info("next end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}

	/**
	 * 
	 * @param wxSession
	 * @param type 1练习模式  2 对战
	 * @return
	 */
	@RequestMapping(value="/typeList",method=RequestMethod.GET)
	@ResponseBody
	public String typeList(String wxSession, Integer type) {
		logger.info("typeList start...wxSession=" + wxSession + ",type=" + type);
		Result result = this.quesTypeService.getQuesTypeList(wxSession, type);
		logger.info("typeList end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 练习模式答题
	 * @param wxSession
	 * @param quesID
	 * @param answerID 用户答案
	 * @return
	 */
	@RequestMapping(value="/answer",method=RequestMethod.POST)
	@ResponseBody
	public String answer(String wxSession, Long questionID,String answerID){
		logger.info("answer start...wxSession=" + wxSession + ",questionID=" + questionID + ",answerID=" + answerID);
		Result result = this.questionService.userAnswer(wxSession, questionID, answerID);
		logger.info("answer end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 删除错题
	 * @param wxSession
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delWrong",method=RequestMethod.POST)
	@ResponseBody
	public String delWrong(String wxSession, Long id){
		logger.info("delWrong start...wxSession=" + wxSession + ",id=" + id);
		Result result = this.questionService.delWrongRecord(wxSession,id);
		logger.info("delWrong end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 错题列表
	 * @param wxSession
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/wrongList",method=RequestMethod.GET)
	@ResponseBody
	public String wrongList(String wxSession,Integer pageNo,Integer pageSize){
		logger.info("wrongList start...wxSession=" + wxSession + ",pageNo=" + pageNo + ",pageSize=" + pageSize);
		if(pageNo == null){
			pageNo = 1;
		}
		if(pageSize == null){
			pageNo = 10;
		}
		Result result = this.questionService.getWrongPage(wxSession, pageNo, pageSize);
		logger.info("wrongList end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 错题详情
	 * @param wxSession
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/wrongDetail",method=RequestMethod.GET)
	@ResponseBody
	public String wrongDetail(String wxSession,Long id){
		logger.info("wrongDetail start...wxSession=" + wxSession + ",id=" + id);
		Result result = this.questionService.getWrongDetail(wxSession, id);
		logger.info("wrongDetail end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 获取对战题
	 * @param wxSession
	 * @param roomID
	 * @return
	 */
	@RequestMapping(value="/roomQuestion",method=RequestMethod.GET)
	@ResponseBody
	public String roomQuestion(String wxSession , Long roomID){
		logger.info("roomQuestion start...wxSession=" + wxSession + ",roomID=" + roomID);
		Result result = this.questionService.getRoomQuestion(wxSession, roomID);
		logger.info("roomQuestion end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
}

package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.utils.Constant;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public String handExcetion(HttpServletRequest request, Exception e) {
		logger.info("handExcetion start...e=" + e.getMessage());
		Result result = new Result();
		e.printStackTrace();
		result.setResultCode(Constant.returnCode.SERVER_EXCEPTION);
		logger.info("handExcetion end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
}

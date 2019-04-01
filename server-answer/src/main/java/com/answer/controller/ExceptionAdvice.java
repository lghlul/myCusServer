package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Result;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public String handExcetion(HttpServletRequest request, Exception e) {
		Log4jUtil.info("handExcetion start...e=" + e.getMessage());
		Result result = new Result();
		e.printStackTrace();
		result.setResultCode(Constant.returnCode.SERVER_EXCEPTION);
		Log4jUtil.info("handExcetion end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
}

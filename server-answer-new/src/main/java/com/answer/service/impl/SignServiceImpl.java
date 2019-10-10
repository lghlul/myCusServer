package com.answer.service.impl;

import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.answer.domain.*;
import com.answer.service.IUserService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.answer.cache.CacheHelper;
import com.answer.mapper.SignMapper;
import com.answer.mapper.UserMapper;
import com.answer.service.ISignService;
import com.answer.utils.Constant;

@Service
public class SignServiceImpl implements ISignService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SignServiceImpl.class);
	@Autowired
	private CacheHelper cacheHelper;
	@Autowired
	private SignMapper signMapper;
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IUserService userService;

	public Result userSign(String wxSession) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		Sign sign = this.signMapper.querySignByOpenID(session.getOpenID());
		Result result = new Result();
		if (sign == null || (!isSameDay(sign.getSignTime()))) {
			Sign newSign = new Sign();
			newSign.setOpenID(session.getOpenID());
			newSign.setSignTime(System.currentTimeMillis());
			//签到
			this.signMapper.addSign(newSign);

			//获取签到配置
			Config config = cacheHelper.getConfig(Constant.ConfigKey.SIGN_CONFIG);
			if(config != null){
				SignConfig signConfig = JSON.parseObject(config.getConfigValue() , SignConfig.class);
				//签到加分
				userService.updateScore(session.getOpenID() ,signConfig.getScore() , "签到" , null );
			}
		} else {
			result.setResultCode(Constant.returnCode.SIGN_FAIL);
		}
		return result;
	}

	private boolean isSameDay(long timeDB) {
		boolean b = false;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(timeDB));
		int yearDB = calendar.get(1);
		int monthDB = calendar.get(2) + 1;
		int dayDB = calendar.get(5);
		calendar.setTime(new Date());
		int yearNow = calendar.get(1);
		int monthNow = calendar.get(2) + 1;
		int dayNow = calendar.get(5);
		if ((yearDB == yearNow) && (monthDB == monthNow) && (dayDB == dayNow)) {
			b = true;
		}
		return b;
	}

	@Override
	public Result isSign(String wxSession) {
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		Sign sign = this.signMapper.querySignByOpenID(session.getOpenID());
		Result result = new Result();
		if (sign != null && (isSameDay(sign.getSignTime()))) {
			result.setResultCode(Constant.returnCode.IS_SIGN);
		}
		return result;
	}
}

package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.BattleConfig;
import com.answer.domain.Config;
import com.answer.domain.Result;
import com.answer.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config" )
public class ConfigController {

	@Autowired
	private CacheHelper cacheHelper;

	@GetMapping("readBattleConfig")
	public String readBattleConfig() {
		Result result = new Result();
		Config config = cacheHelper.getConfig(Constant.ConfigKey.BATTLE_CONFIG);
		BattleConfig battleConfig = JSON.parseObject(config.getConfigValue() , BattleConfig.class);
		result.setResultData(battleConfig);
		return JSON.toJSONString(result);
	}


	@GetMapping("readModuleConfig")
	public String readModuleConfig() {
		Result result = new Result();
		Config config = cacheHelper.getConfig(Constant.ConfigKey.MODULE_CONFIG);
		JSONObject jsonObject = JSON.parseObject(config.getConfigValue());
		result.setResultData(jsonObject);
		return JSON.toJSONString(result);
	}
	
}

package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.common.PageResult;
import com.answer.domain.Activity;
import com.answer.domain.ActivityQuestion;
import com.answer.domain.ActivityUserAnswer;
import com.answer.domain.Result;
import com.answer.service.IActivityService;
import com.answer.utils.Constant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity" )
public class ActivityController {
	@Autowired
	private IActivityService activityService;


	@GetMapping("list")
	public String list(Activity activity , String wxSession) {
		Result result = new Result();
		PageInfo<Activity> page = activityService.page(activity,wxSession);
		PageResult pageResult = new PageResult();
		pageResult.setTotalCount(page.getTotal());
		pageResult.setTotalPage(page.getPages());
		pageResult.setList(page.getList());
		result.setResultData(pageResult);
		return JSON.toJSONString(result);
	}

	@GetMapping("listByActivityID")
	public String listByActivityID(Long activityID, String wxSession) {
		Result result = new Result();
		Map<String , Object> map = new HashMap<>();
		Activity activity = activityService.read(activityID + "");
		map.put("activity" , activity);
		if(activity.getActivityStatus() != Constant.ACTIVITY_UN_START){
			//活动已经开始或者结束   能够查看具体详情
			List<ActivityQuestion> activityQuestions = activityService.listByActivityID(activityID ,wxSession);
			map.put("activityQuestions" , activityQuestions);
		}
		result.setResultData(map);
		return JSON.toJSONString(result);
	}

	@PostMapping("finish")
	public String finish(Long activityID , String strList , String wxSession) {
		if(strList != null){
			List<ActivityUserAnswer> activityUserAnswers = JSON.parseArray(strList, ActivityUserAnswer.class);
			Result result = activityService.finish(activityUserAnswers, wxSession, activityID);
			return JSON.toJSONString(result);
		}
		return JSON.toJSONString(new Result());
	}
}

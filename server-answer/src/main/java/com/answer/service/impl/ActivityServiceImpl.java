package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.ActivityMapper;
import com.answer.mapper.ActivityQuestionMapper;
import com.answer.mapper.ActivityUserMapper;
import com.answer.service.IActivityService;
import com.answer.utils.CommonUtil;
import com.answer.utils.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ActivityServiceImpl implements IActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	@Autowired
	private ActivityQuestionMapper activityQuestionMapper;

	@Autowired
	private CacheHelper cacheHelper;

	@Autowired
	private ActivityUserMapper activityUserMapper;

	@Override
	public PageInfo<Activity> page(Activity activity, String wxSession) {
		PageHelper.startPage(activity.getOffset(), activity.getLimit());
		if (activity.getSortField() != null) {
			PageHelper.orderBy(activity.getSortField() + " " + activity.getSortDir());
		}
		List<Activity> studentList = activityMapper.selectPage(activity);
		//得到分页的结果对象
		PageInfo<Activity> pageInfo = new PageInfo<>(studentList);

		//查询出该员工参加的所有活动
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		ActivityUser activityUser = new ActivityUser();
		activityUser.setOpenID(session.getOpenID());
		List<ActivityUser> activityUserList = activityUserMapper.list(activityUser);
		Map<Long , ActivityUser> activityUserMap = new HashMap<>();
		List<Activity> list = pageInfo.getList();
		if(activityUserList != null){
			for(ActivityUser au : activityUserList){
				activityUserMap.put(au.getActivityID() , au);
			}
			if(list != null){
				for(Activity act : list){
					ActivityUser au = activityUserMap.get(act.getActivityID());
					if(au != null){
						act.setIsJoin(Constant.JOIN_ACTIVITY);
						act.setRightNum(au.getRightNum());
					}else{
						act.setIsJoin(Constant.UN_JOIN_ACTIVITY);
						act.setRightNum(0);
					}
				}
			}
		}



		return pageInfo;
	}

	@Override
	public List<ActivityQuestion> listByActivityID(Long activityID , String wxSession) {
		//查询是否参加过这次活动
		WXSessionCache session = this.cacheHelper.getSession(wxSession);
		ActivityUser activityUser = new ActivityUser();
		activityUser.setActivityID(activityID);
		activityUser.setOpenID(session.getOpenID());
		List<ActivityUser> list = activityUserMapper.list(activityUser);
		List<ActivityQuestion> activityQuestions = activityQuestionMapper.listByActivityID(activityID + "");
		if(list != null && list.size() > 0){
			//参加过活动  查询出其答题详情
			ActivityUserAnswer activityUserAnswer = new ActivityUserAnswer();
			activityUserAnswer.setActivityID(activityID);
			activityUserAnswer.setOpenID(session.getOpenID());
			List<ActivityUserAnswer> activityUserAnswers = activityQuestionMapper.listUserAnswer(activityUserAnswer);
			Map<Long , ActivityUserAnswer> map = new HashMap<>();
			if(activityUserAnswers != null){
				for(ActivityUserAnswer aua : activityUserAnswers){
					map.put(aua.getQuesID() , aua);
				}
			}
			//设置员工的答案 以及是否回答正确
			if(activityQuestions != null){
				for(ActivityQuestion aq : activityQuestions){
					ActivityUserAnswer aua = map.get(aq.getQuesID());
					if(aua != null){
						aq.setIsRight(aua.getIsRight());
						aq.setAnswerID(aua.getAnswerID());
					}
				}
			}
		}else{
			//如果没有参加过该活动  不返回正确选项
			if(activityQuestions != null){
				for(ActivityQuestion aq : activityQuestions){
					aq.setRightAnswerID(null);
				}
			}
		}
		return activityQuestions;
	}

	@Override
	public Result finish(List<ActivityUserAnswer> activityUserAnswers , String wxSession , Long activityID) {
		Result result = new Result();
		WXSessionCache session = this.cacheHelper.getSession(wxSession);

		Activity activity = activityMapper.selectByID(activityID + "");
		if(activity.getActivityStatus() == Constant.ACTIVITY_UN_START){
			//活动尚未开始
			result.setResultCode(Constant.returnCode.ACTIVITY_UN_START);
			return result;
		}else if(activity.getActivityStatus() == Constant.ACTIVITY_FINIFSH){
			//活动已经结束
			result.setResultCode(Constant.returnCode.ACTIVITY_FINISH);
			return result;
		}

		//校验是否已经参加过该活动
		ActivityUser au = new ActivityUser();
		au.setOpenID(session.getOpenID());
		au.setActivityID(activityID);
		List<ActivityUser> list = activityUserMapper.list(au);
		if(list != null && list.size() > 0){
			result.setResultCode(Constant.returnCode.REPEAT_JOIN_ACTIVITY);
			return result;
		}


		int rightNum = 0;
		if(activityUserAnswers != null){
			for(ActivityUserAnswer activityUserAnswer : activityUserAnswers){
				ActivityQuestion activityQuestion = activityQuestionMapper.readByQuesID(activityUserAnswer.getQuesID() + "");
				if(CommonUtil.isRight(activityQuestion.getRightAnswerID(), activityUserAnswer.getAnswerID())){
					activityUserAnswer.setIsRight(Constant.ANSWER_RIGHT);
					rightNum++;
				}else{
					activityUserAnswer.setIsRight(Constant.ANSWER_WRONG);
				}
				activityUserAnswer.setOpenID(session.getOpenID());
				activityUserAnswer.setActivityID(activityID);
			}
		}
		//插入答题详情
		activityQuestionMapper.insertUserAnswer(activityUserAnswers);

		//插入参加活动记录
		ActivityUser activityUser = new ActivityUser();
		activityUser.setActivityID(activityID);
		activityUser.setOpenID(session.getOpenID());
		activityUser.setCreateTime(System.currentTimeMillis());
		activityUser.setRightNum(rightNum);
		activityUserMapper.insert(activityUser);

		Map<String , Object> map = new HashMap<>();
		map.put("quesNum" , activity.getQuesNum());
		map.put("rightNum" , rightNum);
		result.setResultData(map);

		return result;
	}


	@Override
	public Activity read(String activityID) {
		return activityMapper.selectByID(activityID);
	}
}

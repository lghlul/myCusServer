package com.answer.service.impl;

import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.ActivityMapper;
import com.answer.mapper.ActivityQuestionMapper;
import com.answer.service.IActivityService;
import com.answer.utils.CommonUtil;
import com.answer.utils.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivityServiceImpl implements IActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	@Autowired
	private ActivityQuestionMapper activityQuestionMapper;

	@Autowired
	private CacheHelper cacheHelper;

	@Override
	public PageInfo<Activity> page(Activity activity) {
		PageHelper.startPage(activity.getOffset(), activity.getLimit());
		if (activity.getSortField() != null) {
			PageHelper.orderBy(activity.getSortField() + " " + activity.getSortDir());
		}
		List<Activity> studentList = activityMapper.selectPage(activity);
		//得到分页的结果对象
		PageInfo<Activity> pageInfo = new PageInfo<>(studentList);
		return pageInfo;
	}

	@Override
	public List<ActivityQuestion> listByActivityID(String activityID) {
		return activityQuestionMapper.listByActivityID(activityID);
	}

	@Override
	public Result finish(List<ActivityUserAnswer> activityUserAnswers , String wxSession , Long activityID) {
		Result result = new Result();
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
		if(activityUserAnswers != null){
			WXSessionCache session = this.cacheHelper.getSession(wxSession);
			for(ActivityUserAnswer activityUserAnswer : activityUserAnswers){
				ActivityQuestion activityQuestion = activityQuestionMapper.readByQuesID(activityUserAnswer.getQuesID() + "");
				if(CommonUtil.isRight(activityQuestion.getRightAnswerID(), activityUserAnswer.getAnswerID())){
					activityUserAnswer.setIsRight(Constant.ANSWER_RIGHT);
				}else{
					activityUserAnswer.setIsRight(Constant.ANSWER_WRONG);
				}
				activityUserAnswer.setOpenID(session.getOpenID());
				activityUserAnswer.setActivityID(activityID);
			}
		}
		activityQuestionMapper.insertUserAnswer(activityUserAnswers);
		return result;
	}
}

package com.answer.schedule;

import com.answer.common.CommonConstant;
import com.answer.domain.Activity;
import com.answer.mapper.TActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityJob {


    @Autowired
    private TActivityMapper activityMapper;

    @Scheduled(cron = "0/60 * * * * ?")
    private void configureTasks() {
        List<Activity> activities = activityMapper.listUnFinish();
        if(activities != null && activities.size() > 0){
            for (Activity activity : activities) {
                if(activity.getQuesNum() != null && activity.getQuesNum() > 0){
                    if(activity.getStartTime() <= System.currentTimeMillis()){
                        activity.setActivityStatus(CommonConstant.Common.ACTIVITY_STATUS_START);
                        activityMapper.update(activity);
                    }
                    if(activity.getEndTime() <= System.currentTimeMillis()){
                        activity.setActivityStatus(CommonConstant.Common.ACTIVITY_STATUS_END);
                        activityMapper.update(activity);
                    }
                }
            }
        }
    }
}

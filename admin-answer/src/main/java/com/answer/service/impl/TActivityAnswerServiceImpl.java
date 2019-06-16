package com.answer.service.impl;

import com.answer.CacheHelper;
import com.answer.common.CommonConstant;
import com.answer.domain.*;
import com.answer.domain.query.ActivityQuery;
import com.answer.mapper.TActivityMapper;
import com.answer.mapper.TActivityUserMapper;
import com.answer.service.IActivityAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class TActivityAnswerServiceImpl extends BaseServiceImpl<TActivityAnswer> implements IActivityAnswerService {

    @Autowired
    private TActivityUserMapper activityUserMapper;

    @Autowired
    private CacheHelper cacheHelper;

    @Autowired
    private TActivityMapper activityMapper;

    @Override
    public List<UserAnswer4export> listUserAnswer4export(Long activityID) {
        List<UserAnswer4export> userAnswer4exports = activityUserMapper.listUserAnswer4export(activityID);
        if(userAnswer4exports != null && userAnswer4exports.size() > 0){
            ActivityQuery activityQuery = new ActivityQuery();
            activityQuery.setActivityStatus(CommonConstant.Common.ACTIVITY_STATUS_END);
                for (UserAnswer4export userAnswer4export : userAnswer4exports) {
                    TUser user = cacheHelper.getUser(userAnswer4export.getOpenid());
                    TJobnum jobNum = cacheHelper.getJobNum(user.getJobNum());
                    TOrganization org = cacheHelper.getOrg(jobNum.getOrgID());
                    userAnswer4export.setRealName(jobNum.getRealName());
                    userAnswer4export.setOrgName(org.getOrgName());
                }
        }
        return userAnswer4exports;
    }
}

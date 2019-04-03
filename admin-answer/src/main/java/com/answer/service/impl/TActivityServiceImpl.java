package com.answer.service.impl;

import com.answer.domain.Activity;
import com.answer.domain.TrainConfig;
import com.answer.mapper.TActivityMapper;
import com.answer.service.IActivityService;
import com.answer.service.ITrainConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TActivityServiceImpl extends BaseServiceImpl<Activity> implements IActivityService {

    @Autowired
    TActivityMapper activityMapper;


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
}

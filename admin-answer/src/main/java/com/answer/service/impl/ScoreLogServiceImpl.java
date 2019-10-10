package com.answer.service.impl;

import com.answer.domain.ScoreLog;
import com.answer.domain.query.ScoreLogQuery;
import com.answer.mapper.ScoreLogMapper;
import com.answer.service.IScoreLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 11:00
 * @Modified By：
 */
@Transactional
@Service
public class ScoreLogServiceImpl implements IScoreLogService {
    @Autowired
    private ScoreLogMapper scoreLogMapper;

    @Override
    public PageInfo<ScoreLog> page(ScoreLogQuery scoreLogQuery) {
        PageHelper.startPage(scoreLogQuery.getOffset(), scoreLogQuery.getLimit());
        if (scoreLogQuery.getSortField() != null) {
            PageHelper.orderBy(scoreLogQuery.getSortField() + " " + scoreLogQuery.getSortDir());
        }
        List<ScoreLog> scoreLogList = scoreLogMapper.list(scoreLogQuery);
        //得到分页的结果对象
        PageInfo<ScoreLog> pageInfo = new PageInfo<>(scoreLogList);
        return pageInfo;
    }
}

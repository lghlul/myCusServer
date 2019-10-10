package com.answer.service;

import com.answer.domain.ScoreLog;
import com.answer.domain.query.ScoreLogQuery;
import com.github.pagehelper.PageInfo;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 11:00
 * @Modified By：
 */
public interface IScoreLogService {
    PageInfo<ScoreLog> page(ScoreLogQuery scoreLogQuery);
}

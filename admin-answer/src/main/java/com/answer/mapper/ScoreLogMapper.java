package com.answer.mapper;

import com.answer.domain.ScoreLog;
import com.answer.domain.query.ScoreLogQuery;

import java.util.List;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 10:57
 * @Modified By：
 */
public interface ScoreLogMapper {
    List<ScoreLog> list(ScoreLogQuery scoreLogQuery);
}

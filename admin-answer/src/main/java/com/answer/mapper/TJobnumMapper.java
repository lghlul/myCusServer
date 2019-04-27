package com.answer.mapper;

import com.answer.domain.TJobnum;
import com.answer.domain.query.JobNumQuery;

import java.util.List;

public interface TJobnumMapper extends BaseMapper<TJobnum>{

    TJobnum selectByJobNum(String jobNum);


    List<TJobnum> list(JobNumQuery jobNumQuery);

}
package com.answer.service;

import com.answer.domain.TJobnum;
import com.answer.domain.query.JobNumQuery;
import com.github.pagehelper.PageInfo;

public interface ITJobnumService extends IBaseService<TJobnum>{

    PageInfo<TJobnum> list(JobNumQuery jobNumQuery);

    TJobnum selectByJobNum(String jobNum);


}

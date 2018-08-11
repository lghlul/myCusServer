package com.answer.mapper;

import com.answer.domain.JobNumBean;

public interface JobNumMapper {
	public JobNumBean queryJobNumByID(String jobNum);
	public int updateJobNum(JobNumBean jobNumBean);
}

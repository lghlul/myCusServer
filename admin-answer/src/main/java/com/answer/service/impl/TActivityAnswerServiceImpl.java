package com.answer.service.impl;

import com.answer.domain.TActivityAnswer;
import com.answer.service.IActivityAnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TActivityAnswerServiceImpl extends BaseServiceImpl<TActivityAnswer> implements IActivityAnswerService {

}

package com.answer.service.impl;

import com.answer.domain.TActivityQuestion;
import com.answer.service.IActivityQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class TActivityQuestionServiceImpl extends BaseServiceImpl<TActivityQuestion> implements IActivityQuestionService {
}

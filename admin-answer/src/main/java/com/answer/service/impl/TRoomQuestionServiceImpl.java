package com.answer.service.impl;

import com.answer.domain.TRoomQuestion;
import com.answer.service.ITRoomQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TRoomQuestionServiceImpl extends BaseServiceImpl<TRoomQuestion> implements ITRoomQuestionService{
}

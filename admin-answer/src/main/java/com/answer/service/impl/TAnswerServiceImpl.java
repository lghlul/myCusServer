package com.answer.service.impl;

import com.answer.domain.TAnswer;
import com.answer.mapper.TAnswerMapper;
import com.answer.service.ITAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class TAnswerServiceImpl extends BaseServiceImpl<TAnswer> implements ITAnswerService{

    @Autowired
    private TAnswerMapper answerMapper;

    @Override
    public List<TAnswer> listByQuesID(Long quesID) {
        return answerMapper.listByAnsID(quesID);
    }
}

package com.answer.service.impl;

import com.answer.domain.TJobnumCopy;
import com.answer.service.ITJobnumCopyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TJobnumCopyServiceImpl extends BaseServiceImpl<TJobnumCopy> implements ITJobnumCopyService{
}

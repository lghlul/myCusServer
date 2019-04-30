package com.answer.service.impl;

import com.answer.domain.TrainConfig;
import com.answer.service.ITrainConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TTrainConfigServiceImpl extends BaseServiceImpl<TrainConfig> implements ITrainConfigService {

}

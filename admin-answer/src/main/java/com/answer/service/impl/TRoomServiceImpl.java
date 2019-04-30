package com.answer.service.impl;

import com.answer.domain.TRoom;
import com.answer.service.ITRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TRoomServiceImpl extends BaseServiceImpl<TRoom> implements ITRoomService{
}

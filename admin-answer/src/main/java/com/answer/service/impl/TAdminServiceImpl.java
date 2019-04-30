package com.answer.service.impl;

import com.answer.domain.TAdmin;
import com.answer.service.ITAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TAdminServiceImpl extends BaseServiceImpl<TAdmin> implements ITAdminService{
}

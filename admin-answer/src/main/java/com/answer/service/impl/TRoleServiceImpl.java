package com.answer.service.impl;

import com.answer.domain.TRole;
import com.answer.service.ITRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TRoleServiceImpl extends BaseServiceImpl<TRole> implements ITRoleService{
}

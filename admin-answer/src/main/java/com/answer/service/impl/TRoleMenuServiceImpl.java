package com.answer.service.impl;

import com.answer.domain.TRoleMenu;
import com.answer.service.ITRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TRoleMenuServiceImpl extends BaseServiceImpl<TRoleMenu> implements ITRoleMenuService{
}

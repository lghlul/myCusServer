package com.answer.service.impl;

import com.answer.domain.TOrganization;
import com.answer.service.ITOrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TOrganizationServiceImpl extends BaseServiceImpl<TOrganization> implements ITOrganizationService {
}

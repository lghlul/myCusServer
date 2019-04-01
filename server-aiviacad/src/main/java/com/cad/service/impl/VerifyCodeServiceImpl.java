package com.cad.service.impl;

import com.cad.domain.VerifyCode;
import com.cad.mapper.VerifyCodeMapper;
import com.cad.service.IVerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    @Autowired
    VerifyCodeMapper verifyCodeMapper;

    public int add(VerifyCode verifyCode) {
        return verifyCodeMapper.insert(verifyCode);
    }
}
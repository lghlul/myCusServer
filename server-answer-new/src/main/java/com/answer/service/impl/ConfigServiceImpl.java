package com.answer.service.impl;

import com.answer.domain.Config;
import com.answer.mapper.ConfigMapper;
import com.answer.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 9:08
 * @Modified By：
 */
@Service
public class ConfigServiceImpl implements IConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public Config readByKey(String key) {
        return configMapper.readByKey(key);
    }
}

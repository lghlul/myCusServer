package com.answer.service.impl;

import com.answer.domain.Config;
import com.answer.mapper.TConfigMapper;
import com.answer.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/7 10:05
 * @Modified By：
 */
@Service
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements IConfigService {

    @Autowired
    private TConfigMapper configMapper;

    @Override
    public Config readByKey(String configKey) {
        return configMapper.readByKey(configKey);
    }
}

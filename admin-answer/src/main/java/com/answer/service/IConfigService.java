package com.answer.service;

import com.answer.domain.Config;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/7 10:03
 * @Modified By：
 */
public interface IConfigService extends IBaseService<Config>{

    Config readByKey(String configKey);
}

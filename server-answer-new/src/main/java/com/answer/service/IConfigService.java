package com.answer.service;

import com.answer.domain.Config;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 9:07
 * @Modified By：
 */
public interface IConfigService {
    Config readByKey(String key);
}

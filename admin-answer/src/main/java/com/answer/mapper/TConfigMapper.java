package com.answer.mapper;

import com.answer.domain.Config;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/7 9:56
 * @Modified By：
 */
public interface TConfigMapper extends BaseMapper<Config> {
    Config readByKey(String configKey);
}

package com.answer.mapper;

import com.answer.domain.Config;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/7 11:16
 * @Modified By：
 */
public interface ConfigMapper extends BaseMapper<Config>{
    Config readByKey(String configKey);
}

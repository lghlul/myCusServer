package com.answer.domain;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/7 9:57
 * @Modified By：
 */
public class Config {
    private Long id;

    private String configKey;

    private String configValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}

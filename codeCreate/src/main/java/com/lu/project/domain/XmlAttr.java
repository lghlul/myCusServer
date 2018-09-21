package com.lu.project.domain;

/**
 * @CLassName XmlAttr
 * @Description xml属性
 * @Author ll
 * @Date 2018/9/20 17:53
 **/
public class XmlAttr {
    private String key;

    private String value;

    public XmlAttr(){

    }

    public XmlAttr(String key , String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

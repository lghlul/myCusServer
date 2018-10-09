package com.lu.tag.spring.base;

/**
 * @CLassName Value
 * @Description value 标签
 * @Author ll
 * @Date 2018/9/25 9:57
 **/
public class Value {

    private String value;

    public Value(){

    }

    public Value(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

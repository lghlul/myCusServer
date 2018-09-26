package com.lu.code.domain;

/**
 * @CLassName Columns
 * @Description 表列
 * @Author ll
 * @Date 2018/9/26 10:49
 **/
public class Columns {
    /**
     * 数据库字段名称
     */
    private String ColumnName;

    /**
     * 数据库类型
     */
    private String DataType;

    /**
     * java 变量名称
     */
    private String variableName;

    /**
     * java 变量名称
     */
    private String variableType;

    /**
     * 首字母大写 变量名称   用于set  get方法
     */
    private String variableMethod;

    public String getVariableMethod() {
        return variableMethod;
    }

    public void setVariableMethod(String variableMethod) {
        this.variableMethod = variableMethod;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getColumnName() {
        return ColumnName;
    }

    public void setColumnName(String columnName) {
        ColumnName = columnName;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }
}

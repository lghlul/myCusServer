package com.cad.domain;

/**
 * @CLassName CodeManage
 * @Description TODO
 * @Author ll
 * @Date 2019/2/20 16:37
 **/
public class CodeManage {
    private Integer codeType;
    private Integer codeName;
    private Long createTime;
    private String codeValue;


    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    public Integer getCodeName() {
        return codeName;
    }

    public void setCodeName(Integer codeName) {
        this.codeName = codeName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }
}

package com.cad.domain;

/**
 * @CLassName CodeManage
 * @Description TODO
 * @Author ll
 * @Date 2019/2/20 16:37
 **/
public class CodeManage {
    private Integer codeType;
    private String codeName;
    private Long createTime;
    private String codeValue;


    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
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

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}

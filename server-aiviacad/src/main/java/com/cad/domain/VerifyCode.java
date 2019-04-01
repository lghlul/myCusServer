package com.cad.domain;

/**
 * @CLassName VerifyCode
 * @Description TODO
 * @Author ll
 * @Date 2019/3/4 11:23
 **/
public class VerifyCode {
    private Long id;
    private String verifyCode;
    private Long createTime;
    private Byte codeType;
    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getCodeType() {
        return codeType;
    }

    public void setCodeType(Byte codeType) {
        this.codeType = codeType;
    }
}

package com.answer.domain;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/15 15:24
 * @Modified By：
 */
public class Bbs extends PageQuery {
    private Long bbsID;

    private String title;

    private String content;

    private String creator;

    private Long createTime;

    private Byte delStatus;


    private String keyWord;

    private Integer replyNum;


    private String realName;


    private String orgName;


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getBbsID() {
        return bbsID;
    }

    public void setBbsID(Long bbsID) {
        this.bbsID = bbsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Byte getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Byte delStatus) {
        this.delStatus = delStatus;
    }
}

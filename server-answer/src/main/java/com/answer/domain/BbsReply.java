package com.answer.domain;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/15 15:26
 * @Modified By：
 */
public class BbsReply extends PageQuery {
    private Long replyID;

    private String creator;

    private String content;

    private Byte delStatus;

    private Long createTime;

    private Long bbsID;

    public Long getBbsID() {
        return bbsID;
    }

    public void setBbsID(Long bbsID) {
        this.bbsID = bbsID;
    }

    public Long getReplyID() {
        return replyID;
    }

    public void setReplyID(Long replyID) {
        this.replyID = replyID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Byte delStatus) {
        this.delStatus = delStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}

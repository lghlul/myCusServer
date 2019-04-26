package com.answer.domain.query;

import com.answer.common.PageQuery;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/10 16:31
 * @Modified By：
 */
public class QuestionQuery extends PageQuery {

    private String quesDesc;

    private Long typeID;

    private Byte quesType;

    public String getQuesDesc() {
        return quesDesc;
    }

    public void setQuesDesc(String quesDesc) {
        this.quesDesc = quesDesc;
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public Byte getQuesType() {
        return quesType;
    }

    public void setQuesType(Byte quesType) {
        this.quesType = quesType;
    }
}

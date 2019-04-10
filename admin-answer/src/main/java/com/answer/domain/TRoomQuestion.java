package com.answer.domain;

public class TRoomQuestion extends BaseDomain {

    private Long id;

    /**
     * 房间ID
     */
    private Long roomID;

    /**
     * 问题ID
     */
    private Long quesID;

    /**
     * 创建人答案
     */
    private String createAnswer;

    /**
     * 被邀请人答案
     */
    private String answer;

    /**
     * 正确答案
     */
    private String rightAnswer;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getRoomID(){
        return this.roomID;
    }

    public void setRoomID(Long roomID){
        this.roomID = roomID;
    }

    public Long getQuesID(){
        return this.quesID;
    }

    public void setQuesID(Long quesID){
        this.quesID = quesID;
    }

    public String getCreateAnswer(){
        return this.createAnswer;
    }

    public void setCreateAnswer(String createAnswer){
        this.createAnswer = createAnswer;
    }

    public String getAnswer(){
        return this.answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getRightAnswer(){
        return this.rightAnswer;
    }

    public void setRightAnswer(String rightAnswer){
        this.rightAnswer = rightAnswer;
    }

}
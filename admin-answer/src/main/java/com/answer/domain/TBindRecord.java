package com.answer.domain;

public class TBindRecord extends BaseDomain {

    private Long id;

    private String jobNum;

    private String openID;

    private Integer operYear;

    private Integer operMonth;

    private Integer operDay;

    private Long operTime;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getJobNum(){
        return this.jobNum;
    }

    public void setJobNum(String jobNum){
        this.jobNum = jobNum;
    }

    public String getOpenID(){
        return this.openID;
    }

    public void setOpenID(String openID){
        this.openID = openID;
    }

    public Integer getOperYear(){
        return this.operYear;
    }

    public void setOperYear(Integer operYear){
        this.operYear = operYear;
    }

    public Integer getOperMonth(){
        return this.operMonth;
    }

    public void setOperMonth(Integer operMonth){
        this.operMonth = operMonth;
    }

    public Integer getOperDay(){
        return this.operDay;
    }

    public void setOperDay(Integer operDay){
        this.operDay = operDay;
    }

    public Long getOperTime(){
        return this.operTime;
    }

    public void setOperTime(Long operTime){
        this.operTime = operTime;
    }

}
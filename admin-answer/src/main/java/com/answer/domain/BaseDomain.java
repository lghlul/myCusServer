package com.answer.domain;

import com.answer.common.CommonConstant;

public class  BaseDomain{

    private Integer pageNo;

    private Integer pageSize;

    private Integer offSet;

    private Integer limit;

    public Integer getPageNo(){
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo){
        this.pageNo = pageNo;
    }



    public Integer getPageSize(){
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public Integer getOffSet(){
        return this.offSet;
    }

    public void setOffSet(Integer offSet){
        this.offSet = offSet;
    }



    public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
    }

    public void pageHandler(){
        if(this.limit == null){
            if(this.pageSize == null){
                this.limit = CommonConstant.Common.limit;
            }else{
                this.limit = this.pageSize;
            }
        }

        if(this.offSet == null){
            if(this.pageNo == null){
                this.offSet = CommonConstant.Common.offset;
            }else{
                this.offSet = (this.pageNo - 1) * this.limit;
            }
        }
    }

}
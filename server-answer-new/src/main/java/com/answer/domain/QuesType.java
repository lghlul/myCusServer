package com.answer.domain;

import java.util.List;

public class QuesType
{
  private long typeID;
  private long parentID;
  private String typeName;
  private int allNum;
  private int answerNum;
  private String typeImg;
  private List<QuesType> typeList;
  
  
  
  public String getTypeImg() {
	return typeImg;
}

public void setTypeImg(String typeImg) {
	this.typeImg = typeImg;
}

public long getTypeID()
  {
    return this.typeID;
  }
  
  public void setTypeID(long typeID)
  {
    this.typeID = typeID;
  }
  
  public long getParentID()
  {
    return this.parentID;
  }
  
  public void setParentID(long parentID)
  {
    this.parentID = parentID;
  }
  
  public String getTypeName()
  {
    return this.typeName;
  }
  
  public void setTypeName(String typeName)
  {
    this.typeName = typeName;
  }
  
  public List<QuesType> getTypeList()
  {
    return this.typeList;
  }
  
  public void setTypeList(List<QuesType> typeList)
  {
    this.typeList = typeList;
  }
  
  public int getAllNum()
  {
    return this.allNum;
  }
  
  public void setAllNum(int allNum)
  {
    this.allNum = allNum;
  }
  
  public int getAnswerNum()
  {
    return this.answerNum;
  }
  
  public void setAnswerNum(int answerNum)
  {
    this.answerNum = answerNum;
  }
}

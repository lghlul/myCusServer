package com.answer.domain;

public class Sign
{
  private long signID;
  private String openID;
  private long signTime;
  
  public long getSignID()
  {
    return this.signID;
  }
  
  public void setSignID(long signID)
  {
    this.signID = signID;
  }
  
  public String getOpenID()
  {
    return this.openID;
  }
  
  public void setOpenID(String openID)
  {
    this.openID = openID;
  }
  
  public long getSignTime()
  {
    return this.signTime;
  }
  
  public void setSignTime(long signTime)
  {
    this.signTime = signTime;
  }
}

package com.answer.mapper;

import com.answer.domain.Sign;

public abstract interface SignMapper
{
  public abstract Sign querySignByOpenID(String paramString);
  
  public abstract int addSign(Sign paramSign);
}

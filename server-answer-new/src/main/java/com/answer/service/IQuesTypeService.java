package com.answer.service;

import com.answer.domain.Result;

public abstract interface IQuesTypeService
{
  public abstract Result getQuesTypeList(String paramString, int paramInt);
}

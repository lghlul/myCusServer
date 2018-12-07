package com.answer.mapper;

import com.answer.domain.QuesType;
import java.util.List;

public interface QuesTypeMapper{
  public List<QuesType> queryQuesTypeList();

  public List<QuesType> queryQuesTypeListWithQuesNum(String openID);
  
  public QuesType queryQuesByID(long typeID);
}

package com.answer.mapper;

import java.util.List;
import java.util.Map;

import com.answer.domain.WrongRecord;


public interface WrongRecordMapper{
  public int addRecord(WrongRecord wrongRecord);
  
  public int updateRecord(WrongRecord wrongRecord);
  
  public WrongRecord queryRecordById(long id);
  
  /**
   * 分页列表
   * @param map
   * @return
   */
  public List<WrongRecord> queryRecordPage(Map<String , Object> map);
  
  /**
   * 总题数
   * @param openID
   * @return
   */
  public int queryRecordCount(String openID);
  
  /**
   * 当前第几题
   * @param map
   * @return
   */
  public int queryRecordCurrent(Map<String , Object> map);
  
  /**
   * 下一错题id
   * @param map
   * @return
   */
  public Integer queryRecordNextId(Map<String , Object> map);
}

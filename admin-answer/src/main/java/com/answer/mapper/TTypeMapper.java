package com.answer.mapper;

import com.answer.domain.TType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTypeMapper extends BaseMapper<TType>{

    List<TType> selectByPId(@Param("id")Long id);

}
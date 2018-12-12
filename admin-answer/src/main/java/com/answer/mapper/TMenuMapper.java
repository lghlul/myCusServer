package com.answer.mapper;

import com.answer.domain.TMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMenuMapper extends BaseMapper<TMenu>{

    List<TMenu> selectAdminMenu(@Param("roleId") Long roleId ,@Param("parentId") Long parentId);

}
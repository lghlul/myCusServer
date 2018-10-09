package com.lu.code.mapper;

import com.lu.code.domain.Columns;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @CLassName TableMapper
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 18:10
 **/
public interface TableMapper {
    /*
     * @author ll
     * @Description 获取所有表
     * @date 2018/9/25 18:21
     * @param [databaseName]
     * @return java.util.List<java.lang.String>
     */
    @Select("SELECT TABLE_NAME FROM information_schema. TABLES WHERE table_schema = #{databaseName} AND TABLE_TYPE = 'BASE TABLE'")
    public List<String> getTableList(String databaseName);


    /*
     * @author ll
     * @Description 获取所有表字段
     * @date 2018/9/25 18:21
     * @param [tableName]
     * @return java.util.List<java.lang.String>
     */
    @Select("select COLUMN_NAME as columnName , DATA_TYPE as dataType,COLUMN_KEY as columnKey  from INFORMATION_SCHEMA.COLUMNS where table_name = #{tableName} and table_schema = #{databaseName}")
    public List<Columns> getFieldList(@Param("tableName") String tableName , @Param("databaseName") String databaseName);
}

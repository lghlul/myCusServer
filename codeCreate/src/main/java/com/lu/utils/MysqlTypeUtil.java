package com.lu.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @CLassName MysqlTypeUtil
 * @Description  mysql 与 java 数据类型
 * @Author ll
 * @Date 2018/9/26 11:13
 **/
public class MysqlTypeUtil {

    public static Map<String , String > mysqlTypeMap = new HashMap<>();

    static{
        mysqlTypeMap.put("VARCHAR" , "String");
        mysqlTypeMap.put("CHAR" , "String");
        mysqlTypeMap.put("BLOB" , "byte []");
        mysqlTypeMap.put("TEXT","String");
        mysqlTypeMap.put("INT","Integer");
        mysqlTypeMap.put("TINYINT" , "Byte");
        mysqlTypeMap.put("SMALLINT","Integer");
        mysqlTypeMap.put("MEDIUMINT","Integer");
        mysqlTypeMap.put("BIT" , "Boolean");
        mysqlTypeMap.put("BIGINT","Long");
        mysqlTypeMap.put("FLOAT","Float");
        mysqlTypeMap.put("DOUBLE","Double");
        mysqlTypeMap.put("BOOLEAN","Integer");
        mysqlTypeMap.put("DATE","String");
        mysqlTypeMap.put("TIME" , "String");
        mysqlTypeMap.put("DATETIME","String");
        mysqlTypeMap.put("TIMESTAMP","String");
    }
}

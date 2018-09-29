package com.lu.code;

import com.lu.code.domain.Columns;
import com.lu.code.handler.DomainHandler;
import com.lu.code.handler.MapperHandler;
import com.lu.code.mapper.TableMapper;
import com.lu.code.mybatis.DynamicDataSource;
import com.lu.project.PathConfig;
import com.lu.project.ProjectCreate;
import com.lu.utils.CodeUtil;
import com.lu.utils.PropertiesUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @CLassName CodeCreate
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 18:00
 **/
public class CodeCreate {
    public static void main(String[] args) {
        String databaseName = "lghll";
        DynamicDataSource dynamicDataSource = new DynamicDataSource("com.mysql.jdbc.Driver","jdbc:mysql://47.100.229.122:3306/" + databaseName + "?useUnicode=true","root","123456");
        SqlSession sqlSession = dynamicDataSource.getSqlSessionFactory().openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<String> tableList = tableMapper.getTableList(databaseName);
        PropertiesUtil.initProperties();
        ProjectCreate projectHandler = new ProjectCreate();
        projectHandler.init("testOne4", "com.lu.code");
        projectHandler.create();
        String basePackage = projectHandler.getPathConfig().getBasePackage();
        tableList = tableList.subList(0 , 2);
        //BaseMapper.java
        MapperHandler mapperHandler = new MapperHandler(projectHandler.getPathConfig());
        mapperHandler.writeBaseJavaMapper( );
        DomainHandler domainHandler = new DomainHandler(basePackage  , projectHandler.getPathConfig().getDomainPah());
        domainHandler.writeBaseDoamin();
        for(String tableName : tableList){
            String domainName = CodeUtil.delSpecialMark(tableName , 1);
            List<Columns> columnsList = tableMapper.getFieldList(tableName , databaseName);
            //处理列名称
            CodeUtil.colimnConver(columnsList);
            //写入domain
            domainHandler.writeDoamin(domainName , columnsList);
            //写入mapper
            mapperHandler.writeMapper(columnsList, domainName , tableName);
        }

    }
}

package com.lu.code;

import com.lu.code.domain.Columns;
import com.lu.code.handler.ControllerHandler;
import com.lu.code.handler.DomainHandler;
import com.lu.code.handler.MapperHandler;
import com.lu.code.handler.ServiceHandler;
import com.lu.code.mapper.TableMapper;
import com.lu.code.mybatis.DynamicDataSource;
import com.lu.project.PathConfig;
import com.lu.project.ProjectConfig;
import com.lu.utils.CodeUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @CLassName CodeCreate
 * @Description TODO
 * @Author ll
 * @Date 2018/9/25 18:00
 **/
public class CodeCreate {


    public void create(ProjectConfig projectConfig ,PathConfig pathConfig ) throws Exception{
        DynamicDataSource dynamicDataSource = new DynamicDataSource(projectConfig);
        SqlSession sqlSession = dynamicDataSource.openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<String> tableList = tableMapper.getTableList(projectConfig.getDatabase());
        //BaseMapper.java
        MapperHandler mapperHandler = new MapperHandler(pathConfig);
        mapperHandler.writeBaseJavaMapper( );
        //BaseDomain.java
        DomainHandler domainHandler = new DomainHandler(pathConfig);
        //domainHandler.writeBaseDoamin();

        //BaseService
        ServiceHandler serviceHandler = new ServiceHandler(pathConfig);
        serviceHandler.writeBaseService();

        //BaseController
        ControllerHandler controllerHandler = new ControllerHandler(pathConfig);
        controllerHandler.writeBaseController();

        for(int i = 0 ; i < tableList.size()  ; i++){
            String tableName = tableList.get(i);
            String domainName = CodeUtil.delSpecialMark(tableName , 1);
            if(i == 0){
                //TestController
                controllerHandler.writeTestController(domainName);
            }
            List<Columns> columnsList = tableMapper.getFieldList(tableName , projectConfig.getDatabase());
            //处理列名称
            CodeUtil.colimnConver(columnsList);
            //写入domain
            domainHandler.writeDoamin(domainName , columnsList);
            //写入mapper
            mapperHandler.writeMapper(columnsList, domainName , tableName);
            //写入service
            serviceHandler.writeService(domainName);
        }
        dynamicDataSource.closeSession(sqlSession);

    }

    /*public static void main(String[] args) throws Exception{
        String databaseName = "project";

        ProjectConfig projectConfig = new ProjectConfig();
        projectConfig.setBasePackage("com.lu.code");
        projectConfig.setProjectName("testOne4");
        projectConfig.setDrivenClass("com.mysql.jdbc.Driver");
        projectConfig.setUrl("jdbc:mysql://47.100.229.122:3306/" + databaseName + "?useUnicode=true");
        projectConfig.setUsername("root");
        projectConfig.setPassword("123456");

        DynamicDataSource dynamicDataSource = new DynamicDataSource(projectConfig);
        SqlSession sqlSession = dynamicDataSource.getSqlSessionFactory().openSession();
        TableMapper tableMapper = sqlSession.getMapper(TableMapper.class);
        List<String> tableList = tableMapper.getTableList(databaseName);
        PropertiesUtil.initProperties();
        ProjectCreate projectHandler = new ProjectCreate();
        projectHandler.init(projectConfig);

        projectHandler.create();
        //tableList = tableList.subList(0 , 2);
        //BaseMapper.java
        MapperHandler mapperHandler = new MapperHandler(projectHandler.getPathConfig());
        mapperHandler.writeBaseJavaMapper( );
        //BaseDomain.java
        DomainHandler domainHandler = new DomainHandler(projectHandler.getPathConfig());
        //domainHandler.writeBaseDoamin();

        //BaseService
        ServiceHandler serviceHandler = new ServiceHandler(projectHandler.getPathConfig());
        serviceHandler.writeBaseService();

        //BaseController
        ControllerHandler controllerHandler = new ControllerHandler(projectHandler.getPathConfig());
        controllerHandler.writeBaseController();

        for(int i = 0 ; i < tableList.size()  ; i++){
            String tableName = tableList.get(i);
            String domainName = CodeUtil.delSpecialMark(tableName , 1);
            if(i == 0){
                //TestController
                controllerHandler.writeTestController(domainName);
            }
            List<Columns> columnsList = tableMapper.getFieldList(tableName , databaseName);
            //处理列名称
            CodeUtil.colimnConver(columnsList);
            //写入domain
            domainHandler.writeDoamin(domainName , columnsList);
            //写入mapper
            mapperHandler.writeMapper(columnsList, domainName , tableName);
            //写入service
            serviceHandler.writeService(domainName);
        }
    }*/
}

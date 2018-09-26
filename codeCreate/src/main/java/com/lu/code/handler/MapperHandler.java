package com.lu.code.handler;

import com.lu.code.domain.Columns;
import com.lu.project.PathConfig;
import com.lu.tag.XmlAttr;
import com.lu.tag.mybatis.If;
import com.lu.tag.mybatis.Insert;
import com.lu.tag.mybatis.Mapper;
import com.lu.tag.mybatis.Trim;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;
import com.lu.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName MapperHandler
 * @Description 生成mapper
 * @Author ll
 * @Date 2018/9/26 14:23
 **/
public class MapperHandler {

    private String baseMapperName = "BaseMapper";


    private PathConfig pathConfig;

    private String basePackage ;
    private String javaMapperPath ;
    private String xmlMapperPath ;

    public MapperHandler(PathConfig pathConfig){
        this.pathConfig = pathConfig;
        this.basePackage = pathConfig.getBasePackage();
        this.javaMapperPath = pathConfig.getJavaMapperPath();
        this.xmlMapperPath = pathConfig.getXmlMapperPath();
    }

    /*
     * @author ll
     * @Description 写入mapper
     * @date 2018/9/26 15:26
     * @param [columnsList, basePackage, javaMapperPath, resourcesMapperPath, domainName]
     * @return void
     */
    public  void writeMapper(List<Columns> columnsList , String domainName , String tableName){
        writeJavaMapper(domainName);
        writeMapperXml(columnsList ,tableName ,domainName );
    }

    /***************************************BASE MAPPER*************************************************/
    /*
     * @author ll
     * @Description 写入BaseMapper.java
     * @date 2018/9/26 14:52
     * @param [basePackage, javaMapperPath]
     * @return void
     */
    public void writeBaseJavaMapper(){
        String baseJavaMapperCode = getBaseJavaMapperCode();
        String path = javaMapperPath + "/" + baseMapperName + ".java";
        FileUtil.writeFileByStr(baseJavaMapperCode , path);
    }
    /*
     * @author ll
     * @Description 获取BaseMapp.java 代码
     * @date 2018/9/26 14:55
     * @param [basePackage]
     * @return java.lang.String
     */
    private  String getBaseJavaMapperCode(){
        StringBuffer baseMapperCode = new StringBuffer();
        baseMapperCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + ";");
        baseMapperCode.append(CodeUtil.getChangeLine(1));
        // import
        String [] baseMapperImports = PropertiesUtil.BASEMAPPER_IMPORT.split(";");
        for(String mapperImport : baseMapperImports){
            baseMapperCode.append(CodeUtil.getChangeLine(1));
            baseMapperCode.append("import " + mapperImport + ";");
        }
        baseMapperCode.append(CodeUtil.getChangeLine(2));
        baseMapperCode.append("public interface BaseMapper<T> {");
        baseMapperCode.append(CodeUtil.getChangeLine(1));
        //方法
        String [] baseMapperMethods = PropertiesUtil.BASEMAPPER_METHOD.split(";");
        for(String mapperMethod : baseMapperMethods){
            baseMapperCode.append(CodeUtil.getChangeLine(1));
            baseMapperCode.append(CodeUtil.getIndent(1) + mapperMethod + ";");
            baseMapperCode.append(CodeUtil.getChangeLine(1));
        }
        baseMapperCode.append(CodeUtil.getChangeLine(1));
        baseMapperCode.append("}");
        return baseMapperCode.toString();
    }


    /***************************************JAVA MAPPER*************************************************/

    /*
     * @author ll
     * @Description 写入 java mapper文件
     * @date 2018/9/26 15:26
     * @param [javaMapperPath, basePackage, domainName]
     * @return void
     */
    private  void writeJavaMapper(  String domainName){
        String javaMapperCode = getJavaMapperCode( domainName);
        String className = domainName + "Mapper.java";
        String path = javaMapperPath + "/" + className;
        FileUtil.writeFileByStr(javaMapperCode , path);
    }

    /*
     * @author ll
     * @Description 获取JAVA mapper代码
     * @date 2018/9/26 15:17
     * @param [basePackage, domainName]
     * @return java.lang.String
     */
    private  String getJavaMapperCode( String domainName){
        String className = domainName + "Mapper";
        StringBuffer javaMapperCode = new StringBuffer();
        javaMapperCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + "." + domainName + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("public interface " + className + " extends " + baseMapperName + "<" +domainName + ">{");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("}");
        return javaMapperCode.toString();
    }
    /***************************************MAPPER XML*************************************************/

    /*
     * @author ll
     * @Description 写 xmlMapper 文件
     * @date 2018/9/26 15:42
     * @param [columnsList]
     * @return void
     */
    private  void writeMapperXml(List<Columns> columnsList , String tableName   , String domainName ){
        String rootName = "mapper";
        Mapper mapper = getMapper(columnsList,tableName , domainName);

        String [] attrValue = {basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + "." + domainName + "Mapper"};
        XmlUtil.setAttrByMethod(mapper , null , attrValue );
        XmlUtil.writeXml(xmlMapperPath + "/" + domainName + "Mapper.xml" ,mapper , rootName,"mapper","-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd",null );
    }

    /*
     * @author ll
     * @Description 获取mapper 标签
     * @date 2018/9/26 18:22
     * @param [columnsList, tableName]
     * @return com.lu.tag.mybatis.Mapper
     */
    private  Mapper getMapper(List<Columns> columnsList , String tableName , String domainName){
        Mapper mapper = new Mapper();
        mapper.setInsert(getInset(columnsList , tableName , domainName));
        return mapper;
    }

    /*
     * @author ll
     * @Description 生成insert标签
     * @date 2018/9/26 17:36
     * @param [columnsList, tableName]
     * @return com.lu.tag.mybatis.Insert
     */
    private  Insert getInset(List<Columns> columnsList , String tableName , String domainName){
        Insert insert = new Insert();
        insert.setNonTag("insert into" + tableName  );
        List<Trim> trimList = new ArrayList<>();
        trimList.add(getTrim(columnsList , 1));
        trimList.add(getTrim(columnsList , 2));
        insert.setTrim(trimList);

        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("id" , "insert"));
        attrList.add(new XmlAttr("parameterType" , domainName));
        insert.setAttrList(attrList);
        return insert;
    }
    /*
     * @author ll
     * @Description 生成trim标签
     * @date 2018/9/26 17:33
     * @param [columnsList, type] 1 是 数据库字段  2是插入时的values字段
     * @return com.lu.tag.mybatis.Trim
     */
    private  Trim getTrim(List<Columns> columnsList , int type){
        Trim trim = new Trim();
        List<XmlAttr> attrList = new ArrayList<>();
        if(type == 1){
            attrList.add(new XmlAttr("prefix","("));
        }else{
            attrList.add(new XmlAttr("prefix","values ("));
        }
        attrList.add(new XmlAttr("suffix",")"));
        attrList.add(new XmlAttr("suffixOverrides",","));
        List<If> ifList = new ArrayList<>();
        for(Columns columns : columnsList){
            If if2 = null;
            if(type == 1){
                if2 = new If(columns.getColumnName() + ",");
            }else{
                if2 = new If("#{" + columns.getVariableName() + "},");
            }
            List<XmlAttr> ifAttrList = new ArrayList<>();
            ifAttrList.add(new XmlAttr("test",columns.getVariableName() + " != null"));
            if2.setAttrList(ifAttrList);
            ifList.add(if2);
        }
        trim.setIf2(ifList);
        trim.setAttrList(attrList);
        return trim;
    }


}

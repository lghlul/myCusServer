package com.lu.code.handler;

import com.lu.code.domain.Columns;
import com.lu.project.PathConfig;
import com.lu.tag.XmlAttr;
import com.lu.tag.mybatis.*;
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


    private PathConfig pathConfig;

    private String basePackage;
    private String javaMapperPath;
    private String xmlMapperPath;

    public MapperHandler(PathConfig pathConfig) {
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
    public void writeMapper(List<Columns> columnsList, String domainName, String tableName) {
        writeJavaMapper(domainName);
        writeMapperXml(columnsList, tableName, domainName);
    }

    /***************************************BASE MAPPER*************************************************/
    /*
     * @author ll
     * @Description 写入BaseMapper.java
     * @date 2018/9/26 14:52
     * @param [basePackage, javaMapperPath]
     * @return void
     */
    public void writeBaseJavaMapper() {
        String baseJavaMapperCode = getBaseJavaMapperCode();
        String path = javaMapperPath + "/" + PropertiesUtil.CLASS_BASE_MAPPER + ".java";
        FileUtil.writeFileByStr(baseJavaMapperCode, path);
    }

    /*
     * @author ll
     * @Description 获取BaseMapp.java 代码
     * @date 2018/9/26 14:55
     * @param [basePackage]
     * @return java.lang.String
     */
    private String getBaseJavaMapperCode() {
        StringBuffer baseMapperCode = new StringBuffer();
        baseMapperCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + ";");
        baseMapperCode.append(CodeUtil.getChangeLine(1));
        // import
        String[] baseMapperImports = PropertiesUtil.BASEMAPPER_IMPORT.split(";");
        for (String mapperImport : baseMapperImports) {
            baseMapperCode.append(CodeUtil.getChangeLine(1));
            baseMapperCode.append("import " + mapperImport + ";");
        }
        baseMapperCode.append(CodeUtil.getChangeLine(2));
        baseMapperCode.append("public interface " + PropertiesUtil.CLASS_BASE_MAPPER + "<T> {");
        baseMapperCode.append(CodeUtil.getChangeLine(1));
        //方法
        String[] baseMapperMethods = PropertiesUtil.BASEMAPPER_METHOD.split(";");
        for (String mapperMethod : baseMapperMethods) {
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
    private void writeJavaMapper(String domainName) {
        String javaMapperCode = getJavaMapperCode(domainName);
        String className = domainName + "Mapper.java";
        String path = javaMapperPath + "/" + className;
        FileUtil.writeFileByStr(javaMapperCode, path);
    }

    /*
     * @author ll
     * @Description 获取JAVA mapper代码
     * @date 2018/9/26 15:17
     * @param [basePackage, domainName]
     * @return java.lang.String
     */
    private String getJavaMapperCode(String domainName) {
        String className = domainName + "Mapper";
        StringBuffer javaMapperCode = new StringBuffer();
        javaMapperCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + "." + domainName + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("public interface " + className + " extends " + PropertiesUtil.CLASS_BASE_MAPPER + "<" + domainName + ">{");
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
    private void writeMapperXml(List<Columns> columnsList, String tableName, String domainName) {
        String rootName = "mapper";
        Mapper mapper = getMapper(columnsList, tableName, domainName);

        String[] attrValue = {basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + "." + domainName + "Mapper"};
        XmlUtil.setAttrByMethod(mapper, null, attrValue);
        XmlUtil.writeXml(xmlMapperPath + "/" + domainName + "Mapper.xml", mapper, rootName, "mapper", "-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd", null);
    }

    /*
     * @author ll
     * @Description 获取mapper 标签
     * @date 2018/9/26 18:22
     * @param [columnsList, tableName]
     * @return com.lu.tag.mybatis.Mapper
     */
    private Mapper getMapper(List<Columns> columnsList, String tableName, String domainName) {
        Mapper mapper = new Mapper();
        //ResultMap
        mapper.setResultMap(getResultMap(columnsList, domainName));

        List<Select> selectList = new ArrayList<>();
        //selectById
        SelectNoTag selectByIdMethod = getSelectById(columnsList, tableName);
        if (selectByIdMethod != null) {
            selectList.add(selectByIdMethod);
        }
        // selectPage
        selectList.add(getSelectPage(columnsList, tableName, domainName, 1));
        // selectPageCount
        selectList.add(getSelectPage(columnsList, tableName, domainName, 2));
        // selectPageByMap
        selectList.add(getSelectPage(columnsList, tableName, domainName, 3));
        // selectPageCountByMap
        selectList.add(getSelectPage(columnsList, tableName, domainName, 4));
        mapper.setSelect(selectList);

        //insert
        List<Insert> insertList = new ArrayList<>();
        insertList.add(getInsetMethod(columnsList, tableName, domainName));
        mapper.setInsert(insertList);


        List<Delete> deleteList = new ArrayList<>();
        //selectById
        DeleteNoTag deleteByIdMethod = getDeleteById(columnsList, tableName);
        if (deleteByIdMethod != null) {
            deleteList.add(deleteByIdMethod);

        }
        deleteList.add(getDelete(columnsList , tableName , domainName));

        mapper.setDelete(deleteList);
        return mapper;
    }

    /*
     * @author ll
     * @Description 生成  insert方法
     * @date 2018/9/26 17:36
     * @param [columnsList, tableName]
     * @return com.lu.tag.mybatis.Insert
     */
    private Insert getInsetMethod(List<Columns> columnsList, String tableName, String domainName) {
        Insert insert = new Insert();
        insert.setNonTag("insert into" + tableName);
        List<Trim> trimList = new ArrayList<>();
        trimList.add(getTrim(columnsList, 1));
        trimList.add(getTrim(columnsList, 2));
        insert.setTrim(trimList);

        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("id", "insert"));
        attrList.add(new XmlAttr("parameterType", domainName));
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
    private Trim getTrim(List<Columns> columnsList, int type) {
        Trim trim = new Trim();
        List<XmlAttr> attrList = new ArrayList<>();
        if (type == 1) {
            attrList.add(new XmlAttr("prefix", "("));
        } else {
            attrList.add(new XmlAttr("prefix", "values ("));
        }
        attrList.add(new XmlAttr("suffix", ")"));
        attrList.add(new XmlAttr("suffixOverrides", ","));
        List<If> ifList = new ArrayList<>();
        for (Columns columns : columnsList) {
            If if2 = null;
            List<XmlAttr> ifAttrList = new ArrayList<>();
            ifAttrList.add(new XmlAttr("test", columns.getVariableName() + " != null"));
            if (type == 1) {
                if2 = new If(columns.getColumnName() + ",", ifAttrList);
            } else {
                if2 = new If("#{" + columns.getVariableName() + "},", ifAttrList);
            }
            ifList.add(if2);
        }
        trim.setIf2(ifList);
        trim.setAttrList(attrList);
        return trim;
    }

    /*
     * @author ll
     * @Description 生成 selectById方法
     * @date 2018/9/28 16:06
     * @param [columnsList, tableName, domainName]
     * @return com.lu.tag.mybatis.SelectNoTag
     */
    private SelectNoTag getSelectById(List<Columns> columnsList, String tableName) {
        SelectNoTag selectNoTag = null;
        String priColumnName = getPriKey(columnsList);
        if (priColumnName != null) {
            selectNoTag = new SelectNoTag();
            String sql = "select * from " + tableName + " where " + priColumnName + " = #{id}";
            selectNoTag.setNonTag(sql);
            List<XmlAttr> attrList = new ArrayList<>();
            attrList.add(new XmlAttr("id", "selectById"));
            attrList.add(new XmlAttr("parameterType", "string"));
            attrList.add(new XmlAttr("resultMap", PropertiesUtil.BASE_RESULTMAP));
            selectNoTag.setAttrList(attrList);
        }
        return selectNoTag;
    }

    /*
     * @author ll
     * @Description 生成resultMap
     * @date 2018/9/28 16:24
     * @param [columnsList, domainName]
     * @return com.lu.tag.mybatis.ResultMap
     */
    private ResultMap getResultMap(List<Columns> columnsList, String domainName) {
        ResultMap resultMap = new ResultMap();
        List<Result> resultList = new ArrayList<>();
        for (Columns columns : columnsList) {
            if ("PRI".equals(columns.getColumnKey())) {
                List<XmlAttr> attrList = new ArrayList<>();
                attrList.add(new XmlAttr("column", columns.getColumnName()));
                attrList.add(new XmlAttr("property", columns.getVariableName()));
                Id id = new Id(attrList);
                resultMap.setId(id);
            } else {
                List<XmlAttr> attrList = new ArrayList<>();
                attrList.add(new XmlAttr("column", columns.getColumnName()));
                attrList.add(new XmlAttr("property", columns.getVariableName()));
                resultList.add(new Result(attrList));
            }

        }
        resultMap.setResult(resultList);
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("type", domainName));
        attrList.add(new XmlAttr("id", PropertiesUtil.BASE_RESULTMAP));
        resultMap.setAttrList(attrList);
        return resultMap;
    }


    /*
     * @author ll
     * @Description 生成 selectPage 方法
     * @date 2018/9/28 17:31
     * @param [columnsList, tableName] type = 1 page  type = 2 pageCount type = 3 pageByMap  type = 4 pageCountByMap
     * @return com.lu.tag.mybatis.SelectWithTag
     */
    private SelectWithTag getSelectPage(List<Columns> columnsList, String tableName, String domainName, int type) {
        List<XmlAttr> attrList = new ArrayList<>();

        switch (type) {
            case 1:
                attrList.add(new XmlAttr("id", "selectPage"));
                attrList.add(new XmlAttr("resultMap", PropertiesUtil.BASE_RESULTMAP));
                attrList.add(new XmlAttr("parameterType", domainName));
                break;
            case 2:
                attrList.add(new XmlAttr("id", "selectPageCount"));
                attrList.add(new XmlAttr("resultType", "int"));
                attrList.add(new XmlAttr("parameterType", domainName));
                break;
            case 3:
                attrList.add(new XmlAttr("id", "selectPageByMap"));
                attrList.add(new XmlAttr("resultMap", PropertiesUtil.BASE_RESULTMAP));
                attrList.add(new XmlAttr("parameterType", "map"));
                break;
            case 4:
                attrList.add(new XmlAttr("id", "selectPageCountByMap"));
                attrList.add(new XmlAttr("resultType", "int"));
                attrList.add(new XmlAttr("parameterType", "map"));
                break;
            default:
                break;
        }

        SelectWithTag selectWithTag = new SelectWithTag(attrList);

        String sql = null;
        if (type == 1 || type == 3) {
            sql = "select * from " + tableName;
        }else{
            sql = "select count(*) from " + tableName;
        }
        selectWithTag.setNonTag(sql);
        //where标签
        Where where = new Where();
        List<If> whereIfList = getIfList(columnsList , 1);
        where.setIf2(whereIfList);
        selectWithTag.setWhere(where);

        if (type == 1 || type == 3) {
            //if标签
            List<If> ifList = new ArrayList<>();
            List<XmlAttr> ifAttrList = new ArrayList<>();
            ifAttrList.add(new XmlAttr("test", "pageNo != null and pageSize != null"));
            ifList.add(new If("limit (pageNo - 1)*pageSize,pageSize", ifAttrList));
            selectWithTag.setIf2(ifList);
        }

        return selectWithTag;
    }

    /*
     * @author ll
     * @Description 生成 delete方法
     * @date 2018/9/28 19:01
     * @param [columnsList, tableName, domainName]
     * @return com.lu.tag.mybatis.DeleteWithTag
     */
    private DeleteWithTag getDelete(List<Columns> columnsList, String tableName , String domainName){
        List<XmlAttr> attrList = new ArrayList<>();
        attrList.add(new XmlAttr("id", "delete"));
        attrList.add(new XmlAttr("parameterType", domainName));
        DeleteWithTag deleteWithTag = new DeleteWithTag(attrList);
        Where where = new Where();
        List<If> ifList = getIfList(columnsList , 1);
        where.setIf2(ifList);
        deleteWithTag.setWhere(where);
        deleteWithTag.setNonTag("delete from " + tableName);
        return deleteWithTag;
    }

    /*
     * @author ll
     * @Description 生成 deleteById 方法
     * @date 2018/9/28 18:48
     * @param [columnsList, tableName]
     * @return com.lu.tag.mybatis.DeleteNoTag
     */
    private DeleteNoTag getDeleteById(List<Columns> columnsList, String tableName){
        DeleteNoTag deleteNoTag = null;
        String priColumnName = getPriKey(columnsList);
        if (priColumnName != null) {
            deleteNoTag = new DeleteNoTag();
            String sql = "delete from " + tableName + " where " + priColumnName + " = #{id}";
            deleteNoTag.setNonTag(sql);
            List<XmlAttr> attrList = new ArrayList<>();
            attrList.add(new XmlAttr("id", "deleteById"));
            attrList.add(new XmlAttr("parameterType", "string"));
            deleteNoTag.setAttrList(attrList);
        }
        return deleteNoTag;
    }
    /*
     * @author ll
     * @Description 获取主键
     * @date 2018/9/28 18:45
     * @param [columnsList]
     * @return java.lang.String
     */
    private String getPriKey(List<Columns> columnsList){
        String priColumnName = null;
        for (Columns columns : columnsList) {
            if ("PRI".equals(columns.getColumnKey())) {
                priColumnName = columns.getColumnName();
            }
        }
        return priColumnName;
    }


    /*
     * @author ll
     * @Description 获取if标签列表
     * @date 2018/9/28 18:53
     * @param [columns, type] type = 1 and 连接  , type = 2 逗号连接
     * @return java.util.List<com.lu.tag.mybatis.If>
     */
    private List<If> getIfList(List<Columns> columnsList , int type){
        List<If> ifList = new ArrayList<>();
        for (Columns columns : columnsList) {
            List<XmlAttr> ifAttrList = new ArrayList<>();
            ifAttrList.add(new XmlAttr("test", columns.getVariableName() + " != null"));
            if(type == 1){
                ifList.add(new If("and " + columns.getColumnName() + " = #{" + columns.getVariableName() + "}", ifAttrList));
            }else{
                ifList.add(new If(columns.getColumnName() + " = #{" + columns.getVariableName() + "},", ifAttrList));
            }
        }
        return ifList;
    }

}

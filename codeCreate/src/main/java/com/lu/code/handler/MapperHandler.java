package com.lu.code.handler;

import com.lu.code.domain.Columns;
import com.lu.project.PathConfig;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;

import java.util.List;

/**
 * @CLassName MapperHandler
 * @Description 生成mapper
 * @Author ll
 * @Date 2018/9/26 14:23
 **/
public class MapperHandler {

    private static String BASEMAPPER_NAME = "BaseMapper";

    /*
     * @author ll
     * @Description 写入mapper
     * @date 2018/9/26 15:26
     * @param [columnsList, basePackage, javaMapperPath, resourcesMapperPath, domainName]
     * @return void
     */
    public static void writeMapper(List<Columns> columnsList , PathConfig pathConfig , String domainName , String tableName){
        String basePackage = pathConfig.getBasePackage();
        String javaMapperPath = pathConfig.getJavaMapperPath();
        String xmlMapperPath = pathConfig.getXmlMapperPath();
        writeJavaMapper(javaMapperPath,basePackage,domainName);
    }

    /***************************************BASE MAPPER*************************************************/
    /*
     * @author ll
     * @Description 写入BaseMapper.java
     * @date 2018/9/26 14:52
     * @param [basePackage, javaMapperPath]
     * @return void
     */
    public static void writeBaseJavaMapper(String basePackage , String javaMapperPath){
        String baseJavaMapperCode = getBaseJavaMapperCode(basePackage);
        String path = javaMapperPath + "/" + BASEMAPPER_NAME + ".java";
        FileUtil.writeFileByStr(baseJavaMapperCode , path);
    }
    /*
     * @author ll
     * @Description 获取BaseMapp.java 代码
     * @date 2018/9/26 14:55
     * @param [basePackage]
     * @return java.lang.String
     */
    private static String getBaseJavaMapperCode(String basePackage){
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
    private static void writeJavaMapper(String javaMapperPath , String basePackage , String domainName){
        String javaMapperCode = getJavaMapperCode(basePackage , domainName);
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
    private static String getJavaMapperCode(String basePackage , String domainName){
        String className = domainName + "Mapper";
        StringBuffer javaMapperCode = new StringBuffer();
        javaMapperCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_MAPPER + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("import " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + "." + domainName + ";");
        javaMapperCode.append(CodeUtil.getChangeLine(2));
        javaMapperCode.append("public interface " + className + " extends " + BASEMAPPER_NAME + "<" +domainName + ">{");
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
    private static void writeMapperXml(List<Columns> columnsList){

    }


    private String getInsertSql(List<Columns> columnsList , String tableName){
        StringBuffer insertSql = new StringBuffer();
        insertSql.append("insert into" + tableName + "(");
        return null;
    }


}

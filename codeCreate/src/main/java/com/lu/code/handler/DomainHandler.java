package com.lu.code.handler;

import com.lu.code.domain.Columns;
import com.lu.utils.CodeUtil;
import com.lu.utils.FileUtil;
import com.lu.utils.PropertiesUtil;
import java.util.List;

/**
 * @CLassName DomainHandler
 * @Description domain创建工具类
 * @Author ll
 * @Date 2018/9/25 18:34
 **/
public class DomainHandler {


    /*
     * @author ll
     * @Description 写入domain代码
     * @date 2018/9/26 11:23
     * @param [tableName, columnList, basePackage, domainPath]
     * @return void
     */
    public static void writeDoamin(String domainName , List<Columns> columnList , String basePackage , String domainPath){
        String codeStr = getDomainCode(domainName , columnList , basePackage);
        String path = domainPath + "/" + domainName + ".java";
        FileUtil.writeFileByStr(codeStr , path);

    }

    /*
     * @author ll
     * @Description 获取类名称
     * @date 2018/9/25 18:40
     * @param [tableName]
     * @return java.lang.String
     */
    private static String getDomainCode(String domainName , List<Columns> columnList , String basePackage){
        StringBuffer domainCode = new StringBuffer();
        domainCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + ";");
        domainCode.append(CodeUtil.getChangeLine(2));
        domainCode.append("public class " + domainName + "{");
        domainCode.append(CodeUtil.getChangeLine(2));
        //声明变量
        for(Columns columns : columnList){
            domainCode.append(CodeUtil.getIndent(1) + "private " + columns.getVariableType() + " " + columns.getVariableName() + ";");
            domainCode.append(CodeUtil.getChangeLine(2));
        }
        // get  set 方法
        for(Columns columns : columnList){
            String variableName = columns.getVariableName();
            String variableType = columns.getVariableType();
            String variableMethod = columns.getVariableMethod();
            //get 方法
            domainCode.append(CodeUtil.getIndent(1) + "public " + variableType + " get" + variableMethod + "(){");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(2) + "return this." + variableName + ";");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(1) + "}");
            domainCode.append(CodeUtil.getChangeLine(2));
            //set方法
            domainCode.append(CodeUtil.getIndent(1) + "public void set" + variableMethod + "(" + variableType + " " + variableName + "){");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(2) + "this." + variableName + " = " + variableName + ";");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(1) + "}");
            domainCode.append(CodeUtil.getChangeLine(2));
        }
        domainCode.append("}");
        return domainCode.toString();
    }


}

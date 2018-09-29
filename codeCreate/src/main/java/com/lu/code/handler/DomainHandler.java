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


    private String baseDomainName = "BaseDomain";


    private String pageNoName = "pageNo";

    private String pageSizeName = "pageSize";

    private String basePackage;
    private String domainPath;

    public DomainHandler(String basePackage , String domainPath){
        this.basePackage = basePackage;
        this.domainPath = domainPath;
    }

    /*
     * @author ll
     * @Description 写入domain代码
     * @date 2018/9/26 11:23
     * @param [tableName, columnList, basePackage, domainPath]
     * @return void
     */
    public void writeDoamin(String domainName , List<Columns> columnList){
        String codeStr = getDomainCode(domainName , columnList );
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
    private String getDomainCode(String domainName , List<Columns> columnList ){
        StringBuffer domainCode = new StringBuffer();
        domainCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + ";");
        domainCode.append(CodeUtil.getChangeLine(2));
        domainCode.append("public class " + domainName + " extends " + baseDomainName + "{");
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
            CodeUtil.addGetMethod(domainCode , variableType , variableName , variableMethod);
            //set方法
            CodeUtil.addSetMethod(domainCode , variableType , variableName , variableMethod);
            /*domainCode.append(CodeUtil.getIndent(1) + "public " + variableType + " get" + variableMethod + "(){");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(2) + "return this." + variableName + ";");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(1) + "}");
            domainCode.append(CodeUtil.getChangeLine(2));*/


            /*domainCode.append(CodeUtil.getIndent(1) + "public void set" + variableMethod + "(" + variableType + " " + variableName + "){");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(2) + "this." + variableName + " = " + variableName + ";");
            domainCode.append(CodeUtil.getChangeLine(1));
            domainCode.append(CodeUtil.getIndent(1) + "}");
            domainCode.append(CodeUtil.getChangeLine(2));*/

        }
        domainCode.append("}");
        return domainCode.toString();
    }

    /*
     * @author ll
     * @Description 写入basedomain
     * @date 2018/9/28 18:19
     * @param []
     * @return void
     */
    public void writeBaseDoamin(){
        StringBuffer baseDomainCode = new StringBuffer();
        baseDomainCode.append("package " + basePackage + "." + PropertiesUtil.PACKAGE_DOMAIN + ";");
        baseDomainCode.append(CodeUtil.getChangeLine(2));
        baseDomainCode.append("public class  " + baseDomainName + "{");
        baseDomainCode.append(CodeUtil.getChangeLine(2));
        baseDomainCode.append(CodeUtil.getIndent(1) + "private Integer pageNo;");
        baseDomainCode.append(CodeUtil.getChangeLine(2));
        baseDomainCode.append(CodeUtil.getIndent(1) + "private Integer pageSize;");
        baseDomainCode.append(CodeUtil.getChangeLine(2));
        //get 方法
        CodeUtil.addGetMethod(baseDomainCode , "int" , pageNoName , (new StringBuilder()).append(Character.toUpperCase(pageNoName.charAt(0))).append(pageNoName.substring(1)).toString());
        //set方法
        CodeUtil.addSetMethod(baseDomainCode , "int" , pageNoName , (new StringBuilder()).append(Character.toUpperCase(pageNoName.charAt(0))).append(pageNoName.substring(1)).toString());
        baseDomainCode.append(CodeUtil.getChangeLine(2));
        //get 方法
        CodeUtil.addGetMethod(baseDomainCode , "int" , pageSizeName , (new StringBuilder()).append(Character.toUpperCase(pageSizeName.charAt(0))).append(pageSizeName.substring(1)).toString());
        //set方法
        CodeUtil.addSetMethod(baseDomainCode , "int" , pageSizeName , (new StringBuilder()).append(Character.toUpperCase(pageSizeName.charAt(0))).append(pageSizeName.substring(1)).toString());

        baseDomainCode.append(CodeUtil.getChangeLine(2));
        baseDomainCode.append("}");
        String path = domainPath + "/" + baseDomainName + ".java";
        FileUtil.writeFileByStr(baseDomainCode.toString() , path);
    }

}

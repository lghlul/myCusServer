package com.lu.utils;

import com.lu.code.domain.Columns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName CodeUtil
 * @Description 代码工具类
 * @Author ll
 * @Date 2018/9/26 11:03
 **/
public class  CodeUtil {



    public static Map<String , String> methodMap = new HashMap<>();


    /*
     * @author ll
     * @Description 添加 get 方法
     * @date 2018/9/28 18:26
     * @param [code, variableType, variableName, variableMethod]
     * @return void
     */
    public static void addGetMethod(StringBuffer code , String variableType , String variableName , String variableMethod){
        code.append(CodeUtil.getIndent(1) + "public " + variableType + " get" + variableMethod + "(){");
        code.append(CodeUtil.getChangeLine(1));
        code.append(CodeUtil.getIndent(2) + "return this." + variableName + ";");
        code.append(CodeUtil.getChangeLine(1));
        code.append(CodeUtil.getIndent(1) + "}");
        code.append(CodeUtil.getChangeLine(2));
    }

    /*
     * @author ll
     * @Description 添加 set方法
     * @date 2018/9/28 18:26
     * @param [code, variableType, variableName, variableMethod]
     * @return void
     */
    public static void addSetMethod(StringBuffer code , String variableType , String variableName , String variableMethod){
        code.append(CodeUtil.getIndent(1) + "public void set" + variableMethod + "(" + variableType + " " + variableName + "){");
        code.append(CodeUtil.getChangeLine(1));
        code.append(CodeUtil.getIndent(2) + "this." + variableName + " = " + variableName + ";");
        code.append(CodeUtil.getChangeLine(1));
        code.append(CodeUtil.getIndent(1) + "}");
        code.append(CodeUtil.getChangeLine(2));
    }

    /*
     * @author ll
     * @Description 获取层深缩进
     * @date 2018/9/26 11:06
     * @param [level]
     * @return java.lang.String
     */
    public static String getIndent(int level){
        StringBuffer indent = new StringBuffer();
        for(int i = 0 ; i < level ; i++){
            indent.append("    ");
        }
        return indent.toString();
    }

    /*
     * @author ll
     * @Description 获取换行符
     * @date 2018/9/26 14:49
     * @param [line]
     * @return java.lang.String
     */
    public static String getChangeLine(int line){
        StringBuffer indent = new StringBuffer();
        for(int i = 0 ; i < line ; i++){
            indent.append("\r\n");
        }
        return indent.toString();
    }


    /*
     * @author ll
     * @Description 表列处理  变量名称  类名称  java类型
     * @date 2018/9/26 14:36
     * @param [columnList]
     * @return void
     */
    public static void colimnConver(List<Columns> columnList){
        for(Columns columns : columnList) {
            String variableName = delSpecialMark(columns.getColumnName(), 2);
            columns.setVariableName(variableName);
            String variableType = MysqlTypeUtil.mysqlTypeMap.get((columns.getDataType()).toUpperCase());
            if(variableType == null){
                variableType = "String";
            }
            columns.setVariableType(variableType);
            String variableMethod = delSpecialMark(columns.getColumnName(), 1);
            columns.setVariableMethod(variableMethod);
        }
    }

    /*
     * @author ll
     * @Description 首字母转换
     * @date 2018/9/25 18:41
     * @param [s] type = 1 首字母大写 type = 2 首字母小写
     * @return java.lang.String
     */
    public static String toCaseFirstOne(String s , int type){
        if(s.length()  < 1){
            return s;
        }
        if(type == 1){
            if(Character.isUpperCase(s.charAt(0))){
                return s;
            }else{
                return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
            }
        }else{
            if(Character.isLowerCase(s.charAt(0))){
                return s;
            }else{
                return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
            }
        }

    }

    /*
     * @author ll
     * @Description 删除特殊符号
     * @date 2018/9/26 9:55
     * @param [s] type = 1 首字母大写 type = 2 首字母小写
     * @return java.lang.String
     */
    public static String delSpecialMark(String s , int type){
        String result = s;
        String [] specialMark = {"`" , "~" , "!" ,"@" ,"#" ,"%" ,"^" ,"&" ,"-","_","=",";",":","'","\"" ,"," ,"<" ,  ">" ,  "/"," " };
        for(String mark : specialMark){
            String[] marks = result.split(mark);
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0 ; i < marks.length ; i++){
                String m = marks[i];
                // 如果是变量名 首字母小写  其他特殊字符后的首字母大写
                if(i == 0){
                    stringBuffer.append(toCaseFirstOne(m , type));
                }else{
                    stringBuffer.append(toCaseFirstOne(m , 1));
                }

            }
            result = stringBuffer.toString().trim();
        }
        return result;
    }
}

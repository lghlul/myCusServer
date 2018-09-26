package com.lu.utils;

import com.lu.code.domain.Columns;

import java.util.List;

/**
 * @CLassName CodeUtil
 * @Description 代码工具类
 * @Author ll
 * @Date 2018/9/26 11:03
 **/
public class CodeUtil {

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
            columns.setVariableType(variableType);
            String variableMethod = delSpecialMark(columns.getColumnName(), 1);
            columns.setVariableMethod(variableMethod);
        }
    }

    /*
     * @author ll
     * @Description 首字母转换
     * @date 2018/9/25 18:41
     * @param [s]
     * @return java.lang.String
     */
    private static String toCaseFirstOne(String s , int type){
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
                return (new StringBuilder()).append(Character.isLowerCase(s.charAt(0))).append(s.substring(1)).toString();
            }
        }

    }

    /*
     * @author ll
     * @Description 删除特殊符号
     * @date 2018/9/26 9:55
     * @param [s] type = 1 类名   type = 2 属性名称
     * @return java.lang.String
     */
    public static String delSpecialMark(String s , int type){
        String result = s;
        String [] specialMark = {"`" , "~" , "!" ,"@" ,"#" ,"%" ,"^" ,"&" ,"-","_","=",";",":","'","\"" ,"," ,"<" ,  ">" ,  "/"};
        for(String mark : specialMark){
            String[] marks = result.split(mark);
            StringBuffer stringBuffer = new StringBuffer();
            for(String m : marks){
                stringBuffer.append(toCaseFirstOne(m , type));
            }
            result = stringBuffer.toString();
        }
        return result;
    }
}

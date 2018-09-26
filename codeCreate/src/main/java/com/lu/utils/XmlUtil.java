package com.lu.utils;

import com.lu.annotation.Attribute;
import com.lu.annotation.NameSpace;
import com.lu.annotation.NameSpaceUri;
import com.lu.tag.XmlAttr;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @CLassName XmlUtil
 * @Description xml文件工具类
 * @Author ll
 * @Date 2018/9/18 18:15
 **/
public class XmlUtil {


    /*
     * @author ll
     * @Description 根据对象创建xml字符串
     * @date 2018/9/18 18:16
     * @param [obj, elment]
     * @return void
     */
    public static void create(Object obj, Element elment) throws Exception{
        create( obj,  elment , null , null );
    }


    /*
     * @author ll
     * @Description 根据对象创建xml字符串
     * @date 2018/9/18 18:16
     * @param [obj, elment]
     * @return void
     */
    public static void create(Object obj, Element element,Map<String , String> attrMap,Map<String , String> spaceMap) throws Exception{
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if(spaceMap != null){
            for(String key : spaceMap.keySet()){
                element.addNamespace(key , spaceMap.get(key));
            }
        }

        if(attrMap != null){
            for(String key : attrMap.keySet()){
                element.addAttribute(key , attrMap.get(key));
            }
        }
        if(fields.length > 0){
            for (Field field : fields) {
                Element e = null;
                String name = field.getName();
                String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                name = name.replaceAll("1" , ".");
                name = name.replaceAll("2" , "");
                name = name.replaceAll("3" , ":");
                name = name.replaceAll("4" , "-");
                Method method = clazz.getMethod(methodName);
                Object o = method.invoke(obj);
                if(o != null){
                    if (o instanceof List) {
                        List l = (List) o;
                        for (int i = 0; i < l.size(); i++) {
                            if(l.get(i) instanceof XmlAttr){
                                XmlAttr attr = (XmlAttr) l.get(i);
                                element.addAttribute(attr.getKey() , attr.getValue());
                            }else{
                                e = element.addElement(name);
                                create(l.get(i), e);
                            }

                        }
                    }else if(!(o instanceof String)){
                        e = element.addElement(name);
                        create(o, e);
                    }else {
                        e = element.addElement(name);
                        e.addText(o.toString());
                    }

                }else{
                    element.addElement(name);
                }
            }
        }
    }

    /*
     * @author ll
     * @Description 格式化xml文件
     * @date 2018/9/18 18:15
     * @param [unformattedXml]
     * @return java.lang.String
     */
    public static String format(String unformattedXml) {
        try {
            final Document document = parseXmlFile(unformattedXml);
            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(4);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);
            return out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
     * @author ll
     * @Description
     * @date 2018/9/18 18:15
     * @param [in]
     * @return org.w3c.dom.Document
     */
    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
     * @author ll
     * @Description 写xml文件
     * @date 2018/9/26 16:45
     * @param [path, obj, rootName, name, publicId, systemId]
     * @return void
     */
    public static void writeXml(String path , Object obj , String rootName ,String name, String publicId, String systemId  ){
        NameSpace nameSpace = obj.getClass().getAnnotation(NameSpace.class);

        Attribute attribute = obj.getClass().getAnnotation(Attribute.class);

        NameSpaceUri nameSpaceUri = obj.getClass().getAnnotation(NameSpaceUri.class);

        Map<String , String > attrMap = new HashMap<>();
        if(attribute != null){
            String [] nameAttr = attribute.attrName();
            String [] valueAttr = attribute.attrValue();
            for(int i = 0 ; i < nameAttr.length ; i++){
                attrMap.put(nameAttr[i] , valueAttr[i]);
            }
        }

        Map<String , String > spaceMap = new HashMap<>();
        if(nameSpace != null){
            String [] spaceName = nameSpace.spaceName();
            String [] spaceValue = nameSpace.spaceValue();
            for(int i = 0 ; i < spaceValue.length ; i++){
                spaceMap.put(spaceName[i] , spaceValue[i]);
            }
        }
        org.dom4j.Document document = DocumentHelper.createDocument();
        if(name !=null || publicId != null || systemId != null){
            document.addDocType(name , publicId , systemId);
        }
        //设置编号为utf-8
        document.setXMLEncoding("utf-8");
        Element root = null;
        if(nameSpaceUri != null){
            root = document.addElement(rootName , nameSpaceUri.uriName());
        }else{
            root = document.addElement(rootName);
        }
        try {
            XmlUtil.create(obj, root,attrMap,spaceMap );
            StringWriter out = new StringWriter();
            XMLWriter xw = new XMLWriter(out);
            xw.write(document);
            xw.flush();
            out.flush();
            String xmlStr=out.toString();
            System.out.println(xmlStr);
            xmlStr = XmlUtil.format(xmlStr);
            //写入文件
            xmlStr = xmlStr.replaceAll("<nonTag>","");
            xmlStr = xmlStr.replaceAll("</nonTag>","");
            FileUtil.writeFileByStr(xmlStr , path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @author ll
     * @Description 写xml文件
     * @date 2018/9/21 16:28
     * @param [path, xmlStr, obj, attrMap, rootName]
     * @return void
     */
    public static void writeXml(String path , Object obj , String rootName   ){
        writeXml(path , obj , rootName , null , null , null );

    }

    /*
     * @author ll
     * @Description 给字段设置属性
     * @date 2018/9/26 16:40
     * @param [field, attrName, attrValue]
     * @return void
     */
    public static void setAttrByFiled(Field field , String [] attrName , String [] attrValue){
        try {
            Attribute attribute = field.getAnnotation(Attribute.class);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(attribute);
            Field value = invocationHandler.getClass().getDeclaredField("memberValues");
            value.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
            memberValues.put("attrName", attrName);
            memberValues.put("attrValue", attrValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * @author ll
     * @Description 给方法设置属性
     * @date 2018/9/26 16:40
     * @param [field, attrName, attrValue]
     * @return void
     */
    public static void setAttrByMethod(Object obj , String [] attrName , String [] attrValue){
        try {
            Attribute attribute = obj.getClass().getAnnotation(Attribute.class);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(attribute);
            Field value = invocationHandler.getClass().getDeclaredField("memberValues");
            value.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
            if(attrName != null){
                memberValues.put("attrName", attrName);
            }
            if(attrValue != null){
                memberValues.put("attrValue", attrValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

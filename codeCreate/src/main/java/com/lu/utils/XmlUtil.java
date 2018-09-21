package com.lu.utils;

import com.lu.project.domain.XmlAttr;
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
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @CLassName XmlUtil
 * @Description TODO
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
        create( obj,  elment , null , null);
    }


    /*
     * @author ll
     * @Description 根据对象创建xml字符串
     * @date 2018/9/18 18:16
     * @param [obj, elment]
     * @return void
     */
    public static void create(Object obj, Element element,Map<String , String> spaceMap,Map<String , String> attrMap) throws Exception{
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
                    e = element.addElement(name);
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
            format.setIndent(2);
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
            System.out.println(in);
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
     * @date 2018/9/21 16:28
     * @param [path, xmlStr, obj, attrMap, rootName]
     * @return void
     */
    public static void writeXml(String path , Object obj , Map<String , String> spaceMap , Map<String , String> attrMap , String rootName  ){
        org.dom4j.Document document = DocumentHelper.createDocument();
        //设置编号为utf-8
        document.setXMLEncoding("utf-8");
        Element root = document.addElement(rootName , PropertiesUtil.NAMESPACEURL);
        try {
            XmlUtil.create(obj, root,spaceMap ,attrMap );
            StringWriter out = new StringWriter();
            XMLWriter xw = new XMLWriter(out);
            xw.write(document);
            xw.flush();
            out.flush();
            String xmlStr=out.toString();
            xmlStr = XmlUtil.format(xmlStr);
            //写入文件
            FileWriter writer = new FileWriter(path);
            writer.write(xmlStr);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

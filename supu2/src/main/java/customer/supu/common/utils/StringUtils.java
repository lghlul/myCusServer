package customer.supu.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringEscapeUtils;
/*import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.springframework.web.multipart.MultipartFile;

/**
 * 字符串处理
 *
 * @author
 */
public abstract class StringUtils {

    /**
     * 默认分隔符
     */
    private static final String defaultDelimiter = ",";

    /**
     * 分割字符串
     *
     * @param str 输入字符串
     * @param delimiters 分隔符
     * @return
     */
    public static String[] split(final String str, final String delimiters) {
        return org.apache.commons.lang.StringUtils.split(str, delimiters);
    }

    /**
     * 分割字符串(采用默认分隔符 , )
     *
     * @param str 输入字符串
     * @return
     */
    public static String[] split(final String str) {
        return split(str, defaultDelimiter);
    }

    /**
     * 集合类连接
     *
     * @param c 集合
     * @param delim 连接符
     * @return
     */
    public static String join(final Collection<?> c, final String delim) {
        return org.apache.commons.lang.StringUtils.join(c.iterator(), delim);
    }

    /**
     * 集合类连接（采用默认连接符 ,）
     *
     * @param c 集合
     * @return
     */
    public static String join(final Collection<?> c) {
        return join(c, defaultDelimiter);
    }

    /**
     * 数组连接
     *
     * @param arr 数组
     * @param delim 连接符
     * @return
     */
    public static String join(final Object[] arr, final String delim) {
        return org.apache.commons.lang.StringUtils.join(arr, delim);
    }

    /**
     * 数组连接（采用默认连接符 ,）
     *
     * @param arr 数组
     * @return
     */
    public static String join(final Object[] arr) {
        return join(arr, defaultDelimiter);
    }

    /**
     * 字符串替换
     *
     * @param inString 输入字符串
     * @param oldPattern 替换字符
     * @param newPattern 输出字符
     * @return
     */
    public static String replace(final String inString, final String oldPattern, final String newPattern) {
        return org.apache.commons.lang.StringUtils.replace(inString, oldPattern, newPattern);
    }

    /**
     * 输入参数是否为空
     *
     * @param string 输入字符串
     * @return 输入： null|"" 返回 false 否则 true
     */
    public static boolean hasText(final String string) {
        return org.apache.commons.lang.StringUtils.isNotBlank(string);
    }

    /**
     * @param str
     * @return
     */
    public static boolean isEmpty(final String str) {
        // return org.apache.commons.lang.StringUtils.isEmpty(str);
        return !hasText(str);
    }

    /**
     * @param str
     * @return
     */
    public static boolean isEmptyT(final String str) {
        return ("".equals(str) || "null".equals(str) || null == str || "none".equals(str));
    }

    /**
     * 输入参数是否为空
     *
     * @param object 输入参数
     * @return
     */
    public static boolean hasTextObject(final Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof String) {
            return hasText((String) object);
        }
        return true;
    }

    /**
     * 返回输入字符中首个不为空的字符
     *
     * @param strings 字符数组
     * @return
     */
    public static String text(final String... strings) {
        if (strings != null) {
            for (final String string : strings) {
                if (hasText(string)) {
                    return string;
                }
            }
        }
        return "";
    }

    /**
     * 判断n是否大于0
     *
     * @param n
     * @param m
     * @return
     */
    public static int blank(final int n, final int m) {
        return n > 0 ? n : m;
    }

/*    *//**
     * 获取文件名称
     *
     * @param path 文件路径
     * @return
     *//*
    public static String getFilename(final String path) {
        return FilenameUtils.getName(path);
    }
*/
 /*   *//**
     * 获取文件扩展名
     *
     * @param path 文件路径
     * @return
     *//*
    public static String getFilenameExtension(final String path) {
        return FilenameUtils.getExtension(path);
    }
*/
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};

    // static{DateTimeUtil.getCompactTime();}
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 转换字节数组为16进制字符串
     *
     * @param b 字节数组
     * @return 16进制字符串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * MD5加密一个字符串
     *
     * @param origin 原始字符串
     * @return 加密后字符串
     */
    public static String MD5Encode(String origin) {
        String resultString = "";
        resultString = new String(origin);
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
        try {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
        }
        catch (UnsupportedEncodingException e) {
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        }
        return resultString;
    }

    /**
     * String转化Int
     *
     * @param str
     * @return str为空或不为数字 返回-1
     */
    public static int parseInt(String str) {
        if (str == null || str.trim().length() == 0) {
            return -1;
        }
        try {
            Integer.parseInt(str.trim());
        }
        catch (Exception e) {
            return -1;
        }
        return Integer.parseInt(str.trim());
    }

    public static int parseInt(String num, int def) {
        if (num == null || num.trim().length() == 0) {
            return def;
        }
        try {
            Integer.parseInt(num.trim());
        }
        catch (Exception e) {
            return def;
        }
        return Integer.parseInt(num.trim());
    }

 /*   public static boolean matches(String content, String regex) {
        boolean flag = false;
        try {
            flag = new Perl5Matcher().contains(content, new Perl5Compiler().compile(regex));
        }
        catch (MalformedPatternException e) {
            e.printStackTrace();
        }
        return flag;
    }*/

    public static String arrayToString(String[] strArray) {
        StringBuffer buffer = new StringBuffer();
        if (strArray != null && strArray.length > 0) {
            for (String s : strArray) {
                buffer.append(s).append(",");
            }
        }
        return buffer.toString();
    }

    public static String getWSUrl(String Ip, int Port) {
        return "http://" + String.valueOf(Ip) + ":" + String.valueOf(Port);
    }

    // **************Html相关 开始********************//

    /**
     * 转化Html编码
     *
     * @param strTHML
     * @return
     */
    public static String HTMLEscape(String strTHML) {
        return StringEscapeUtils.escapeHtml(strTHML);
    }

    /**
     * 转化Html解码
     *
     * @param strTHML
     * @return
     */
    public static String HTMLUNEscape(String strTHML) {
        return StringEscapeUtils.unescapeHtml(strTHML);
    }

    /**
     * 转化xml编码
     *
     * @param xml
     * @return
     */
    public static String xmlEscape(String xml) {
        return StringEscapeUtils.escapeXml(xml);
    }

    /**
     * 转化xml解码
     */
    public static String xmlUNEscape(String xml) {
        return StringEscapeUtils.unescapeXml(xml);
    }

    /**
     * 删除input中html格式
     *
     * @param input
     * @return
     */
    public static String removeHtml(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // 去掉所有html元素,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        return str;
    }

    /**
     * 删除特殊字符
     *
     * @param value
     * @return
     */
    public static String removeSign(String value) {
        value = value.replaceAll("'", "");
        value = value.replaceAll("%", "");
        value = value.replaceAll("[*]", "");
        value = value.replaceAll("[.]", "");
        value = value.replaceAll("=", "");
        value = trimAll(value);
        return value;

    }

    /**
     * 删除input中span和div标记
     *
     * @param input
     * @return
     */
    public static String removeStyle(String input) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        String str =
                input.replaceAll("<\\s{0,}((span)|(div)|(SPAN)|(DIV)|(/DIV)|(/SPAN)|(/div)|(/span))\\s{0,}[^>]*>", "");
        return str;
    }

    // **************Html相关 结束********************//

    /**
     * javascript 解析处理成字符串
     *
     * @param js
     * @return
     */
    public static String javascriptEscape(String js) {
        return org.apache.commons.lang.StringEscapeUtils.escapeJavaScript(js);
    }

    /**
     * javascript 处理
     *
     * @param js
     * @return
     */
    public static String javascriptUNEscape(String js) {
        return org.apache.commons.lang.StringEscapeUtils.unescapeJavaScript(js);
    }

    public static String trimToEmpty(String str) {
        return StringUtils.trimToEmpty(str);
    }

    public static String trim(String str) {
        return org.apache.commons.lang.StringUtils.trim(str);
    }

    public static String trimAll(String str) {
        return str.replaceAll(" ", "");
    }

    public static String enCode(String str) {
        if (str == null) {
            return "";
        }
        String hs = "";
        try {
            byte b[] = str.getBytes("UTF-16");
            for (int n = 0; n < b.length; n++) {
                str = (java.lang.Integer.toHexString(b[n] & 0XFF));
                if (str.length() == 1) {
                    hs = hs + "0" + str;
                }
                else {
                    hs = hs + str;
                }
                if (n < b.length - 1) {
                    hs = hs + "";
                }
            }
            // 去除第一个标记字符
            str = hs.toUpperCase().substring(4);
            // System.out.println(str);
            char[] chs = str.toCharArray();
            str = "";
            for (int i = 0; i < chs.length; i = i + 4) {
                str += "&#x" + chs[i] + chs[i + 1] + chs[i + 2] + chs[i + 3] + ";";
            }
            return str;
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return str;
    }

    /**
     * @param str 给定的字符
     * @param searchChar 搜索字符
     * @return
     */
    public static int firstIndexOf(String str, String searchChar) {
        return org.apache.commons.lang.StringUtils.indexOf(str, searchChar);
    }

    /**
     * @param str 给定的字符
     * @param searchChar 搜索字符
     * @return
     */
    public static int lastIndexOf(String str, String searchChar) {
        return org.apache.commons.lang.StringUtils.lastIndexOf(str, searchChar);
    }

    /**
     * 截取字符串
     *
     * @param str 输入字符串
     * @param separator 分割符号
     * @return
     */
    public static String subStringAfter(String str, String separator) {

        return org.apache.commons.lang.StringUtils.substringAfter(str, separator);
    }

    /**
     * 截取字符串
     *
     * @param str 输入字符串
     * @param start 起始索引
     * @return
     */
    public static String subString(String str, int start) {
        return org.apache.commons.lang.StringUtils.substring(str, start);

    }

    /**
     * 截取字符串
     *
     * @param srcStr 输入字符串
     * @param start 截取起点
     * @param end 结束索引
     * @return
     */
    public static String subString(String srcStr, int start, int end) {
        return org.apache.commons.lang.StringUtils.substring(srcStr, start, end);

    }

    /**
     * 连接字符串
     *
     * @param str1 输入串1
     * @param str2 输入串2
     * @param flag 是否删除公共部分
     * @return
     */
    public static String contractString(String str1, String str2, boolean flag, String dot) {
        if (isEmpty(str1) || isEmpty(str2)) {
            return isEmpty(str1) ? (isEmpty(str2) ? "" : str2) : str1;
        }
        int i = 0;
        for (i = str2.length(); i > 0; i--) {
            if (str1.length() - str1.indexOf(str2.substring(0, i)) <= str1.length()) {
                break;
            }
        }
        // System.out.println("   ======="+str2.substring(0,i));
        StringBuffer sb = new StringBuffer(str1);
        // sb.delete(i,sb.length());
        if (!flag) {
            sb.append(isEmpty(dot) ? "" : dot).append(str2.substring(i));

        }
        else {
            sb.append(isEmpty(dot) ? "" : dot).append(str2.substring(i));
        }
        return sb.toString();
    }

    /**
     * 路径处理方法
     *
     * @param path 编码任意,格式任意
     * @param prefixed 是否前缀目录符号(false 前没有 "/" )
     * @param suffixed 是否后缀目录符号 (不是目录最后不存在 "/")
     * @return 返回 路径格式 [/]XXX/YYY/zz[/] UTF-8编码
     */
    public static String triggerPath(String path, boolean prefixed, boolean suffixed) {
        if (isEmpty(path) || "/".equals(path)) {
            return (prefixed || suffixed) ? "/" : "";
        }
        StringBuffer sb = new StringBuffer(path.replaceAll("\\\\", "/"));
        if (suffixed) {
            sb.append("/");
        }
        // /System.out.println("=================> "+sb.toString());
        for (int i = 0; i < sb.length() - 1;) {
            if ((sb.charAt(i) & '/' & sb.charAt(i) ^ sb.charAt(i + 1)) == 0) {
                sb.deleteCharAt(i);
            }
            else {
                i++;
            }
        }
        if ((sb.charAt(sb.length() - 1) ^ '/') == 0) {
            if (!suffixed) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        else {
            if (suffixed) {
                sb.insert(0, "/");
            }
        }
        if (sb.length() <= 0) {
            return prefixed ? "/" : sb.toString();
        }

        if ((sb.charAt(0) ^ '/') == 0) {
            if (!prefixed) {
                sb.deleteCharAt(0);
            }
        }
        else {
            if (prefixed) {
                sb.insert(0, "/");
            }
        }
        return sb.toString();
    }

    /**
     * 判断给定的值是否代表真
     *
     * @param value true|1|真|是|y
     * @return
     */
    public static boolean isTrue(String value) {
        return "true".equalsIgnoreCase(value) || "1".equals(value) || "真".equals(value) || "是".equals(value)
                || "y".equalsIgnoreCase(value);
    }

    /**
     * 系统目标编码
     */
    public static String Encoding = "utf-8";

    /**
     * 容器编码
     */
    public static String ContainerEncoding = "ISO-8859-1";

    /**
     * 将指定的字符串转换为目标编码的字节数组
     *
     * @param source 待转换的字符串
     * @param coding 目标编码
     * @return 转换后的字节数组
     */
    public static byte[] enCodingString(String source, String coding) {
        try {
            return source.getBytes(coding);
        }
        catch (Exception e) {
        }
        return source.getBytes();
    }

    /**
     * 从ISO-8859-1到GBK编码
     *
     * @param value
     * @return
     */
    public static String chgGBK(String value) {
        if (value == null || value.equals("")) {
            return "";
        }
        else {
            try {
                return new String(value.getBytes("ISO-8859-1"), "GBK");
            }
            catch (Exception e) {
            }
            return null;
        }
    }

    /**
     * 从容器编码到系统目标编码
     *
     * @param value 待编码的值
     * @return
     */
    public static String enCoding(String value) {
        try {
            return codeTran(value, ContainerEncoding, Encoding);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 从系统目标编码到容器编码格式
     *
     * @param value 待解码的值
     * @return
     */
    public static String deCoding(String value) {
        try {
            return codeTran(value, Encoding, ContainerEncoding);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 将字符串从源编码格式转换到目标编码格式
     *
     * @param value 待转换的字符串
     * @param sourceCode 源编码
     * @param targetCode 目标编码
     * @return 转换后的字符串
     * @throws UnsupportedEncodingException
     */
    public static String codeTran(String value, String sourceCode, String targetCode)
            throws UnsupportedEncodingException {
        if (sourceCode.equalsIgnoreCase(targetCode)) {
            return value;
        }
        else if (value == null || value.equals("")) {
            return value;
        }
        else {
            return new String(value.getBytes(sourceCode), targetCode);
        }
    }

    public static String URLEncoding(String value) {
        try {
            return URLEncoder.encode(value, Encoding);
        }
        catch (Exception e) {
        }
        return value;
    }

    public static String URLDecoding(String value) {
        try {
            return URLDecoder.decode(value, Encoding);
        }
        catch (Exception e) {

        }
        return value;
    }

    /**
     * 将NULL转化为空字符串
     *
     * @param strTarget 转化目标
     * @return 转化结果
     */
    public static String makeNullToEmptyString(String strTarget) {
        if (strTarget == null) {
            strTarget = "";
        }
        return strTarget;
    }

    /**
     * string转换html串
     *
     * @param text
     * @return
     */
    public static String escape(Object text) {
        return escapeHtml(text);
    }

    public static String escapeHtml(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            String result = value.toString();
            result = result.replaceAll("&amp;", "&");
            result = result.replaceAll("&gt;", ">");
            result = result.replaceAll("&lt;", "<");
            result = result.replaceAll("&quot;", "\"");
            return result;
        }
        else {
            return value.toString();
        }
    }

    /**
     * 将params转换成map,params和形式为name1=value1&name2=value2...nameN=valueN
     *
     * @param text
     * @return
     */
    public static Map<String, String> convertParams(String params) {
        if (StringUtils.isEmpty(params)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        if (params.indexOf("&") != -1) {
            for (String string : params.split("&")) {
                if (string.indexOf("=") != -1) {
                    String[] key_value = string.split("=");
                    String key = key_value[0];
                    String value = key_value[1];
                    map.put(key, value);
                }
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    /**
     * 将参数中的html标签取消
     *
     * @param value
     * @return
     */
    public static String eraseHtml(String value) {
        // 替换所有html标签为空字符串
        while (value.indexOf("<") != -1 && value.indexOf(">") != -1) {
            value = value.replace(value.substring(value.indexOf("<"), value.indexOf(">") + 1), "");
        }
        while (value.indexOf("&lt;") != -1 && value.indexOf("&gt;") != -1) {
            value = value.replace(value.substring(value.indexOf("&lt;"), value.indexOf("&gt;") + 4), "");
        }
        // 替换所有空格为空字符串
        Pattern pattern = Pattern.compile("\\s|&nbsp;");
        Matcher matcher = pattern.matcher(value);
        value = matcher.replaceAll("");
        return value;
    }
/*
    *//**
     * 将excel表数据转换成String数组list
     *
     * @param file 上传excel文件
     * @param cloumn 列数
     * @return
     * @throws IOException
     *//*
    public static List<String[]> convertExcelSheet(MultipartFile file, int cloumn) throws IOException {
        List<String[]> list = new ArrayList<String[]>();
        Workbook workbook = null;
        InputStream is = file.getInputStream();
        try {
            workbook = new HSSFWorkbook(is);
        }
        catch (Exception ex) {
            workbook = new XSSFWorkbook(is);
        }
        try {
            if (workbook != null) {
                Sheet sheet = workbook.getSheetAt(0);
                Row row;
                String[] cells;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    if (row != null) {
                        cells = new String[cloumn];
                        for (int j = 0; j < cloumn; j++) {
                            if (row.getCell(j) != null && row.getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
                                cells[j] =
                                        org.apache.commons.lang.StringUtils.trimToEmpty(row.getCell(j)
                                                .getStringCellValue());
                            }
                            else if (row.getCell(j) != null && row.getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                                cells[j] = String.valueOf(row.getCell(j).getNumericCellValue());
                                if (HSSFDateUtil.isCellDateFormatted(row.getCell(j))) {
                                    // 如果是date类型则 ，获取该cell的date值
                                    Date date = new Date();
                                    date = HSSFDateUtil.getJavaDate(row.getCell(j).getNumericCellValue());
                                    SimpleDateFormat SDF = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
                                    cells[j] = SDF.format(date);
                                }
                                else {// 纯数字
                                    row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                                    cells[j] = row.getCell(j).getRichStringCellValue().toString();
                                }
                            }
                        }
                        list.add(cells);
                    }
                }
            }
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }*/

    // MD5(yyyy+'VJMIS'+mm+'VJMIS'+dd+MD5(username))
    public static String getEncodeCodename(String codename) {
        if (isEmpty(codename)) {
            return "";
        }
        String year = DateTimeUtil.getYear();
        String month = DateTimeUtil.getMonth();
        String day = DateTimeUtil.getDay();
        String pass = year + "VJMIS" + month + "VJMIS" + day + md5result(codename);
        return md5result(pass);
    }

    public static String md5result(String input) {
        return StringUtils.MD5Encode(input);
    }

/*    public static String getOdmName(String name) {
        String rn = name;
        if (rn.indexOf("年级") != -1) {
            rn = name.replace("年级", MessageUtil.getMessage("default_grade", ""));
        }
        else if (name.indexOf("学科") != -1) {
            rn = name.replace("学科", MessageUtil.getMessage("default_subject", ""));
        }
        else if (name.indexOf("标签") != -1) {
            rn = name.replace("标签", MessageUtil.getMessage("default_tag", ""));
        }
        else if (name.indexOf("专辑") != -1) {
            rn = name.replace("专辑", MessageUtil.getMessage("default_album", ""));
        }
        return rn;
    }*/

    /**
     * 获取所有图片的src
     *
     * @param imghtml
     * @return
     */
    public static List<String> getImgSrc(String imghtml) {
        List<String> lst = new ArrayList<String>();
        while (imghtml.indexOf("<img src=") != -1) {
            String url = "";
            imghtml = imghtml.substring(imghtml.indexOf("<img src=") + 10, imghtml.length());
            if (imghtml.indexOf("\"") != -1) {
                url = imghtml.substring(0, imghtml.indexOf("\""));
                lst.add(url);
            }
        }
        return lst;
    }

    /**
     * String 数组去除重复数据
     *
     * @param strings
     * @return
     */
    public static String[] deduplication(String[] strings) {
        List<String> list2 = Arrays.asList(strings);
        Set<String> set = new HashSet<String>(list2);
        return (String[]) set.toArray(new String[0]);
    }

    /**
     * 获取随机字符串
     *
     * @param length 生产的字符串长度
     * @param base 基础字符串，为null或"" 时默认是大小写字母加数字
     * @return
     */
    public static String getRandomString(int length, String base) { // length表示生成字符串的长度
        if (!StringUtils.hasText(base)) {
            base = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机数字
     *
     * @param length 生产的字符串长度
     * @param base 基础字符串，为null或"" 时默认是大小写字母加数字
     * @return
     */
    public static String getRandomNum(int length) { // length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

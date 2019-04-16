package customer.supu.common.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {

	private static final Logger log = LoggerFactory.getLogger(Utility.class);

	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

	// 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后2位，以后的数字四舍五入
	private static final int DEF_DIV_SCALE = 2;

	/**
	 *
	 * @param sqlList
	 *            批量SQL
	 * @param count
	 *            每多少条执行一次
	 * @param isAutoCommit
	 *            是否需要起事物
	 * @param conn
	 *            数据库连接
	 * @return
	 */

	public static boolean exeBatch(ArrayList sqlList, int count,
			boolean isAutoCommit, Connection conn) {
		boolean bool = true;
		Statement stmt = null;
		try {
			if (isAutoCommit)
				conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int sqlcount = 0;
			for (int i = 0; i < sqlList.size(); i++) {

				String sql = Utility.chgNull(sqlList.get(i));
				if (!"".equals(sql)) {

					stmt.addBatch(sql);
					sqlcount++;
					if (i != 0 && i % count == 0) {
						stmt.executeBatch();
						stmt.clearBatch();
						sqlcount = 0;
						if (isAutoCommit)
							conn.commit();
					}

				}

			}
			if (sqlcount > 0) {
				stmt.executeBatch();
				stmt.clearBatch();
				if (isAutoCommit) {
					conn.commit();
				}
			}

		} catch (Exception e) {
			bool = false;
			try {
				// 回滚事物
				if (isAutoCommit)
					conn.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			log.info(e.toString());

		} finally {
			sqlList.clear();
			try {
				if (isAutoCommit)
					conn.setAutoCommit(true);
				if (stmt != null)
					stmt.close();
			} catch (Exception e_stmt) {
			}
		}

		return bool;
	}

	// SQL执行
	public static List exeSqlRetrunList(String sql, Connection conn) {

		List list = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {

				HashMap hashMap = new HashMap(); // 存贮每一行的值
				for (int i = 0; i < rsmd.getColumnCount(); i++) {

					String colName = Utility
							.chgNull(rsmd.getColumnLabel(i + 1)); // 列名
					colName = colName.toLowerCase();
					String colValue = Utility.chgNull(rs.getString(i + 1));// 列值
					hashMap.put(colName, colValue);
				}

				list.add(hashMap);// 将每一行的值放进List中
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e_rs) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e_stmt) {
			}
		}

		return list;
	}

	/**
	 * 类的方法定义: chgNull(); 方法的说明: 将 String 对象转换 如果对象为Null转换为""字符串
	 *
	 * @param source
	 *            被处理的字符串
	 * @return 处理后的字符串
	 */
	public static String chgNull(Object source) {
		String result = "";
		if (source != null)
			result = source.toString();
		return result;
	}

	public static String chgNull(String source) {
		String result = "";
		if (source != null)
			result = source.toString().trim();
		return result;
	}

	/**
	 * 类的方法定义: chgZero(); 方法的说明: 将 String 对象转换 如果对象为Null转换为"0"字符串,用于数字
	 *
	 * @param source
	 *            被处理的字符串
	 * @return 处理后的字符串
	 */
	public static String chgZero(Object source) {
		String result = "0";
		if (chgNull(source).length() > 0)
			result = source.toString();
		return result;
	}

	/**
	 * 类的方法定义: chgZero(); 方法的说明: 将 String 对象转换 如果对象为Null转换为"0"字符串,用于数字
	 *
	 * @param source
	 *            被处理的字符串
	 * @return 处理后的字符串
	 */
	public static String chgZero(String str) {
		str = toEmptyString(str);
		return (str.equals("")) ? "0" : str;
	}

	public static String toEmptyString(String source) {
		return (source == null || source.equalsIgnoreCase("null")) ? ""
				: source.trim();
	}

	/**
	 * 根据sql去执行相应的update语句
	 */
	public static boolean updateDataBySql(String sql, Connection conn) {
		boolean result = false;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			if (stmt.executeUpdate(sql) >= 0) {
				result = true;
				// SQL写入日志表
			}
		} catch (SQLException e) {
			log.info("SQL 语句错误" + sql);
			result = false;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				log.error("", e);
			}
		}
		return result;
	}

	public static String getResultOfSQL(Connection conn, String sql) {
		Statement stmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			rs = conn.createStatement().executeQuery(sql);
			if (rs.next())
				result = (rs.getString(1));
		} catch (Exception ex) {
			log.error("报错SQL ====" + sql);
			log.error("", ex);
		} finally {
			SQLCloseResultset(rs);
			SQLCloseStatment(stmt);
		}
		return result;
	}

	/**
	 * 安全关闭记录集
	 *
	 * @param rs
	 *            记录集
	 */
	public static void SQLCloseResultset(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception ex) {
			log.error("", ex);
		}

	}

	/**
	 * 安全关闭Statement对象
	 *
	 * @param stat
	 *            Statement对象
	 */
	public static void SQLCloseStatment(Statement stat) {
		try {
			if (stat != null)
				stat.close();
		} catch (Exception ex) {
			log.error("", ex);
		}
	}

	/**
	 * 获取全url路径,如:http://hostname.com:80/mywebapp/servlet/MyServlet/a/b;c=123?d=
	 * 789 取得每个业务的唯一标识主键值
	 *
	 * @return
	 */
	public static String getReturnObjname(String sql, String colname,
			Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		// String sql = " SELECT " + bizname + " " + " FROM " + tablename + " "
		// + " WHERE " + bizid + "=" + bizvalue;
		String name = "";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				name = rs.getString(colname);
			}
		} catch (SQLException e) {
			log.error("", e);
		} finally {
			SQLCloseResultset(rs);
			SQLCloseStatment(stmt);
		}
		return name;
	}

	public static void stopUserSession(String userTokenName, HttpSession session) {
		session.removeAttribute("Listener"); // 删除session监听器
		session.removeAttribute(userTokenName); // 删除UserToken
		session.invalidate(); // 撤销当前会话
	}

	public static void copyProperties(Object oFrom, Object oTo) {
		// 获得对象的所有属性
		Field fields[] = oFrom.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();

			// 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			// 获得和属性对应的setXXX()方法的名字
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			// 获得和属性对应被拷贝类（User）里面的getXXX()方法
			try {
				Method getMethod = oFrom.getClass().getMethod(getMethodName,
						new Class[] {});

				/**
				 * 如果拷贝到的类里面没有被拷贝类的属性就跳过这个属性拷贝
				 */
				// 获得和属性对应拷贝到的类（UserInfo ）里面的setXXX()方法，使用filed对象的类型
				Method setMethod = oTo.getClass().getMethod(setMethodName,
						new Class[] { field.getType() });
				// 调用原对象的getXXX()方法：指定调用的对象和方法的参数值列表
				Object value = getMethod.invoke(oFrom, new Object[] {});
				// System.out.println(fieldName + ":" + value);
				// 调用拷贝对象的setXXX()方法：指定调用的对象和参数值列表(注意必须是Object类型)
				setMethod.invoke(oTo, new Object[] { value });
			} catch (NoSuchMethodException noe) {
				log.warn("缺少方法：" + noe.getMessage());
				continue;
			} catch (Exception e) {
				continue;
			}
		}
	}

	/**
	 * 取得对象中所有属性和值
	 *
	 * @param obj
	 * @return HashMap<filedName,fileValue>
	 */
	public static HashMap getObjectHashMap(Object obj) {

		HashMap hashMap = new HashMap();

		// 获得对象的所有属性
		Field fields[] = obj.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {

			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();

			// 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			try {
				// 获取方法对象
				Method getMethod = obj.getClass().getMethod(getMethodName,
						new Class[] {});
				// 获取方法对应的值
				Object value = getMethod.invoke(obj, new Object[] {});
				// 设定值
				hashMap.put(fieldName, Utility.chgNull(value));

			} catch (NoSuchMethodException noe) {
				log.warn("缺少方法：" + noe.getMessage());
				continue;
			} catch (Exception e) {
				continue;
			}

		}

		return hashMap;
	}

	public static void objectLogInfo(Object o) {
		HashMap hashMap = getObjectHashMap(o);
		Iterator iter = hashMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			log.info(Utility.chgNull(key) + ":" + Utility.chgNull(val));
		}
	}

	// SQL执行 ArrayList<ArrayList>
	public static List exeSqlRetrunArrayList(String sql, Connection conn) {

		List list = new ArrayList();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {

				List colList = new ArrayList(); // 存贮每一行的值
				for (int i = 0; i < rsmd.getColumnCount(); i++) {

					// String colName = Utility
					// .chgNull(rsmd.getColumnLabel(i + 1)); // 列名
					// colName = colName.toLowerCase();
					String colValue = Utility.chgNull(rs.getString(i + 1));// 列值
					colList.add(colValue);
					// hashMap.put(colName, colValue);
				}

				list.add(colList);// 将每一行的值放进List中
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e_rs) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e_stmt) {
			}
		}

		return list;
	}

	public static String delHTMLTag(String htmlStr) {
		if (htmlStr == null) {
			return "";
		}
		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}

	// 去除科学计数法
	public static String scientificNotation(String str) {

		BigDecimal bd = new BigDecimal(str);
		return bd.toString();

	}

	/**
	 * 提供精确的加法运算。
	 *
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 *
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 *
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 *
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 *
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 *
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 取得对象中所有属性和值
	 *
	 * @param obj
	 *            对象
	 * @param attr
	 *            对象属性
	 * @return String
	 */
	public static String getObjectMathValue(Object obj, String attr) {

		String value = "";
		String firstLetter = attr.substring(0, 1).toUpperCase();

		// 获得和属性对应的getXXX()方法的名字
		String getMethodName = "get" + firstLetter + attr.substring(1);
		try {
			// 获取方法对象
			Method getMethod = obj.getClass().getMethod(getMethodName,
					new Class[] {});
			// 获取方法对应的值
			Object valueObj = getMethod.invoke(obj, new Object[] {});
			// 设定值
			value = Utility.chgNull(valueObj);

		} catch (NoSuchMethodException noe) {
			log.error("缺少方法：" + noe.getMessage());
			value = "";
		} catch (Exception e) {
			value = "";
		}

		return value;
	}

	/**
	 * 设置对象中所有属性和值
	 *
	 * @param obj
	 *            对象
	 * @param attr
	 *            对象属性
	 * @return String
	 */
	public static void setObjectMathValue(Object obj, String attr, Object value) {

		String firstLetter = attr.substring(0, 1).toUpperCase();
		// 获得和属性对应的setXXX()方法的名字
		String setMethodName = "set" + firstLetter + attr.substring(1);
		try {

			// 获得和属性对应拷贝到的类（UserInfo ）里面的setXXX()方法，使用filed对象的类型
			Method setMethod = obj.getClass().getMethod(setMethodName,
					new Class[] { String.class });
			// 调用拷贝对象的setXXX()方法：指定调用的对象和参数值列表(注意必须是Object类型)
			setMethod.invoke(obj, new Object[] { value });
		} catch (NoSuchMethodException noe) {
			log.error("缺少方法：" + noe.getMessage());
		} catch (Exception e) {
		}
	}

	/**
	 * springmvc 参数乱码
	 */
	public static String setParamterEncode(String str){
		try{
			str = new String(str.getBytes("ISO-8859-1"),"utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 用户密码加密（可以扩展）
	 * @param password
	 * @return
	 */
	public static String getMd5Password(String password){
		return new MD5Util().calcMD5(password);
	}

	/**
     * 获取当前网络ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ipAddress = request.getHeader("x-forwarded-for");
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                    //根据网卡取本机配置的IP
                    InetAddress inet=null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress= inet.getHostAddress();
                }
            }
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
                if(ipAddress.indexOf(",")>0){
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
                }
            }
            return ipAddress;
    }

    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

	public static void main(String args[]) {

		System.out.println(Utility.getMd5Password("888888"));
	}

}

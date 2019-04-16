package customer.supu.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ComUtil {

	protected final static Log logger = LogFactory.getLog(ComUtil.class);

	private static long orderNum = 0l;
	private static String date;
	private static Map<String, String> RANDOM_NUMBER_MAP = new HashMap<String, String>();
	private static long RANDOM_NUMBER_TIME = System.currentTimeMillis();
	private static int RANDOMNUMBER = 9;

	/**
	 * 拼接路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
	}

	/**
	 * 獲取userId-session
	 * 
	 * @return
	 */
	public static String getSession(HttpServletRequest request, String key) {
		String str = "0";

		if (request.getSession().getAttribute(key) != null) {
			str = request.getSession().getAttribute(key) + "";
		}

		return str;
	}

	/**
	 * 獲取object-session
	 * 
	 * @return
	 */
	public static Object getSessionObj(HttpServletRequest request, String key) {

		Object obj = null;

		if (request.getSession().getAttribute(key) != null) {
			obj = request.getSession().getAttribute(key);
		}

		return obj;
	}

	/**
	 * 清空-session
	 * 
	 * @return
	 */
	public static void removeSession(HttpServletRequest request, String key) {
		if (request.getSession().getAttribute(key) != null) {
			request.getSession().removeAttribute(key);
		}
	}

	/**
	 * 獲取userId-request
	 * 
	 * @return
	 */
	public static String getRequest(HttpServletRequest request, String key) {
		String str = "0";

		if (request.getParameter(key) != null) {
			str = request.getParameter(key) + "";
		}

		return str;
	}

	public static Object getRequestObj(HttpServletRequest request, String key) {
		Object obj = null;

		if (request.getParameter(key) != null) {
			obj = request.getParameter(key);
		}

		return obj;

	}

	public static void setSession(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);

	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {

		String retStr = "";

		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXYZ";

		int len = strTable.length();

		boolean bDone = true;

		do {

			retStr = "";

			int count = 0;

			for (int i = 0; i < length; i++) {

				double dblR = Math.random() * len;

				int intR = (int) Math.floor(dblR);

				char c = strTable.charAt(intR);

				if (('0' <= c) && (c <= '9')) {

					count++;

				}

				retStr += strTable.charAt(intR);

			}

			if (count >= 2) {

				bDone = false;

			}

		} while (bDone);

		return retStr;
	}

	/**
	 * 获取客户端的ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}

	/**
	 * 转换时间戳
	 * 
	 * @param dataStr
	 *            时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss 为null时，获取当前时间戳
	 * @throws ParseException
	 */
	public static long getTimestamp(String dataStr) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (null == dataStr) {
			Date date = new Date();
			dataStr = format.format(date);
		}
		Date da = null;
		try {
			da = format.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da.getTime();
	}

	public static String getChannelCode(String str) {
		String channelCode = str.substring(0, 6);
		return channelCode;
	}

	public static String getOrderNo() {
		String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());

		if (date == null || !date.equals(str)) {
			date = str;
			orderNum = 0l;
		}
		orderNum++;

		long orderNo = Long.parseLong((date)) * 10000;
		orderNo += orderNum;
		;

		return orderNo + "";

	}

	/**
	 * 获取区间随机数
	 * 
	 * @param min
	 *            随机数的起始值
	 * @param max
	 *            随机数的最大值
	 * @return
	 */
	public static int random(int min, int max) {

		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;

		return s;
	}

	/**
	 * 过滤emoji 或者 其他非文字类型的字符
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		int len = source.length();
		StringBuilder buf = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isNotEmojiCharacter(codePoint)) {
				buf.append(codePoint);
			}
		}
		return buf.toString();
	}

	private static boolean isNotEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double Distance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}

	/**
	 * 获取永不重复的随机数 16位
	 * 
	 * @return
	 */
	public synchronized static String getRandomNumber() {
		long thistime = System.currentTimeMillis();
		//
		if ((thistime - RANDOM_NUMBER_TIME) >= 1000) {
			RANDOM_NUMBER_MAP = new HashMap<String, String>();
			RANDOM_NUMBER_TIME = thistime;
		}
		String number;
		while (true) {
			if (RANDOMNUMBER > 98) {
				RANDOMNUMBER = 9;
			}
			RANDOMNUMBER++;
			number = thistime - 1200000000000L + "" + (new Random().nextInt(10)) + "" + (new Random().nextInt(10))
					+ RANDOMNUMBER;
			if (RANDOM_NUMBER_MAP.get(number) == null) {
				RANDOM_NUMBER_MAP.put(number, number);
				break;
			}
		}
		return number;
	}

	private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	private static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符

	/**
	 * @param htmlStr
	 * @return 删除Html标签
	 */
	public static String delHTMLTag(String htmlStr) {
		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签
		//
		// Pattern p_space = Pattern.compile(regEx_space,
		// Pattern.CASE_INSENSITIVE);
		// Matcher m_space = p_space.matcher(htmlStr);
		// htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
		return htmlStr.trim(); // 返回文本字符串
	}

	public static String getTextFromHtml(String htmlStr) {
		htmlStr = delHTMLTag(htmlStr);
		htmlStr = htmlStr.replaceAll(" ", "");
		htmlStr = htmlStr.substring(0, htmlStr.indexOf("。") + 1);
		return htmlStr;
	}

	public static String stripHtml(String content) {
		// <p>段落替换为换行
		content = content.replaceAll("<p .*?>", "\r\n");
		// <br><br/>替换为换行
		content = content.replaceAll("<br\\s*/?>", "\r\n");
		// 去掉其它的<>之间的东西
		content = content.replaceAll("\\<.*?>", "");
		// 还原HTML
		// content = HTMLDecoder.decode(content);
		return content;
	}

	/**
	 * 根据name获取cookie
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static void main(String[] args) {
		String h = "<a>adsa<br/>wsfds</a>";
		String a = stripHtml(h);
		System.out.println(a);
	}
	
	public static boolean LongisEmpty(Long param){
		if(param == null ){
			return true;
		}else{
			return false;
		}
	}
}

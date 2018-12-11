package com.answer.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	protected final static Log logger = LogFactory.getLog(CommonUtil.class);

	/**
	 * 拼接路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/";
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
	 * 获取userId-request
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

	/**
	 * 设置session
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setSession(HttpServletRequest request, String key,
			Object value) {
		request.getSession().setAttribute(key, value);

	}

	/**
	 * 清楚session
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeSession(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
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

		String strTable = numberFlag ? "1234567890"
				: "1234567890ABCDEFGHIJKMNPQRSTUVWXYZ";

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

	public static void main(String[] args) {
		System.out.println(createRandom(false, 6));
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

}

package customer.supu.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;


public class UserUtil {
	/**
	 * 获取当前用户对象shiro
	 * @return shirouser
	 */
//	public static ShiroUser getCurrentShiroUser(){
//		ShiroUser user=(ShiroUser) SecurityUtils.getSubject().getPrincipal();
//		return user;
//	}

	public static Object getCurrentStringUser(){

		return SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 获取当前用户session
	 * @return session
	 */
	public static Session getSession(){
		Session session =SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户httpsession
	 * @return httpsession
	 */
	public static Session getHttpSession(){
		Session session =SecurityUtils.getSubject().getSession();
		return session;
	}

	/**
	 * 获取当前用户对象
	 * @return user
	 */
//	public static User getCurrentUser(){
//		Session session =SecurityUtils.getSubject().getSession();
//		if(null!=session){
//			return (User) session.getAttribute("userinfo");
//		}else{
//			return null;
//		}
//
//	}
}

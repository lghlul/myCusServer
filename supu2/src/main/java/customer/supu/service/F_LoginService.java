package customer.supu.service;

import javax.servlet.http.HttpServletRequest;

import customer.supu.po.Employee;

public interface F_LoginService {
	/**
	 * 外面用户注册
	 */
	public Integer addOutsideEmployee(Employee employee, HttpServletRequest request) throws Exception;


	/**
	 * 判断账号是否存在
	 */
	public Integer isExist(Employee employee,HttpServletRequest request) throws Exception;





	/**
	 * 判断账号和密码是否正确
	 */
	public void jugdePasswordCorrect(String username,String password,String captcha,
			HttpServletRequest request) throws Exception;


	/**
	 * 获取登陆次数
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Integer  LoginCount(HttpServletRequest request) throws Exception;


	/**
	 * 发送6位随机数字验证码
	 */
	public void getRegisterMobileCode(String mobile,String templateCode,HttpServletRequest request) throws Exception;


	/**
	 * 发送验证码   登录
	 * @param mobile
	 * @throws Exception
	 */
	public void getLoginMobileCode(String mobile) throws Exception;

	/**
	 * 对比登录验证码
	 * @param username
	 * @param password
	 * @param captcha
	 * @param request
	 * @throws Exception
	 */
	public void jugdeMsgCorrect(String username,String password,String captcha,
			HttpServletRequest request)throws Exception;


	/**
	 * 绑定手机号到openid
	 */
	public void bindMobile(String mobile,String openid)throws Exception;


	/*
	*  判断手机号是否绑定过openid
	 */
	public Integer isExistOpenid(Employee employee, HttpServletRequest request) throws Exception;


	public Integer selectByMobile(Employee employee) throws Exception;
	public Integer updateByPrimaryKeySelective(Employee employee) throws Exception;
	public Employee selectByOpenid(String openid) throws Exception;
	public void updateByMobile(Employee employee) throws Exception;
}




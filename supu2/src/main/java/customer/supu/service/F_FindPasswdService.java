package customer.supu.service;

import javax.servlet.http.HttpServletRequest;

import customer.supu.po.Employee;



/**
 * 外部用户   找回密码   业务接口
 * @author
 *
 */
public interface F_FindPasswdService {
	/**
	 * 判断手机号是否存在
	 */
	public Integer phoneIsExist(Employee employee) throws Exception;

	/**
	 * 短信验证码是否相同
	 */
	public Integer isSameIdentifyCode() throws Exception;

	/**
	 * 根据手机号重置密码
	 */
	public void resetPassword(Employee employee) throws Exception;
	/**
	 * 发送6位随机数字验证码
	 */
	public void getMobileCode(String mobile,String templateCode,HttpServletRequest request) throws Exception;
}

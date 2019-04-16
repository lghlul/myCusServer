package customer.supu.service;


import customer.supu.exception.IncorrectCaptchaException;
import customer.supu.jenum.ESmsType;
import customer.supu.po.SmsLog;


public interface SmsLogService {
	/**
	 * 发送验证码成功后插入数据库数据
	 * @param mobile
	 * @param code
	 * @throws Exception
	 */
	  public void InsertSmsLog(String mobile,String code,Integer type) throws Exception;



		/**
		 *
		 * 根据电话      获取发送的验证码
		 * @param mobile
		 * @param type  1：注册  2：忘记密码
		 * @return
		 * @throws Exception
		 */

	public SmsLog getSmsLog(String mobile,String code,ESmsType type) throws IncorrectCaptchaException;



    /**
     * 校验手机验证码
     *
     * @param mobile
     * @param code
     * @return
     * @throws Exception
     */
    public boolean doValidMobileCode(String mobile, String code,ESmsType type) throws IncorrectCaptchaException;



    /**
     * 发送验证码
     *
     * @param mobile 手机号

     */
    public void sendMobileValidCode(String mobile,Integer type,String templateCode) throws Exception;
}

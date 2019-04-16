package customer.supu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import customer.supu.exception.IncorrectCaptchaException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.common.utils.SendAiliDaYuMsg;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.SmsLogDao;
import customer.supu.jenum.ESmsType;
import customer.supu.jenum.SmsStatusEnum;
import customer.supu.po.SmsLog;
import customer.supu.po.SmsLogExample;
import customer.supu.service.SmsLogService;



@Service
public class SmsLogServiceImpl implements SmsLogService{

	@Autowired
	private SmsLogDao smsLogDao;







    /**
     * 校验手机验证码
     *
     * @param mobile
     * @param code
     * @return
     * @throws Exception
     */
    public boolean doValidMobileCode(String mobile, String code,ESmsType type) throws IncorrectCaptchaException {
        SmsLog log = getSmsLog(mobile, code,type);
        if (null == log) {
            throw new IncorrectCaptchaException("手机验证码错误!");
        }
        if (DateTimeUtil.getSecondDifference(log.getSendtime(), new Date()) >= (10 * 60)) {
            throw new IncorrectCaptchaException("验证码失效!");
        }
        log.setStatus(SmsStatusEnum.CONTRASTED.getCode());//表示已经对比过了
        return updateSmsLog(log) > 0;
    }


	/**
	 *
	 * 根据电话      获取发送的验证码
	 * @param mobile
	 * @param type  1：注册  2：忘记密码
	 * @return
	 * @throws Exception
	 */

	public SmsLog getSmsLog(String mobile,String code,ESmsType type) throws IncorrectCaptchaException {
		SmsLogExample example=new SmsLogExample();
		//根据电话号码   以及没有对比过的 ， 判断是注册还是忘记密码的
		example.createCriteria().andMobileEqualTo(mobile).andStatusEqualTo(SmsStatusEnum.NOCONTRAST.getCode()).andCodeEqualTo(code).andTypeEqualTo(type.getCode());

		example.setOrderByClause("sendTime DESC");
		List<SmsLog> smsLogs=smsLogDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(smsLogs)){
			return  smsLogs.get(0);
		}

		return null;

	}



    /**
     * 更新状态，表示已经对比过了
     * @param log
     * @return
     */
    public int updateSmsLog(SmsLog log) {
        return smsLogDao.updateByPrimaryKeySelective(log);
    }


    /**
     * 发送验证码
     *
     * @param mobile 手机号

     */
    @Override
    public void sendMobileValidCode(String mobile,Integer type,String templateCode) throws Exception {
        System.out.println("sendMobileValidCode...mobile=" + mobile + ",templateCode="+ templateCode + ",type="+ type);
        if (!validMobileNumber(mobile)) {
            throw new Exception("请输入正确的手机号码!");
        }
        String strRslt = null;
        SmsLog log = null;
        // Integer a = Integer.parseInt(mobile);
        List<SmsLog> logs = getSmsLog(mobile,SmsStatusEnum.NOCONTRAST.getCode());
        if (CollectionUtils.isNotEmpty(logs)) {
            if (logs.size() >= 3) {
                throw new Exception("已向您发送三条短信验证码，不能重新发送，请在10分钟内输入最新的验证码！");
            }
            else {
                log = logs.get(0);
            }
        }
       if (null != log && DateTimeUtil.getSecondDifference(log.getSendtime(), new Date()) < (9 * 60)) {
            strRslt = String.valueOf(log.getCode());
        }
        else {
            strRslt =RandomStringUtils.randomNumeric(4);

        }

       //发送短信
       //String result=SendSMS.sendMessage(mobile, strRslt);

      // String result=SendMsgUtil.sendSingleMsg(mobile, "【亿芽网】"+strRslt);
     //  String result="1";
/*       String message=null;
       if(type==1){//注册
    	   message=new String(SpringPropertyResourceReader.getProperty("register.user").getBytes("ISO8859-1"),"utf-8");
       }else if(type==2){//忘记密码
    	   message=new String(SpringPropertyResourceReader.getProperty("edit.pwd").getBytes("ISO8859-1"),"utf-8");
       }
       String content=MessageFormat.format(message,strRslt);*/
        System.out.println("sendMobileValidCode...strRslt=" + strRslt + ",templateCode="+ templateCode + ",mobile="+ mobile);
       String result=String.valueOf(SendAiliDaYuMsg.send(strRslt,mobile,templateCode,null,null,0,null,null));
        System.out.println("sendMobileValidCode...result=" + result);
       //        String result = "0";
        if (!(StringUtils.hasText(result) && result.equals("1"))) {
            throw new Exception("验证码发送失败，请重试!");
        }else{
            System.out.println("短信验证码为：" + strRslt + "，手机为：" + mobile + "---------------------------------------------------");
        	InsertSmsLog(mobile, strRslt,type);
        }

    }




    /**
     * 获取当天所有未验证且发送成功的验证码
     *
     * @param mobile
     * @param state
     * @return
     */
    public List<SmsLog> getSmsLog(String mobile, Integer state) {
        SmsLogExample example = new SmsLogExample();
        example.createCriteria().andMobileEqualTo(mobile).andStatusEqualTo(state)
              .andSendtimeBetween(DateTimeUtil.getCurrentDateZeroTime(), DateTimeUtil.getCurrentDateLastedTime());
        example.setOrderByClause("id DESC");
        return smsLogDao.selectByExample(example);
    }

    /**
     * 验证手机号码
     * @param mobile
     * @return
     */
    public boolean validMobileNumber(String mobile) {
        Pattern p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 将发送付验证码保存数据库中
     * @param mobile
     * @param code
     */
    public void InsertSmsLog(String mobile,String code,Integer type) throws Exception{
    	SmsLog record=new SmsLog();
    	record.setCode(code);
    	record.setMobile(mobile);
    	record.setStatus(SmsStatusEnum.NOCONTRAST.getCode());
    	record.setSendtime(new Date());
    	record.setType(type);
    	smsLogDao.insertSelective(record);

    }





}

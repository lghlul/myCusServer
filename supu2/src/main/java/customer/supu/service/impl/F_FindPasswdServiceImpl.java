package customer.supu.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.utils.Utility;
import customer.supu.dao.EmployeeDao;
import customer.supu.jenum.ESmsType;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeExample;
import customer.supu.service.F_FindPasswdService;
import customer.supu.service.F_LoginService;
import customer.supu.service.SmsLogService;



/**
 * 外部用户   找回密码   业务实现类
 * @author
 *
 */
@Service
public class F_FindPasswdServiceImpl implements F_FindPasswdService{


	@Autowired
	private EmployeeDao employeeDao;

    @Autowired
    private F_LoginService f_LoginService;

	@Autowired
	private SmsLogService smsLogService;
	/**
	 * 判断手机号是否存在   在F_IndexService中有相同方法
	 */
	@Override
	public Integer phoneIsExist(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 短信验证码是否相同
	 */
	@Override
	public Integer isSameIdentifyCode() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据手机号重置密码
	 */
	@Override
	public void resetPassword(Employee employee) throws Exception {
		//创建查询条件
		EmployeeExample example=new EmployeeExample();
		//给查询条件赋值
		example.createCriteria().andEcodeEqualTo(employee.getEcode());
		//MD5加密
		employee.setPassword(Utility.getMd5Password(employee.getPassword()));
		//修改
		employeeDao.updateByExampleSelective(employee, example);
	}

	/**
	 * 发送6位随机数字验证码
	 */
	@Override
	public void getMobileCode(String mobile,String templateCode,HttpServletRequest request) throws Exception{
		Employee employee=new Employee();
		employee.setUsername(mobile);
		Integer code=f_LoginService.isExist(employee,request);
		if (code==0) {
			throw new Exception("账号不存在");
		}
		//smsLogService.doValidMobileCode(mobile, ESmsType.MODIFY);

		//String code=RandomStringUtils.randomNumeric(6);
		smsLogService.sendMobileValidCode(mobile, ESmsType.MODIFY.getCode(),templateCode);



	}

}

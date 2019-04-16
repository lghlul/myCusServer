package customer.supu.service.impl;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import customer.supu.common.utils.StringUtils;
import customer.supu.common.utils.Utility;
import customer.supu.dao.EmployeeBuyCardDao;
import customer.supu.dao.EmployeeDao;
import customer.supu.exception.IncorrectCaptchaException;
import customer.supu.jenum.DataValidEnum;
import customer.supu.jenum.ESmsType;
import customer.supu.po.Employee;
import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.EmployeeExample;
import customer.supu.po.EmployeeExample.Criteria;
import customer.supu.service.F_LoginService;
import customer.supu.service.SmsLogService;

@Service
public class F_LoginServiceImpl implements F_LoginService{

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private SmsLogService smsLogService;
	
	@Autowired
	private EmployeeBuyCardDao employeeBuyCardDao;
	/**
	 * 外面用户注册
	 */
	public Integer addOutsideEmployee(Employee employee, HttpServletRequest request) throws Exception {
		// 设置ecode
		//employee.setEcode(employee.getCnname());
		employee.setUsername(employee.getCnname());
//		employee.setFlag(DataValidEnum.EFFECT.getCode());
//		employee.setPassword(Utility.getMd5Password(employee.getPassword()));
		//employee.setMobilephone(employee.getUsername());
		//表示前台    注册用户
		employee.setIsback(0);
		employee.setHead(employee.getHead());
		employee.setOpenid(request.getSession().getAttribute("openId").toString());
		//创建日期
		employee.setCreatedate(new Date());
		//插入数据库
		employeeDao.insertSelective(employee);
		return employee.getEmployeeid();
	}


	/**
	 * 判断账号是否存在
	 */
	public Integer isExist(Employee employee,HttpServletRequest request) throws Exception {
		//创建查询对象
		EmployeeExample example=new EmployeeExample();
		Criteria contion=example.createCriteria();
		//给查询对象赋值
		contion.andMobilephoneEqualTo(employee.getUsername());
		contion.andFlagEqualTo(DataValidEnum.EFFECT.getCode());
		//查询
		List<Employee> employees=employeeDao.selectByExample(example);
		//判断是否为空
		if (CollectionUtils.isEmpty(employees)) {
			return 1;
		}else{
			String openId=(String) request.getSession().getAttribute("openId");
			if(employees.get(0).getOpenid()!=null&&employees.get(0).getOpenid().equals(openId)) {
				return 0;//如果手机号 绑定账号不是此账号 提示手机已被绑定
			}
			return 1;
		}

	}

	/**
	 * 判断账号和密码是否正确
	 */
	public void jugdePasswordCorrect(String username,String password,String captcha,
			HttpServletRequest request) throws Exception {
		//获取验证码
		String captcha2 =
	                (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

	    if (captcha != null && captcha !="" && !captcha2.equalsIgnoreCase(captcha)) {
	            throw new IncorrectCaptchaException("验证码错误！");
	    }

		//创建查询对象
		EmployeeExample example=new EmployeeExample();
		Criteria contion=example.createCriteria();
		//给查询对象赋值
		contion.andEcodeEqualTo(username);
		contion.andFlagEqualTo(DataValidEnum.EFFECT.getCode());
		//查询
		List<Employee> employees=employeeDao.selectByExample(example);
		//判断是否为空
		if (CollectionUtils.isNotEmpty(employees)) {
			contion.andPasswordEqualTo(Utility.getMd5Password(password));
			//查询
			List<Employee> list=employeeDao.selectByExample(example);
			if (CollectionUtils.isEmpty(list)) {
				 throw new IncorrectCaptchaException("密码错误！");
			}else{

				//setCookieInfo(username, password, response, 24*60*60);//一个月过期
				//登陆成功后  移除登陆次数
				//String ip=CusAccessObjectUtil.getIpAddress(request);
				request.getSession().removeAttribute("outsidecount");

				//将id保存session
				request.getSession().setAttribute("employeeId", list.get(0).getEmployeeid());
				System.out.println("登陆request的userId=="+request.getSession().getAttribute("employeeId"));
				//System.out.println("登陆session的userId=="+session().getAttribute("employeeId"));
				//System.out.println(SessionIdStaticData.sessionmapLength());
				//设置sessionId
				//setSessionIdStaticData(request, username);
				//System.out.println(SessionIdStaticData.sessionmapLength());

			}

		}else{
			 throw new IncorrectCaptchaException("用户名错误！");
		}
		//设置openId的值
		setOpenId(request, employees.get(0));


	}

	//登陆时吗，根据账号查询openid,




	/**
	 * 对比登录验证码
	 * @param username
	 * @param password
	 * @param captcha
	 * @param request
	 * @throws Exception
	 */
	public void jugdeMsgCorrect(String username,String password,String captcha,
			HttpServletRequest request)throws Exception {
		//获取验证码
		String captcha2 =
	                (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

	    if (captcha != null && captcha !="" && !captcha2.equalsIgnoreCase(captcha)) {
	            throw new IncorrectCaptchaException("验证码错误！");
	    }
		//创建查询对象
		EmployeeExample example=new EmployeeExample();
		Criteria contion=example.createCriteria();
		//给查询对象赋值
		contion.andEcodeEqualTo(username);
		contion.andFlagEqualTo(DataValidEnum.EFFECT.getCode());
		//查询
		List<Employee> employees=employeeDao.selectByExample(example);
		//判断是否为空
		if (CollectionUtils.isEmpty(employees)) {
			throw new IncorrectCaptchaException("用户名错误！");
		}

	    //验证对错
	    smsLogService.doValidMobileCode(username, password, ESmsType.LOGIN);
	    Employee record  = employees.get(0);
	    record.setMobilephone(username);
	    record.setEcode(username);
	    employeeDao.updateByPrimaryKeySelective(record);
		//将id保存session
		request.getSession().setAttribute("employeeId", employees.get(0).getEmployeeid());


		//设置openId的值
		setOpenId(request, employees.get(0));


	}

	/**
	 * 更新openId
	 * @param request
	 * @param employee
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void setOpenId(HttpServletRequest request,Employee employee) throws Exception{
		String openId=(String) request.getSession().getAttribute("openId");
		//如果opendId有值
		if(StringUtils.hasText(openId)){
			EmployeeExample example=new EmployeeExample();
			example.createCriteria().andOpenidEqualTo(openId);
			List<Employee> employees= employeeDao.selectByExample(example);

			//如果openId 不为空，表示已经有微信客户端登陆过
			if(CollectionUtils.isNotEmpty(employees)){
				Employee employeeBefore_ByOpenId=employees.get(0);
				//如果是同一个电话登陆，不需要更新
				if(employee.getUsername().equals(employeeBefore_ByOpenId.getUsername())){

				}else{
					//先置空前一个号码的微信openId，再更新本号码的openId,保证同一个号码绑定唯一openid
					updateOpenIdEmpty(employeeBefore_ByOpenId);

					updateOpenId(employee, openId);
				}

			}
			else{

				updateOpenId(employee, openId);
			}
		}
	}


	public void updateOpenId(Employee employee,String openId){
		//没有客户端登陆就直接更新
		employee.setOpenid(openId);
		employeeDao.updateByPrimaryKeySelective(employee);
	}

    public void bindMobile(String mobile,String openId){
		Employee employee = new Employee();
		employee.setMobilephone(mobile);
		employee.setOpenid(openId);
		employeeDao.updateByOpenid(employee);
	}


	/**
	 * 置空openId
	 * @param employee
	 */
	public void updateOpenIdEmpty(Employee employee){
		//没有客户端登陆就直接更新
		employee.setOpenid("");
		employeeDao.updateByPrimaryKeySelective(employee);
	}



	/**
	 * 设置sessionId
	 * @param request
	 * @param username
	 */
/*	public void setSessionIdStaticData(HttpServletRequest request,String username){

		String sessionID =request.getRequestedSessionId();

		if(!SessionIdStaticData.getSessionIDMap().containsKey(username)){
			SessionIdStaticData.getSessionIDMap().put(username, sessionID);
		}else if(SessionIdStaticData.getSessionIDMap().containsKey(username)&&!sessionID.equals(SessionIdStaticData.getSessionIDMap().get(username).toString())){

			SessionIdStaticData.getSessionIDMap().remove(username);
			SessionIdStaticData.getSessionIDMap().put(username, sessionID);

		}

	}*/

	/**
	 * 获取登陆次数
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Integer  LoginCount(HttpServletRequest request) throws Exception{
		//String ip=CusAccessObjectUtil.getIpAddress(request);
		HttpSession session=request.getSession();
		if (session.getAttribute("outsidecount")==null) {
			session.setAttribute("outsidecount", 1);
		}else{
			session.setAttribute("outsidecount", Integer.parseInt(String.valueOf(session.getAttribute("outsidecount")))+1);
		}
		int loginCount= Integer.parseInt(String.valueOf(request.getSession().getAttribute("outsidecount")));

		return loginCount;
	}




	/**
	 * 发送6位随机数字验证码  注册
	 */
	public void getRegisterMobileCode(String mobile,String templateCode,HttpServletRequest request) throws Exception{
		Employee employee=new Employee();
		employee.setUsername(mobile);
		Integer code=isExist(employee,request);
		if (code==1) {
			throw new Exception("账号已存在");
		}

		smsLogService.sendMobileValidCode(mobile, ESmsType.REGISTER.getCode(),templateCode);


	}

	/**
	 * 发送验证码   登录
	 * @param mobile
	 * @throws Exception
	 */
	public void getLoginMobileCode(String mobile) throws Exception{
		smsLogService.sendMobileValidCode(mobile, ESmsType.LOGIN.getCode(),null);
	}


	/*
	*
	 */
	public Integer isExistOpenid(Employee employee, HttpServletRequest request) throws Exception{
//		EmployeeExample example=new EmployeeExample();

//		Criteria contion=example.createCriteria();
		//给查询对象赋值
//		contion.andEcodeEqualTo(employee.getUsername());
//		contion.andFlagEqualTo(DataValidEnum.EFFECT.getCode());

		//查询
		List<Employee> employees=employeeDao.selectByMobile(employee);
		//判断是否为空
		if (CollectionUtils.isEmpty(employees)) {
			return 1;
		}else{
//			String openId=(String) request.getSession().getAttribute("openId");
			if(employees.get(0).getOpenid() != null) {
				return 0;//如果手机号 绑定账号不是此账号 提示手机已被绑定
			}
//			if(employees.get(0).getOpenid().equals(openId)) {
//				return 0;//如果手机号 绑定账号不是此账号 提示手机已被绑定
//			}
		}
		return 1;
	}
    public Integer selectByMobile(Employee employee) throws Exception{
        //查询
        List<Employee> employees=employeeDao.selectByMobile(employee);
        //判断是否为空
        if (CollectionUtils.isEmpty(employees)) {
            return 1;
        }else{
			return employees.get(0).getEmployeeid();
        }
    }

    public Integer updateByPrimaryKeySelective(Employee employee) throws Exception{

        return employeeDao.updateByPrimaryKeySelective(employee);
    }

	public Employee selectByOpenid(String openid) throws Exception{
		return employeeDao.selectByOpenid(openid);
	}

	@Transactional
	@Override
	public void updateByMobile(Employee employee) throws Exception {
		List<EmployeeBuyCard> employeeBuyCards = employeeBuyCardDao.selectByUserId(employee.getEmployeeid());
		//判断是否为空
        if (CollectionUtils.isEmpty(employeeBuyCards)) {
        	employeeDao.updateByPrimaryKeySelective(employee);
        }else{
        	for (EmployeeBuyCard employeeBuyCard : employeeBuyCards) {
        		employeeBuyCard.setPhonenumber(employee.getMobilephone());
        		employeeBuyCardDao.updateByPrimaryKey(employeeBuyCard);
			}
        	employeeDao.updateByPrimaryKeySelective(employee);
        }
		
	}

}

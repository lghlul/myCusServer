package com.cad.aop;



import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cad.cache.CacheDeviationHelper;
import com.cad.domain.Visit;
import com.cad.mapper.VisitMapper;
import com.cad.utils.HttpUtil;
import com.cad.utils.LogUtil;
import com.cad.utils.UnicodeUtil;

/**
 * 
 * @author Lu
 * @Description: aop  记录访问者信息
 * @Package com.cad.aop
 * @date 2017年5月6日 下午9:45:36 
 * @version V1.0
 */
@Component
@Aspect
public class ControllerAspect {
	
	private static final String TAG = ControllerAspect.class.getName();
	
	@Autowired
	private VisitMapper visitMapper;
	
	
	@Pointcut("execution(public * com.cad.controller..*.*(..))")
	public void controllerAspect(){}
	
	/**
	 * @Description: 环绕通知 
	 * @throws
	 */
	@Around("controllerAspect()")  
	public Object addLogsForSuccess(ProceedingJoinPoint pjp) {
		Object retVal = "";
		Visit visit = new Visit();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		//MethodSignature signature = (MethodSignature) pjp.getSignature();
		//Method method = signature.getMethod();
		String method = request.getServletPath();
		//String methodName = method.getName();
		String ip = this.getIp(request);
		//if(false){
		if(!ip.equals("127.0.0.1")){
			//String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php";
			String url = "http://ip.taobao.com/service/getIpInfo.php";
			String param = "ip=" + ip;
			LogUtil.i(TAG, "sendGet start...url = " + url + ",ip=" + ip);
			//String address = HttpUtil.sendGet(url, param);
			//LogUtil.i(TAG, "sendGet end...address = " + address);
			visit.setIp(ip);
			visit.setMethod(method);
			/*if(!address.equals("-2")){
				JSONObject jObj = (JSONObject) JSON.parseObject(address);
				visit.setCity(UnicodeUtil.convertUnicode(jObj.getString("city")));
				visit.setCountry(UnicodeUtil.convertUnicode(jObj.getString("country")));
				visit.setProvince(UnicodeUtil.convertUnicode(jObj.getString("province")));
			}*/
			/*JSONObject jObj = (JSONObject) JSON.parseObject(address);
			Integer code = jObj.getInteger("code");
			if(code == 0){
				JSONObject jsonObject = jObj.getJSONObject("data");
				visit.setCity(jsonObject.getString("city"));
				visit.setCountry(jsonObject.getString("country"));
				visit.setProvince(jsonObject.getString("region"));
			}*/
			visitMapper.insertVisit(visit);
		}
		
		try {
			retVal = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return retVal;
	}

/*	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if(this.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
			int index = ip.indexOf(",");
			if(index != -1){
				return ip.substring(0,index);
			}else{
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if(this.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
			return ip;
		}
		return request.getRemoteAddr();
	}*/
	/**
	 * 
	* @Title: getIp 
	* @Description: 获取访问者ip
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String getIp(HttpServletRequest request){

        String ip = request.getHeader("X-Forwarded-For");  
  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip;  
	}
	
	
/*	private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }*/


}

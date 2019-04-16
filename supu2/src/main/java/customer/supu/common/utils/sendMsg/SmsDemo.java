package customer.supu.common.utils.sendMsg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class SmsDemo {
	public static void main(String[] args) throws InterruptedException {
		String url="http://www.api.zthysms.com/sendSmsBatch.do";
		String username="njjzhy";  //账e号
		String password="ywAgrd";  //密码
		String tkey=TimeUtil.getNowTime("yyyyMMddHHmmss");
		String mobile="13770814824";  //发送的手机号
		String content="【亿芽网】156898";   //内容


		//String time="2016-09-06 17:48:22";//定时信息所需参数时间格式为yyyy-MM-dd HH:mm:ss
		String xh="";
		try {
			content=URLEncoder.encode(content, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String param="url="+url+"&username="+username+"&password="+MD5Gen.getMD5(MD5Gen.getMD5(password)+tkey)+"&tkey="+tkey+"&mobile="+mobile+"&content="+content+"&xh="+xh;
		//String param="url="+url+"&username="+username+"&password="+MD5Gen.getMD5(MD5Gen.getMD5(password)+tkey)+"&tkey="+tkey+"&time="+time+"&mobile="+mobile+"&content="+content+"&xh="+xh;//定时信息url输出
		String ret=HttpRequest.sendPost(url,param);//定时信息只可为post方式提交
		System.out.println("ret:"+ret);
		System.out.println(param);

	}


	}
//}
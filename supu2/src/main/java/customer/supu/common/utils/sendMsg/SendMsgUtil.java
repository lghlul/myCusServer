package customer.supu.common.utils.sendMsg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SendMsgUtil {


	//单条短信的地址
	private final static  String url="http://www.api.zthysms.com/sendSmsBatch.do";
	private final static  String username="njjzhy";  //账e号
	private final static  String password="ywAgrd";  //密码
	//private final static  String tkey=TimeUtil.getNowTime("yyyyMMddHHmmss");
	//private final static  String mobile="18061614483";  //发送的手机号
	//private final static  String content="【亿芽网】156898";   //内容

	/**
	 * 发送单条信息
	 * @param mobile 手 机
	 * @param content 内容（包含【签名】）
	 * @return
	 */
	public static String sendSingleMsg(String mobile,String content){

		String tkey=TimeUtil.getNowTime("yyyyMMddHHmmss");
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

		//为1 的时候表示发送成功
		System.out.println("ret:"+ret);
		System.out.println(param);
		return ret.split(",")[0];
	}
}

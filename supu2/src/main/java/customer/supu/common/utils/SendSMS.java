package customer.supu.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*
 *
 *
 *
 *
 * username  用户名
 * password_md5   密码
 * mobile  手机号
 * apikey  apikey秘钥
 * content  短信内容
 * startTime  UNIX时间戳，不写为立刻发送，http://tool.chinaz.com/Tools/unixtime.aspx （UNIX时间戳网站）
 *
 * success:msgid  提交成功。
error:msgid  提交失败
error:Missing username  用户名为空
error:Missing password  密码为空
error:Missing apikey  APIKEY为空
error:Missing recipient  手机号码为空
error:Missing message content  短信内容为空
error:Account is blocked  帐号被禁用
error:Unrecognized encoding  编码未能识别
error:APIKEY or password_md5 error  APIKEY或密码错误
error:Unauthorized IP address  未授权 IP 地址
error:Account balance is insufficient  余额不足
 * */

 /**
 * 乱码问题处理：
 * 1、GBK编码提交的
    首先urlencode短信内容（content），然后在API请求时，带入encode=gbk

    2、UTF-8编码的

    将content 做urlencode编码后，带入encode=utf8或utf-8
    http://m.5c.com.cn/api/send/index.php?username=XXX&password_md5=XXX&apikey=XXX&mobile=XXX&content=%E4%BD%A0%E5%A5%BD%E6%89%8D%E6%94%B6%E7%9B%8A%E9%9F%A6&encode=utf8

    示例
 *
 */

public class SendSMS {

	private final static String encode = "UTF-8";

	private final static String username = "njjz";  //用户名

	private final static String password_md5 =  Utility.getMd5Password("asdf1234");  //密码

	private final static String apikey = "de5eb523c7b68518360360d2fe79bb1d";


	static{

	}
	public static String  sendMessage(String mobile,String content) throws Exception{
		//连接超时及读取超时设置
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000"); //连接超时：30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000");	//读取超时：30秒

		StringBuffer buffer = new StringBuffer();

		String contentUrlEncode;

		contentUrlEncode = URLEncoder.encode(content,encode);

			//把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
		buffer.append("http://115.28.23.78/api/send/index.php?username="+username+"&password_md5="+password_md5+"&mobile="+mobile+"&apikey="+apikey+"&content="+contentUrlEncode+"&encode="+encode);

		//System.out.println(buffer); //调试功能，输入完整的请求URL地址

		//把buffer链接存入新建的URL中
		URL url = new URL(buffer.toString());

		//打开URL链接
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		//使用POST方式发送
		connection.setRequestMethod("POST");

		//使用长链接方式
		connection.setRequestProperty("Connection", "Keep-Alive");

		//发送短信内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

		//获取返回值
		String result = reader.readLine();
		/*if(!(StringUtils.hasText(result) && "success".equals(result))){
			throw new Exception("发送验证码失败");
		}*/
		return result;

	}
/*	public static void main(String[] args) {



		//新建一个StringBuffer链接
		StringBuffer buffer = new StringBuffer();


		//String encode = "GBK"; //页面编码和短信内容编码为GBK。重要说明：如提交短信后收到乱码，请将GBK改为UTF-8测试。如本程序页面为编码格式为：ASCII/GB2312/GBK则该处为GBK。如本页面编码为UTF-8或需要支持繁体，阿拉伯文等Unicode，请将此处写为：UTF-8

		String encode = "UTF-8";

		String username = "njjz";  //用户名

		String password_md5 =  "asdf1234";  //密码

		String mobile = "13770814824,13912985665,17626035665,13915982076,18351884007,18061614483";  //手机号,只发一个号码：13800000001。发多个号码：13800000001,13800000002,...N 。使用半角逗号分隔。

	 //apikey秘钥（请登录 http://m.5c.com.cn 短信平台-->账号管理-->我的信息 中复制apikey）

		String content = "您好，您的验证码是：12345【亿芽网】";  //要发送的短信内容，特别注意：签名必须设置，网页验证码应用需要加添加【图形识别码】。



		try {

			password_md5=Utility.getMd5Password(password_md5);
			String contentUrlEncode = URLEncoder.encode(content,encode);  //对短信内容做Urlencode编码操作。注意：如

			//把发送链接存入buffer中，如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
			buffer.append("http://115.28.23.78/api/send/index.php?username="+username+"&password_md5="+password_md5+"&mobile="+mobile+"&apikey="+apikey+"&content="+contentUrlEncode+"&encode="+encode);

			//System.out.println(buffer); //调试功能，输入完整的请求URL地址

			//把buffer链接存入新建的URL中
			URL url = new URL(buffer.toString());

			//打开URL链接
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();

			//使用POST方式发送
			connection.setRequestMethod("POST");

			//使用长链接方式
			connection.setRequestProperty("Connection", "Keep-Alive");

			//发送短信内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

			//获取返回值
			String result = reader.readLine();

			//输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
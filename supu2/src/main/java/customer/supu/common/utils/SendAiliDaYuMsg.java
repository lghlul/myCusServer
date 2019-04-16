package customer.supu.common.utils;



import java.util.Map;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import customer.supu.dto.returnMsg.returnMsg;


public class SendAiliDaYuMsg {
	private final static  String url="http://gw.api.taobao.com/router/rest";
	private final static  String appkey="23662006";  //账e号
	private final static  String secret="eed5f7b47f934384964fdc34f67fb1d3";  //密码



	/**
	 *
	 * @param code 验证码  type=0的时候有值
	 * @param mobile 电话
	 * @param TemplateCode 模板
	 * @param name  教练名称（模板需要的参数） type=1的时候有值
	 * @param number 电话（模板需要的参数） type=1，2的时候有值
	 * type :0短信验证码   1：私教课预约或取消预约   2工作室预约或取消预约
	 * coursename:课程名称 （工作室模板传入）
	 * date:日期：2017-10-22 11:20（工作室模板传入）
	 * @return
	 */
	public static Integer  send(String code,String mobile,String TemplateCode,String name,String number,Integer type,String coursename,String date){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		//String json="{\"code\":\"1234\",\"product\":\"某某电子商务验证\"}";
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("SP速扑健身");

		if(type==0){//不为空，表示发送的是  验证码短信
		//内容
			req.setSmsParamString("{\"code\":\""+code+"\"}");
		}else if(type==1){//  私教课程模板          尊敬的${name}，有会员预约了您的私教课程，请及时与${number}联系。

			req.setSmsParamString("{\"name\":\""+name+"\",\"number\":\""+number+"\"}");

		}else if(type==2){ // 工作室模板        有会员预约了${date}的课程，课程名称${coursename}，请及时与${number}联系
			req.setSmsParamString("{\"number\":\""+number+"\",\"date\":\""+date+"\",\"coursename\":\""+coursename+"\"}");
		}
		//电话
		req.setRecNum(mobile);

		//模板
		if(StringUtils.hasText(TemplateCode)){
			req.setSmsTemplateCode(TemplateCode);
		}else{
			req.setSmsTemplateCode("SMS_85815021");
		}
		try {
			System.out.println(JSON.toJSONString(req));
		    AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		    System.out.println(rsp.getBody());

		    //检查返回参数
		    checkReturnMsg(rsp.getBody());

		    return 1;
		} catch (Exception e) {
		    // TODO: handle exception
			System.out.println(e.getMessage());
		    return -1;
		}

	}
	/*
	 * @author ll
	 * @Description 发送短信
	 * @date 2018/12/4 17:37
	 * @param [mobile, TemplateCode, obj]
	 * @return java.lang.Integer
	 */
	public static Integer  send(String mobile,String TemplateCode,Object obj){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("SP速扑健身");
		req.setSmsParamString(JSON.toJSONString(obj));
		//电话
		req.setRecNum(mobile);

		//模板
		req.setSmsTemplateCode(TemplateCode);
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			//检查返回参数
			checkReturnMsg(rsp.getBody());
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}

	}



	/**
	 * 检查返回参数是否正确
	 * @param returnJson
	 * @throws Exception
	 */
	public static void checkReturnMsg(String returnJson) throws Exception{
		//String json="{'alibaba_aliqin_fc_sms_num_send_response':{'result':{'err_code':'0','model':'109561062808^1112728496504','msg':'*','success':true},'request_id':'zddqcfuyhm7q'}}";
		JSONObject jsonObject = JSONObject.fromObject(returnJson);
		returnMsg return_msg=(returnMsg) JSONObject.toBean(jsonObject,returnMsg.class);
		String errorCode=return_msg.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getErr_code();

		if(errorCode.equals("0")){//表示没有错误
			return ;
		}else{
			throw new Exception();
		}

	}


	public static void main(String[] args) {
		String json="{'alibaba_aliqin_fc_sms_num_send_response':{'result':{'err_code':'0','model':'109561062808^1112728496504','msg':'*','success':true},'request_id':'zddqcfuyhm7q'}}";
		JSONObject jsonObject = JSONObject.fromObject(json);
		returnMsg a=(returnMsg) JSONObject.toBean(jsonObject,returnMsg.class);
		System.out.println(a.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getErr_code());
		// alibaba_aliqin_fc_sms_num_send_response a=  JSONObject.parseObject(rsp.getBody(),alibaba_aliqin_fc_sms_num_send_response.class);

		/*Integer id=send("哈哈", "13770814824");
		System.out.println(id);*/
	}
/*	String url="http://gw.api.taobao.com/router/rest";
	//成为开发者，创建应用后系统自动生成
	String appkey="23300902";
	String secret="24c5befb62bed7917bf139b7d39d251d";
	//短信模板的内容
	String json="{\"code\":\"1234\",\"product\":\"某某电子商务验证\"}";
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
	req.setExtend("123456");
	req.setSmsType("normal");
	req.setSmsFreeSignName("变更验证");
	req.setSmsParamString(json);
	req.setRecNum(tel);
	req.setSmsTemplateCode("SMS_4720619");
	try {
	    AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
	    System.out.println(rsp.getBody());
	    return 1;
	} catch (Exception e) {
	    // TODO: handle exception
	    return -1;
	}*/

}

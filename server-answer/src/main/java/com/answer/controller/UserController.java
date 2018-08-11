package com.answer.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.Result;
import com.answer.domain.User;
import com.answer.domain.WXSessionCache;
import com.answer.service.ISignService;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import com.answer.utils.HttpClientUtil;
import com.answer.utils.Log4jUtil;

@Controller
@RequestMapping("/user" )
public class UserController {
	@Autowired
	private CacheHelper cacheHelper;
	@Autowired
	private IUserService userService;
	@Autowired
	private ISignService signService;
	@Value("${wechat.appID}")
	private String appID;
	@Value("${wechat.appSecret}")
	private String appSecret;
	@Value("${wechat.grant_type}")
	private String grant_type;

	/**
	 * 登录
	 * 
	 * @param code
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/login", method = RequestMethod.POST )
	@ResponseBody
	public String login(String code, HttpServletRequest request) throws Exception {
		Log4jUtil.info("login start...code=" + code);
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		httpClientUtil.setHttpclient(HttpClientBuilder.create().build());

		Map<String, Object> map = new HashMap<>();
		map.put("appid", this.appID);
		map.put("secret", this.appSecret);
		map.put("js_code", code);
		map.put("grant_type", this.grant_type);
		
		//String resultStr = getOpenIDForTest(code);
		String resultStr = httpClientUtil.getDataByParamMap(Constant.url.GET_OPENID_SESSION, map);
		Log4jUtil.info("login getDataByParamMap...resultStr=" + resultStr);
		JSONObject jsonObj = JSON.parseObject(resultStr);
		Result result = new Result();
		if (jsonObj.get("errcode") == null) {
			WXSessionCache session = new WXSessionCache();
			session.setOpenID(jsonObj.getString("openid"));
			UUID uuid = UUID.randomUUID();  
			String wxSession = uuid.toString().replaceAll("-", ""); 
			//生成session
			session.setWxSession(wxSession);
			
			this.cacheHelper.setSession(session);
			User u = this.userService.getUserByOpenID(session.getOpenID());
			
			if ((u == null) || (u.getUserID() < 1L)) {
				User user = new User();
				user.setOpenID(session.getOpenID());
				Log4jUtil.info("login registerUser...user=" + JSON.toJSONString(user));
				this.userService.registerUser(user);
			}
			session.setOpenID(null);
			result.setResultData(session);
		} else {
			result.setResultCode(jsonObj.getIntValue("errcode"));
		}
		Log4jUtil.info("login end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}


	/**
	 * 签到
	 * @param wxSession
	 * @return
	 */
	@RequestMapping(value="/sign",method=RequestMethod.POST )
	@ResponseBody
	public String sign(String wxSession) {
		Log4jUtil.info("sign start...wxSession=" + wxSession);
		Result result = this.signService.userSign(wxSession);
		Log4jUtil.info("sign end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 排名列表
	 * @param wxSession
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="/rankList",method=RequestMethod.GET )
	@ResponseBody
	public String rankList(String wxSession,Integer pageNo , Integer pageSize) {
		Log4jUtil.info("rankList start...wxSession=" + wxSession + ",pageNo=" + pageNo +  "，pageSize=" + pageSize);
		Result result = this.userService.getRankList(wxSession, pageNo, pageSize);
		Log4jUtil.info("rankList end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 校验是否绑定工号
	 * @param wxSession
	 * @return
	 */
	@RequestMapping(value="/checkJobNum",method=RequestMethod.GET )
	@ResponseBody
	public String checkJobNum(String wxSession) {
		Log4jUtil.info("checkJobNum start...wxSession=" + wxSession);
		Result result = this.userService.checkJobNum(wxSession);
		Log4jUtil.info("checkJobNum end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 绑定工号
	 * @param wxSession
	 * @param jonNum
	 * @return
	 */
	@RequestMapping(value="/bindJobNum",method=RequestMethod.POST )
	@ResponseBody
	public String bindJobNum(String wxSession,String jobNum) {
		Log4jUtil.info("bindJobNum start...wxSession=" + wxSession + ",jobNum=" + jobNum);
		Result result = this.userService.bindJobNum(wxSession, jobNum);
		Log4jUtil.info("bindJobNum end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 获取用户信息
	 * @param wxSession
	 * @return
	 */
	@RequestMapping(value="/userInfo",method=RequestMethod.GET )
	@ResponseBody
	public String userInfo(String wxSession){
		Log4jUtil.info("userInfo start...wxSession=" + wxSession);
		Result result = this.userService.getUserInfo(wxSession);
		Log4jUtil.info("userInfo end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 更新用户信息
	 * @param wxSession
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST )
	@ResponseBody
	public String update(String wxSession , String userImg , String userName){
		Log4jUtil.info("update start...wxSession=" + wxSession + ",userImg=" + userImg + ",userName=" + userName);
		Result result = this.userService.editUser(wxSession,userImg,userName);
		Log4jUtil.info("update end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 是否签到过
	 * @param wxSession
	 * @return
	 */
	@RequestMapping(value="/isSign",method=RequestMethod.GET )
	@ResponseBody
	public String isSign(String wxSession){
		Log4jUtil.info("isSign start...wxSession=" + wxSession);
		Result result = this.signService.isSign(wxSession);
		Log4jUtil.info("isSign end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 创建对战房间
	 * @param wxSession
	 * @param typeID
	 * @return
	 */
	@RequestMapping(value="/createRoom",method=RequestMethod.POST )
	@ResponseBody
	public String createRoom(String wxSession , Long typeID){
		Log4jUtil.info("createRoom start...wxSession=" + wxSession + ",typeID=" + typeID);
		Result result = this.userService.createRoom(wxSession, typeID);
		Log4jUtil.info("createRoom end...result=" + JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
}

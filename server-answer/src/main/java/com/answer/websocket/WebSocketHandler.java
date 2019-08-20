/**  
* Title: WebSocketHandler.java 
* Description:   
* @author ll  
* @date 2018年5月7日  
* @version 1.0  
*/  
package com.answer.websocket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.Question;
import com.answer.domain.Result;
import com.answer.domain.Room;
import com.answer.domain.RoomQuestion;
import com.answer.domain.User;
import com.answer.domain.WXSessionCache;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;

/**  
* Title: WebSocketHandler 
* Description:   
* @author ll  
* @date 2018年5月7日  
*/
public class WebSocketHandler extends TextWebSocketHandler{
	  
    //已建立连接的用户  
    private static final Map<String,WebSocketSession> userMap = new HashMap<>();

    @Autowired
	private CacheHelper cacheHelper;
    
    @Autowired
	private IUserService userService;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomQuestionMapper roomQuestionMapper;
    
    @Autowired
    private QuestionMapper questionMapper;
    /** 
     * 处理前端发送的文本信息 
     * js调用websocket.send时候，会调用该方法 
     * 
     * @param session 
     * @param message 
     * @throws Exception 
     */  
    @Override  
    protected void handleTextMessage(WebSocketSession socketSession, TextMessage message) throws Exception {  
    	Log4jUtil.info("handleTextMessage start...message=" + JSON.toJSONString(message));
    	Result result = new Result();
    	WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
    	Log4jUtil.info("getSession...session=" + JSON.toJSONString(session));
    	//校验是否有凭证
		if (session.getOpenID() == null) {
			result.setResultCode(Constant.returnCode.SESSOIN_TIMEOUT);
			socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));  
		}else{
				//校验是否有工号
			User user = userService.getUserByOpenID(session.getOpenID());
			Log4jUtil.info("getUserByOpenID...user=" + JSON.toJSONString(user));
			if(user.getJobNum() == null || "".equals(user.getJobNum())){
				result.setResultCode(Constant.returnCode.NO_JOBNUM);
				socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));  
			}else if(user.getScore() < 10){
				//积分不够
				result.setResultCode(Constant.returnCode.SCORE_NOT_ENOUGH);
				socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));  
			}else{
				String msgStr = message.getPayload();
		    	JSONObject jsonObj = JSON.parseObject(msgStr);
		    	Integer type = jsonObj.getInteger("msgType");
		    	Long roomID = jsonObj.getLong("roomID");
		    	Room room = this.roomMapper.queryRoomById(roomID);
		    	WebSocketSession otherSocketSession = null;
				Log4jUtil.info("handleTextMessage...userMap=" + JSON.toJSONString(userMap));
		    	//是否是房间发起人
		    	boolean isCreater = true;
		    	//得到另外一个人的webSocketSession
		    	if(session.getOpenID().equals(room.getCreateOpenID())){
		    		otherSocketSession = userMap.get(room.getOpenID());
		    	}else{
		    		otherSocketSession = userMap.get(room.getCreateOpenID());
		    		isCreater = false;
		    	}
		    	if(otherSocketSession == null){
		    		//对方不在线
		    		result.setResultCode(Constant.returnCode.NOT_ONLINE);
					socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));  
		    	}else{
		    		switch (type) {
					case 1:
						//上线
						Room r = new Room();
						r.setRoomID(room.getRoomID());
						r.setOpenID(session.getOpenID());
						r.setJoinTime(System.currentTimeMillis());
						this.roomMapper.updateRoom(r);
						Map<String,Object> userMap = new HashMap<>();
						User creater = this.userService.getUserByOpenID(room.getCreateOpenID());
						userMap.put("userImg", creater.getUserImg());
						userMap.put("userName", creater.getUserName());
						userMap.put("msgType",type);
						result.setResultData(userMap);
						Log4jUtil.info("socketSession...result=" + JSON.toJSONString(result));
						socketSession.sendMessage(new TextMessage(JSON.toJSONString(result))); 
						userMap.put("userImg", user.getUserImg());
						userMap.put("userName", user.getUserName());
						userMap.put("msgType",type);
						result.setResultData(userMap);
						Log4jUtil.info("otherSocketSession...result=" + JSON.toJSONString(result));
						otherSocketSession.sendMessage(new TextMessage(JSON.toJSONString(result))); 
						break;
					case 2:
						//告诉对方是否回答正确
						Long questionID = jsonObj.getLong("questionID");
						String answerID = jsonObj.getString("answerID");
						Question question = this.questionMapper.queryQuestionByID(questionID);
						Map<String , Object> map = new HashMap<>();
						int isRight = 2;
						if(isRight(question, answerID)){
							isRight = 1;
						}
						map.put("isRight", isRight);
						map.put("answerID", answerID);
						map.put("msgType",type);
						result.setResultData(map);
						
						//更新数据库用户答题情况
						RoomQuestion roomQuestion = new RoomQuestion();
						roomQuestion.setRoomID(roomID);
						roomQuestion.setQuesID(questionID);
						if(isCreater){
							roomQuestion.setCreateAnswer(answerID);
						}else{
							roomQuestion.setAnswer(answerID);
						}
						this.roomQuestionMapper.updateQuestionByRoom(roomQuestion);
						Log4jUtil.info("otherSocketSession...result=" + JSON.toJSONString(result));
						otherSocketSession.sendMessage(new TextMessage(JSON.toJSONString(result))); 
						result.setResultData(null);
						//socketSession.sendMessage(new TextMessage(JSON.toJSONString(result))); 
					default:
						break;
				}
		    	}
		    	
			}
		}
    }  
  
  
    /** 
     * 当新连接建立的时候，被调用 
     * 连接成功时候，会触发页面上onOpen方法 
     * 
     * @param session 
     * @throws Exception 
     */  
    @Override  
    public void afterConnectionEstablished(WebSocketSession socketSession){
    	WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
    	Log4jUtil.info("afterConnectionEstablished...session=" + JSON.toJSONString(session));
		userMap.put(session.getOpenID(), socketSession);
		Log4jUtil.info("afterConnectionEstablished...userMap=" + JSON.toJSONString(userMap));
    }  
  
    /** 
     * 当连接关闭时被调用 
     * 
     * @param session 
     * @param status 
     * @throws Exception 
     */  
    @Override  
    public void afterConnectionClosed(WebSocketSession socketSession, CloseStatus status){
    	WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
		Log4jUtil.info("afterConnectionClosed...session=" + JSON.toJSONString(session));
    	userMap.remove(session.getOpenID());
		Log4jUtil.info("afterConnectionClosed...userMap=" + JSON.toJSONString(userMap));
    }  
  
    /** 
     * 传输错误时调用 
     * 
     * @param session 
     * @param exception 
     * @throws Exception 
     */  
    @Override  
    public void handleTransportError(WebSocketSession socketSession, Throwable exception) throws Exception {  
        if (socketSession.isOpen()) {  
        	socketSession.close();  
        }  
        WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
		Log4jUtil.info("handleTransportError...session=" + JSON.toJSONString(session));
        userMap.remove(session.getOpenID());
		Log4jUtil.info("handleTransportError...userMap=" + JSON.toJSONString(userMap));
    }  
  
    /** 
     * 给所有在线用户发送消息 
     * 
     * @param message 
     */  
    public void sendMessageToUsers(TextMessage message) {  
    }  
  
    /** 
     * 给某个用户发送消息 
     * 
     * @param userName 
     * @param message 
     */  
    public void sendMessageToUser(String userName, TextMessage message) {  
    }  
    
    private boolean isRight(Question question,String answerID){
		String[] rightAnswers = question.getRightAnswerID().split(",");
		String[] answerIDs = answerID.split(",");
		
		//答案个数不一样 错误
		if(rightAnswers.length != answerIDs.length){
			return false;
		}else{
			Set<String> answerSet = new HashSet<>();
			for(String rightAnswer : rightAnswers){
				answerSet.add(rightAnswer);
			}
			for(String answer : answerIDs){
				//如果正确答案不包含  回答的答案就是回答错误
				if(!answerSet.contains(answer)){
					return false;
				}
			}
		}
		return true;
	}
}

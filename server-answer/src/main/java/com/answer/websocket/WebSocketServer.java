package com.answer.websocket;


import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.alibaba.fastjson.JSON;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/8/14 11:13
 * @Modified By：
 */
@ServerEndpoint(value="/websocket/socketServer2/{wxSession}", configurator = SpringConfigurator.class)
public class WebSocketServer {

    // 已经建立链接的对象缓存起来
    private static ConcurrentMap<Integer, WebSocketServer> serverMap = new ConcurrentHashMap<Integer, WebSocketServer>();
    // 当前session
    private Session currentSession;

    private WXSessionCache wxSessionCache;

    //已建立连接的用户
    private static final ConcurrentMap<String, WebSocketServer> userMap = new ConcurrentHashMap<>();

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

    @OnOpen
    public void onOpen(Session session, @PathParam("wxSession") String wxSession) throws IOException {
        Log4jUtil.info("WebSocketServer onOpen start...wxSession=" + wxSession);
        this.currentSession = session;
        WXSessionCache wxSessionCache = this.cacheHelper.getSession(wxSession);
        this.wxSessionCache = wxSessionCache;
        userMap.put(wxSessionCache.getOpenID(), this);//建立链接时，缓存对象
    }
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        Log4jUtil.info("WebSocketServer onClose start...");
        if (userMap.containsValue(this)) {
            Iterator<String> keys = userMap.keySet().iterator();
            String openid = null;
            while(keys.hasNext()) {
                openid = keys.next();
                if (userMap.get(openid) == this) {
                    Log4jUtil.info("WebSocketServer onClose openid=" + openid);
                    userMap.remove(openid, this);//关闭链接时，删除缓存对象
                }
            }
        }
        this.currentSession = null;
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnMessage()
    @SuppressWarnings("unchecked")
    public void onMessage(String message) throws Exception{
        Log4jUtil.info("WebSocketServer onMessage start...message=" + JSON.toJSONString(message));
        Result result = new Result();
        //校验是否有凭证
        if (wxSessionCache.getOpenID() == null) {
            result.setResultCode(Constant.returnCode.SESSOIN_TIMEOUT);
            this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
        }else{
            //校验是否有工号
            User user = userService.getUserByOpenID(wxSessionCache.getOpenID());
            Log4jUtil.info("WebSocketServer getUserByOpenID...user=" + JSON.toJSONString(user));
            if(user.getJobNum() == null || "".equals(user.getJobNum())){
                result.setResultCode(Constant.returnCode.NO_JOBNUM);
                this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
            }else if(user.getScore() < 10){
                //积分不够
                result.setResultCode(Constant.returnCode.SCORE_NOT_ENOUGH);
                this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
            }else{
                JSONObject jsonObj = JSON.parseObject(message);
                Integer type = jsonObj.getInteger("msgType");
                Long roomID = jsonObj.getLong("roomID");
                Room room = this.roomMapper.queryRoomById(roomID);
                WebSocketServer otherSocketSession = null;
                Log4jUtil.info("handleTextMessage...userMap=" + JSON.toJSONString(userMap));
                //是否是房间发起人
                boolean isCreater = true;
                //得到另外一个人的webSocketSession
                if(wxSessionCache.getOpenID().equals(room.getCreateOpenID())){
                    otherSocketSession = userMap.get(room.getOpenID());
                }else{
                    otherSocketSession = userMap.get(room.getCreateOpenID());
                    isCreater = false;
                }
                if(otherSocketSession == null){
                    //对方不在线
                    result.setResultCode(Constant.returnCode.NOT_ONLINE);
                    this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
                }else{
                    switch (type) {
                        case 1:
                            //上线
                            Room r = new Room();
                            r.setRoomID(room.getRoomID());
                            r.setOpenID(wxSessionCache.getOpenID());
                            r.setJoinTime(System.currentTimeMillis());
                            this.roomMapper.updateRoom(r);
                            Map<String,Object> userMap = new HashMap<>();
                            User creater = this.userService.getUserByOpenID(room.getCreateOpenID());
                            userMap.put("userImg", creater.getUserImg());
                            userMap.put("userName", creater.getUserName());
                            userMap.put("msgType",type);
                            result.setResultData(userMap);
                            Log4jUtil.info("socketSession...result=" + JSON.toJSONString(result));
                            this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
                            userMap.put("userImg", user.getUserImg());
                            userMap.put("userName", user.getUserName());
                            userMap.put("msgType",type);
                            result.setResultData(userMap);
                            Log4jUtil.info("WebSocketServer otherSocketSession...result=" + JSON.toJSONString(result));
                            otherSocketSession.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
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
                            Log4jUtil.info("WebSocketServer otherSocketSession...result=" + JSON.toJSONString(result));
                            otherSocketSession.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
                            result.setResultData(null);
                            //socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                        default:
                            break;
                    }
                }

            }
        }
    }
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
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

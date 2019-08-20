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
import com.answer.mapper.UserMapper;
import com.answer.utils.Constant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/8/14 11:13
 * @Modified By：
 */
//@Component
//@ServerEndpoint(value="/websocket/socketServer2/{wxSession}")
public class WebSocketServer {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    // 当前session
    private Session currentSession;

    private WXSessionCache wxSessionCache;

    //已建立连接的用户
    private static final ConcurrentMap<String, Session> userMap = new ConcurrentHashMap<>();

    private static CacheHelper cacheHelper;

    @Autowired
    private void  setCacheHelper(CacheHelper cacheHelper){
        WebSocketServer.cacheHelper = cacheHelper;
    }
    private static UserMapper userMapper;
    @Autowired
    private void setUserMapper(UserMapper userMapper){
        WebSocketServer.userMapper = userMapper;
    }
    private static RoomMapper roomMapper;
    @Autowired
    private void setRoomMapper(RoomMapper roomMapper){
        WebSocketServer.roomMapper = roomMapper;
    }
    private static RoomQuestionMapper roomQuestionMapper;
    @Autowired
    private void setRoomQuestionMapper(RoomQuestionMapper roomQuestionMapper){
        WebSocketServer.roomQuestionMapper = roomQuestionMapper;
    }
    private static QuestionMapper questionMapper;
    @Autowired
    private void setQuestionMapper (QuestionMapper questionMapper){
        WebSocketServer.questionMapper = questionMapper;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("wxSession") String wxSession) throws IOException {
        logger.info("WebSocketServer onOpen start...wxSession=" + wxSession);
        this.currentSession = session;
        WXSessionCache wxSessionCache = this.cacheHelper.getSession(wxSession);
        this.wxSessionCache = wxSessionCache;
        userMap.put(wxSessionCache.getOpenID(), this.currentSession);//建立链接时，缓存对象
    }
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        logger.info("WebSocketServer onClose start...");
        if (userMap.containsValue(this)) {
            Iterator<String> keys = userMap.keySet().iterator();
            String openid = null;
            while(keys.hasNext()) {
                openid = keys.next();
                if (userMap.get(openid) == this) {
                    logger.info("WebSocketServer onClose openid=" + openid);
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
        logger.info("WebSocketServer onMessage start...message=" + JSON.toJSONString(message));
        Result result = new Result();
        //校验是否有凭证
        if (wxSessionCache.getOpenID() == null) {
            result.setResultCode(Constant.returnCode.SESSOIN_TIMEOUT);
            this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
        }else{
            //校验是否有工号
            User user = userMapper.queryUserByOpenID(wxSessionCache.getOpenID());
            logger.info("WebSocketServer getUserByOpenID...user=" + JSON.toJSONString(user));
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
                Session otherSocketSession = null;
                logger.info("WebSocketServer...userMap=" + JSON.toJSONString(userMap));
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
                            Map<String,Object> userInfoMap = new HashMap<>();
                            User creator = userMapper.queryUserByOpenID(room.getCreateOpenID());
                            userInfoMap.put("userImg", creator.getUserImg());
                            userInfoMap.put("userName", creator.getUserName());
                            userInfoMap.put("msgType",type);
                            result.setResultData(userInfoMap);
                            logger.info("WebSocketServer socketSession...result=" + JSON.toJSONString(result));
                            this.currentSession.getBasicRemote().sendText(JSON.toJSONString(result));
                            userInfoMap.put("userImg", user.getUserImg());
                            userInfoMap.put("userName", user.getUserName());
                            userInfoMap.put("msgType",type);
                            result.setResultData(userInfoMap);
                            logger.info("WebSocketServer otherSocketSession...result=" + JSON.toJSONString(result));
                            otherSocketSession.getBasicRemote().sendText(JSON.toJSONString(result));
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
                            logger.info("WebSocketServer otherSocketSession...result=" + JSON.toJSONString(result));
                            otherSocketSession.getBasicRemote().sendText(JSON.toJSONString(result));
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

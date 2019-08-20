/**
 * Title: WebSocketHandler.java
 * Description:
 *
 * @author ll
 * @date 2018年5月7日
 * @version 1.0
 */
package com.answer.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.domain.Config;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.mapper.UserMapper;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Title: WebSocketHandler
 * Description:
 *
 * @author ll
 * @date 2018年5月7日
 */
public class WebSocketHandler extends TextWebSocketHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    //已建立连接的用户  
    private static final Map<String, WebSocketSession> userMap = new HashMap<>();

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
    @Autowired
    private UserMapper userMapper;

    /**
     * 处理前端发送的文本信息
     * js调用websocket.send时候，会调用该方法
     *
     * @param socketSession
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession socketSession, TextMessage message) throws Exception {
        logger.info("handleTextMessage start...message=" + JSON.toJSONString(message));
        Result result = new Result();
        WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
        logger.info("getSession...session=" + JSON.toJSONString(session));
        //校验是否有凭证
        if (session.getOpenID() == null) {
            result.setResultCode(Constant.returnCode.SESSOIN_TIMEOUT);
            socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
        } else {
            //校验是否有工号
            User user = userService.getUserByOpenID(session.getOpenID());
            logger.info("getUserByOpenID...user=" + JSON.toJSONString(user));
            Config config = cacheHelper.getConfig(Constant.ConfigKey.BATTLE_CONFIG);
            JSONObject jsonObject = JSON.parseObject(config.getConfigValue());
            Integer score = jsonObject.getInteger("score");
            if (user.getJobNum() == null || "".equals(user.getJobNum())) {
                result.setResultCode(Constant.returnCode.NO_JOBNUM);
                socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
            } else if (user.getScore() < score.intValue()) {
                //积分不够
                result.setResultCode(Constant.returnCode.SCORE_NOT_ENOUGH);
                socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
            } else {
                String msgStr = message.getPayload();
                JSONObject jsonObj = JSON.parseObject(msgStr);
                Integer type = jsonObj.getInteger("msgType");
                Long roomID = jsonObj.getLong("roomID");
                Room room = this.roomMapper.queryRoomById(roomID);
                WebSocketSession otherSocketSession = null;
                logger.info("handleTextMessage...userMap=" + userMap.size());
                //是否是房间发起人
                boolean isCreater = true;
                //得到另外一个人的webSocketSession
                if (session.getOpenID().equals(room.getCreateOpenID())) {
                    otherSocketSession = userMap.get(room.getOpenID());
                } else {
                    otherSocketSession = userMap.get(room.getCreateOpenID());
                    isCreater = false;
                }
                if (otherSocketSession == null) {
                    //对方不在线
                    result.setResultCode(Constant.returnCode.NOT_ONLINE);
                    socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                } else {
                    switch (type) {
                        case 1:
                            //上线
                            Room r = new Room();
                            r.setRoomID(room.getRoomID());
                            r.setOpenID(session.getOpenID());
                            r.setJoinTime(System.currentTimeMillis());
                            this.roomMapper.updateRoom(r);
                            Map<String, Object> userInfoMap = new HashMap<>();
                            User creator = this.userService.getUserByOpenID(room.getCreateOpenID());
                            userInfoMap.put("userImg", creator.getUserImg());
                            userInfoMap.put("userName", creator.getUserName());
                            userInfoMap.put("msgType", type);
                            result.setResultData(userInfoMap);
                            logger.info("socketSession...result=" + JSON.toJSONString(result));
                            socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                            userInfoMap.put("userImg", user.getUserImg());
                            userInfoMap.put("userName", user.getUserName());
                            userInfoMap.put("msgType", type);
                            result.setResultData(userInfoMap);
                            logger.info("otherSocketSession...result=" + JSON.toJSONString(result));
                            logger.info("otherSocketSession...result=" + otherSocketSession.getAttributes().get("WEBSOCKET_SESSION_ID"));
                            otherSocketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                            break;
                        case 2:
                            //告诉对方是否回答正确
                            Long questionID = jsonObj.getLong("questionID");
                            String answerID = jsonObj.getString("answerID");
                            Question question = this.questionMapper.queryQuestionByID(questionID);
                            Map<String, Object> map = new HashMap<>();
                            int isRight = 2;
                            if (isRight(question, answerID)) {
                                isRight = 1;
                            }
                            map.put("isRight", isRight);
                            map.put("answerID", answerID);
                            map.put("msgType", type);
                            result.setResultData(map);

                            //更新数据库用户答题情况
                            RoomQuestion roomQuestion = new RoomQuestion();
                            roomQuestion.setRoomID(roomID);
                            roomQuestion.setQuesID(questionID);
                            String otherOpenId = null;
                            if (isCreater) {
                                roomQuestion.setCreateAnswer(answerID);
                                otherOpenId = room.getOpenID();
                            } else {
                                roomQuestion.setAnswer(answerID);
                                otherOpenId = room.getCreateOpenID();
                            }
                            this.roomQuestionMapper.updateQuestionByRoom(roomQuestion);
                            logger.info("otherSocketSession...result=" + JSON.toJSONString(result));
                            otherSocketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                            result.setResultData(null);
                            //socketSession.sendMessage(new TextMessage(JSON.toJSONString(result)));
                            //记录答题数量
                            String key = roomID + session.getOpenID();
                            String answerNumStr = cacheHelper.get(key);
                            int answerNum = StringUtils.isEmpty(answerNumStr) ? 0 : Integer.parseInt(answerNumStr);
                            answerNum++;
                            cacheHelper.set(key , answerNum + "");
                            cacheHelper.expire(key , 1 , TimeUnit.HOURS);

                            String otherKey = roomID + otherOpenId;
                            String otherAnswerNumStr = cacheHelper.get(otherKey);
                            int otherAnswerNum = StringUtils.isEmpty(otherAnswerNumStr) ? 0 : Integer.parseInt(otherAnswerNumStr);
                            if (answerNum == 10 && otherAnswerNum == 10) { //答题结束
                                logger.info("battle finish roomID=" + roomID);
                                List<RoomQuestion> answerList = roomQuestionMapper.selectAnswerByRoomID(roomID);
                                logger.info("battle finish answerList=" + JSONObject.toJSONString(answerList));
                                int createRightNum = 0;
                                //被邀请人答对数量
                                int rightNum = 0;
                                if (answerList != null && answerList.size() > 0) {
                                    for (RoomQuestion answer : answerList) {
                                        if (isRight(answer.getRightAnswer() , answer.getCreateAnswer())) {
                                            createRightNum++;
                                        }
                                        if (isRight(answer.getRightAnswer() , answer.getAnswer())) {
                                            rightNum++;
                                        }
                                    }
                                    User updateUser = new User();
                                    logger.info("battle finish=" + createRightNum + ",rightNum=" + rightNum);
                                    config = cacheHelper.getConfig(Constant.ConfigKey.BATTLE_CONFIG);
                                    BattleConfig battleConfig = JSON.parseObject(config.getConfigValue() , BattleConfig.class);
                                    if (createRightNum > rightNum) {
                                        //创建人获胜
                                        //胜者加10分
                                        updateUser.setScore(battleConfig.getScore());
                                        updateUser.setOpenID(room.getCreateOpenID());
                                        userMapper.updateUser(updateUser);
                                        //败者减10分
                                        updateUser.setScore(-battleConfig.getScore());
                                        updateUser.setOpenID(room.getOpenID());
                                        userMapper.updateUser(user);
                                    } else if (createRightNum < rightNum) {
                                        //被邀请人获胜
                                        //胜者加10分
                                        updateUser.setScore(battleConfig.getScore());
                                        updateUser.setOpenID(room.getOpenID());
                                        userMapper.updateUser(updateUser);
                                        //败者减10分
                                        updateUser.setScore(-battleConfig.getScore());
                                        updateUser.setOpenID(room.getCreateOpenID());
                                        userMapper.updateUser(updateUser);
                                    }
                                    //修改对战状态改为已计分
                                    Room updateRoom = new Room();
                                    updateRoom.setRoomID(room.getRoomID());
                                    updateRoom.setStatus(Constant.ROOM_STATUS_COUNT);
                                    roomMapper.updateRoom(updateRoom);
                                }
                            }
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
     * @param socketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession socketSession) {
        WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
        logger.info("afterConnectionEstablished...session=" + JSON.toJSONString(session));
        userMap.put(session.getOpenID(), socketSession);
        logger.info("afterConnectionEstablished...userMap=" + userMap.size());
    }

    /**
     * 当连接关闭时被调用
     *
     * @param socketSession
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession socketSession, CloseStatus status) {
        WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
        logger.info("afterConnectionClosed...session=" + JSON.toJSONString(session));
        userMap.remove(session.getOpenID());
        logger.info("afterConnectionClosed...userMap=" + userMap.size());
    }

    /**
     * 传输错误时调用
     *
     * @param socketSession
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession socketSession, Throwable exception) throws Exception {
        if (socketSession.isOpen()) {
            socketSession.close();
        }
        WXSessionCache session = this.cacheHelper.getSession(socketSession.getAttributes().get("WEBSOCKET_SESSION_ID").toString());
        logger.info("handleTransportError...session=" + JSON.toJSONString(session));
        userMap.remove(session.getOpenID());
        logger.info("handleTransportError...userMap=" + userMap.size());
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

    private boolean isRight(Question question, String answerID) {
        String[] rightAnswers = question.getRightAnswerID().split(",");
        String[] answerIDs = answerID.split(",");

        //答案个数不一样 错误
        if (rightAnswers.length != answerIDs.length) {
            return false;
        } else {
            Set<String> answerSet = new HashSet<>();
            for (String rightAnswer : rightAnswers) {
                answerSet.add(rightAnswer);
            }
            for (String answer : answerIDs) {
                //如果正确答案不包含  回答的答案就是回答错误
                if (!answerSet.contains(answer)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isRight(String rightAnswerID, String answerID) {
        String[] rightAnswers = rightAnswerID.split(",");
        String[] answerIDs = answerID.split(",");

        //答案个数不一样 错误
        if (rightAnswers.length != answerIDs.length) {
            return false;
        } else {
            Set<String> answerSet = new HashSet<>();
            for (String rightAnswer : rightAnswers) {
                answerSet.add(rightAnswer);
            }
            for (String answer : answerIDs) {
                //如果正确答案不包含  回答的答案就是回答错误
                if (!answerSet.contains(answer)) {
                    return false;
                }
            }
        }
        return true;
    }
}

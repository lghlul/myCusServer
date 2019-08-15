package com.answer.websocket;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answer.cache.CacheHelper;
import com.answer.domain.*;
import com.answer.mapper.QuestionMapper;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.service.IUserService;
import com.answer.utils.Constant;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/8/14 11:13
 * @Modified By：
 */
@Component
@ServerEndpoint(value="/websocket/socketServer2")
public class WebSocketServer2 {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(WebSocketServer2.class);
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("打开链接");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("有一连接关闭！当前在线人数为");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

 }

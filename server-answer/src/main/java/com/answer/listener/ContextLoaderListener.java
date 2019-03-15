package com.answer.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.answer.domain.Room;
import com.answer.domain.RoomQuestion;
import com.answer.domain.User;
import com.answer.mapper.RoomMapper;
import com.answer.mapper.RoomQuestionMapper;
import com.answer.mapper.UserMapper;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;
@Component
public class ContextLoaderListener implements ServletContextListener{

	private RoomMapper roomMapper;
	private RoomQuestionMapper roomQuestionMapper;
	private UserMapper userMapper;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		roomMapper = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(RoomMapper.class);
		roomQuestionMapper = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(RoomQuestionMapper.class);
		userMapper = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(UserMapper.class);
		//this.task();
	}
	
	private void task(){
		Runnable r = new Runnable() {
			@Override
			public void run() {
				while(true){
					//获取所有还未计分的房间
					List<Room> roomList = roomMapper.queryRoomByStatus(Constant.ROOM_STATUS_NOT_COUNT);
					if(roomList != null){
						//Log4jUtil.info("task...roomList=" + JSON.toJSONString(roomList));
						for(Room room : roomList){
							//Log4jUtil.info("task...room=" + JSON.toJSONString(room));
							List<RoomQuestion> answerList = roomQuestionMapper.selectAnswerByRoomID(room.getRoomID());
							//Log4jUtil.info("task...answerList=" + JSON.toJSONString(answerList));
							//创建人答对数量
							int createRightNum = 0;
							//被邀请人答对数量
							int rightNum = 0;
							if(answerList != null && answerList.size() > 0){
								//是否答完
								boolean isFinish = false;
								int finishNum = 0;
								//对战答完
								for(RoomQuestion answer : answerList){
									if(answer.getCreateAnswer() != null && answer.getAnswer() != null){
										finishNum++;
									}
									if(answer.getCreateAnswer() == answer.getRightAnswer()){
										createRightNum++;
									}
									if(answer.getAnswer() == answer.getRightAnswer()){
										rightNum++;
									}
								}
								if(finishNum == answerList.size() && finishNum != 0){
									isFinish = true;
								}
								if(isFinish){
									User user = new User();
									Log4jUtil.info("task...createRightNum=" + createRightNum + ",rightNum=" + rightNum);
									if(createRightNum > rightNum){
										//创建人获胜
										//胜者加10分  
										user.setScore(Constant.score.TEN);
										user.setOpenID(room.getCreateOpenID());
										userMapper.updateUser(user);
										//败者减10分
										user.setScore(-Constant.score.TEN);
										user.setOpenID(room.getOpenID());
										userMapper.updateUser(user);
									}else if(createRightNum < rightNum){
										//被邀请人获胜
										//胜者加10分  
										user.setScore(Constant.score.TEN);
										user.setOpenID(room.getOpenID());
										userMapper.updateUser(user);
										//败者减10分
										user.setScore(-Constant.score.TEN);
										user.setOpenID(room.getCreateOpenID());
										userMapper.updateUser(user);
									}
									//修改对战状态改为已计分
									Room r = new Room();
									r.setRoomID(room.getRoomID());
									r.setStatus(Constant.ROOM_STATUS_COUNT);
									Log4jUtil.info("task...r=" + JSON.toJSONString(r));
									roomMapper.updateRoom(r);
								}
							}
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

}

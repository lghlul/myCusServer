package com.answer.domain;

public class RoomQuestion {
	private long id;
	private long roomID;
	private long quesID;
	private String createAnswer;
	private String answer;
	private String rightAnswer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRoomID() {
		return roomID;
	}
	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}
	public long getQuesID() {
		return quesID;
	}
	public void setQuesID(long quesID) {
		this.quesID = quesID;
	}
	public String getCreateAnswer() {
		return createAnswer;
	}
	public void setCreateAnswer(String createAnswer) {
		this.createAnswer = createAnswer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	
}

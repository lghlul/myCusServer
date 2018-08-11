package com.answer.domain;

public class Room {
	private long roomID;
	private String createOpenID;
	private String openID;
	private long createTime;
	private long joinTime;
	private long typeID;
	private byte status;
	
	
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public long getRoomID() {
		return roomID;
	}
	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}
	public String getCreateOpenID() {
		return createOpenID;
	}
	public void setCreateOpenID(String createOpenID) {
		this.createOpenID = createOpenID;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(long joinTime) {
		this.joinTime = joinTime;
	}
	public long getTypeID() {
		return typeID;
	}
	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}
	
	
	
}

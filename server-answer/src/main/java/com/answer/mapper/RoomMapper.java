package com.answer.mapper;

import java.util.List;

import com.answer.domain.Room;

public interface RoomMapper {

	public int addRoom(Room room);

	public Room queryRoomById(long roomID);
	
	public int updateRoom(Room room);
	
	
	public List<Room> queryRoomByStatus(byte status);

}

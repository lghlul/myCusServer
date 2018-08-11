package com.answer.mapper;

import java.util.List;

import com.answer.domain.Question;
import com.answer.domain.RoomQuestion;

public interface RoomQuestionMapper {

	public int addRoomQuestion(RoomQuestion roomQuestion);

	public List<Question> selectQuestionByRoom(long roomID);
	
	public int updateQuestionByRoom(RoomQuestion roomQuestion);
	
	public List<RoomQuestion> selectAnswerByRoomID(long roomID);
}

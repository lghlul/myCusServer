package com.answer.domain;

import java.util.List;

public class Question {
	private long quesID;
	private String quesDesc;
	private String rightAnswerID;
	private long typeID;
	private byte quesType;
	private Byte isRight;
	private String answerID;
	private String quesExplain;

	public String getQuesExplain() {
		if(quesExplain == null){
			return "";
		}
		return quesExplain;
	}

	public void setQuesExplain(String quesExplain) {
		this.quesExplain = quesExplain;
	}

	public Byte getIsRight() {
		if(isRight == null){
			return 0;
		}
		return isRight;
	}

	public void setIsRight(Byte isRight) {
		this.isRight = isRight;
	}

	public byte getQuesType() {
		return quesType;
	}

	public void setQuesType(byte quesType) {
		this.quesType = quesType;
	}

	public long getTypeID() {
		return typeID;
	}

	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}

	private List<Answer> answerList;

	public long getQuesID() {
		return this.quesID;
	}

	public void setQuesID(long quesID) {
		this.quesID = quesID;
	}

	public String getQuesDesc() {
		return this.quesDesc;
	}

	public void setQuesDesc(String quesDesc) {
		this.quesDesc = quesDesc;
	}

	public List<Answer> getAnswerList() {
		return this.answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public String getRightAnswerID() {
		return rightAnswerID;
	}

	public void setRightAnswerID(String rightAnswerID) {
		this.rightAnswerID = rightAnswerID;
	}

	public String getAnswerID() {
		return answerID;
	}

	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
}

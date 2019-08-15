package com.answer.domain;

public class WXSessionCache {
	private String wxSession;
	private String openID;
	private String session_key;
	private String unionid;

	public String getWxSession() {
		return this.wxSession;
	}

	public void setWxSession(String wxSession) {
		this.wxSession = wxSession;
	}


	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getSession_key() {
		return this.session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionid() {
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}

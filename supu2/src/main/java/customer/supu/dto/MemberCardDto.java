package customer.supu.dto;

import java.util.Date;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.po.MemberCard;

public class MemberCardDto extends MemberCard{
	public boolean checked=false;

	public Date buytime;
	
	public String buyTimestr;
	
	public String expireTimeStr;
	
	public Date expireTime;

	private Integer memberid;

	//会员卡对应的时长   月份
	private Integer month;

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * 用户会员卡是否购买
	 */
	private boolean isbuy=false;


	/**
	 * 会员卡是否过期
	 */
	private boolean isoverdue;


	public boolean isIsoverdue() {
		return isoverdue;
	}

	public void setIsoverdue(boolean isoverdue) {
		this.isoverdue = isoverdue;
	}

	public boolean isIsbuy() {
		return isbuy;
	}

	public void setIsbuy(boolean isbuy) {
		this.isbuy = isbuy;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Date getBuytime() {
		return buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
		this.buyTimestr=DateTimeUtil.getCurrDateWithDir(buytime);
	}
	
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
		this.expireTimeStr=DateTimeUtil.getCurrDateWithDir(expireTime);
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getBuyTimestr() {
		return buyTimestr;
	}

	public void setBuyTimestr(String buyTimestr) {
		this.buyTimestr = buyTimestr;
	}

	public String getExpireTimeStr() {
		return expireTimeStr;
	}

	public void setExpireTimeStr(String expireTimeStr) {
		this.expireTimeStr = expireTimeStr;
	}
	
	

}

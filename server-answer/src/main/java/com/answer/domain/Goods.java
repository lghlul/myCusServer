package com.answer.domain;

public class Goods {

	private long goodsID;
	/**
	 * 图标
	 */
	private String goodsIcon;
	/**
	 * 大图
	 */
	private String goodsImg;
	/**
	 * 描述
	 */
	private String goodsDesc;
	/**
	 * 排序
	 */
	private int goodsSort;
	/**
	 * 所需积分
	 */
	private int goodsScore;
	/**
	 * 状态 1上架2下架
	 */
	private byte goodsStatus;
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	public long getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(long goodsID) {
		this.goodsID = goodsID;
	}
	public String getGoodsIcon() {
		return goodsIcon;
	}
	public void setGoodsIcon(String goodsIcon) {
		this.goodsIcon = goodsIcon;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public int getGoodsScore() {
		return goodsScore;
	}
	public void setGoodsScore(int goodsScore) {
		this.goodsScore = goodsScore;
	}
	public byte getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(byte goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsSort() {
		return goodsSort;
	}
	public void setGoodsSort(int goodsSort) {
		this.goodsSort = goodsSort;
	}
	
	
}

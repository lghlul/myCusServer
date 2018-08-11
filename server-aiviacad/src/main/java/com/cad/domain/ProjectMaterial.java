package com.cad.domain;

/**
 * 
 * @author Lu
 * @Description: 工程材料bean
 * @Package com.cad.domain
 * @date 2017年4月19日 下午10:18:19 
 * @version V1.0
 */
public class ProjectMaterial {
	
	/**
	 * 主键
	 */
	private int pm_id;
	/**
	 * 德国
	 */
	private String germany;
	/**
	 * 西班牙
	 */
	private String spain;
	/**
	 * 中国
	 */
	private String china;
	/**
	 * 美国
	 */
	private String usa;
	/**
	 * 墨西哥
	 */
	private String mexico;
	/**
	 * 印度
	 */
	private String india;
	/**
	 * 土耳其
	 */
	private String turkey;
	/**
	 * 渗碳
	 */
	private String carburize;
	/**
	 * 淬火
	 */
	private String quench;
	/**
	 * 渗氮
	 */
	private String nitriding;
	/**
	 * 百度百科
	 */
	private String baidubaike;
	public int getPm_id() {
		return pm_id;
	}
	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	public String getGermany() {
		return germany;
	}
	public void setGermany(String germany) {
		this.germany = germany;
	}
	public String getSpain() {
		return spain;
	}
	public void setSpain(String spain) {
		this.spain = spain;
	}
	public String getChina() {
		return china;
	}
	public void setChina(String china) {
		this.china = china;
	}
	public String getUsa() {
		return usa;
	}
	public void setUsa(String usa) {
		this.usa = usa;
	}
	public String getMexico() {
		return mexico;
	}
	public void setMexico(String mexico) {
		this.mexico = mexico;
	}
	public String getIndia() {
		return india;
	}
	public void setIndia(String india) {
		this.india = india;
	}
	public String getTurkey() {
		return turkey;
	}
	public void setTurkey(String turkey) {
		this.turkey = turkey;
	}
	public String getCarburize() {
		return carburize;
	}
	public void setCarburize(String carburize) {
		this.carburize = carburize;
	}
	public String getQuench() {
		return quench;
	}
	public void setQuench(String quench) {
		this.quench = quench;
	}
	public String getNitriding() {
		return nitriding;
	}
	public void setNitriding(String nitriding) {
		this.nitriding = nitriding;
	}
	public String getBaidubaike() {
		return baidubaike;
	}
	public void setBaidubaike(String baidubaike) {
		this.baidubaike = baidubaike;
	}
	@Override
	public String toString() {
		return "ProjectMaterial [pm_id=" + pm_id + ", germany=" + germany + ", spain=" + spain + ", china=" + china
				+ ", usa=" + usa + ", mexico=" + mexico + ", india=" + india + ", turkey=" + turkey + ", carburize="
				+ carburize + ", quench=" + quench + ", nitriding=" + nitriding + ", baidubaike=" + baidubaike + "]";
	}
	

}

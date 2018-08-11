package com.cad.domain;

/**
 * 
 * @author Lu
 * @Description: 气缸压力bean
 * @Package com.cad.domain
 * @date 2017年4月19日 下午10:17:47 
 * @version V1.0
 */
public class Pressure {
	/**
	 * 缸径
	 */
	private long bore_size;
	/**
	 * 方向类型 1 伸出  2 缩回
	 */
	private int direction_type;
	/**
	 * 压力
	 */
	private int pressure_size;
	/**
	 * 值
	 */
	private double pressure_value;

	public long getBore_size() {
		return this.bore_size;
	}

	public void setBore_size(long bore_size) {
		this.bore_size = bore_size;
	}

	public int getDirection_type() {
		return this.direction_type;
	}

	public void setDirection_type(int direction_type) {
		this.direction_type = direction_type;
	}

	public int getPressure_size() {
		return this.pressure_size;
	}

	public void setPressure_size(int pressure_size) {
		this.pressure_size = pressure_size;
	}

	public double getPressure_value() {
		return this.pressure_value;
	}

	public void setPressure_value(double pressure_value) {
		this.pressure_value = pressure_value;
	}

	@Override
	public String toString() {
		return "Pressure [bore_size=" + bore_size + ", direction_type=" + direction_type + ", pressure_size="
				+ pressure_size + ", pressure_value=" + pressure_value + "]";
	}
	
	
}
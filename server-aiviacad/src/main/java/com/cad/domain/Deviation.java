package com.cad.domain;

/**
 * 
 * @author Lu
 * @Description: 公差查询bean
 * @Package com.cad.domain
 * @date 2017年4月19日 下午10:17:29 
 * @version V1.0
 */
public class Deviation {
	/**
	 * 主键
	 */
	private String deviation_id;
	/**
	 * 尺寸类型
	 */
	private String size_type;
	/**
	 * 尺寸ID
	 */
	private String size_id;
	/**
	 * 尺寸大小
	 */
	private String size_value;
	/**
	 * 类型（孔或轴）
	 */
	private String deviation_type;
	/**
	 * 孔
	 */
	private String deviation_name;
	/**
	 * 偏差值1
	 */
	private String value_one;
	/**
	 * 偏差值2
	 */
	private String value_two;
	/**
	 * 尺寸为0时是否有值    0没有 1有
	 */
	private String have_zero;
	/**
	 * 是否常用 0 不是  1 是
	 */
	private String is_often;

	public String getIs_often() {
		return this.is_often;
	}

	public void setIs_often(String is_often) {
		this.is_often = is_often;
	}

	public String getDeviation_id() {
		return this.deviation_id;
	}

	public void setDeviation_id(String deviation_id) {
		this.deviation_id = deviation_id;
	}

	public String getSize_type() {
		return this.size_type;
	}

	public void setSize_type(String size_type) {
		this.size_type = size_type;
	}

	public String getSize_id() {
		return this.size_id;
	}

	public void setSize_id(String size_id) {
		this.size_id = size_id;
	}

	public String getDeviation_name() {
		return this.deviation_name;
	}

	public void setDeviation_name(String deviation_name) {
		this.deviation_name = deviation_name;
	}

	public String getValue_one() {
		return this.value_one;
	}

	public void setValue_one(String value_one) {
		this.value_one = value_one;
	}

	public String getValue_two() {
		return this.value_two;
	}

	public void setValue_two(String value_two) {
		this.value_two = value_two;
	}

	public String getDeviation_type() {
		return this.deviation_type;
	}

	public void setDeviation_type(String deviation_type) {
		this.deviation_type = deviation_type;
	}

	public String getSize_value() {
		return this.size_value;
	}

	public void setSize_value(String size_value) {
		this.size_value = size_value;
	}

	public String getHave_zero() {
		return this.have_zero;
	}

	public void setHave_zero(String have_zero) {
		this.have_zero = have_zero;
	}

	@Override
	public String toString() {
		return "Deviation [deviation_id=" + deviation_id + ", size_type=" + size_type + ", size_id=" + size_id
				+ ", size_value=" + size_value + ", deviation_type=" + deviation_type + ", deviation_name="
				+ deviation_name + ", value_one=" + value_one + ", value_two=" + value_two + ", have_zero=" + have_zero
				+ ", is_often=" + is_often + "]";
	}
	
	
}
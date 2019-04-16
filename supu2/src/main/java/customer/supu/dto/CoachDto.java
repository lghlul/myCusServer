package customer.supu.dto;

import customer.supu.common.utils.StringUtils;
import customer.supu.po.Coach;

public class CoachDto extends Coach{

	//善长
	private String strongpoint;
	//获取图片
	private String image;

	private boolean checked=false;

	//教练价格（根据私教课）
	private String courseAmount;

	/**
	 * 课程 私教价格
	 */
	private Integer price;
	/**
	 * 私教排序
	 */
	private Integer orderNum;

	private Integer commentCount;

	private Integer totalStar;

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getTotalStar() {
		return totalStar;
	}

	public void setTotalStar(Integer totalStar) {
		this.totalStar = totalStar;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getCourseAmount() {
		return courseAmount;
	}

	public void setCourseAmount(String courseAmount) {
		this.courseAmount = courseAmount;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getImage() {
		if(StringUtils.hasText(getCoachimg1())){
			return getCoachimg1();
		}else{
			if(StringUtils.hasText(getCoachimg2())){
				return getCoachimg2();
			}else{
				if(StringUtils.hasText(getCoachimg3())){
					return getCoachimg3();
				}else{
					if(StringUtils.hasText(getCoachimg4())){
						return getCoachimg4();
					}else{
						if(StringUtils.hasText(getCoachimg5())){
							return getCoachimg5();
						}
					}
				}
			}
		}
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStrongpoint() {
		return strongpoint;
	}

	public void setStrongpoint(String strongpoint) {
		this.strongpoint = strongpoint;
	}

}

package customer.supu.dto;

import customer.supu.common.utils.StringUtils;
import customer.supu.po.Store;

public class StoreDto extends Store{

	//所属区域
	private String area;

	private Integer storeId;




	//详细地址
	private String detailAddress;

	//手机位置与门店之间的距离  （米）
	private double distance=0.0;

	//门店经度
	private double lng;

	//门店纬度
	private double lat;

	//门店数量
	private Integer count;

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

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDetailAddress() {

		return detailAddress;
	}



	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}



	//是否选中
	private boolean checked=false;


	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}

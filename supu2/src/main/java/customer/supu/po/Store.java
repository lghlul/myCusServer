package customer.supu.po;

import java.math.BigDecimal;
import java.util.Date;

public class Store {
    private Integer id;

    private String storename;

    private String storeimg;

    private String province;

    private String city;

    private String region;

    private String address;

    private Integer status;

    private Date realsetime;

    private String realsepeople;

    private Date addtime;

    private String addpeople;
    
    private double latitude;
    
    private double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getStoreimg() {
        return storeimg;
    }

    public void setStoreimg(String storeimg) {
        this.storeimg = storeimg == null ? null : storeimg.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRealsetime() {
        return realsetime;
    }

    public void setRealsetime(Date realsetime) {
        this.realsetime = realsetime;
    }

    public String getRealsepeople() {
        return realsepeople;
    }

    public void setRealsepeople(String realsepeople) {
        this.realsepeople = realsepeople == null ? null : realsepeople.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAddpeople() {
        return addpeople;
    }

    public void setAddpeople(String addpeople) {
        this.addpeople = addpeople == null ? null : addpeople.trim();
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    
    
}
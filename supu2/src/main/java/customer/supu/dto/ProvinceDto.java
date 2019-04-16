package customer.supu.dto;

import java.util.List;

public class ProvinceDto {

	private String  name;

	private List<CityDto> cityList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CityDto> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityDto> cityList) {
		this.cityList = cityList;
	}

}

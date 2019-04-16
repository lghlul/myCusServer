package customer.supu.dto;

import java.util.List;

public class CityDto {
	private String name;

	private List<RegionDto> regionList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RegionDto> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<RegionDto> regionList) {
		this.regionList = regionList;
	}

}

package customer.supu.dto;

import java.util.List;

public class RegionDto {
	private String name;

	private List<StoreDto> storeList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StoreDto> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<StoreDto> storeList) {
		this.storeList = storeList;
	}

}

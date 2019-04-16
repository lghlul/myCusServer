package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.ZoneDto;
import customer.supu.mapper.ZoneMapper;

public interface ZoneDao extends ZoneMapper{
	//	<!-- 获取基础数据  和数据库value对比，并标记选中状态 -->
	public List<ZoneDto> selectZoneChecked(Map<String,Object> map);

}

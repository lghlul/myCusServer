package customer.supu.service;

import java.util.List;

import customer.supu.dto.ZoneDto;
import customer.supu.po.Zone;

public interface ZoneService {
	/**
	 * 根据 level 去除省市区
	 * 省：1   市 ：2    区：3
	 */

	public List<Zone> selectZoneList(Integer level) throws  Exception;

	/**
	 * 根据父类以及  等级查询
	 * @param parentCode
	 * @return
	 */
	public List<Zone> selectZoneByParentId(String parentCode,Integer level)throws  Exception;

	/**
	 * 根据编码  和等级确定   该市或者区有没有被选中
	 * @param zoneCode
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public List<ZoneDto> selectZoneChecked(String zoneCode,Integer level,String cityCode) throws  Exception;
}

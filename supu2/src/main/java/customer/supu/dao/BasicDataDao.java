package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.BasicDataCheckDto;
import customer.supu.dto.MemberCardDto;
import customer.supu.mapper.BasicDataMapper;
import customer.supu.po.BasicData;

public interface BasicDataDao extends BasicDataMapper{
	/**
	 * 获取基础数据  和数据库value对比，并标记选中状态
	 * @param map
	 * @return
	 */
	List<BasicDataCheckDto> selectBasicChecked(Map<String,Object> map);

	/**
	 * 获取基础数据最大basicvalue
	 */
	public BasicData selectMaxId(Map<String,Object> map);

}

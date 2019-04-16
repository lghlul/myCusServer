package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.OrderDto;
import customer.supu.mapper.OrderMapper;

public interface OrderDao extends OrderMapper{

	/**
	 * 查询所有
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<OrderDto> selectOrderByList(Map<String,Object> map) throws Exception;

	/**
	 * 查询总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer countByList(Map<String,Object> map) throws Exception;

}

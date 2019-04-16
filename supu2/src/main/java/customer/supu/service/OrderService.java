package customer.supu.service;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.OrderDto;

public interface OrderService {

	/**
	 * 根据条件查询所有订单
	 * @param page  分页参数
	 * @param orderDto
	 * @return
	 * @throws Exception
	 */
	public PageResponse selectAllByList(Page page, OrderDto orderDto) throws Exception;
}

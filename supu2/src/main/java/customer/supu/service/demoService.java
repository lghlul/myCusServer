package customer.supu.service;


import customer.supu.dto.DemoDto;

public interface demoService {
	/**
	 * 批量插入
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void insertCoachList(DemoDto demoDto) throws Exception;

}

package customer.supu.dao;


import java.util.Map;




public interface DemoDao{

	/**
	 * 批量插入
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void insertCoachList(Map<String,Object> map) throws Exception;


}

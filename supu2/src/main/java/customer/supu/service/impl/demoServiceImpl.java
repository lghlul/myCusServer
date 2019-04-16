package customer.supu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.dao.DemoDao;
import customer.supu.dto.DemoDto;
import customer.supu.service.demoService;

@Service
public class demoServiceImpl implements demoService{
	@Autowired
	private DemoDao demoDao;
	/**
	 * 批量插入
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public void insertCoachList(DemoDto demoDto) throws Exception {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list", demoDto.getCoachDtos());
		demoDao.insertCoachList(map);
	}

}

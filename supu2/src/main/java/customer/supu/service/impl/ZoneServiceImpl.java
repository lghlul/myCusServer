package customer.supu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.utils.StringUtils;
import customer.supu.dao.ZoneDao;
import customer.supu.dto.ZoneDto;
import customer.supu.po.Zone;
import customer.supu.po.ZoneExample;
import customer.supu.service.ZoneService;

@Service
public class ZoneServiceImpl implements ZoneService{
	@Autowired
	private ZoneDao zoneDao;

	/**
	 * 根据 level 去除省市区
	 * 省：1   市 ：2    区：3
	 */

	public List<Zone> selectZoneList(Integer level) throws  Exception{

		ZoneExample example=new ZoneExample();
		example.createCriteria().andLevelEqualTo(level);
		List<Zone> zoneList=zoneDao.selectByExample(example);
		return zoneList;

	}

	/**
	 * 根据父类以及  等级查询
	 * @param parentCode
	 * @return
	 */
	public List<Zone> selectZoneByParentId(String parentCode,Integer level)throws  Exception{
		ZoneExample example=new ZoneExample();

		//父类节点
		example.createCriteria().andParentcodeEqualTo(parentCode).andLevelEqualTo(level);

		List<Zone> zoneList=zoneDao.selectByExample(example);
		return zoneList;
	}


	/**
	 * 根据编码  和等级确定   该市或者区有没有被选中
	 * @param zoneCode
	 * @param level
	 *
	 * cityCode ：如果查询区是否被选中，需要传入市的code
	 * @return
	 * @throws Exception
	 */
	public List<ZoneDto> selectZoneChecked(String zoneCode,Integer level,String cityCode) throws  Exception{

			Map<String,Object> map=new HashMap<String,Object>();
			String[] value=null;
			 if(StringUtils.hasText(zoneCode)){
				    value=zoneCode.split("[,，]");

			   }else{//不传值，则默认-1，不选中状态
				   value=new String[]{"-1"};

			  }
			  map.put("zoneCodes", value);
			  map.put("level", level);
			  map.put("cityCode", cityCode);

			  return zoneDao.selectZoneChecked(map);

	}


}

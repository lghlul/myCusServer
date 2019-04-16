package customer.supu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.utils.StringUtils;
import customer.supu.dao.BasicDataDao;
import customer.supu.dto.BasicDataCheckDto;
import customer.supu.jenum.DataValidEnum;
import customer.supu.po.BasicData;
import customer.supu.po.BasicDataExample;
import customer.supu.service.BasicDataService;
/**
 * 基础数据业务实现类
 * @author
 *
 */
@Service
public class BasicDataServiceImpl implements BasicDataService{
	@Autowired
	private BasicDataDao basicdataDao;

	/**
	 * 根据  基础数据类型获取   基础数据
	 * @param basicType
	 * @return
	 * @throws Exception
	 */
	public List<BasicData> getBasicDataByType(String basicType) throws Exception {
		   BasicDataExample basicdataExample=new BasicDataExample();
		   basicdataExample.createCriteria().andBasictypeEqualTo(basicType).andFlagEqualTo(DataValidEnum.EFFECT.getCode());

		   //根据basicType查询基础数据
		   List<BasicData> basicDataList=basicdataDao.selectByExample(basicdataExample);

		   return basicDataList;
	}





	/**
	 * 根据基础数据的类型  和 基础数据的值  查询  title
	 * @param basictype
	 * @param basicvalue
	 * @return
	 */
	public String getTitleByTypeAndValue(String basictype,String basicvalue) throws Exception{

		BasicDataExample example=new BasicDataExample();
		example.createCriteria().andBasictypeEqualTo(basictype).andBasicvalueEqualTo(basicvalue).andFlagEqualTo(DataValidEnum.EFFECT.getCode());
		List<BasicData> l_basicData=basicdataDao.selectByExample(example);
		if(CollectionUtils.isNotEmpty(l_basicData)){
			return l_basicData.get(0).getTitle();
		}else{
			return null;
		}


	}


	/**
	 * 获取基础数据  和数据库value对比，并标记选中状态
	 * @param map
	 * @return
	 */
   public List<BasicDataCheckDto> selectBasicChecked(String basicType,String basicValue) throws Exception{
	   Map<String,Object> map=new HashMap<String,Object>();
	   if(StringUtils.hasText(basicValue)){
		   String[] value=basicValue.split("[,，]");

		   map.put("basicvalue", value);
	   }else{//不传值，则默认-1，不选中状态
		   String[] value=new String[]{"-1"};
		   map.put("basicvalue", value);
	   }
	   map.put("basictype", basicType);

	  return  basicdataDao.selectBasicChecked(map);

   }















}

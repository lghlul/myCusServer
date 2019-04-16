package customer.supu.service;

import java.util.List;

import customer.supu.dto.BasicDataCheckDto;
import customer.supu.po.BasicData;



/**
 * 基础数据业务接口
 * @author
 *
 */
public interface BasicDataService {
	/**
	 * 根据  基础数据类型获取   基础数据
	 * @param basicType
	 * @return
	 * @throws Exception
	 */
    public List<BasicData> getBasicDataByType(String basicType)throws Exception;




    /**
	 * 根据基础数据的类型  和 基础数据的值  查询  title
	 * @param basictype
	 * @param basicvalue
	 * @return
	 */
	public String getTitleByTypeAndValue(String basictype,String basicvalue) throws Exception;



	/**
	 * 获取基础数据  和数据库value对比，并标记选中状态
	 * @param map
	 * @return
	 */
   public List<BasicDataCheckDto> selectBasicChecked(String basicType,String basicValue) throws Exception;


}

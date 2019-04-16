package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.CityDto;
import customer.supu.dto.ProvinceDto;
import customer.supu.dto.RegionDto;
import customer.supu.dto.StoreDto;
import customer.supu.mapper.StoreMapper;
import customer.supu.po.Store;

public interface StoreDao extends StoreMapper{
	/**
	 * 批量改变咨询的状态
	 * @return
	 */
	List<Store> updateStoreByList(Map<String,Object> map);



	/**
	 * 查询省   根据省分类
	 * @param map
	 * @return
	 */
	public List<ProvinceDto> selectStoreGroupByProvince();

	/**
	 * 查询市   根据市分类
	 * @param map
	 * @return
	 */
	public List<CityDto> selectStoreGroupByCity(Map<String,Object> map);

	/**
	 * 查询区  根据区分类
	 * @param map
	 * @return
	 */
	public List<RegionDto> selectStoreGroupByRegion(Map<String,Object> map);


	/**
	 * 根据地区查询门店
	 * @param map
	 * @return
	 */
	public List<StoreDto> selectStoreByRegion(Map<String,Object> map);
	/**
	 * 查询所有门店
	 * @param map
	 * @return
	 */
	public List<StoreDto> selectAllStore(Map<String, Object> map);


	/**
	 * 查询所有门店数量
	 * @param map
	 * @return
	 */
	public Integer countByList(Map<String, Object> map);
	/**
	 * 根据门店id 课程id查询指定门店
	 * @param map
	 * @return
	 */
	public StoreDto selectStoreByStIdAndCoId(Map<String, Object> map);


	public List<Store>  selectStoreByMcardId(Map<String, Object> map);


	/**
	 * 根据课程id查询门店
	 * @param map   courseId  type:0私教课   1：团课
	 * @return
	 */
	public List<StoreDto> selectStoreByCourseId(Map<String, Object> map);


	/**
	 * 查询筹备中以及开业中的门店
	 * @param map
	 * @return
	 */
	public List<StoreDto> selectEffectAndPreStore(Map<String, Object> map);

}

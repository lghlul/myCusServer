package customer.supu.service;

import java.util.List;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.ProvinceDto;
import customer.supu.dto.StoreDto;

import customer.supu.po.Store;

/**
 * 门店管理业务类接口
 * @author
 *
 */
public interface StoreService {

	/**
	 * 查询所有门店
	 */
	public PageResponse selectAllByList(Page page,Store store) throws Exception;


	/**
	 * 添加保存
	 */
	public void addSave(Store store)throws Exception;


	/**
	 * 编辑保存
	 */
	public void editSave(Store store)throws Exception;


	/**
	 * 根据id获取门店信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Store selectStoreById(Integer id) throws Exception;
	/**
	 * 批量 开业,暂停,闭馆
	 */
	public void updateStoreByList(String idItems,int status) throws Exception;


	/**
	 * 获取  门店的省市区分类
	 * @return ids:添加的时候为null  编辑的时候表示 会员卡已经选中门店的id  集合
	 * @throws Exception
	 */
	public List<ProvinceDto> selectStoreByArea(String ids) throws Exception;

	/**
	 * 获取所有开业中的门店
	 * @return
	 */
	public List<Store> selectAllStore() throws Exception;



	/**
	 * 根据门店表 获取  课程id
	 * @param storeId 门店id
	 * @param type 0：表示私教课   1：表示精品团课
	 * @return
	 */
	public List<String> selectCourseByStoreId(Integer storeId,Integer type) throws Exception;

	/**
	 * 获取门店地址
	 * @param storeDtos
	 * @param lng 经度
	 * @param lat 纬度
	 * @return
	 */
	public List<StoreDto> getStoresDistance(List<StoreDto> storeDtos,double lng,double lat ) throws Exception;


	/**
	 * 根据门店id 课程id查询指定门店
	 * @param storeid  门店id
	 * @param courseid  课程id
	 * @return
	 */
	public StoreDto selectStoreByStIdAndCoId(Integer storeid,Integer courseid,Integer type)throws Exception;



	/**
	 * 根据会员卡id查询门店
	 * @param mCardId
	 * @return
	 * @throws Exception
	 */
	public List<Store> selectStoreByMcardId(Integer mCardId) throws Exception;

	/**
	 * 获取门店详细地址
	 */
	public String getdetailAddress(StoreDto storeDto)throws Exception;

	/**
	 * 根据课程id查出  门店    ，再计算距离
	 * @param lng
	 * @param lat
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public List<StoreDto> selectStoreByCourseIdDistance(double lng,double lat,Integer courseId) throws Exception;


	/**
	 * 根据是否开业查询门店
	 * status  门店状态
	 * @return
	 * @throws Exception
	 */
	public List<Store> selectOpendStore(Integer status) throws Exception;

}

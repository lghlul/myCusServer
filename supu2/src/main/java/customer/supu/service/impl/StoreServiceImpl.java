package customer.supu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.JavaListSoft;
import customer.supu.common.utils.MapOfDistanceUtil;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CourseStoresDao;
import customer.supu.dao.StoreDao;
import customer.supu.dto.CityDto;
import customer.supu.dto.ProvinceDto;
import customer.supu.dto.RegionDto;
import customer.supu.dto.StoreDto;
import customer.supu.jenum.CourseTypeEnum;
import customer.supu.jenum.DataValidEnum;
import customer.supu.jenum.StoreStatusEnum;
import customer.supu.po.CourseStores;
import customer.supu.po.CourseStoresExample;
import customer.supu.po.Store;
import customer.supu.po.StoreExample;
import customer.supu.po.StoreExample.Criteria;
import customer.supu.service.F_AboutClassService;
import customer.supu.service.StoreService;
/**
 * 门店管理业务实现类
 * @author Administrator
 *
 */
@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDao storeDao;



	@Autowired
	private CourseStoresDao courseStoresDao;

	@Autowired
	private F_AboutClassService f_AboutClassService;

	/**
	 * 查询所有门店
	 */
	@Override
	public PageResponse selectAllByList(Page page, Store store) throws Exception {
		PageResponse pageResponse=new PageResponse();
		//创建查询对象
		StoreExample example=new StoreExample();
		Criteria contion=example.createCriteria();
		//给查询条件赋值
		contion.andStatusNotEqualTo(StoreStatusEnum.DELETE.getCode());
		//如果门店名字不为空
		if (StringUtils.hasText(store.getStorename())) {
			contion.andStorenameLike("%"+store.getStorename()+"%");
		}
		//如果省不为空
		if (StringUtils.hasText(store.getProvince()) && !store.getProvince().equals("1")) {
			contion.andProvinceEqualTo(store.getProvince());
		}
		//如果市不为空
		if (StringUtils.hasText(store.getCity()) && !store.getCity().equals("1")) {
			contion.andCityEqualTo(store.getCity());
		}
		//如果区不为空
		if (StringUtils.hasText(store.getRegion()) && !store.getRegion().equals("1")) {
			contion.andRegionEqualTo(store.getRegion());
		}
		//如果状态不为空
		if (store.getStatus()!=null) {
			contion.andStatusEqualTo(store.getStatus());
		}
		//总数
		int count = storeDao.countByExample(example);
		//分页条件
		example.setLimitStart(Integer.valueOf(page.getOffset()));
		example.setLimitEnd(Integer.valueOf(page.getLimit()));
//		example.setOrderByClause("realseTime desc");

		List<Store> storesList=storeDao.selectByExample(example);
		//创建集合
		List<StoreDto> list=new ArrayList<StoreDto>();
		for (int i = 0; i < storesList.size(); i++) {
			Store stores=storesList.get(i);
			StoreDto dto=new StoreDto();
			dto.setId(stores.getId());
			dto.setArea(getArea(stores));
			dto.setStatus(stores.getStatus());
			dto.setStorename(stores.getStorename());
			list.add(dto);
		}
		pageResponse.setRecords(list);
		pageResponse.setTotal(count);
		return pageResponse;
	}


	/**
	 * 添加门店保存
	 */
	public void addSave(Store store) throws Exception {
		//store.setStatus(StoreStatusEnum.DELETE.getCode());
		store.setAddtime(new Date());

		//如果区为空 ，就插入市
		if(!StringUtils.hasText(store.getRegion())){
			store.setRegion(store.getCity());
		}
		storeDao.insertSelective(store);

	}

	/**
	 * 编辑门店保存
	 */
	public void editSave(Store store) throws Exception {
		if(store.getId() ==null  || store.getId() <=0){
			throw new Exception("数据不完整，无法修改");
		}
		Store beforeStore=storeDao.selectByPrimaryKey(store.getId());
		if(beforeStore ==null){
			throw new Exception("没有该数据或数据已经被删除，无法修改");
		}

		store.setAddtime(beforeStore.getAddtime());

		//如果区为空 ，就插入市
		if(!StringUtils.hasText(store.getRegion())){
			store.setRegion(store.getCity());
		}
		//更新时间
		store.setRealsetime(new Date());


		storeDao.updateByPrimaryKey(store);


	}

	/**
	 * 拼接所属区域
	 */
	public String getArea(Store store){
		StringBuffer stringBuffer=new StringBuffer();
		//判断省不为空
		if (StringUtils.hasText(store.getProvince())) {
			stringBuffer.append(store.getProvince());

		}
		//如果城市不为空
		if (StringUtils.hasText(store.getCity())) {
			stringBuffer.append("-"+store.getCity());

		}
		//如果区县不为空
		if (StringUtils.hasText(store.getRegion())) {
			stringBuffer.append("-"+store.getRegion());
		}
		return stringBuffer.toString();
	}

	/**
	 * 根据是否开业查询门店
	 * status  门店状态
	 * @return
	 * @throws Exception
	 */
	public List<Store> selectOpendStore(Integer status) throws Exception{
		StoreExample example=new StoreExample();
		//给查询条件赋值
		example.createCriteria().andStatusEqualTo(status);
		//查询
		List<Store> stores=storeDao.selectByExample(example);
		return stores;

	}


	/**
	 * 根据id获取门店信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Store selectStoreById(Integer id) throws Exception{
		return storeDao.selectByPrimaryKey(id);

	}

	/**
	 * 批量 开业,暂停,闭馆
	 */
	@Override
	public void updateStoreByList(String idItems,int status) throws Exception {
		//创建map
		Map<String,Object> map=new HashMap<String,Object>();
		//判断idItems不为空
		if (StringUtils.hasText(idItems)) {
			String[] ids=idItems.split(",");
			map.put("status", status);
			map.put("ids", ids);
		}else{
			map.put("ids", null);
		}
		storeDao.updateStoreByList(map);
	}


	/**
	 * 获取  门店的省市区分类
	 * @return ids:添加的时候为null   编辑的时候表示 会员卡已经选中门店的id  集合
	 * @throws Exception
	 */
	public List<ProvinceDto> selectStoreByArea(String ids) throws Exception{

		//查询省的分类
		List<ProvinceDto> prList=storeDao.selectStoreGroupByProvince();

		return selectCityByProvince(prList,ids);
	}


	/**
	 * 根据省获取市
	 * @param prList
	 * @return
	 */
	public List<ProvinceDto> selectCityByProvince(List<ProvinceDto> prList,String ids){
	//	List<CityDto> cList=new ArrayList<CityDto>();
		if(CollectionUtils.isNotEmpty(prList)){
			//遍历省
			for(int i=0;i<prList.size();i++){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("province", prList.get(i).getName());
				//根据省查询市区
				List<CityDto> cListByProvince=storeDao.selectStoreGroupByCity(map);

				//根据所得到的市查询区(就是把区的值加到   city里面，层层嵌套)
				List<CityDto> resultCityRegion=selectRegionByCity(cListByProvince, ids);


				prList.get(i).setCityList(resultCityRegion);
			}

		}

		return prList;
	}


	/**
	 * 根据市查询区
	 * @param cList
	 * @return
	 */
	public List<CityDto> selectRegionByCity(List<CityDto> cList,String ids){

		if(CollectionUtils.isNotEmpty(cList)){

			//遍历市
			for(int i=0;i<cList.size();i++){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("city", cList.get(i).getName());

				//根据市查询区
				List<RegionDto> regionList=storeDao.selectStoreGroupByRegion(map);


				List<RegionDto> resultReginList=this.selectStoreByRegion(regionList, ids);
				//将当前市的区   塞入当前的市中
				cList.get(i).setRegionList(resultReginList);

			}
		}
		return cList;
	}

	/**
	 *
	 * 根据区来查询  门店信息  并标记选中状态
	 * @param regionList
	 * @return
	 */
	public List<RegionDto> selectStoreByRegion(List<RegionDto> regionList,String ids){

		if(CollectionUtils.isNotEmpty(regionList)){

			//遍历区，根据区来确定区 下面  的   店面 以及标记选中状态
			for(int i=0;i<regionList.size();i++){
				Map<String,Object> map=new HashMap<String,Object>();

				//如果id不为空，表示 是编辑页面，需要看是不是以及选中某个门店
				if(StringUtils.hasText(ids)){
					map.put("ids",ids.split("[,，]"));
				}else{
					map.put("ids",new String[]{"-1"});
				}

				map.put("region", regionList.get(i).getName());


				List<StoreDto>  storeList=storeDao.selectStoreByRegion(map);
				regionList.get(i).setStoreList(storeList);
			}

		}
		return regionList;

	};

	/**
	 * 获取所有开业中的门店
	 * @return
	 */
	public List<Store> selectAllStore() throws Exception{
		StoreExample example=new StoreExample();
		example.createCriteria().andStatusEqualTo(StoreStatusEnum.BUSINESS.getCode());
		return storeDao.selectByExample(example);
	}


	/**
	 * 根据门店表 获取  课程id
	 * @param storeId 门店id
	 * @param type 0：表示私教课   1：表示精品团课
	 * @return
	 */
	public List<String> selectCourseByStoreId(Integer storeId,Integer type) throws Exception{
	    List<String> result_List=new ArrayList<String>();

		CourseStoresExample example=new CourseStoresExample();

		//根据 门店id  以及type查询课程id
		example.createCriteria().andStoreidEqualTo(storeId).andStatusEqualTo(DataValidEnum.EFFECT.getCode()).andTypeEqualTo(type);
	    List<CourseStores> courseList=	courseStoresDao.selectByExample(example);

	    //如果课程不为空
	    if(CollectionUtils.isNotEmpty(courseList)){
	    	for(int i=0;i<courseList.size();i++){
	    		//加载到list中
	    		result_List.add(courseList.get(i).getCourseid().toString());
	    	}

	    }else{
	    	result_List.add("-1");
	    }

	    return result_List;


	}


	/**
	 * 获取门店地址
	 * @param storeDtos
	 * @param lng 经度
	 * @param lat 纬度
	 * @return
	 */
	public List<StoreDto> getStoresDistance(List<StoreDto> storeDtos,double lng,double lat ) throws Exception{
		if(CollectionUtils.isNotEmpty(storeDtos) && lng!=0.0 && lat!=0.0){
		//循环获取所有门店
			for (int i = 0; i < storeDtos.size(); i++) {
				//创建map
				Map<String, BigDecimal> dismap=new HashMap<String,BigDecimal>();

				StoreDto storeDto=storeDtos.get(i);
				//经度纬度
				if(storeDto.getLatitude()==0||storeDto.getLongitude()==0){
					dismap=MapOfDistanceUtil.getLatAndLngByAddress(getdetailAddress(storeDto));
					storeDto.setLatitude(dismap.get("lat").doubleValue());
					storeDto.setLongitude(dismap.get("lng").doubleValue());
					storeDao.updateByPrimaryKeySelective(storeDto);
				}else{
					dismap.put("lat", new BigDecimal(storeDto.getLatitude()));
					dismap.put("lng", new BigDecimal(storeDto.getLongitude()));
				}
				//dismap=MapOfDistanceUtil.getLatAndLngByAddress(getdetailAddress(storeDto));
				//计算手机与门店之间距离
				double[] latAndLng=MapOfDistanceUtil.map_tx2bd(lat, lng);
				Double dis=MapOfDistanceUtil.distanceOfTwoPoints(dismap.get("lng").doubleValue(), dismap.get("lat").doubleValue(), latAndLng[1], latAndLng[0])/1000;
				//System.out.println(dis);
				//保留两位小数
	            BigDecimal bg = new BigDecimal(dis);
	            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				//放入对象中
				storeDto.setDistance(f1);
			}
			System.out.println(storeDtos.get(0).getStorename());
			Collections.sort(storeDtos, new Comparator<StoreDto>(){

				@Override
				public int compare(StoreDto storeDto1, StoreDto storeDto2) {
					// TODO Auto-generated method stub
					if(storeDto1.getStatus().compareTo(storeDto2.getStatus())==0){
						return new Double(storeDto1.getDistance()).compareTo(new Double(storeDto2.getDistance()));
					}else{
						return storeDto2.getStatus()-storeDto1.getStatus();
					}
				}
			});
			System.out.println(storeDtos.get(0).getStorename());
		}
		return storeDtos;


	}


	/**
	 * 获取门店详细地址
	 */
	public String getdetailAddress(StoreDto storeDto)throws Exception{

		StringBuffer buffer=new StringBuffer();
		if (StringUtils.hasText(storeDto.getProvince())) {
			buffer.append(storeDto.getProvince());
		}
		if (StringUtils.hasText(storeDto.getCity())) {
			buffer.append(storeDto.getCity());
		}
		if (StringUtils.hasText(storeDto.getRegion())) {
			buffer.append(storeDto.getCity());
		}
		if (StringUtils.hasText(storeDto.getAddress())) {
			buffer.append(storeDto.getAddress());
		}

		return buffer.toString();

	}
	/**
	 * 根据门店id 课程id查询指定门店
	 * @param storeid  门店id
	 * @param courseid  课程id
	 * @return
	 */
	public StoreDto selectStoreByStIdAndCoId(Integer storeid,Integer courseid,Integer type)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("storeid", storeid);
		map.put("courseid", courseid);
		map.put("type", type);
		return storeDao.selectStoreByStIdAndCoId(map);

	}

	/**
	 * 根据会员卡id查询门店
	 * @param mCardId
	 * @return
	 * @throws Exception
	 */
	public List<Store> selectStoreByMcardId(Integer mCardId) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();

		map.put("mCardId", mCardId);
		return storeDao.selectStoreByMcardId(map);

	}

	/**
	 * 根据课程id查出  门店    ，再计算距离
	 * @param lng
	 * @param lat
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public List<StoreDto> selectStoreByCourseIdDistance(double lng,double lat,Integer courseId) throws Exception{
		//创建map
			Map<String, Object> map=new HashMap<String,Object>();

			map.put("courseId", courseId);
			//私教课
			map.put("type", CourseTypeEnum.PRICOACH.getCode());

			//查询所有开业中的门店
			List<StoreDto> storeDtos= storeDao.selectStoreByCourseId(map);
			//循环获取所有门店


			//获取门店地址（距离）
			storeDtos=getStoresDistance(storeDtos, lng, lat);
			JavaListSoft<StoreDto> sortList=new JavaListSoft<StoreDto>();
			//给storeDtos排序
			sortList.sort(storeDtos, "distance", "asc");
			return storeDtos;
	}



}

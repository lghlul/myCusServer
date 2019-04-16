package customer.supu.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customer.supu.mapper.CommentMapper;
import org.apache.commons.collections.CollectionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.StringUtils;
import customer.supu.dao.CoachCertificateDao;
import customer.supu.dao.CoachDao;
/*import customer.supu.dao.CoachGoodatDao;*/
import customer.supu.dao.CoachServiceAreaDao;
import customer.supu.dao.CoachStoresDao;
import customer.supu.dto.CoachDto;
import customer.supu.dto.CoachEditNextDto;
import customer.supu.jenum.CoachStatusEnum;
import customer.supu.jenum.DataValidEnum;
import customer.supu.po.Coach;
import customer.supu.po.CoachCertificate;
import customer.supu.po.CoachCertificateExample;
import customer.supu.po.CoachExample;
/*import customer.supu.po.CoachGoodat;
import customer.supu.po.CoachGoodatExample;*/
import customer.supu.po.CoachServiceArea;
import customer.supu.po.CoachServiceAreaExample;
import customer.supu.po.CoachStores;
import customer.supu.po.CoachStoresExample;
import customer.supu.po.CoursePriCoach;
import customer.supu.po.MemberCard;
import customer.supu.po.MemberCardStore;
import customer.supu.po.MemberCardStoreExample;
import customer.supu.po.CoachExample.Criteria;

import customer.supu.service.BasicDataService;
import customer.supu.service.CoachService;

@Service
public class CoachServiceImpl implements CoachService{

	@Autowired
	private CoachDao coachDao;

	@Autowired
	private BasicDataService basicDataService;

	@Autowired
	private CoachServiceAreaDao coachServiceAreaDao;


/*	@Autowired
	private CoachGoodatDao coachGoodatDao;*/


	@Autowired
	private CoachStoresDao coachStoresDao;

	@Autowired
	private CoachCertificateDao coachCertificateDao;


	@Autowired
	private CommentMapper commentMapper;
	/**
	 * 查询所有教练
	 */
	@Override
	public PageResponse selectAllByList(Page page, Coach coach)
			throws Exception {
		PageResponse pageResponse=new PageResponse();
		//创建查询对象
		CoachExample example=new CoachExample();
		Criteria contion=example.createCriteria();
		//给查询条件赋值
		contion.andStatusEqualTo(DataValidEnum.EFFECT.getCode());

		//总数
		int count = coachDao.countByExample(example);
		//分页条件
		example.setLimitStart(Integer.valueOf(page.getOffset()));
		example.setLimitEnd(Integer.valueOf(page.getLimit()));


		List<Coach> membersList=coachDao.selectByExample(example);
		pageResponse.setRecords(membersList);
		pageResponse.setTotal(count);
		return pageResponse;
	}

	/**
	 * 添加  保存
	 */
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void addSave(Coach coach) throws Exception {

		coach.setStatus(DataValidEnum.EFFECT.getCode());
		coach.setAddtime(new Date());
		try{
			coachDao.insertSelective(coach);
		}catch(Exception e){
			e.printStackTrace();
		}

		//获取教练id
		Integer coachId=coach.getId();
		//添加教练擅长中间表
		//insertCoachGoodAt(coach.getGoodat(), coachId);

		//添加教练服务中间表
		insertCoachServiceArea(coach.getServicearea(), coachId);

		//添加教练门店中间表
		insertCoachStores(coach.getStores(), coachId);


	}


	/**
	 * 编辑保存
	 */
	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void editSave(Coach coach) throws Exception {
		if(coach.getId() ==null  || coach.getId() <=0){
			throw new Exception("数据不完整，无法修改");
		}
		Coach beforeCoach=coachDao.selectByPrimaryKey(coach.getId());
		if(beforeCoach ==null){
			throw new Exception("没有该数据或数据已经被删除，无法修改");
		}

		coach.setAddtime(beforeCoach.getAddtime());

		//身份证照
		if(StringUtils.hasText(beforeCoach.getFrontidnumber())){
			coach.setFrontidnumber(beforeCoach.getFrontidnumber());
		}
		if(StringUtils.hasText(beforeCoach.getReverseidnumber())){
			coach.setReverseidnumber(beforeCoach.getReverseidnumber());
		}



		//状态
		coach.setStatus(beforeCoach.getStatus());
		//更新时间
		coach.setRealsetime(new Date());

		coachDao.updateByPrimaryKeyWithBLOBs(coach);

		Integer coachId=coach.getId();

		//删除教练门店表
		deleteCoachStoresByCoachId(coachId);

		//删除教练擅长表
		//deleteGoodAtByCoachId(coachId);

		//删除教练服务区域表
		deleteServiceAreaByCoachId(coachId);



		//添加教练擅长中间表
		//insertCoachGoodAt(coach.getGoodat(), coachId);

		//添加教练服务中间表
		insertCoachServiceArea(coach.getServicearea(), coachId);

		//添加教练门店中间表
		insertCoachStores(coach.getStores(), coachId);


	}

	/**
	 * 根据id查询教练信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Coach selectZoneById(Integer id) throws  Exception{


		return coachDao.selectByPrimaryKey(id);

	}
	/**
	 * 获取所有教练
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CoachDto> selectCoachDtoByList(Page page,Coach coach) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", Integer.valueOf(page.getOffset()));
		map.put("end", Integer.valueOf(page.getLimit()));
		//判断名字或手机号不为空
		if (StringUtils.hasText(coach.getCoachname())) {
			map.put("coachname", coach.getCoachname());
		}
		//如果性别不为空
		if (coach.getSex()!=null) {
			map.put("sex", coach.getSex());
		}
		//如果状态不为空
		if (coach.getStatus()!=null) {
			map.put("status", new String[]{coach.getStatus().toString()});
		}else{
			map.put("status", new String[]{"1","2","3"});
		}
		//如果善长不为空
		if (StringUtils.hasText(coach.getGoodat())) {
			map.put("goodat", coach.getGoodat());
		}
		//如果门店不为空
		if (StringUtils.hasText(coach.getStores())) {
			map.put("store", Integer.parseInt(coach.getStores()));
		}
		List<CoachDto> coachlist=coachDao.selectCoachByList(map);

		return coachlist;
	}


	/**
	 * 改变教练状态
	 */
	@Override
	public void updateCoachStatus(Integer status,Integer id) throws Exception {
		//创建对象
		Coach coach=new Coach();
		//赋值
		coach.setStatus(status);
		coach.setId(id);
		//改变状态
		coachDao.updateByPrimaryKeySelective(coach);

	}

	/**
	 * 获取教练照片的个数
	 * @param coach
	 * @return
	 */
	public Integer selectImgCount(Coach coach) throws Exception{
		Integer count=0;
		if(StringUtils.hasText(coach.getCoachimg1())){
			count++;
		}
		if(StringUtils.hasText(coach.getCoachimg2())){
			count++;
		}
		if(StringUtils.hasText(coach.getCoachimg3())){
			count++;
		}
		if(StringUtils.hasText(coach.getCoachimg4())){
			count++;
		}
		if(StringUtils.hasText(coach.getCoachimg5())){
			count++;
		}
		return count;
	}

	/**
	 * 获取不为空的图片
	 */
/*	public void getIsNotEmptyImg(CoachDto coachDto) throws Exception{
		if(StringUtils.hasText(coachDto.getCoachimg1())){
			coachDto.setImage(coachDto.getCoachimg1());
		}else{
			if(StringUtils.hasText(coachDto.getCoachimg2())){
				coachDto.setImage(coachDto.getCoachimg2());
			}else{
				if(StringUtils.hasText(coachDto.getCoachimg3())){
					coachDto.setImage(coachDto.getCoachimg3());
				}else{
					if(StringUtils.hasText(coachDto.getCoachimg4())){
						coachDto.setImage(coachDto.getCoachimg4());
					}else{
						if(StringUtils.hasText(coachDto.getCoachimg5())){
							coachDto.setImage(coachDto.getCoachimg5());
						}
					}
				}
			}
		}
	}*/


	/**
	 * 获取所有合作中教练
	 * @return
	 * @throws Exception
	 */
	public List<Coach>  selectAllCoach() throws Exception{
		CoachExample example=new CoachExample();
		//合作中
		example.createCriteria().andStatusEqualTo(CoachStatusEnum.COOPERATION.getCode());
		return coachDao.selectByExample(example);

	}

	/**
	 * 获取所有合作中   教练人气王
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto>  selectAllPopularCoach() throws Exception{

		List<CoachDto> coachlist= coachDao.selectCoachIsPopular();
	/*	for(int i=0;i<coachlist.size();i++){
			getIsNotEmptyImg(coachlist.get(i));
		}*/



		return coachlist;

	}


	/**
	 * 根据教练id 删除教练门店表
	 * @param coachId
	 * @throws Exception
	 */
	public  void deleteCoachStoresByCoachId(Integer coachId) throws Exception{

		CoachStoresExample example=new CoachStoresExample();
		example.createCriteria().andCoachidEqualTo(coachId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		coachStoresDao.deleteByExample(example);
	}


	/**
	 * 插入  教练门店表
	 * @param stores
	 * @param coachId
	 * @throws Exception
	 */
	public void insertCoachStores(String  stores,Integer coachId) throws Exception{
		if(StringUtils.hasText(stores)){
			String[] ids=stores.split(",");
	    	//判断不为空
	    	if (ids!=null) {
	        	//循环插入中间表
	    		for (int i = 0; i < ids.length; i++) {
	    			CoachStores record=new CoachStores();
	    			record.setCoachid(coachId);
	    			record.setStoreid(Integer.valueOf(ids[i]));
	    			record.setStatus(DataValidEnum.EFFECT.getCode());
	    			coachStoresDao.insertSelective(record);

	    		}
	    	}
		}

	}

	/**
	 * 删除教练服务中间表
	 * @param coachId
	 * @throws Exception
	 */
	public void deleteServiceAreaByCoachId(Integer coachId) throws Exception{
		CoachServiceAreaExample example=new CoachServiceAreaExample();
		example.createCriteria().andCoachidEqualTo(coachId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		coachServiceAreaDao.deleteByExample(example);

	}


	/**
	 * 插入教练服务中间表
	 * @param coachServiceArea
	 * @param coachid
	 * @throws Exception
	 */
	public void insertCoachServiceArea(String coachServiceArea,Integer coachid)throws Exception{
		if(StringUtils.hasText(coachServiceArea)){
			String[] ids=coachServiceArea.split(",");
	    	//判断不为空
	    	if (ids!=null) {
	        	//循环插入中间表
	    		for (int i = 0; i < ids.length; i++) {
	    			CoachServiceArea record=new CoachServiceArea();
	    			record.setCoachid(coachid);
	    			record.setServiceareaid(Integer.valueOf(ids[i]));
	    			record.setStatus(DataValidEnum.EFFECT.getCode());
	    			coachServiceAreaDao.insertSelective(record);
	    		}
	    	}
		}

	}
	/**
	 * 根据教练id删除  教练和擅长的中间表
	 * @param coachId
	 * @throws Exception
	 */
/*	public void  deleteGoodAtByCoachId(Integer coachId) throws Exception{
		CoachGoodatExample example=new CoachGoodatExample();
		example.createCriteria().andCoachidEqualTo(coachId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		coachGoodatDao.deleteByExample(example);
	}*/


	/**
	 * 插入教练擅长的中间表
	 * @param goodat  1，2，3  教练擅长的id
	 * @param coachid  教练id
	 * @throws Exception
	 */
/*	public void insertCoachGoodAt(String goodat,Integer coachid)throws Exception{
		if(StringUtils.hasText(goodat)){
			String[] ids=goodat.split(",");
	    	//判断不为空
	    	if (ids!=null) {
	        	//循环插入中间表
	    		for (int i = 0; i < ids.length; i++) {
	    			CoachGoodat record=new CoachGoodat();
	    			record.setCoachid(coachid);
	    			record.setGooatid(Integer.valueOf(ids[i]));
	    			record.setStatus(DataValidEnum.EFFECT.getCode());
	    			coachGoodatDao.insertSelective(record);

	        	}
	        }
		}
	}*/

	/**
	 * 获取所有 的教练，并标记选中的教练
	 * @param coachId
	 * @return
	 */
	public List<CoachDto> selectCoachChecked (String coachIds) throws  Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtils.hasText(coachIds)){
			String[] coachId=coachIds.split("[,，]");
			if(null != coachId){
					map.put("ids", coachId);
			}else{
				map.put("ids", new String[]{"-1"});
			}
		}else{
			map.put("ids", new String[]{"-1"});
		}

		return coachDao.selectCoachChecked(map);

	}

	/**
	 * 根据主键id查询
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public Coach selectCoachById(Integer coachId)throws  Exception{

		return coachDao.selectByPrimaryKey(coachId);
	}


	/**
	 * 添加教练 第二步
	 * @param coachEditNextDto
	 * @throws Exception
	 */
	public void addNextSave(CoachEditNextDto coachEditNextDto)throws  Exception{
		if(coachEditNextDto.getId() ==null && coachEditNextDto.getId()<=0){
			throw new Exception("数据缺失");
		}

		//根据教练id更新身份照
		updCoachByCoachId(coachEditNextDto);

		//删除教练证书表
		//delCertificateByCoachId(coachEditNextDto.getId());


		//插入教练证书表
		insertCertificate(coachEditNextDto);
	}
	/**
	 * 保存教练编辑第二步
	 * @param coachEditNextDto
	 * @throws Exception
	 */
	public void editNextSave(CoachEditNextDto coachEditNextDto)throws  Exception{
		if(coachEditNextDto.getId() ==null && coachEditNextDto.getId()<=0){
			throw new Exception("数据缺失");
		}

		//根据教练id更新身份照
		updCoachByCoachId(coachEditNextDto);

		//删除教练证书表
		delCertificateByCoachId(coachEditNextDto.getId());


		//插入教练证书表
		insertCertificate(coachEditNextDto);
	}

	/**
	 * 根据教练id更新身份照
	 * @param coachEditNextDto
	 * @throws Exception
	 */
	public void updCoachByCoachId(CoachEditNextDto coachEditNextDto) throws Exception{
		Integer coachId=coachEditNextDto.getId();

		Coach coach=selectCoachById(coachId);
		if(coach !=null){
			//身份证正面照
			if(StringUtils.hasText(coachEditNextDto.getFrontidnumber())){
				coach.setFrontidnumber(coachEditNextDto.getFrontidnumber());
			}else{
				coach.setFrontidnumber("");
			}

			//身份照反面
			if(StringUtils.hasText(coachEditNextDto.getReverseidnumber())){
				coach.setReverseidnumber(coachEditNextDto.getReverseidnumber());
			}else{
				coach.setReverseidnumber("");
			}
			coachDao.updateByPrimaryKey(coach);
		}

	}


	/**
	 * 根据教练id删除证书
	 * @param coachId
	 */
	public void delCertificateByCoachId(Integer coachId){
		CoachCertificateExample example=new CoachCertificateExample();
		example.createCriteria().andCoachidEqualTo(coachId);
		coachCertificateDao.deleteByExample(example);
	}

	/**
	 * 插入教练证书表   数据
	 * @param coachEditNextDto
	 */
	public void insertCertificate(CoachEditNextDto coachEditNextDto){

		//教练id
		Integer coachId=coachEditNextDto.getId();
		List<CoachCertificate> certificateList=coachEditNextDto.getCoachCertificate();
		if(CollectionUtils.isNotEmpty(certificateList)){
			for(int i=0;i<certificateList.size();i++){

				CoachCertificate record=certificateList.get(i);
				//如果证书已经上传图片或者   有名字就插入数据
				if(StringUtils.hasText(record.getName()) ||StringUtils.hasText( record.getCertificateimg())){
					//教练id
					record.setCoachid(coachId);

					//有效
					record.setStatus(DataValidEnum.EFFECT.getCode());

					coachCertificateDao.insertSelective(record);
				}
			}

		}
	}

	/**
	 * 获取身份证照个数
	 * @param coach
	 * @return
	 * @throws Exception
	 */
	public Integer getIdNumberCount(Coach coach) throws Exception{
		Integer count=0;
		if(StringUtils.hasText(coach.getFrontidnumber())){
			count++;

		}
		if(StringUtils.hasText(coach.getFrontidnumber())){
			count ++;
		}

		return count;
	}

	/**
	 * 根据教练id查询证书
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public List<CoachCertificate> selectCertificateByCoachId(Integer coachId) throws Exception{
		CoachCertificateExample example=new CoachCertificateExample();
		example.createCriteria().andCoachidEqualTo(coachId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());
		return coachCertificateDao.selectByExample(example);

	}



	/**
	 * 前台异步获取教练
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoursePriCoach(Page page) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		//map.put("start", Integer.valueOf(page.getOffset()));
		//map.put("end", Integer.valueOf(page.getLimit()));
		return coachDao.selectAllCoach(map);


	}


	/**
	 * 根据教练id获取证书
	 * @param coachId
	 * @return
	 */
	public List<CoachCertificate>  selectCoachCertificateList(Integer coachId) throws Exception{
		CoachCertificateExample example=new CoachCertificateExample();

		//证书
		example.createCriteria().andCoachidEqualTo(coachId);
		return coachCertificateDao.selectByExample(example);

	}

	/**
	 * 根据教练id获取教练证书
	 * @param coachId
	 * @return
	 */
	public List<CoachCertificate> selectCoachCertificate(Integer coachId) throws Exception{
		CoachCertificateExample example=new CoachCertificateExample();
		//证书
		example.createCriteria().andCoachidEqualTo(coachId);

		return coachCertificateDao.selectByExample(example);
	}

	/**
	 * 根据id获取教练信息
	 */
	public CoachDto selectCoachByCoachId(Integer coachId) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("coachId", coachId);
		CoachDto coachDto = coachDao.selectCoachById(map);
		//评价来源标识：1私教课2团课3门店4私教
		Map<String, Object> stringObjectMap = commentMapper.selectCommentWithStartLevel(4, coachDto.getId());
		coachDto.setCommentCount(stringObjectMap.get("commentCount") == null ? 0 : Integer.parseInt(stringObjectMap.get("commentCount").toString()));
		coachDto.setTotalStar(stringObjectMap.get("totalStar") == null ? 0 : Integer.parseInt(stringObjectMap.get("totalStar").toString()));
		return coachDto;
	}

	/**
	 * 根据courseId获取教练信息
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoachByGroupId(Integer courseId,Integer type)throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("courseId", courseId);
		map.put("type", type);
		List<CoachDto> coachDtos=coachDao.selectGroupCoachById(map);
		return coachDtos;

	}


	@Override
	public List<CoachDto> queryCoach(int courseId, int type) {
		Map<String , Object> map = new HashMap<>();
		map.put("courseId",courseId);
		map.put("type",type);
		List<CoachDto> coachDtos = this.coachDao.queryCourseCoach(map);
		if(coachDtos.size() > 0){
			for(CoachDto coachDto : coachDtos){
				if(coachDto.getPrice() != null){
					coachDto.setChecked(true);
				}
			}
		}
		return coachDtos;
	}
}

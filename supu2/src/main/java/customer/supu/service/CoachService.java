package customer.supu.service;

import java.util.List;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.CoachDto;
import customer.supu.dto.CoachEditNextDto;
import customer.supu.po.Coach;
import customer.supu.po.CoachCertificate;


public interface CoachService {
	/**
	 * 查询所有会员卡
	 */
	public PageResponse selectAllByList(Page page, Coach coach) throws Exception;


	/**
	 * 添加保存
	 */
	public void addSave(Coach coach)throws Exception;


	/**
	 * 编辑保存
	 */
	public void editSave(Coach coach)throws Exception;



	/**
	 * 根据id查询教练信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Coach selectZoneById(Integer id) throws  Exception;

	/**
	 * 获取所有教练
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoachDtoByList(Page page,Coach coach) throws Exception ;

	/**
	 * 改变教练状态
	 */
	public void updateCoachStatus(Integer status,Integer id)throws Exception;


	/**
	 * 获取教练照片的个数
	 * @param coach
	 * @return
	 */
	public Integer selectImgCount(Coach coach) throws Exception;


	/**
	 * 获取所有合作中教练
	 * @return
	 * @throws Exception
	 */
	public List<Coach>  selectAllCoach() throws Exception;



	/**
	 * 获取所有 的教练，并标记选中的教练
	 * @param coachId
	 * @return
	 */
	public List<CoachDto> selectCoachChecked (String coachIds) throws  Exception;

	/**
	 * 根据主键id查询
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public Coach selectCoachById(Integer coachId)throws  Exception;


	/**
	 * 保存教练编辑第二步
	 * @param coachEditNextDto
	 * @throws Exception
	 */
	public void editNextSave(CoachEditNextDto coachEditNextDto)throws  Exception;

	/**
	 * 获取身份证照个数
	 * @param coach
	 * @return
	 * @throws Exception
	 */
	public Integer getIdNumberCount(Coach coach) throws Exception;

	/**
	 * 根据教练id查询证书
	 * @param coachId
	 * @return
	 * @throws Exception
	 */
	public List<CoachCertificate> selectCertificateByCoachId(Integer coachId) throws Exception;


	/**
	 * 添加教练 第二步
	 * @param coachEditNextDto
	 * @throws Exception
	 */
	public void addNextSave(CoachEditNextDto coachEditNextDto)throws  Exception;

	/**
	 * 获取所有合作中   教练人气王
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto>  selectAllPopularCoach() throws Exception;


	/**
	 * 前台异步获取教练
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoursePriCoach(Page page) throws Exception;

	/**
	 * 根据教练id获取证书
	 * @param coachId
	 * @return
	 */
	public List<CoachCertificate>  selectCoachCertificateList(Integer coachId) throws Exception;


	/**
	 * 根据教练id获取教练证书
	 * @param coachId
	 * @return
	 */
	public List<CoachCertificate> selectCoachCertificate(Integer coachId) throws Exception;

	/**
	 * 根据id获取教练信息
	 */
	public CoachDto selectCoachByCoachId(Integer coachId) throws Exception;
	/**
	 * 根据courseId获取教练信息
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	public List<CoachDto> selectCoachByGroupId(Integer courseId,Integer type)throws Exception;



	public List<CoachDto> queryCoach(int courseId , int type);


}

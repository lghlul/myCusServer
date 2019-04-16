package customer.supu.dao;

import java.util.List;
import java.util.Map;

import customer.supu.dto.MemberCardDto;
import customer.supu.mapper.MemberCardMapper;
import customer.supu.po.MemberCard;


public interface MemberCardDao extends MemberCardMapper{


	/**
	 * 根据会员里的会员卡id  查询该会员选择了哪些会员卡
	 * @param map
	 * @return
	 */
	public List<MemberCardDto> selectMcardChecked(Map<String,Object> map);

	/**
	 * 查询所有
	 */

	public List<MemberCard> selectMcardByList(Map<String,Object> map) throws Exception;


	/**
	 * 根据用户id查询会员卡，并标记该用户是否购买该会员卡
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<MemberCardDto> selectMcardByUserId(Map<String,Object> map)throws Exception;

	/**
	 * 	 查询会员卡信息，并且查出该会员卡  对应的过期月份
	 * @return
	 * @throws Exception
	 */

	public  MemberCardDto selectMcardInfo(Map<String,Object> map)throws Exception;

}

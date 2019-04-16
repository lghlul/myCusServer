package customer.supu.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.supu.dao.MemberCardDao;


import customer.supu.service.MemberMiddleCardService;

@Service
public class MemberMiddleCardServiceImpl implements MemberMiddleCardService{
/*	@Autowired
	private MemberMiddleCardDao memberMiddleCardDao;*/
	@Autowired
	private MemberCardDao memberCardDao;

	/**
	 * 根据会员id获取  该会员选中的会员卡
	 * @param memberId
	 * @return
	 */
/*	public List<MemberCardDto> selectMiddleByMemberId(Integer memberId) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",memberId);*/

		/*	memberMiddleCardExample example=new memberMiddleCardExample();

		example.createCriteria().andMemberidEqualTo(memberId).andStatusEqualTo(DataValidEnum.EFFECT.getCode());

		//获取该会员下的会员卡
		List<memberMiddleCard> middleList= memberMiddleCardDao.selectByExample(example);


		if(CollectionUtils.isNotEmpty(middleList)){

			Integer ids[]=new Integer[middleList.size()];
			//遍历中间表
			for(int i=0;i<middleList.size();i++){
				//
				memberMiddleCard middleCard=middleList.get(i);
				if(middleCard !=null){
					//将该用户拥有的会员卡id塞入数组中中
					ids[i]=middleCard.getMembercardid();

				}
			}

			map.put("ids", ids);
		}else{//用户选中的会员卡为空
			map.put("ids", new String[]{"-1"});
		}
*/

		//查询 选中的会员卡
	/*	List<MemberCardDto> resultMemberCard=memberCardDao.selectMcardChecked(map);

		return resultMemberCard;

	}*/

	/**
	 * 根据memberId 成员id删除中间表
	 * @param memberId
	 */
/*	public void deleteByMiddleMmberId(Integer memberId) throws Exception{
		memberMiddleCardExample example=new memberMiddleCardExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		memberMiddleCardDao.deleteByExample(example);

	}*/

}

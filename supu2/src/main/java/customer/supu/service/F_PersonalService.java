package customer.supu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import customer.supu.dto.MemberCardDto;
import customer.supu.po.Employee;

public interface F_PersonalService {
	/**
	 * 查询用户信息
	 * @return
	 * @param session
	 */
	public Employee selectEmployeeInfo(HttpSession session) throws Exception;


	/**
	 * 根据用户id查询会员卡，并标记是否购买
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<MemberCardDto>  selectMcardByUserId(HttpSession session) throws Exception;


	/**
	 * 用户开门
	 * @throws Exception
	 */
	public void  opendoor(HttpSession session,double lng,double lat) throws Exception;


	/**
	 * 判断该用户是否购买私教课
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public boolean isBuyPriCoach(HttpSession session) throws Exception;


	/**
	 * 根据手机和门店之间的距离，判断能否开门
	 * @param lng
	 * @param lat
	 * @throws Exception
	 */
	public String out_of_distance(double lng,double lat) throws Exception;


}

package customer.supu.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;

import customer.supu.jenum.ResultCodeEnum;

import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.MemberCard;
import customer.supu.po.Store;
import customer.supu.service.BasicDataService;
import customer.supu.service.MemberCardService;
import customer.supu.service.MemberMiddleCardService;
import customer.supu.service.MemberService;
import customer.supu.service.StoreService;

@Controller
@RequestMapping(value = "/user/member")
public class B_MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private BasicDataService basicDataService;

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private MemberMiddleCardService memberMiddleCardService;


	@Autowired
	private  StoreService storeService;



	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {
			//是否购买会员卡
			model.addAttribute("isBuyMemberCard", basicDataService.getBasicDataByType("isBuyMemberCard"));
			//会员状态
			model.addAttribute("memberStatus", basicDataService.getBasicDataByType("memberStatus"));
			//会员来源
			model.addAttribute("memberSource", basicDataService.getBasicDataByType("memberSource"));
			//获取所有开业中的门店
			model.addAttribute("storeList", storeService.selectAllStore());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/member/memberlist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getMemberList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getStoreList(Page page,EmployeeBuyCard employeeBuyCard){
		  try {
			  PageResponse employeeBuyCardList=memberService.selectAllByList(page, employeeBuyCard);

			  return employeeBuyCardList;

	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
	        return null;
	}



	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping(value="addPage",method=RequestMethod.GET)
	public String addPage(Model model){
		try {
			List<MemberCard>  memberCardList=memberCardService.selectMemberCardList();
			if (CollectionUtils.isNotEmpty(memberCardList)) {
				model.addAttribute("memberCardList",memberCardList);
			}
			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/member/add_member";
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Model model,EmployeeBuyCard employeeBuyCard){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			memberService.addSave(employeeBuyCard);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}



	/**
	 * 进入编辑页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="editPage",method=RequestMethod.GET)
	public String editPage(@RequestParam(value="id")Integer id,Model model){

		try {

			EmployeeBuyCard  member=memberService.selectMemberById(id);
			if(member ==null){
				return "/error/404";

			}
			//获取所有的会员卡
			model.addAttribute("memberCard", memberCardService.selectMemberCardList());

			//会员信息
			model.addAttribute("member", member);

			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(String.valueOf(member.getStoreid())));
			//会员卡id
			model.addAttribute("mCardId",member.getMcardid());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/member/edit_member";
	}


	/**
	 * 保存编辑页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSave(Model model,EmployeeBuyCard member){
		PageResponse response=new PageResponse();

		try {
			//保存编辑
			memberService.editSave(member);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;
	}

   /**
     * 进入详情页面
     * @param id
     * @param model
     * @return
     */
	@RequestMapping(value="detailPage",method=RequestMethod.GET)
	public String  detailPage(@RequestParam(value="id")Integer id,Model model){

		/*try {
			Member member=memberService.selectMemberById(id);
			if(member !=null){

				//获取用户选中的会员卡
				model.addAttribute("mCardChecked", memberMiddleCardService.selectMiddleByMemberId(member.getId()));
			}else{
				return "/error/404";
			}
			//获取会员卡号
			//String choosemcode=member.getChoosemcode();
			model.addAttribute("member", member);
			//获取 会员卡信息
			//model.addAttribute("mCardChecked", memberCardService.selectMemberCardByIds(choosemcode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {

			EmployeeBuyCard  member=memberService.selectMemberById(id);
			if(member ==null){
				return "/error/404";

			}
			//获取所有的会员卡
			model.addAttribute("memberCard", memberCardService.selectMemberCardList());

			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(String.valueOf(member.getStoreid())));

			//会员信息
			model.addAttribute("member", member);

			//会员卡id
			model.addAttribute("mCardId",member.getMcardid());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/member/detail_member";
	}



	@RequestMapping(value="/listErrorPage",method=RequestMethod.GET)
	public String listErrorPage(){
		return "/member/error_member_list";

	}


	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public PageResponse delete(Integer id){
		int i = memberService.delete(id);
		PageResponse response=new PageResponse();
		if(i > 0){
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		}else{
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
		return response;
	}

}

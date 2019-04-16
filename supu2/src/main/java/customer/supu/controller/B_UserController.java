package customer.supu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import customer.supu.common.utils.DateTimeUtil;
import customer.supu.domain.Activity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.examples.NewWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qimen.api.QimenClient;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;

import customer.supu.jenum.ResultCodeEnum;

import customer.supu.po.EmployeeBuyCard;
import customer.supu.po.MemberCard;
import customer.supu.po.Store;
import customer.supu.po.UserData;
import customer.supu.service.BasicDataService;
import customer.supu.service.MemberCardService;
import customer.supu.service.MemberMiddleCardService;
import customer.supu.service.MemberService;
import customer.supu.service.StoreService;
import customer.supu.service.UserService;

@Controller
@RequestMapping(value = "/user/xfuser")
public class B_UserController {

//	@Autowired
//	private MemberService memberService;
	@Autowired
	private UserService userService;

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
		return "/user/userlist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getuserList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getStoreList(Page page,EmployeeBuyCard employeeBuyCard){
		PageResponse employeeBuyCardList = null;
		  try {
			  employeeBuyCardList=userService.selectAllByList(page, employeeBuyCard);

	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
		  return employeeBuyCardList;
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
			userService.addSave(employeeBuyCard);

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
	public String editPage(@RequestParam(value="id")Integer id,Integer org,Model model){
		UserData  member = null;
		try {
			if(org != null && org<0) {//org小与0表示会员表中没有，是普通用户，去用户表去查询
				member=userService.selectuserById(id);//org小与0表示是普通用户中的ID
			
			}else {
				member=userService.selectvipById(org);//org大于0表示是VIP中的ID，到会员表中去查ID
			}
			if(member != null && member.getOrg().equals("0")) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date date = simpleDateFormat.parse("1970-01-01 08:00:00");
				member.setBuyTime(date);
				member.setExpireTime(date);
			}
			
			if(member ==null){
				return "/error/404";

			}
			//获取所有的会员卡
			model.addAttribute("memberCard", memberCardService.selectMemberCardList());

			//会员信息
			model.addAttribute("member", member);

			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(String.valueOf(member.getStoreId())));
			//会员卡id
			model.addAttribute("mCardId",member.getmCardId());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/user/edit_user";
	}


	/**
	 * 保存编辑页面
	 * @param store
	 * @return
	 */
	@Transactional
	@RequestMapping(value="editsaveuser",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editsaveuser(Model model,EmployeeBuyCard member){
		PageResponse response=new PageResponse();
		
		UserData  memberd = null;
//			if(member.getOrg() != null && (member.getOrg()).equals("0")) {
				try {
					userService.editsaveuser(member);//org=0表示用户表，是普通用户，今行用户表操作
					response.setResultCode(200);
				} catch (Exception e) {
					e.printStackTrace();
					response.setMessage(e.getMessage());
					response.setResultCode(ResultCodeEnum.FAIL.getCode());
				}
//			}else {
//				try {
//					userService.editsavevip(member);//保存为会员
//				} catch (Exception e) {
//					e.printStackTrace();
//					response.setMessage(e.getMessage());
//					response.setResultCode(ResultCodeEnum.FAIL.getCode());
//				}
//		try {
//			//保存编辑
//			userService.editSave(member);
//
//			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
//		} catch (Exception e) {
//			response.setMessage(e.getMessage());
//			response.setResultCode(ResultCodeEnum.FAIL.getCode());
//		}

		return response;
	}

	
	/**
	 * 保存编辑页面---更改为会员
	 * @param store
	 * @return
	 */
	
	
	@RequestMapping(value="editsavevip",method=RequestMethod.POST)
	@ResponseBody
	@Transactional
	public PageResponse editsavevip(Model model,EmployeeBuyCard member){
		PageResponse response=new PageResponse();
		UserData  memberd = null;
		try {
			userService.editsavevip(member);//保存为会员
			response.setResultCode(200);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}
//
//		try {
//			//保存编辑
//			userService.editSave(member);
//
//			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
//		} catch (Exception e) {
//			response.setMessage(e.getMessage());
//			response.setResultCode(ResultCodeEnum.FAIL.getCode());
//		}

		return response;
	}

	
	
   /**
     * 进入详情页面
     * @param id
     * @param model
     * @return
     */
	@RequestMapping(value="detailPage",method=RequestMethod.GET)
	public String  detailPage(@RequestParam(value="id")Integer id,Integer org,Model model){
		UserData  member = null;
		try {
			if(org != null && org<0) {//org小与0表示会员表中没有，是普通用户，去用户表去查询
				member=userService.selectuserById(id);//org小与0表示是普通用户中的ID
			
			}else {
				member=userService.selectvipById(org);//org大于0表示是VIP中的ID，到会员表中去查ID
			}
			if(member != null && member.getOrg().equals("0")) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date date = simpleDateFormat.parse("1970-01-01 08:00:00");
				member.setBuyTime(date);
				member.setExpireTime(date);
			}
			
			if(member ==null){
				return "/error/404";

			}
			//获取所有的会员卡
			model.addAttribute("memberCard", memberCardService.selectMemberCardList());

			//会员信息
			model.addAttribute("member", member);

			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(String.valueOf(member.getStoreId())));
			//会员卡id
			model.addAttribute("mCardId",member.getmCardId());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/user/detail_user";
	}



	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listErrorPage",method=RequestMethod.GET)
	public String listErrorPage(){
		return "/user/error_user_list";
	}


	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public PageResponse delete(Integer id){
		PageResponse response=new PageResponse();

		try{
			int i = userService.delete(id);
			if(i > 0){
				response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
			}else{
				response.setResultCode(ResultCodeEnum.FAIL.getCode());
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return response;
	}

}

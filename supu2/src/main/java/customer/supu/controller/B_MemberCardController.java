package customer.supu.controller;

import java.util.List;

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
import customer.supu.po.BasicData;

import customer.supu.po.MemberCard;
import customer.supu.po.Store;
import customer.supu.service.BasicDataService;
import customer.supu.service.MemberCardService;
import customer.supu.service.StoreService;

@Controller
@RequestMapping(value = "/user/memberCard")
public class B_MemberCardController {

	@Autowired
	private MemberCardService memberCardService;

	@Autowired
	private BasicDataService basicDataService;


	@Autowired
	private StoreService storeService;
	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {
			Page page=new Page();
			page.setLimit("9");
			page.setOffset("0");
			model.addAttribute("memberCard", memberCardService.selectAllByList(page));
			model.addAttribute("no_membercard", memberCardService.selectEnabledMemberCardList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/membercard/membercardlist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getMemberCardList",method = RequestMethod.GET)
	@ResponseBody
	public List<MemberCard> getStoreList(Page page){
		  try {
			  List<MemberCard> memberCardList=memberCardService.selectAllByList(page);

			  return memberCardList;

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
			//获取会员时长基础数据
			model.addAttribute("memberCardTimeLong",basicDataService.getBasicDataByType("memberCardTimeLong"));
			//获取会员卡类型基础数据

			model.addAttribute("memberCardType",basicDataService.getBasicDataByType("memberCardType"));

			//获取门店区域
			model.addAttribute("area", storeService.selectStoreByArea(null));

			//获取会员卡类型基础数据
			//model.addAttribute("memberStatus",basicDataService.getBasicDataByType("memberCardTimeLong"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/membercard/add_membercard";
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Model model,MemberCard memberCard){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			memberCardService.addSave(memberCard);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		//id=13;
		try {
			MemberCard memberCard=memberCardService.selecMemberCardInfoById(id);
			model.addAttribute("memberCard",memberCard);

			model.addAttribute("area", storeService.selectStoreByArea(memberCard.getStores()));
			//获取会员时长基础数据
			model.addAttribute("memberCardTimeLong",basicDataService.selectBasicChecked("memberCardTimeLong", memberCard.getTimelong().toString()));
			//获取会员卡类型基础数据
			model.addAttribute("memberCardType",basicDataService.selectBasicChecked("memberCardType", memberCard.getCardtype().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return "/membercard/edit_membercard";
	}


	/**
	 * 保存编辑页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSave(Model model,MemberCard memberCard){
		PageResponse response=new PageResponse();

		try {
			//保存编辑
			memberCardService.editSave(memberCard);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addMemberCardType",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addMemberCardType(Model model,String title){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			response.setTotal(memberCardService.insertMemberCardType("memberCardType",title));
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}

	/**
	 * 删除会员卡
	 */
	@RequestMapping(value="deleteCard",method=RequestMethod.GET)
	@ResponseBody
	public PageResponse deleteCard(Model model,@RequestParam(value="id")Integer id){
		PageResponse response=new PageResponse();
		try {
			//添加保存
			memberCardService.deleteCard(id);

			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		//id=13;
		try {
			MemberCard memberCard=memberCardService.selecMemberCardInfoById(id);
			model.addAttribute("memberCard",memberCard);

			model.addAttribute("area", storeService.selectStoreByArea(memberCard.getStores()));
			//获取会员时长基础数据
			model.addAttribute("memberCardTimeLong",basicDataService.selectBasicChecked("memberCardTimeLong", memberCard.getTimelong().toString()));
			//获取会员卡类型基础数据
			model.addAttribute("memberCardType",basicDataService.selectBasicChecked("memberCardType", memberCard.getCardtype().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/membercard/detail_membercard";
	}
}

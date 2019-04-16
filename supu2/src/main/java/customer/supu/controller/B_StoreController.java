package customer.supu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.swing.internal.plaf.basic.resources.basic;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.po.Store;
import customer.supu.service.BasicDataService;
import customer.supu.service.StoreService;

/**
 * 门店管理控制器
 * @author
 *
 */
@Controller
@RequestMapping("/user/store")
public class B_StoreController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private BasicDataService basicDataService;


	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {
			model.addAttribute("storeStatus", basicDataService.getBasicDataByType("storeStatus"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/store/storelist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getStoreList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getStoreList(Page page,Store store){
		  try {
			  PageResponse reslseInfoList=storeService.selectAllByList(page, store);

			  return reslseInfoList;

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
			model.addAttribute("storeStatus", basicDataService.getBasicDataByType("storeStatus"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/store/add_store";
	}

	/**
	 * 保存添加页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="addSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse addSave(Store store){
		PageResponse response=new PageResponse();
		try {
			storeService.addSave(store);
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
		try {
			Store store=storeService.selectStoreById(id);
			//根据id获取门店信息
			model.addAttribute("store",store);
			model.addAttribute("storeStatus", basicDataService.selectBasicChecked("storeStatus", store.getStatus().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/store/edit_store";
	}



	/**
	 * 保存编辑页面
	 * @param store
	 * @return
	 */
	@RequestMapping(value="editSave",method=RequestMethod.POST)
	@ResponseBody
	public PageResponse editSave(Store store){

		PageResponse response=new PageResponse();

		try {
			storeService.editSave(store);
			response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setResultCode(ResultCodeEnum.FAIL.getCode());
		}

		return response;

	}


	@RequestMapping(value="detailPage",method=RequestMethod.GET)
	public String  detailPage(@RequestParam(value="id")Integer id,Model model){

		try {
			//获取门户信息
			Store store=storeService.selectStoreById(id);
			model.addAttribute("store", store);
			//获取 门店的  状态
			model.addAttribute("basicdataChecked",basicDataService.selectBasicChecked("storeStatus", store.getStatus().toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/store/detail_store";
	}


	/**
	 * 待审  审核  下线  删除
	 */
	@RequestMapping(value="/changeStatusByList",method = RequestMethod.POST)
	@ResponseBody
	public PageResponse changeStatusByList(String idItems,int status){
		PageResponse pageResponse=new PageResponse();
		try {
			storeService.updateStoreByList(idItems, status);
			pageResponse.setResultCode(ResultCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResponse;
	}


	@RequestMapping(value="/a",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse a(){
		PageResponse pageResponse=new PageResponse();
		try {
			pageResponse.setRecords(storeService.selectStoreByArea(null));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageResponse;
	}
}

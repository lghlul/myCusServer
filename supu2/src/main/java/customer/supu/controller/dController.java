package customer.supu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import customer.supu.service.F_AboutClassService;
import customer.supu.service.StoreService;

import java.io.IOException;

@Controller
@RequestMapping(value="")
public class dController {
	@Autowired
	private F_AboutClassService f_AboutClassService;

	@Autowired
	private StoreService storeService;

	/**
	 * 进入约课页面
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void aboutclass(Model model, HttpServletRequest request, HttpServletResponse response) {
//		try {
//
//			//移动端 底端 样式
//			model.addAttribute("bottom", MobileBottomEnum.APPOINT.getCode());
//
//
//			//获取门店信息
//			List<Store> storeList= storeService.selectAllStore();
//			model.addAttribute("store",storeList);
//
//			//门店不为空
//			if(CollectionUtils.isNotEmpty(storeList)){
//
//				//查询精品团课  默认第一个门店id，
//				//model.addAttribute("courseExcGroup", f_AboutClassService.selectCourseExcGroup(storeList.get(0).getId(), null, null));
//				//日期按钮
//				model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());
//			}
//			model.addAttribute("weekAndDate", f_AboutClassService.getDateAndWeek());
//
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		try {
			response.sendRedirect(request.getContextPath() + "/wx/wxLogin");
		} catch (IOException e) {
			e.printStackTrace();
		}
//        //return "outside/aboutclass/noclass";
//	 //   return "outside/aboutclass/aboutclasslist";
//	//	return "outside/login/index";
//        return null;
//    }

	}
}

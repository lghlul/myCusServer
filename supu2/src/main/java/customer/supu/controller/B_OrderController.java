package customer.supu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import customer.supu.common.po.Page;
import customer.supu.common.po.PageResponse;
import customer.supu.dto.OrderDto;
import customer.supu.service.OrderService;

@Controller
@RequestMapping("/user/order")
public class B_OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 进入页面
	 * @return
	 */
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(Model model){
		try {
//			model.addAttribute("storeStatus", basicDataService.getBasicDataByType("storeStatus"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/order/orderlist";

	}

	/**
	 * 异步获取列表数据
	 */
	@RequestMapping(value="/getOrderList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getStoreList(Page page,OrderDto orderDto){
		  try {
			  PageResponse orderList=orderService.selectAllByList(page, orderDto);

			  return orderList;

	        } catch (Exception e) {

	        	e.printStackTrace();
	        }
	        return null;
	}
}

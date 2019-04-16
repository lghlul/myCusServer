package customer.supu.controller;

import customer.supu.common.po.PageResponse;
import customer.supu.common.utils.DateTimeUtil;
import customer.supu.domain.Activity;
import customer.supu.domain.LotteryRecord;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/activity")
public class B_ActivityController {

	@Autowired
	private IActivityService activityService;


    @Autowired
    private ILotteryRecordService lotteryRecordService;


	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public String listPge(){
		return "/activity/list";
	}

	@RequestMapping(value="/getActivityList",method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getActivityList(Activity activity){
		PageResponse response = activityService.selectAllByList(activity);
		return response;
	}

    @RequestMapping(value="/toAdd",method=RequestMethod.GET)
    public String toAdd(){
        return "/activity/add";
    }

    @ResponseBody
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public PageResponse add(Activity activity){
        activity.setStartDate(DateTimeUtil.getTimestamp(activity.getStartDate()) + "");
        activity.setEndDate(DateTimeUtil.getTimestamp(activity.getEndDate()) + "");
        int i = activityService.add(activity);
        PageResponse response=new PageResponse();
        if(i > 0){
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        }else{
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }


    @RequestMapping(value="/recordListPge",method=RequestMethod.GET)
    public String recordListPge(Integer activityId , Model model){
       /* PrizeStore prizeStore = new PrizeStore();
        prizeStore.setActivityId(activityId);
        List<PrizeStore> list = prizeStoreService.queryAll(prizeStore);
        model.addAttribute("list" , list);*/
        model.addAttribute("activityId",activityId);
        return "/activity/recordList";
    }

    @RequestMapping(value="/getRecordList",method = RequestMethod.GET)
    @ResponseBody
    public PageResponse getRecordList(String activityId , Integer offset , Integer limit , String mobilePhone , String status ){
        Map<String , Object> map = new HashMap<>();
        map.put("activityId",activityId);
        map.put("offset",offset);
        map.put("limit",limit);
        map.put("mobilePhone",mobilePhone);
        map.put("status",status);
        PageResponse response = activityService.queryRecordList(map);
        return response;
    }


    @ResponseBody
    @RequestMapping(value="/updateRecord",method=RequestMethod.POST)
    public PageResponse updateRecord(LotteryRecord lotteryRecord){
        int i = lotteryRecordService.edit(lotteryRecord);
        PageResponse response=new PageResponse();
        if(i > 0){
            response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        }else{
            response.setResultCode(ResultCodeEnum.FAIL.getCode());
        }
        return response;
    }
}

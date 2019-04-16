package customer.supu.controller;

import com.alibaba.fastjson.JSON;
import customer.supu.common.po.PageResponse;
import customer.supu.domain.Activity;
import customer.supu.jenum.ResultCodeEnum;
import customer.supu.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/outside/activity")
public class F_ActivityController {

	@Autowired
	private IActivityService activityService;


	@ResponseBody
	@RequestMapping(value="/getActivityWithPrize" , method = RequestMethod.GET ,produces = "application/json;charset=utf-8")
	public String getActivityWithPrize(String activityId , String openId){
        Activity activity = activityService.queryActivityWithPrize(activityId , openId);
        PageResponse response=new PageResponse();
        response.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        response.setRecords(activity);
        return JSON.toJSONString(response);
    }


    @ResponseBody
    @RequestMapping(value="/joinActivity", method = RequestMethod.POST ,produces = "application/json;charset=utf-8")
    public String joinActivity(String activityId, String openId){
        PageResponse response = activityService.joinActivity(openId, activityId);
        return JSON.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value="/getMyPrize", method = RequestMethod.GET ,produces = "application/json;charset=utf-8")
    public String getMyPrize(String activityId, String openId){
        PageResponse response = activityService.queryMyPrize(openId, activityId);
        return JSON.toJSONString(response);
    }

    @RequestMapping(value="/prize", method = RequestMethod.GET ,produces = "application/json;charset=utf-8")
    public String prize(String activityId, String openId){
       return "outside/activity/prize";
    }
}

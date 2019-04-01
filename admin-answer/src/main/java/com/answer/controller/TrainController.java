package com.answer.controller;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.TrainConfig;
import com.answer.service.ITrainConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 账号管理
 * 
 * @author chenyagang
 * 
 */
@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    ITrainConfigService trainConfigService;

    @GetMapping("configList")
    public Object configList(){
        List<TrainConfig> trainConfigs = trainConfigService.queryPage(null);
        if(trainConfigs != null && trainConfigs.size() > 0){
            for(TrainConfig trainConfig : trainConfigs){
                if(trainConfig.getTypeID() == 0){
                    trainConfig.setTypeName("全部类型");
                    break;
                }
            }
        }
        return ResultCodeEnum.SUCCESS.getResponse(trainConfigs);
    }

    @PostMapping("updateConfig")
    public Object updateConfig(TrainConfig trainConfig){
        trainConfigService.edit(trainConfig);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

}

package com.answer.controller;

import com.alibaba.fastjson.JSON;
import com.answer.CacheHelper;
import com.answer.common.CommonConstant;
import com.answer.common.ResultCodeEnum;
import com.answer.domain.*;
import com.answer.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 11:36
 * @Modified By：
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private IConfigService configService;

    @Autowired
    private CacheHelper cacheHelper;

    @GetMapping("readTrainConfig")
    public Object readTrainConfig(){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.TRAIN_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.TRAIN_CONFIG);
        TrainConfig trainConfig = JSON.parseObject(config.getConfigValue(), TrainConfig.class);
        return ResultCodeEnum.SUCCESS.getResponse(trainConfig);
    }

    @PostMapping("updateTrainConfig")
    public Object updateTrainConfig(TrainConfig trainConfig){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.TRAIN_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.TRAIN_CONFIG);
        config.setConfigValue(JSON.toJSONString(trainConfig));
        configService.edit(config);
        cacheHelper.delete(CommonConstant.ConfigKey.TRAIN_CONFIG);

        return ResultCodeEnum.SUCCESS.getResponse();
    }



    @GetMapping("readPractiseConfig")
    public Object readPractiseConfig(){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.PRACTISE_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.PRACTISE_CONFIG);
        PractiseConfig practiseConfig = JSON.parseObject(config.getConfigValue(), PractiseConfig.class);
        return ResultCodeEnum.SUCCESS.getResponse(practiseConfig);
    }

    @PostMapping("updatePractiseConfig")
    public Object updateTrainConfig(PractiseConfig practiseConfig){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.PRACTISE_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.PRACTISE_CONFIG);
        config.setConfigValue(JSON.toJSONString(practiseConfig));
        configService.edit(config);
        cacheHelper.delete(CommonConstant.ConfigKey.PRACTISE_CONFIG);
        return ResultCodeEnum.SUCCESS.getResponse();
    }



    @GetMapping("readSignConfig")
    public Object readSignConfig(){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.SIGN_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.SIGN_CONFIG);
        SignConfig signConfig = JSON.parseObject(config.getConfigValue(), SignConfig.class);
        return ResultCodeEnum.SUCCESS.getResponse(signConfig);
    }

    @PostMapping("updateSignConfig")
    public Object updateSignConfig(SignConfig signConfig){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.SIGN_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.SIGN_CONFIG);
        config.setConfigValue(JSON.toJSONString(signConfig));
        configService.edit(config);
        cacheHelper.delete(CommonConstant.ConfigKey.SIGN_CONFIG);
        return ResultCodeEnum.SUCCESS.getResponse();
    }




    @GetMapping("readBattleConfig")
    public Object readBattleConfig(){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.BATTLE_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.BATTLE_CONFIG);
        BattleConfig battleConfig = JSON.parseObject(config.getConfigValue(), BattleConfig.class);
        return ResultCodeEnum.SUCCESS.getResponse(battleConfig);
    }

    @PostMapping("updateBattleConfig")
    public Object updateBattleConfig(BattleConfig battleConfig){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.BATTLE_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.BATTLE_CONFIG);
        config.setConfigValue(JSON.toJSONString(battleConfig));
        configService.edit(config);
        cacheHelper.delete(CommonConstant.ConfigKey.BATTLE_CONFIG);
        return ResultCodeEnum.SUCCESS.getResponse();
    }



    @GetMapping("readGoodsConfig")
    public Object readGoodsConfig(){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.GOODS_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.GOODS_CONFIG);
        GoodsConfig goodsConfig = JSON.parseObject(config.getConfigValue(), GoodsConfig.class);
        return ResultCodeEnum.SUCCESS.getResponse(goodsConfig);
    }

    @PostMapping("updateGoodsConfig")
    public Object updateGoodsConfig(GoodsConfig goodsConfig){
        //Config config = configService.readByKey(CommonConstant.ConfigKey.GOODS_CONFIG);
        Config config = cacheHelper.getConfig(CommonConstant.ConfigKey.GOODS_CONFIG);
        config.setConfigValue(JSON.toJSONString(goodsConfig));
        configService.edit(config);
        cacheHelper.delete(CommonConstant.ConfigKey.GOODS_CONFIG);
        return ResultCodeEnum.SUCCESS.getResponse();
    }

}

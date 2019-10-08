package com.answer;

import com.alibaba.fastjson.JSON;
import com.answer.common.CommonConstant;
import com.answer.domain.*;
import com.answer.mapper.TConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/5/15 14:48
 * @Modified By：
 */
@Component
public class InitHelper {

    @Autowired
    private TConfigMapper configMapper;

    @PostConstruct
    public void init(){
        initTrainConfig();
        initPractiseConfig();
        initSignConfig();
        initBattleConfig();
        initGoodsConfig();
    }


    private void initTrainConfig (){
        Config config = configMapper.readByKey(CommonConstant.ConfigKey.TRAIN_CONFIG);
        if(config == null){
            config = new Config();
            config.setConfigKey(CommonConstant.ConfigKey.TRAIN_CONFIG);
            TrainConfig trainConfig = new TrainConfig();
            trainConfig.setQuesNum(100);
            trainConfig.setRightNum(100);
            trainConfig.setTypeID(0L);
            trainConfig.setScore(0F);
            trainConfig.setTrainTime(500L);
            config.setConfigValue(JSON.toJSONString(trainConfig));
            configMapper.insert(config);
        }
    }

    private void initPractiseConfig (){
        Config config = configMapper.readByKey(CommonConstant.ConfigKey.PRACTICE_CONFIG);
        if(config == null){
            config = new Config();
            config.setConfigKey(CommonConstant.ConfigKey.PRACTICE_CONFIG);
            PractiseConfig practiseConfig = new PractiseConfig();
            practiseConfig.setQuesNum(100);
            practiseConfig.setScore(0F);
            config.setConfigValue(JSON.toJSONString(practiseConfig));
            configMapper.insert(config);
        }
    }

    private void initSignConfig (){
        Config config = configMapper.readByKey(CommonConstant.ConfigKey.SIGN_CONFIG);
        if(config == null){
            config = new Config();
            config.setConfigKey(CommonConstant.ConfigKey.SIGN_CONFIG);
            SignConfig signConfig = new SignConfig();
            signConfig.setScore(0.1F);
            config.setConfigValue(JSON.toJSONString(signConfig));
            configMapper.insert(config);
        }
    }


    private void initBattleConfig (){
        Config config = configMapper.readByKey(CommonConstant.ConfigKey.BATTLE_CONFIG);
        if(config == null){
            config = new Config();
            config.setConfigKey(CommonConstant.ConfigKey.BATTLE_CONFIG);
            BattleConfig battleConfig = new BattleConfig();
            battleConfig.setScore(10F);
            config.setConfigValue(JSON.toJSONString(battleConfig));
            configMapper.insert(config);
        }
    }

    private void initGoodsConfig (){
        Config config = configMapper.readByKey(CommonConstant.ConfigKey.GOODS_CONFIG);
        if(config == null){
            config = new Config();
            config.setConfigKey(CommonConstant.ConfigKey.GOODS_CONFIG);
            GoodsConfig goodsConfig = new GoodsConfig();
            //默认开启
            goodsConfig.setExchangeEnable((byte)1);
            config.setConfigValue(JSON.toJSONString(goodsConfig));
            configMapper.insert(config);
        }
    }

}

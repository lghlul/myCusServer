package com.answer.thread;

import com.answer.domain.Train;
import com.answer.mapper.TrainMapper;
import com.answer.utils.Constant;
import com.answer.utils.Log4jUtil;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/3/27 9:08
 * @Modified By：
 */
public class TrainThread extends Thread{


    private TrainMapper trainMapper;


    private Long trainID;

    private Long trainTime;

    public TrainThread(TrainMapper trainMapper , Long trainID , Long trainTime){
        this.trainMapper = trainMapper;
        this.trainID = trainID;
        this.trainTime = trainTime;
    }

    @Override
    public void run() {
        Log4jUtil.info("TrainThread start...trainID = " + trainID);
        try{
            Thread.sleep(trainTime * 1000);
            Train train = new Train();
            train.setFinishTime(System.currentTimeMillis());
            train.setRightNum(0);
            train.setTrainStatus(Constant.TRAIN_STATUS_FINISH);
            train.setTrainID(trainID);
            trainMapper.update(train);
        }catch (Exception e){
            Log4jUtil.info("TrainThread interrupt...trainID = " + trainID);
        }
    }
}

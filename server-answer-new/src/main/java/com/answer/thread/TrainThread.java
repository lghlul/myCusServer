package com.answer.thread;

import com.answer.domain.Train;
import com.answer.mapper.TrainMapper;
import com.answer.utils.Constant;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/3/27 9:08
 * @Modified By：
 */
public class TrainThread extends Thread{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TrainThread.class);

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
        logger.info("TrainThread start...trainID = " + trainID);
        try{
            Thread.sleep(trainTime * 1000);
            Train train = new Train();
            train.setFinishTime(System.currentTimeMillis());
            train.setRightNum(0);
            train.setTrainStatus(Constant.TRAIN_STATUS_FINISH);
            train.setTrainID(trainID);
            trainMapper.update(train);
        }catch (Exception e){
            logger.info("TrainThread interrupt...trainID = " + trainID);
        }
    }
}

package com.answer.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/3/27 9:17
 * @Modified By：
 */
public class ThreadCache {

    private static Map<Long, TrainThread> threadMap = new HashMap<>();

    public static void put(Long trainID, TrainThread trainThread) {
        threadMap.put(trainID, trainThread);
    }

    public static TrainThread get(Long trainID) {
        return threadMap.get(trainID);
    }


    public static void remove(Long trainID){
        threadMap.remove(trainID);
    }
}

package com.answer.utils;

public interface Constant {

    Integer JOIN_ACTIVITY = 1;

    Integer UN_JOIN_ACTIVITY = 2;

    byte ANSWER_RIGHT = 1;

    byte ANSWER_WRONG = 2;

    byte ACTIVITY_UN_START = 1;
    byte ACTIVITY_START = 2;
    byte ACTIVITY_FINIFSH = 3;

    /**
     * 错题删除状态
     */
    byte DEL_STATUS = 2;
    /**
     * 可用正常状态的工号
     */
    byte JOBNUM_UNUSER = 1;
    /**
     * 不可用状态的工号
     */
    byte JOBNUM_USELESS = 2;

    /**
     * 对战房间没有计分
     */
    byte ROOM_STATUS_NOT_COUNT = 1;
    /**
     * 对战房间已经计分
     */
    byte ROOM_STATUS_COUNT = 2;


    /**
     * 考试练习未结束
     */
    byte TRAIN_STATUS_UN_FINISH = 1;

    /**
     * 考试练习结束
     */
    byte TRAIN_STATUS_FINISH = 2;

    interface returnCode {
        /**
         * 没有绑定工号
         */
        int NO_JOBNUM = 10001;


        /**
         * 无效工号 或者已被绑定
         */
        int USELESS_JOBNUM = 10002;
        /**
         * 每天最多绑定3次  明日再试
         */
        int BIND_OVER_THREE = 10003;

        /**
         * 不能重复绑定
         */
        int NO_BIND_REPEAT = 10004;

        /**
         * 练习模式结束
         */
        int QUES_FINISH = 10005;

        /**
         * 无效session(重新登录)
         */
        int SESSOIN_TIMEOUT = 10000;
        /**
         * 无效code
         */
        int CODE_NOT_USE = 40029;
        /**
         * 服务器异常
         */
        int SERVER_EXCEPTION = -1;
        /**
         * 签到失败
         */
        int SIGN_FAIL = 9999;
        /**
         * 操作失败  不是本人错题
         */
        int OPER_FAIL = 9998;

        /**
         * 不存在 查无此数据
         */
        int NOT_EXIST = 9997;


        /**
         * 暂无数据
         */
        int NO_DATA = 2;
        /**
         * 积分不够
         */
        int SCORE_NOT_ENOUGH = 9996;


        /**
         * 已经签到
         */
        int IS_SIGN = 9995;


        /**
         * 不在线
         */
        int NOT_ONLINE = 9994;
        /**
         * 考试已经结束
         */
        int TRAIN_FINISHED = 9993;


        int ACTIVITY_UN_START = 9992;

        int ACTIVITY_FINISH = 9991;

    }

    interface url {
        /**
         * 获取openID
         */
        String GET_OPENID_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
    }

    interface score {
        int TEN = 10;

        int FIVE = 5;

        float SIGN_SCORE = 1;
        //  float SIGN_SCORE = 0.1f;
    }
}

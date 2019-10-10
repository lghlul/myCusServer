package com.answer.domain;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/10/10 10:10
 * @Modified By：
 */
@Data
public class ScoreLog {
    private BigInteger id;

    private Float beginScore;

    private Float modifyScore;

    private String modifyName;

    private Date modifyTime;

    private BigInteger goodsID;

    private String openID;

}

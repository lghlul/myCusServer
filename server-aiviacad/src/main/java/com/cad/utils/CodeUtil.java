package com.cad.utils;

import java.util.Random;

/**
 * @CLassName CodeUtil
 * @Description TODO
 * @Author ll
 * @Date 2019/2/20 15:08
 **/
public class CodeUtil {

    public static String createCode(int len){
        StringBuffer sb = new StringBuffer();
        int [] numbers = {0,1,2,3,4,5,6,7,8,9};
        Random r = new Random();
        for(int i = 0 ; i < len ; i++){
            sb.append(numbers[r.nextInt(10)]);
        }
        return sb.toString();
    }
}

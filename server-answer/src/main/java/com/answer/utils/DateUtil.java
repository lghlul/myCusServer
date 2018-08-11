package com.answer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String convertByLong(long timeStamp){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeStamp);
        String res = simpleDateFormat.format(date);
        return res;
	}
}

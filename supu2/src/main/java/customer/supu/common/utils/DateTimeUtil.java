package customer.supu.common.utils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * 时间工具类
 */
public class DateTimeUtil {

    private static SimpleDateFormat FORMATTIME_DATE;

    private static SimpleDateFormat FORMATTIME_DATETIME;

    private static SimpleDateFormat FORMATTIME_DATE_ZH;

    private static SimpleDateFormat FORMATTIME;

    private static SimpleDateFormat FORMATDATEWITHDIR;

    private static SimpleDateFormat FORMATDATEWITHMON;

    private static SimpleDateFormat FORMATTIME_WITHOUTSEC;

    private static int OPTION_TIME = 1325347200;

    static {
        FORMATTIME_DATE = new SimpleDateFormat("yyyy-MM-dd");
        FORMATTIME = new SimpleDateFormat("HH:mm:ss");
        FORMATTIME_WITHOUTSEC = new SimpleDateFormat("HH:mm");
        FORMATTIME_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FORMATTIME_DATE_ZH = new SimpleDateFormat("yyyy年MM月dd日");
        FORMATDATEWITHDIR = new SimpleDateFormat("yyyy/MM/dd");
        FORMATDATEWITHMON = new SimpleDateFormat("yyyy-MM");
    }

    /**
     * 获取  yyyy-MM类型
     * @param date
     * @return
     */
    public static String getDateTimeWithMon(Date date) {
        if (date == null) {
            return "";
        }
        return FORMATDATEWITHMON.format(date);
    }

    public static String getDateTime(Timestamp sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_DATETIME.format(sourceDate);
    }

    public static String getDateWithoutTime(Timestamp sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_DATE.format(sourceDate);
    }

    public static Date getDateWithoutTime(String date){
    	try {
	    	 if (date == null) {
	               return null;
	         }
			return  FORMATTIME_DATE.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


    }

    public static String getDateWithoutTime(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_DATE.format(sourceDate);
    }

    public static Date getDateTime(Date datein, Date timein) {
        String date = getCurrDate(datein);
        String time = getCurrTime(timein);
        return getStringToDate(date + " " + time);
    }

    public static String getDateTime(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_DATETIME.format(sourceDate);
    }

    /**
     * HH:mm:ss
     *
     * @param sourceDate
     * @return
     */
    public static String getCurrTime(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME.format(sourceDate);
    }

    /**
     * HH:mm
     * @param sourceDate
     * @return
     */

    public static String getCurrTime_withoutSec(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_WITHOUTSEC.format(sourceDate);
    }

    /**
     * HH:mm
     * @param sourceDate
     * @return
     * @throws ParseException
     */

    public static Date getCurrTime_withoutSec(String strDate) {

        try {
        	 if (strDate == null) {
                 return null;
             }
			return FORMATTIME_WITHOUTSEC.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
    }


    public static String getCurrDateWithDir(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATDATEWITHDIR.format(sourceDate);
    }

    public static String getCurrDate(Date sourceDate) {
        if (sourceDate == null) {
            return "";
        }
        return FORMATTIME_DATE.format(sourceDate);
    }

    public static Date getSysNowDate() {
        return new Date();
    }

    /**
     * 取得当前时间
     *
     * @return Timestamp类型
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 取得当前时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static String getCurrentDate() {
        return FORMATTIME_DATE.format(new java.util.Date());
    }

    /**
     * 取得距当前时间N天的日期
     *
     * @param n 相隔天数
     * @return yyyy-MM-dd 格式
     */
    public static String getDateByCurrenDateWithNum(int n) {
        java.util.Calendar rightNow = java.util.Calendar.getInstance();
        rightNow.add(java.util.Calendar.DAY_OF_MONTH, n);
        return FORMATTIME_DATE.format(rightNow.getTime());
    }

    /**
     * 取得当前时间
     *
     * @return yyMMdd格式
     */
    public static String getCurrentSequnceDate() {
        String today = null;
        today = FORMATTIME_DATE.format(new java.util.Date());
        today = today.replace("-", "");
        today = today.substring(2, today.length());
        return today;
    }

    /**
     * 取得当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static String getCurrentTime() {
        return FORMATTIME_DATETIME.format(new java.util.Date());
    }

    /**
     * 取得前一天日期
     *
     * @return yyyy-MM-dd 格式
     */
    public static String getYesterDay() {
        return FORMATTIME_DATE.format(new java.util.Date(System.currentTimeMillis() - 1000 * 3600 * 24));
    }

    /**
     * 取得前一天日期
     *
     * @return yyyy-MM-dd 格式
     */
    public static String getYesterDayByDate(String date) {
        return FORMATTIME_DATE.format(new java.util.Date(getStringToDate(date).getTime() - 1000 * 3600 * 24));
    }

    /**
     * 取得当前时间
     *
     * @return yyyyMMddHHmmss 格式
     */
    public static String getCompactTime() {
        SimpleDateFormat FORMATTIME = new SimpleDateFormat("yyyyMMddHHmmss");

        return FORMATTIME.format(new java.util.Date());
    }

    /**
     * 取得当前日期
     *
     * @return yyyyMMdd 格式
     */
    public static String getCompactDate() {
        SimpleDateFormat FORMATTIME = new SimpleDateFormat("yyyyMMdd");
        return FORMATTIME.format(new java.util.Date());
    }

    public static String getTimeInMillis() {
        Calendar cal = Calendar.getInstance();
        return Long.toString(cal.getTimeInMillis());
    }

    /**
     * String转换成Date类型日期
     *
     * @param strDate
     * @return
     */
    public static Date getStringToDate(String strDate) {
        if (strDate == null) {
            return null;
        }
        ParsePosition pos = new ParsePosition(0);
        if (strDate.length() == 10) {
            return FORMATTIME_DATE.parse(strDate, pos);
        }
        return FORMATTIME_DATETIME.parse(strDate, pos);
    }

    public static Date getStringToTime(String strDate) {
        if (strDate == null) {
            return null;
        }
        ParsePosition pos = new ParsePosition(0);
        return FORMATTIME.parse(strDate, pos);
    }

    public static int getTimeToSeconds(String time) {
        int nRslt = 0;
        if (StringUtils.isEmpty(time)) {
            return 0;
        }
        String[] times = time.split(":");
        if (times != null && times.length == 3) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            int hours = 0, minutes = 0, seconds = 0;
            try {
                Date date = sdf.parse(time);
                hours = date.getHours();
                minutes = date.getMinutes();
                seconds = date.getSeconds();
            }
            catch (ParseException e) {
            }
            nRslt += seconds;
            nRslt += (minutes * 60);
            nRslt += (hours * 60 * 60);
        }
        return nRslt;
    }

    /**
     * 获取时间跟“2012-1-1 0：0：0”之间的差
     *
     * @param date
     * @return
     */
    public static int getTimeToSecondFrom2012(Date date) {
        if (date == null) {
            return 0;
        }
        return (int) (date.getTime() / 1000 - OPTION_TIME);

    }

    public static long getStringDateToTimeLong(String strDate) {
        if (strDate == null) {
            return 0;
        }

        if (strDate.length() >= 10) {
            // String year = "20"+strDate.substring(0,2);
            // String month = strDate.substring(3,5);
            // String day = strDate.substring(6,8);
            // strDate = year+"-"+month+"-"+day;
            return new Timestamp(getStringToDate(strDate).getTime()).getTime();
        }
        return 0;

    }

    public static Timestamp getStringToTimestamp(String strDate) {
        if (strDate == null) {
            return null;
        }

        if (strDate.length() >= 10) {
            // String year = "20"+strDate.substring(0,2);
            // String month = strDate.substring(3,5);
            // String day = strDate.substring(6,8);
            // strDate = year+"-"+month+"-"+day;
            return new Timestamp(getStringToDate(strDate).getTime());
        }
        return null;

    }

    /**
     * 返回当前时间是一周中的第几天
     *
     * @return 从周日到周六分别是1-7
     */
    public static String getDayOfWeek() {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        String dayofweek = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));
        return dayofweek;
    }

    /**
     * 返回日期是一周中的第几天
     *
     * @return 从周日到周六分别是1-7
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        return dayofweek;
    }

    /**
     * 返回当前时间是一周中的第几天
     *
     * @return
     */
    public static int getWeekNumber() {
        int w = -1;
        String week = getDayOfWeek();
        try {
            w = Integer.parseInt(week);
        }
        catch (Exception e) {
            return -1;
        }
        switch (w) {
            case 1 :
                return 7;
            case 2 :
                return 1;
            case 3 :
                return 2;
            case 4 :
                return 3;
            case 5 :
                return 4;
            case 6 :
                return 5;
            case 7 :
                return 6;
            default :
                return -1;
        }
    }

    public static String getDayOfWeek(int week) {
        int w = -1;
        try {
            w = week;
        }
        catch (Exception e) {
            return "";
        }
        switch (w) {
            case 0 :
                return "星期日";
            case 1 :
                return "星期一";
            case 2 :
                return "星期二";
            case 3 :
                return "星期三";
            case 4 :
                return "星期四";
            case 5 :
                return "星期五";
            case 6 :
                return "星期六";
            default :
                return "";
        }
    }


    public static String getWeek(int week) {
        int w = -1;
        try {
            w = week;
        }
        catch (Exception e) {
            return "";
        }
        switch (w) {
            case 1 :
                return "日";
            case 2 :
                return "一";
            case 3 :
                return "二";
            case 4 :
                return "三";
            case 5 :
                return "四";
            case 6 :
                return "五";
            case 7 :
                return "六";
            default :
                return "";
        }
    }

    /**
     * 数字转换成时间类型
     *
     * @param time
     * @return
     */
    public static Date long2Date(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        return c.getTime();
    }

    public static String getDayOfWeek(String week) {
        int w = -1;
        try {
            w = Integer.parseInt(week);
        }
        catch (Exception e) {
            return "";
        }
        switch (w) {
            case 1 :
                return "星期日";
            case 2 :
                return "星期一";
            case 3 :
                return "星期二";
            case 4 :
                return "星期三";
            case 5 :
                return "星期四";
            case 6 :
                return "星期五";
            case 7 :
                return "星期六";
            default :
                return "";
        }
    }

    public static String getCurrWeek() {
        int w = -1;
        String week = getDayOfWeek();
        try {
            w = Integer.parseInt(week);
        }
        catch (Exception e) {
            return "";
        }
        switch (w) {
            case 1 :
                return "星期日";
            case 2 :
                return "星期一";
            case 3 :
                return "星期二";
            case 4 :
                return "星期三";
            case 5 :
                return "星期四";
            case 6 :
                return "星期五";
            case 7 :
                return "星期六";
            default :
                return "";
        }
    }

    public static String backDayandWeek(Date date) {
        int n = 0;
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            n = c.get(Calendar.DAY_OF_WEEK) - 1;
            if (n < 0)
                n = 0;
        }
        catch (Exception e) {
            n = 0;
        }
        return weekDays[n];
    }

    /***
     * 根据日期返回当前是周几
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        int n = 0;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            n = c.get(Calendar.DAY_OF_WEEK) - 1;
            if (n < 0)
                n = 0;
        }
        catch (Exception e) {
            n = 0;
        }
        return n;
    }

    public static String getWeekMonth(int week) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, week);
        cal.add(Calendar.DATE, 1);// 推迟一天
        int month = cal.get(Calendar.MONTH) + 1;
        switch (month) {
            case 1 :
                return "一月";
            case 2 :
                return "二月";
            case 3 :
                return "三月";
            case 4 :
                return "四月";
            case 5 :
                return "五月";
            case 6 :
                return "六月";
            case 7 :
                return "七月";
            case 8 :
                return "八月";
            case 9 :
                return "九月";
            case 10 :
                return "十月";
            case 11 :
                return "十一月";
            case 12 :
                return "十二月";
            default :
                return "";
        }
    }

    public static String getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);// 推迟一天
        int month = cal.get(Calendar.MONTH) + 1;
        switch (month) {
            case 1 :
                return "一月";
            case 2 :
                return "二月";
            case 3 :
                return "三月";
            case 4 :
                return "四月";
            case 5 :
                return "五月";
            case 6 :
                return "六月";
            case 7 :
                return "七月";
            case 8 :
                return "八月";
            case 9 :
                return "九月";
            case 10 :
                return "十月";
            case 11 :
                return "十一月";
            case 12 :
                return "十二月";
            default :
                return "";
        }
    }

    public static int getWeekDay(int week) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, week);
        cal.add(Calendar.DATE, 1);// 推迟一天
        int currDay = cal.get(Calendar.DATE);
        return currDay;
    }

    /***
     * 前台播放使用日期
     *
     * @param week
     * @return
     */
    public static String getWeekDate(int week) {
        String strDate = "";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, week);
        cal.add(Calendar.DATE, 1);// 推迟一天
        strDate = FORMATTIME_DATE.format(cal.getTime());
        return strDate;
    }

    public static String getWeekDateTime(int week) {
        String strDate = "";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, week);
        cal.add(Calendar.DATE, 1);// 推迟一天
        strDate = FORMATTIME_DATE_ZH.format(cal.getTime());
        switch (week) {
            case 1 :
                return strDate + "星期一";
            case 2 :
                return strDate + "星期二";
            case 3 :
                return strDate + "星期三";
            case 4 :
                return strDate + "星期四";
            case 5 :
                return strDate + "星期五";
            case 6 :
                return strDate + "星期六";
            case 7 :
                return strDate + "星期日";
            default :
                return "";
        }
    }

    public static String getYear(String datestr) {
        return datestr.substring(0, 4);
    }

    /**
     * 取得当前时间的年份
     *
     * @return yyyy
     */
    public static String getYear() {
        return getYear(getCurrentDate());
    }

    public static String getMonth(String datestr) {
        return datestr.substring(5, 7);
    }

    /**
     * 取得当前时间的月份
     *
     * @return
     */
    public static String getMonth() {
        return getMonth(getCurrentDate());
    }

    public static String getDay(String datestr) {
        return datestr.substring(8, 10);
    }

    /**
     * 取得当前时间的日
     *
     * @return
     */
    public static String getDay() {
        return getDay(getCurrentDate());
    }

    public static String getHour(String date) {
        return date.substring(11, 13);
    }

    public static String getHour() {
        return getHour(getCurrentTime());
    }

    /**
     * 计算两个Date类型的时间差，单位转换成秒
     *
     * @param starttime
     * @param endtime
     * @return 返回结果是endtime-starttime的时间差，单位是秒
     */
    public static int getSecondDifference(Date starttime, Date endtime) {
        int diff = new Long((endtime.getTime() - starttime.getTime()) / 1000).intValue();
        return diff;
    }

    /**
     * 判断当前时间是否在这两个时间之间
     *
     * @param starttime
     * @param endtime
     * @return
     */
    public static boolean betweenCurrentTime(Date starttime, Date endtime) {
        Date cd = new Date();
        return cd.before(endtime) && cd.after(starttime);
    }

    public static int getSecondDifference(Timestamp starttime, Timestamp endtime) {
        int diff = new Long((endtime.getTime() - starttime.getTime()) / 1000).intValue();
        return diff;
    }

    public static int getDaysInterval(String starttime, String endtime) {
        return getDaysInterval(getStringToDate(starttime), getStringToDate(endtime));
    }

    public static int getDaysInterval(Date starttime, Date endtime) {
        return new Long((endtime.getTime() - starttime.getTime()) / 86400000).intValue();
    }

    public static int getMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        Calendar objCalendarDate1 = Calendar.getInstance();
        objCalendarDate1.setTime(date1);

        Calendar objCalendarDate2 = Calendar.getInstance();
        objCalendarDate2.setTime(date2);

        if (objCalendarDate2.equals(objCalendarDate1)) {
            return 0;
        }
        if (objCalendarDate1.after(objCalendarDate2)) {
            Calendar temp = objCalendarDate1;
            objCalendarDate1 = objCalendarDate2;
            objCalendarDate2 = temp;
        }
        // if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
        // .get(Calendar.DAY_OF_MONTH)) {
        // flag = 1;
        // }
        if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR)) {
            iMonth =
                    ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12
                            + objCalendarDate2.get(Calendar.MONTH) - flag)
                            - objCalendarDate1.get(Calendar.MONTH);
            System.out.println("iMonth:" + iMonth);
        }
        else {
            iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;
        }
        return iMonth;
    }

    public static boolean isDateTimeBefore(String date1, String date2) {
        try {
            return FORMATTIME_DATETIME.parse(date1).before(FORMATTIME_DATETIME.parse(date2));
        }
        catch (Exception e) {
            System.out.println("==========");
            return false;
        }
    }

    public static boolean isDateBefore(String date1, String date2) {
        try {
            return FORMATTIME_DATE.parse(date1).before(FORMATTIME_DATE.parse(date2));
        }
        catch (Exception e) {
            System.out.println("==========");
            return false;
        }
    }

    public static boolean isDateAfter(String date1, String date2) {
        try {
            return FORMATTIME_DATE.parse(date1).after(FORMATTIME_DATE.parse(date2));
        }
        catch (Exception e) {
            System.out.println("==========");
            return false;
        }
    }

    public static Timestamp getNotNullTimestampValue(String str) {
        Timestamp value;
        try {
            if (str == null || str.equals("")) {
                value = new Timestamp(System.currentTimeMillis());
            }
            else {
                value = new Timestamp(FORMATTIME_DATE.parse(str).getTime());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            value = new Timestamp(System.currentTimeMillis());
        }
        return value;
    }

    public static Timestamp getNotNullTimestampValue(String str, String format) {
        Timestamp value;
        try {
            if (str == null || str.equals("")) {
                value = new Timestamp(System.currentTimeMillis());
            }
            else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                value = new Timestamp(simpleDateFormat.parse(str).getTime());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            value = new Timestamp(System.currentTimeMillis());
        }
        return value;
    }

    public static boolean compareTotime(String time) {
        boolean bFlag = false;
        long l = 0;
        String currentTime = getCurrentTime();
        try {
            Date currentDate = FORMATTIME_DATE.parse(currentTime);
            Date date = FORMATTIME_DATE.parse(time);
            l = currentDate.getTime() - date.getTime();
        }
        catch (Exception e) {
            l = 0;
            e.printStackTrace();
        }
        if (l > 0)
            bFlag = true;
        return bFlag;
    }

    public static int compareTimstampStr(String sTime, String tTime, String format) {
        int nRslt = 10;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        long l = 10;
        try {
            Date sDate = simpleDateFormat.parse(sTime);
            Date tDate = simpleDateFormat.parse(tTime);
            l = sDate.getTime() - tDate.getTime();
        }
        catch (Exception e) {
            nRslt = 2147483647;
            e.printStackTrace();
        }
        if (l > 0)
            nRslt = 1;
        else if (l == 0)
            nRslt = 0;
        else if (l < 0)
            nRslt = -1;
        return nRslt;
    }

    public static String getCurrentDay(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);
        return simpleDateFormat.format(new Date());
    }

    public static String getTimetoString(String seconds) {
        if (StringUtils.isEmpty(seconds)) {
            return "";
        }
        long l = 0;
        try {
            l = Long.parseLong(seconds);
        }
        catch (Exception e) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date d = new Date(l * 1000 - sdf.getTimeZone().getRawOffset());
        String str = sdf.format(d);
        return str;
    }

    public static Date getDateBeforeNum(int n) {
        return new Date(System.currentTimeMillis() - 1000 * 3600 * 24 * (n - 1));
    }

    public static Date getDateBeforeNum(Date date, int n) {
        return new Date(date.getTime() - 1000 * 3600 * 24 * (n - 1));
    }

    public static Date getSomeDateToggle(Date date, int n) {
        return new Date(date.getTime() + 1000 * 3600 * 24 * n);

    }

    public static int daysOfMonth(int year, int month) {
        int days = 0; // 该月的天数
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1); // java中Calendar类中的月从0-11，所以要month-1

        // 日历每天向后滚一天，如果月份相等，天数+1，月份不等，说明已经到下月第一天了，跳出循环
        while (true) {
            if (c.get(Calendar.MONTH) == (month - 1)) {
                days++;
                c.add(Calendar.DAY_OF_YEAR, 1);
            }
            else {
                break;
            }
        }
        return days;
    }

    /**
     * 获取前一天时间
     *
     * @return
     */
    public static String getPreDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -1);
        return DateTimeUtil.getDateWithoutTime(c.getTime());
    }

    public static int getCurrWeekOfMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当天的最晚时间
     *
     * @return
     */
    public static Date getCurrentDateLastedTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取当天零点时间
     *
     * @return
     */
    public static Date getCurrentDateZeroTime() {
        Calendar c = Calendar.getInstance();
        // c.setLenient(true);
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取本周第一天零点时间
     *
     * @return
     */
    public static Date getTheFirstOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取本周最后一天最晚时间
     *
     * @return
     */
    public static Date getTheLastOfThisWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getMaximum(Calendar.DAY_OF_WEEK));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

    /**
     * 获取本月第一天的零点时间
     *
     * @return
     */
    public static Date getTheFirstOfMoth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DATE));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取当月最后一天的最后时间
     *
     * @return
     */
    public static Date getTheLastOfMoth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

    public static Date getTheFirstOfYear(int year) {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 0);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取本年最后一天的最后时间
     *
     * @return
     */
    public static Date getTheLastOfYear(int year) {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DAY_OF_MONTH, 31);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

    public static int getCurrMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.MONTH) + 1;
    }

    public static String Seconds2Time(long sec) {
        int h = 0, m = 0;
        h = (int) (sec == 0 ? 0 : sec / 3600);
        sec = (sec == 0 ? 0 : sec % 3600);
        m = (int) (sec == 0 ? 0 : sec / 60);
        sec = (sec == 0 ? 0 : sec % 60);
        return (h == 0 ? "00" : (h / 10) + "" + h % 10) + ":" + (m == 0 ? "00" : (m / 10) + "" + m % 10) + ":"
                + (sec == 0 ? "00" : (sec / 10) + "" + sec % 10);
    }

    /**
     * 时间格式转换成描述如： 01:01:01转出为3661, 111转出直接为111，00:00默认为分秒
     *
     * @param time
     * @return
     */
    public static int timeToSeconds(String time) {
        if (StringUtils.isEmpty(time)) {
            return 0;
        }
        String[] strs = time.split(":");
        if (strs.length == 3) {
            return parseInt(strs[0], 0) * 3600 + parseInt(strs[1], 0) * 60 + parseInt(strs[2], 0);

        }
        else if (strs.length == 1) {
            return parseInt(time, 0);
        }
        else if (strs.length == 2) {
            return parseInt(strs[0], 0) * 60 + parseInt(strs[1], 0);
        }
        return 0;
    }

    private static int parseInt(String str, int defaultValue) {
        try {
            defaultValue = Integer.parseInt(str);
        }
        catch (Exception e) {
        }
        return defaultValue;
    }

    /**
     * 将时间转换成d 天，HH:mm:ss的格式
     *
     * @param sec
     * @return
     */
    public static String secondsToTime(long sec) {
        int d = 0, h = 0, m = 0;
        d = (int) (sec == 0 ? 0 : sec / (3600 * 24));
        sec = (sec == 0 ? 0 : sec % (3600 * 24));
        h = (int) (sec == 0 ? 0 : sec / 3600);
        sec = (sec == 0 ? 0 : sec % 3600);
        m = (int) (sec == 0 ? 0 : sec / 60);
        sec = (sec == 0 ? 0 : sec % 60);
        DecimalFormat format = new DecimalFormat("00");
        return d + " 天," + format.format(h) + ":" + format.format(m) + ":" + format.format(sec);
    }

    public static int dateDiff(Date startTime, Date endTime) {
        long nd = 1000 * 24 * 60 * 60;
        long diff;
        try {
            diff =
                    FORMATTIME_DATE.parse(getDateTime(endTime)).getTime()
                            - FORMATTIME_DATE.parse(getDateTime(startTime)).getTime();
            long day = diff / nd;
            return (int) day;
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int compareDate(Date beginDate, Date endDate) {
        try {
            if (beginDate.getTime() > endDate.getTime()) {
                return 1;
            }
            else if (beginDate.getTime() < endDate.getTime()) {
                return -1;
            }
            else {
                return 0;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean isToday(Date date) {
        return getDateWithoutTime(new Date()).equals(getDateWithoutTime(date));
    }

    public static Date covertUnixTime(int unixtime) {
        return new Date(unixtime * 1000L);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期是否相等
     *
     * @param smdate 较小的时间
     * @param bdate 较大的时间
     * @return
     * @throws ParseException
     */
    public static boolean daysBetween2(Date smdate, Date bdate) throws ParseException {
        int d = daysBetween(smdate, bdate);
        if (d == 0) {
            return true;
        }
        return false;
    }

    /**
     * 合拼日期与时间
     *
     * @param date 日期
     * @param time 时间
     * @return
     */
    public static String combiningDateTimeToString(Date date, Date time) {
        try {
            return getDateWithoutTime(date) + " " + getCurrTime(time);
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

    /**
     * 合拼日期与时间
     *
     * @param date 日期
     * @param time 时间
     * @return
     */
    public static Date combiningDateTimeToDate(Date date, Date time) {
        return getStringToDate(combiningDateTimeToString(date, time));
    }

    /**
     * 时间偏移
     *
     * @param date
     * @param num 偏移天数
     * @return
     */
    public static Date offsetDate(Date date, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, num);
        return calendar.getTime();
    }


    /**
     * 得到   n年    n月    n日后的日期
     * @param format  格式  如  yyyy-MM-dd
     * @param StrDate  传入时间    如  2017-08-21
     * @param year 可以传0
     * @param month 可以传0
     * @param day 可以传0
     * @return
     */
    public static   String   getNextDate(String  format, String  StrDate,   int  year,   int month,int day)   {
        Calendar   cal = Calendar.getInstance();
        SimpleDateFormat  sFmt= new  SimpleDateFormat(format);
        cal.setTime(sFmt.parse((StrDate), new ParsePosition(0)));

        if(day != 0){
        	cal.add(cal.DATE,   day);
        }
        if(month   !=   0){
        	cal.add(cal.MONTH,   month);
        }
        if(year   !=   0){
        	cal.add(cal.YEAR,   year);
        }
        return   sFmt.format(cal.getTime());
    }

	/**
	 * 获取未来 或 过去     任意天数之内的   日期数组
	 * @param pastDaysList  返回过去天数的   日期数组
	 * @param fetureDaysList 返回未来天数的   日期数组
	 */
    public static ArrayList<String> getDateList(int intervals) {
    	//返回过去天数的
        //ArrayList<String> pastDaysList = new ArrayList<>();
        //返回未来天数的
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
           // pastDaysList.add(getPastDate(i));
            fetureDaysList.add(getFetureDate(i));
        }
        return fetureDaysList;
    }


    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        //Log.e(null, result);
        return result;
    }

    /**
     * 获取未来 第 几 天的日期
     * @param feture
     * @return
     */
    public static String getFetureDate(int feture) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + feture);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
       // Log.e(null, result);
        return result;
    }


    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekDate(Date dt) {
        String[] weekDays = {"1", "2", "3", "4", "5", "6", "7"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }



    /**
     * 获取当前月份有多少天
     * @param year
     * @param month
     * @return
     */
    public static Integer getCountMonthOfDay(int year, int month) {
        int days = 0;
        if (month != 2) {
            switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;

            }
        } else {
            // 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else
                days = 28;

        }
        return days;
    }

    
    /**
	 * 转换时间戳
	 * @param dataStr 时间字符串，字段格式为:yyyy-MM-dd HH:mm:ss或yyyy-MM-dd 
	 *        为null时，获取当前时间戳
	 * @throws ParseException 
	 */
	public static long getTimestamp(String dataStr){
		SimpleDateFormat format = null;
		if (null == dataStr){
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date date = new Date();
			dataStr =format.format(date);
		}else{
			if (dataStr.length() == 10){
				format = new SimpleDateFormat("yyyy-MM-dd"); 
			}else{
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			}
		}
		Date da = null;
		try {
			da = format.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da.getTime();
	}
	
public static boolean validTime(String time, long timeStamp){
		
		if(time!=null){
			long timeLong = Long.parseLong(time);
			if ((timeStamp - timeLong)/1000 > 7000){
				return true;
			}
		}
		return false;
	}
    public static void main(String[] args) {

    	System.out.println(getCountMonthOfDay(2018, 1));
    	System.out.println(getCountMonthOfDay(2018, 2));
    	System.out.println(getCountMonthOfDay(2018, 3));
    	System.out.println(getCountMonthOfDay(2018, 4));
    	System.out.println(getCountMonthOfDay(2018, 5));
    	System.out.println(getCountMonthOfDay(2018, 6));
    	System.out.println(getCountMonthOfDay(2018, 7));
    	System.out.println(getCountMonthOfDay(2018, 8));
    	System.out.println(getCountMonthOfDay(2018, 9));
    	System.out.println(getCountMonthOfDay(2018, 10));
    	System.out.println(getCountMonthOfDay(2018, 11));
       	System.out.println(getCountMonthOfDay(2017, 12));


    	//System.out.println(getCountMonthOfDay(2018, 01));

    	//System.out.println(getTheLastOfYear(2017));
    	//System.out.println(GetSysDate("yyyy-MM-dd", "2017-08-21",0, 2, 0));
    	//GetSysDate("18:00", StrDate, 0, 2, 0)
    	//System.out.println(getFetureDate(8));
		/*//月
		String month="2017-08-02".substring(5, 7);
		//日
		String day="2017-08-02".substring(8, 10);
        System.out.println(month+"."+day);*/

       // System.out.println(getWeekOfDate(getStringToDate("2017-08-02")));
        // String result = DateTimeUtil.getDayOfWeek();
        // System.out.println("result=" + result);
        //
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // String currDateTime = DateTimeUtil.getCurrentDate();
        // System.out.println(df.format(DateTimeUtil.getTheLastOfThisWeek()));

        // System.out.println(getSysNowDate());
        // System.out.println(DateTimeUtil.getTheLastOfYear(2011));

        // Runtime lRuntime = Runtime.getRuntime();
        // System.out.println("*** BEGIN MEMORY STATISTICS ***<br/>");
        // System.out.println("Free   Memory: "+lRuntime.freeMemory()/1000+"<br/>");
        // System.out.println("Max    Memory: "+lRuntime.maxMemory()/1000+"<br/>");
        // System.out.println("Total Memory: "+lRuntime.totalMemory()/1000+"<br/>");
        // System.out.println("Available Processors : "+lRuntime.availableProcessors()+"<br/>");
        // System.out.println("*** END MEMORY STATISTICS ***");

        // System.out.println( DateUtil
        // .getLastlyTimeOfDate(DateTimeUtil
        // .getStringToDate("2012-11-13")));
        // System.out.println(DateUtil
        // .getFirstTimeOfDate(DateTimeUtil
        // .getStringToDate("2012-11-13")));
        // System.out.println(DateTimeUtil.getStringToDate(" "));

        // int day =
        // DateTimeUtil.dateDiff(DateTimeUtil.getStringToDate("2013-11-05 10:22:22"),
        // new Date());
        // System.out.println(day);

        // Date date = new Date();
        // System.out.println(DateTimeUtil.getDateTime(date));
        // long l = date.getTime();
        // System.out.println(l);
        // int ll = (int) (l / 1000);
        // System.out.println(ll);
        // System.out.println(DateTimeUtil.getDateTime(new Date(ll * 1000L)));

        // Date d1 = DateTimeUtil.getStringToDate("2014-01-20 18:00:11");
        // Date d2 = DateTimeUtil.getStringToDate("2014-01-20 18:00:32");
        //
        // int d = (int) (d2.getTime() / 1000) - (int) (d1.getTime() / 1000);
        // System.out.println(d);
    }


    public static String timemillonToStr(long timeMillon , String format){
        SimpleDateFormat sdf=new SimpleDateFormat(format);//这个是你要转成后的时间的格式
        String sd = sdf.format(new Date(timeMillon));
        return sd;
    }

}

package www.vip.com.JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/** 日期工具类*/
public class DateUtils {

    /** 1.字符串转换成Utils.Date*/
    public static java.util.Date strToUtil(String str){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        try {
            java.util.Date date = simpleDateFormat.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    /** 2.util.Date转换为sql.Date*/
    public static java.sql.Date utilToSQL(java.util.Date date){

        return new java.sql.Date(date.getTime());

    }

    /** 3.util.Date 转换为字符串形式*/
    public static String utilToStr(java.util.Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /** 4.获取当前时间字符串 */
    public static String getCurrentTime(){

        java.util.Date date = new java.util.Date();
        return utilToStr(date);

    }



}

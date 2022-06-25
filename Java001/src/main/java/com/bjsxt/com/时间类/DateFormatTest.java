package com.bjsxt.com.时间类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat: 时间对象字符串格式化
 */
public class DateFormatTest {

    public static void main(String[] args) throws ParseException {

        /**
         * DateFormat属于abstact抽象类，不能使用new初始化，通常使用SimpleDateFormat；
         */
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        /**
         * format：把时间对象按照"按字符串指定格式"转化成相应的字符串
         */
        String str = format.format(new Date());
        System.out.println(str);

        /**
         * parse：把字符串按照"格式字符串指定的格式"转换成相应的时间对象
         */
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date date = df.parse("2020年8月1日 10时30分15秒");
        System.out.println(date);

        /**
         * 获取Date时间所在的 天 位于当年的第几天
         */
        DateFormat d = new SimpleDateFormat("D");
        String day = d.format(new Date());
        System.out.println(day);
    }

}

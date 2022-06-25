package com.bjsxt.com.时间类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 可视化日历程序
 */
public class CalenderExerise {

    public static void main(String[] args) throws ParseException {

        String scanerString = "2020-7-24";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(scanerString);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH,1);

        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK)-1; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i < calendar.getActualMaximum(Calendar.DATE); i++) {
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }

    }

}

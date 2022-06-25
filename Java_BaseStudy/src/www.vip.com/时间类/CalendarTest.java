package www.vip.com.时间类;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Calendar :日历对象
 */
public class CalendarTest {

    public static void main(String[] args) {

        /**
         * 创建日历对象
         */
        Calendar calendar = new GregorianCalendar(2020,10,9,22,10,50);
        print(calendar);

        /**
         * 获取年月日等信息
         */
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(weekDay);

        Calendar c = new GregorianCalendar();
        /**
         * 设置哪一年
         */
        c.set(Calendar.YEAR,2020);
        print(c);

        Calendar c1 = new GregorianCalendar();
        /**
         * 往前100年
         */
        c1.add(Calendar.YEAR,-100);
        print(c1);

        /**
         * 日期对象和时间对象的转化：
         */
        Date date = c.getTime();
        Calendar c2 = new GregorianCalendar();
        c2.setTime(date);

        //
        Calendar calendar1 = new GregorianCalendar();
        print(calendar1);

    }

    /**
     * 格式化输出
     */
    public static void print(Calendar c){
        //格式化打印：2020年8月1日 12:00:00 周三
        int  year = c.get(Calendar.YEAR);
        int  month = c.get(Calendar.MONTH)+1; //(0-11)
        int  day = c.get(Calendar.DAY_OF_MONTH);

        int  hour = c.get(Calendar.HOUR);
        int  minute = c.get(Calendar.MINUTE);
        int  second = c.get(Calendar.SECOND);

        int  dayweek = c.get(Calendar.DAY_OF_WEEK)-1; //1-7 : 1周日，2周一，3周二
        String dayweek1 = dayweek == 0 ? "日":dayweek+"";
        System.out.println(year+"年"+month+"月"+day+"日"+" "+hour+"时"+minute+"分"+second+"秒"+" 周"+dayweek1);

    }

}



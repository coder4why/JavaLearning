package www.vip.com.时间类;
import java.util.Date;

/**
 * Date：时间对象
 */
public class DateTest {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        /**
         * 1970年1月1日 00:00:00时刻为0基准，往前时间毫秒数为负，往后毫秒数为正；
         */
        Date currentDate = new Date(101031); //1970年以后
        System.out.println(currentDate);

        Date lastDate = new Date(-1111101031); //1970年以前
        System.out.println(lastDate);

        /**
         * 获取当前的毫秒数；
         */
        long now = System.currentTimeMillis();
        Date nowDate = new Date(now);
        System.out.println(nowDate);

        /**
         * getTime: 获取时间毫秒数
         */
        System.out.println(nowDate.getTime());

        /**
         * after、before: 比较两个时间的先后顺序
         */
        System.out.println(currentDate.after(lastDate));
        System.out.println(currentDate.before(lastDate));

        /**
         * equals :比较两个日期的相等性
         */
        System.out.println(date.equals(now));
        System.out.println(date.equals(date));

        /**
         * toString()：时间转化成字符串
         */
        System.out.println(date.toString());

        /**
         * 废弃API：
         */
        Date desDate = new Date(2020-1900,7-1,24); // 2020.7.24日表示
        System.out.println(desDate.toString());

    }

}

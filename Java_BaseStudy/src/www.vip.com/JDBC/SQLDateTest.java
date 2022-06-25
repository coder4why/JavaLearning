package www.vip.com.JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *     数据库存储的数据类型为java.sql.Date，java应用层存储日期类型为java.util.Date；
 *  当我们用Java应用程序插入带有日期的数据到数据库中时，需要进行转换；
 * java.util.Date：
 *     1.Java语言常规应用层面的日期类型，可以通过字符串创建对应的时间对象；
 *     2.无法直接通过JDBC写入到数据库；
 * java.sql.Date:
 *     1.不可以通过字符串创建对应的时间对象，只能通过毫秒值创建对象（1970年至今的毫秒值）；
 *     2.可以直接通过JDBC插入到数据库；
 *  SimpleDateFormat:
 *      格式化和解析日期的具体类，允许进行格式化（日期->文本）、解析（文本->日期）和规范化;
 */
public class SQLDateTest {
    public static void main(String[] args) throws ParseException {

        System.out.println(new java.util.Date());
        System.out.println(new java.sql.Date(20200819));

        /** 1.字符串转util.Date*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = simpleDateFormat.parse("2020-12-12 12:10:09");
        System.out.println(date);

        /** 2.util.Date日期转字符串*/
        java.util.Date date1 = new java.util.Date();
        String dateString = simpleDateFormat.format(date1);
        System.out.println(dateString);

        /** 3.使用java.sql.Date*/
        java.sql.Date date2 = new java.sql.Date(new java.util.Date().getTime());
        System.out.println(date2);

        /** 4.java.sql.Date对象格式化输出 */
        String sqlTime = simpleDateFormat.format(date2);
        System.out.println(sqlTime);

    }
}

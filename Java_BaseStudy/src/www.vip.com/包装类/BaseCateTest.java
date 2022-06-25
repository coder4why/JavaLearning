package www.vip.com.包装类;

/**
 * Java常用包装类：
 *      基本数据类型对应的包装类
 *          byte    Byte
 *          boolean Boolean
 *          short   Short
 *          char    Char
 *          int     Integer
 *          long    Long
 *          float   Float
 *          double  Double
 */
public class BaseCateTest {
    public static void main(String[] args) {

        //1.把基本数据类型 转化成 包装类
        //Integer包装一个int类型的数字，生成一个Integer对象；
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(10);

        //
        byte by = 10;
        Byte c = new Byte(by);

        //字符串转化成包装类对象
        Integer strNum = Integer.valueOf("999");
        Integer strS = Integer.parseInt("1000");

        //2.把包装类 转化成 基本数据类型
        int d = a.intValue();
        String e = strNum.toString();

        System.out.println(strNum);
        System.out.println(e);


    }
}

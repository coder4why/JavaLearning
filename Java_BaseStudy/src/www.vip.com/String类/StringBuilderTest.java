package www.vip.com.String类;

/**
 * Java中的StringBuilder：可变字符串
 */
public class StringBuilderTest {

    public static void main(String[] args) {

        /**
         * 初始化一个可变字符串
         */
        StringBuilder builder = new StringBuilder("shangHai");
        /**
         * 字符串替换：
         */
        builder.setCharAt(2,'B');
        System.out.println(builder);

        /**
         * 添加字符串
         */
        builder.append(",huanyingning");
        System.out.println(builder);

        /**
         * 插入字符串:offset 索引  str 要插入的字符串
         */
        builder.insert(2,"HPK");
        System.out.println(builder);

        /**
         * 删除字符串: 2 删除起始索引 3 删除结束索引(不包含结束位)
         */
        builder.delete(2,3);
        System.out.println(builder);

        /**
         * 删除索引位置字符：3 字符索引
         */
        builder.deleteCharAt(3);
        System.out.println(builder);

        /**
         * 字符串倒序
         */
        builder.reverse();
        System.out.println(builder);

        long num1 = Runtime.getRuntime().freeMemory();// 获得系统剩余内存空间
        long time1 = System.currentTimeMillis(); //获取系统的当前时间

        /**
         * toString() : 获取字符序列中数据的字符串表示形式；
         */
        String str = builder.toString();
        System.out.println(str);

        /**
         * StringBuilder：
         *      循环添加字符串，占用内存较小，耗时更短，效率更高；
         */
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 5000; i++) {
            stringBuilder.append(i);
        }
        long num2 = Runtime.getRuntime().freeMemory();// 获得系统剩余内存空间
        long time2 = System.currentTimeMillis(); //获取系统的当前时间
        System.out.println("StringBuilder占用内存："+(num1-num2));
        System.out.println("StringBuilder占用时间："+(time2-time1));

        long num3 = Runtime.getRuntime().freeMemory();// 获得系统剩余内存空间
        long time3 = System.currentTimeMillis(); //获取系统的当前时间

        /**
         * String：
         *      循环拼接字符串，占用内存较大，耗时更长，效率极低；
         */
        String testStr = "";
        for (int i = 0; i < 5000; i++) {
            testStr = testStr+i;
        }
        long num4 = Runtime.getRuntime().freeMemory();// 获得系统剩余内存空间
        long time4 = System.currentTimeMillis(); //获取系统的当前时间
        System.out.println("String占用内存："+(num3-num4));
        System.out.println("String占用时间："+(time4-time3));



    }

}

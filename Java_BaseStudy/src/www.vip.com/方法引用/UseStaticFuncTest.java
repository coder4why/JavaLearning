package www.vip.com.方法引用;

/**
 * 引用类方法：
 *    其实就是引用类的静态方法；
 * 格式：
 *    类名::静态方法；
 * 范例：
 *    Integer::parseInt
 *
 */
public class UseStaticFuncTest {

    private static void useConvert(OMGInterface omg){
        System.out.println(omg.convert("10"));
    }
    public static void main(String[] args) {

        /**
         * 匿名内部类实现：
         */
        useConvert(new OMGInterface() {
            @Override
            public int convert(String s) {
                return Integer.parseInt(s);
            }
        });

        /**
         * 使用类的对象实现：
         */
        OMGInterface omg = new OMGInterface() {
            @Override
            public int convert(String s) {
                return Integer.parseInt(s);
            }
        };
        useConvert(omg);

        /**
         * Lambda表达式的非省略写法：
         */
        useConvert((String s)->{
            return Integer.parseInt(s);
        });

        /**
         * Lambda表达式省略写法实现：
         */
        useConvert(s->Integer.parseInt(s));

        /**
         * Lambda表达式 结合 方法引用 实现；
         * Lambda表达式被类方法替代的时候，它的形式参数全部传递给静态方法作为参数；
         */
        useConvert(Integer::parseInt);

    }

}

interface OMGInterface{

    int convert(String s);
}


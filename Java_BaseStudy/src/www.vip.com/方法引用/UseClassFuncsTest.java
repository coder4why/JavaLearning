package www.vip.com.方法引用;

/**
 * 引用类的实例方法：
 *    其实就是引用类的成员方法；
 * 格式：
 *    类名::成员方法；
 */
public class UseClassFuncsTest {

    private static void useMyString(ClassApi api){
        System.out.println(api.mySubString("abcdefg",2,5));;
    }

    public static void main(String[] args) {

        /**
         * 使用Lambda表达式的实现；
         */
        useMyString((s,x,y)->{

            return s.substring(x,y);

        });

        /** Lambda表达式的简写：*/
        useMyString((s,x,y)->s.substring(x,y));

        /** 使用方法引用符的实现：类的实例方法*/
        useMyString(String::substring);

        /**
         * Lambda表达式被类的实例方法替代的时候：
         *    第一个参数作为调用者，
         *    后面的参数全部传递给该方法作为参数；
         */

    }

}

interface ClassApi{
    String mySubString(String s,int x,int y);
}

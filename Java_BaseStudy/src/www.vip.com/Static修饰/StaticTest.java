package www.vip.com.Static修饰;

//Static修饰的变量称为静态变量
//Static修饰的方法称为静态方法
public class StaticTest {

    //在类中，用static修饰的成员变量称为静态成员变量，也称为类变量；
    //类变量的生命周期和类相同，在整个应用程序执行期间都效；
    static String name;

    //静态语句块：没有名字，在类初始化的时候执行
    static {
        System.out.printf("我是一个静态初始化块");
        name = "北京尚学堂";
        goodStudy();
    }

    void test(){
        StaticTest.name = "Hello Staic";
        name = "Hello Java";
        System.out.printf(StaticTest.name);
    }

    static void goodStudy(){
        System.out.printf("\n好好学习，天天向上");
    }

    public static void main(String[] args) {
        //类初始化的时候执行静态语句块
        StaticTest test = new StaticTest();
        test.test();
        goodStudy();
    }

}

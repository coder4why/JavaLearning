package www.vip.com.内部类;

/**
 * Java中的内部类：
 *      1.成员内部类（非静态内部类、静态内部类）；
 *      2.匿名内部类；
 *      3.局部内部类；
 */
public class InnerClassTest {

    public static void test(AA a){
        System.out.println("测试-----");
        a.showMe();
    }
    public static void main(String[] args) {
        Father fa = new Father();
        //创建非静态内部类对象：
        Father.FatherOne oneFa = new Father().new FatherOne();
        oneFa.oneName = "我是中华人民共和国海军";
        oneFa.whoAreYou();

        //创建静态类内部对象：
        Father.FatherTwo twoFa = new Father.FatherTwo();
        twoFa.twoName = "我是一只小小鸟";
        Father.FatherTwo.twoString = "你好啊，大妈";
        Father.FatherTwo.showPlease();
        twoFa.whoYouAre();

        //创建匿名内部类：临时使用的类，不创建类对象；
        InnerClassTest.test(new ImpAA(){
            @Override
            public void showMe() {
                System.out.println("匿名内部类测试");
            }
        });

    }
}

interface AA{
    void showMe();
}

class ImpAA implements AA{
    @Override
    public void showMe() {
        System.out.println("显示一下拉");
    }
}

class Father{

    String name = "Say:" ;
    void showMessage(){
        System.out.println(name);
    }
    //成员内部类：
    //修饰符可以使用：private、default、protected、public任意进行修饰；
    //1.非静态内部类
    class FatherOne{
        //非静态内部类里面不可创建静态属性和方法；
        //static String whosFather;
        //static void showWhat(){}
        String oneName;
        void whoAreYou(){
            String word = "Ni好";
            System.out.println("我是成员内部类：非静态内部类");
            System.out.println(name+oneName+word);
        }
    }
    //2.static修饰的内部类：静态内部类
    static class FatherTwo{
        //静态内部类里面可以创建静态属性和方法；
        static String twoString = "你好，吃了吗";
        static void showPlease(){
            System.out.println("打个招呼："+twoString);
        }
        String twoName;
        void whoYouAre(){
            Father fa = new Father();
            fa.name = "Say Hi";
            System.out.println("我是成员内部类：静态内部类："+twoName);
            System.out.println(fa.name);
        }

    }

}

class GrandPa{
    //非静态内部类
    class Dady{
        void sayDaddy(){
            System.out.println("Daddy");
        }
        //局部内部类
        class Me{
            void sayMe(){
                System.out.println("Me");
            }
        }
    }
}
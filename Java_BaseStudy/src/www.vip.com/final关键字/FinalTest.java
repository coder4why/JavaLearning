package www.vip.com.final关键字;

/**
 * final关键字的作用：
 *      1.修饰变量：被他修饰的变量不可改变。一旦赋了初值，就不能被重新赋值；
 *      2.修饰方法：该方法不可被子类重写，但是可以被重载；
 *      3.修饰类：修饰的类不可被继承；
 */

public class FinalTest {
}
//子类无法继承final修饰的class
final class Earth{
    String which;
}

class Person{
    //final修饰的属性，不可被重新赋值；
    final String name = "Person类";
    String school;

    //final修饰的父类方法不可被子类重写，可以被子类调用
    final void gotoSchool(){
        System.out.println("去学校");
    }
    void goHome(){
        System.out.println("回家");
    }
}

class Boy extends Person{
    @Override
    void goHome() {
        gotoSchool();
//        name = "你好"; //无法重新赋值
        System.out.println( "这个男生");
    }
}
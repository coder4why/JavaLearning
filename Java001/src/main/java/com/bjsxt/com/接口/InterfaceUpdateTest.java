package com.bjsxt.com.接口;

/**
 * 在接口Interface中扩展一个default方法：
 *      default修饰的方法不是抽象方法，所以不强制被重写，但是可以被重写，重写的时候去掉default关键字；
 *      public可以省略，default不能省略；
 *      default修饰的方法:
 *          实现类无需实现，由Interface本身来实现;
 *          实现类可以重写default修饰的方法；
 *      default方法格式：
 *          public default 返回值类型 方法名(参数列表){}
 *
 */
public class InterfaceUpdateTest {

    public static void main(String[] args) {

        InterfaceIMP imp = new InterfaceIMP();
        imp.show();
        imp.doWhat();
        imp.sayWords();
        imp.doSomething();

    }

}

interface InterfaceUpdate{
    void show();
    void doWhat();

    /**
     * 在接口中，添加一个默认方法，
     *   具体实现类，则无需实现该方法；
     */
   default void sayWords() {
        System.out.println("你说什么？");
    }
    default void doSomething() {
        System.out.println("你做了什么？");
    }
}

/**
 * 所有接口实现类：必须实现接口中的方法；
 *  接口中由default修饰的方法，接口实现类无需实现；
 */
class InterfaceIMP implements InterfaceUpdate{

    @Override
    public void show() {
        System.out.println("搞什么飞机!");
    }

    @Override
    public void doWhat() {
        System.out.println("干啥啊！");
    }

    @Override
    public void doSomething() {
        System.out.println("打了个大飞机！");
    }



}
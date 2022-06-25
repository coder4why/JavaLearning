package com.bjsxt.com.接口;

/**
 * Java 9中新增了带方法体的私有方法；
 * 格式1：(基本私有方法)
 *     private 返回值类型 方法名(参数列表){}
 * 格式2：(静态私有方法)
 *     private static 返回值类型 方法名(参数列表){}
 *
 */
public class InterfacePrivateTest {
    public static void main(String[] args) {

        MyInterface imp = new MyIMP();
        imp.doOne();
        imp.doSecond();

        MyInterface.doThird();
        MyInterface.doFour();

    }
}

interface MyInterface{

    default void doOne(){
        doTheSame();
        doStaticSame();
        System.out.println("做第一件事");
    };
    default void doSecond(){
        doTheSame();
        doStaticSame();
        System.out.println("做第二件事");
    };
    static void doThird(){
        doStaticSame();
        System.out.println("做第三件事");
    };
    static void doFour(){
        doStaticSame();
        System.out.println("做第四件事");
    }

    private void doTheSame(){
        System.out.println("调用接口中private常规方法");
    }
    private static void doStaticSame(){
        System.out.println("调用接口中private静态方法");
    }

}

class MyIMP implements MyInterface{

}
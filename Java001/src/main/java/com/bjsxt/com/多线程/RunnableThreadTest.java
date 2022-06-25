package com.bjsxt.com.多线程;

/* 多线程的实现方式1：Thread */
/**
 * 多线程的实现方式2:Runnable （Java中常用的多线程实现方式，Java不推荐使用第一种方式（继承会产生一些弊端））
 *      1.定义一个类(如：MyRunnable)，实现Runnable接口；
 *      2.重写run()方法；
 *      3.创建类(MyRunnable)的对象；
 *      4.创建Thread类的对象，把MyRunnable对象作为构造方法的参数；
 *      5.执行Thread对象的start()/run()方法，启动线程；
 */
public class RunnableThreadTest {
    public static void main(String[] args) {

        /** 3.创建类(MyRunnable)的对象；*/
        MyRunnable myRunnable = new MyRunnable();
        /** 4.创建Thread类的对象，把MyRunnable对象作为构造方法的参数；*/
        Thread thread = new Thread(myRunnable,"火箭");
        /** 5.执行Thread对象的start()/run()方法，启动线程；*/
        thread.start();

        MyRunnable myRunnable1 = new MyRunnable();
        Thread thread1 = new Thread(myRunnable1,"汽车");
        thread1.start();
    }
}
/**
 * 使用Thread和Runnable接口实现多线程的区别：
 *    1.使用Thread，逻辑更简单，实现类只能继承Thread,不可继承其他父类(Java不支持多继承，可实现接口多继承)；
 *          class HpkThread  extends Thread{}
 *    2.使用Runnable，实现逻辑更复杂点，但是实现类可以同时兼容继承和接口实现；
 *      class MyRunnable extends Object implements Runnable{}
 */
/**
 * 使用Runnable接口，相比继承Thread类的好处：
 *     1.避免了Java单继承的局限性；
 *     2.适合多个相同程序的代码去处理同一个资源的情况，把线程和程序的代码、数据有效分离，
 *       较好的体现了面向对象的设计思想；
 */

/** 1.定义一个类(如：MyRunnable)，实现Runnable接口；*/
class MyRunnable implements Runnable{
    /** 2.重写run()方法；*/
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"："+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


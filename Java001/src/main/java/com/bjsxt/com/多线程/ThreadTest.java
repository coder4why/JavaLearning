package com.bjsxt.com.多线程;

/**
 * 进程：正在执行的应用程序
 * 线程：是进程中的单个顺序控制流，是一条执行路径；
 *     单线程：一个进程如果只有一条执行路径，则称为单线程程序；
 *     多线程：一个进程如果有多条执行路径，则称为多线程程序；
 */

/**
 * 多线程的实现方式：
 *    1.Thread：
 *         a.创建一个新的执行线程有两种方法，一个是将一个类声明为Thread的子类，
 *      这个子类应该重写Thread类的run()方法，然后可以分配并启动子类的实例；
 *    2.Runable:
 *         b.创建一个新的线程的另一个方法，声明一个实现了Runnable接口的类，实现run()方法；
 *
 *    3.
 */

/**
 * 方法1：继承Thread类
 *     a.定义一个类继承Thread；
 *     b.在类中重写run()方法；
 *     c.创建类的对象
 *     d.启动线程
 */
/**
 * 为什么要重写run()方法：
 *      因为run()方法是用来封装被线程执行的代码
 * run()和start()的区别：
 *      run():封装线程执行的代码，直接调用，相当于普通方法的调用
 *      start():启动线程，然后由JVM调用此线程的run()方法；
 */

class HpkThread  extends Thread{

    /** 通过构造方法设置线程名称 **/
    HpkThread(String name){
        super(name);
    }
    HpkThread(){}
    @Override
    public void run() {
        System.out.println(this.getName());
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"："+i);
        }
    }
}

public class ThreadTest {

    /**
     * run():封装线程执行的代码，直接调用，相当于普通方法的调用
     * start():启动线程，然后由JVM调用此线程的run()方法；
     */
    static void normalUse(){
        HpkThread thread = new HpkThread();
        thread.start();
        HpkThread thread1 = new HpkThread();
        thread1.start();
    }

    /**
     * 设置和获取线程名称：
     *      1.setName()：设置线程名称
     *      2.getName()：获取线程名称
     */
    static void operatorThread(){
        HpkThread hpkThread = new HpkThread();
        hpkThread.setName("我是线程1");
        hpkThread.start();

        HpkThread hpkThread1 = new HpkThread();
        hpkThread1.setName("我是线程2");
        hpkThread1.start();


        HpkThread thread = new HpkThread("高铁");
        thread.start();
    }

    /**
     *  Thread.currentThread():获取当前线程对象；
     */
    public static void main(String[] args) {
        normalUse();
        operatorThread();
        System.out.println("=========="+Thread.currentThread().getName()+"===========");

    }


}

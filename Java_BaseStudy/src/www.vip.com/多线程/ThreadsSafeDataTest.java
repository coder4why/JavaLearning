package www.vip.com.多线程;

/**
 * 多线程数据安全的问题：
 * 1.是否有多线程环境
 * 2.是否共享数据
 * 3.是否有多条语句操作共享数据(添加线程锁，任意时刻，只能一个线程操作一个任务)
 */
public class ThreadsSafeDataTest {

    public static void main(String[] args) {

//        ShareData shareData = new ShareData();
        ShareDataThis shareData = new ShareDataThis();
//        ShareDataSynchronizedMethod shareData = new ShareDataSynchronizedMethod();
        Thread thread = new Thread(shareData, "窗口1");
        Thread thread1 = new Thread(shareData, "窗口2");
        Thread thread2 = new Thread(shareData, "窗口3");

        thread.start();
        thread1.start();
        thread2.start();

    }

}

/**
 * 同步代码块：
 * 锁多条语句操作共享数据，可以使用同步代码块实现；
 * 格式:
 * synchronized(任意对象){
 * 操作共享数据的代码
 * }
 * synchronized(任意对象)：相当于给代码加锁了，任意对象就可以看成是一把锁；
 * <p>
 * 同步的好处和弊端：
 * 好处：解决了多线程的数据安全问题；
 * 弊端：当线程很多时，因为每个线程都会去判断同步上的锁，这是很消耗资源的，无形中会降低程序的运行效率；
 */

class ShareData implements Runnable {

    private int numbers = 100;
    private Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (numbers > 0) {
                    System.out.println(
                            Thread.currentThread().getName() + "----剩余:" + numbers
                    );
                    numbers--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}

class ShareDataThis implements Runnable {

    private int numbers = 1000;

    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                if (numbers > 0) {
                    System.out.println(
                            Thread.currentThread().getName() + "----剩余:" + numbers
                    );
                    numbers--;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }else {
                    break;
                }
            }
        }
    }
}


class ShareDataSynchronizedMethod implements Runnable {

    private int numbers = 100;

    private static int tickets = 100;

    @Override
    public void run() {

//        synchronizedData();
        staticSynchronizedData();

    }

    /**
     * 同步方法：
     *      就是把 synchronized 关键字加到方法上
     * 格式：
     *      修饰符 synchronized 返回值类型 方法名(方法参数){}
     * 同步方法的锁对象是什么？
     *      this对象；
     */
    private synchronized void synchronizedData() {
        while (numbers >= 0) {
            System.out.println(
                    Thread.currentThread().getName() + "----剩余:" + numbers
            );
            numbers--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 同步静态方法：
     *      就是把 synchronized 关键字加到静态方法上
     * 格式：
     *      修饰符 static synchronized 返回值类型 方法名(方法参数){}
     * 同步方法的锁对象是什么？
     *      当前类(类名.class)；
     */

    private static synchronized void staticSynchronizedData() {
        while (tickets >= 0) {
            System.out.println(
                    Thread.currentThread().getName() + "----剩余:" + tickets
            );
            tickets--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


package com.bjsxt.com.多线程;
/**
 * 多线程的生命周期:
 *      1.新生：创建线程对象（调用 new 方法，创建一个线程对象）；
 *      2.就绪：调用start()方法（表示线程有被CPU调用的权限，但是没有执行权，执行权由CPU来确定）;
 *      3.执行：线程抢到CPU的执行权（被CPU调度），有执行资格，运行run()方法里的具体代码；
 *      4.死亡：线程run()方法执行完毕，或者线程主动调用stop()方法，线程将结束生命死亡，变成垃圾，
 *             被Java垃圾回收机制回收；
 *
 *      如果线程在执行时，被其他线程抢占了CPU的执行权，该线程将回到就绪状态，继续抢占CPU执行权；
 *      如果线程在执行时，调用了sleep()或者其他阻塞式方法，当前线程将丧失CPU执行资格和执行权，
 *         直到sleep()或者其他阻塞方式结束，该线程将回到就绪状态，再次等待被CPU调度执行；
 *
 */
public class ThreadLifeCycleTest {
    public static void main(String[] args) {

        ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle("毛毛虫");
//        threadLifeCycle.setPriority(10);
//        threadLifeCycle.join();
//        threadLifeCycle.setDaemon(false);
        threadLifeCycle.start();
//        threadLifeCycle.stop();
    }
}

class ThreadLifeCycle extends Thread{

    ThreadLifeCycle(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
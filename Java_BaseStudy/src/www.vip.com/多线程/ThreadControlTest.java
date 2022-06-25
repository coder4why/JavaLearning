package www.vip.com.多线程;

/**
 * 线程控制：
 *      1.static void sleep(long millis)：使当前正在执行的线程停留（暂停执行）指定的毫秒数
 *      2.void join():等待这个线程死亡；
 *          (也就是说一个线程调用了这个方法，其他的线程只有等待这个线程任务执行完毕才有机会执行)；
 *      3.void setDaemon(boolean on):将此线程标记为守护线程，当运行的线程都是守护线程(除了main主线程外)时，
 *          Java虚拟机将不会等待所有守护线程任务执行完毕，而是直接退出，结束主线程；
 */
public class ThreadControlTest {

    public static void main(String[] args) throws InterruptedException,IllegalThreadStateException {

        ControlThread controlThread = new ControlThread();
        controlThread.setName("孙权");

        ControlThread controlThread1 = new ControlThread();
        controlThread1.setName("刘备");
        ControlThread controlThread2 = new ControlThread();
        controlThread2.setName("曹操");

        controlThread.start();
        /**
         * join()方法，要在start()调用之后设置，否则无效；
         */
        controlThread.join();
        System.out.println("----------开始睡眠3s----------");
        Thread.sleep(3000);
        System.out.println("----------结束睡眠3s----------");

        /**
         * 设置为守护线程的线程，线程可能会被CPU调用，也可能不被调用，
         *     守护线程任务可能执行也可能不执行；因为主线程不会等待守护线程，而直接结束退出；
         */
        /**
         * 设置线程controlThread1为守护线程：
         *    setDaemon()方法要在start方法之前调用，否则将抛出异常；
         */
        controlThread1.setDaemon(false);
        controlThread1.start();

        /**
         * 设置线程controlThread2为守护线程
         */
        controlThread2.setDaemon(true);
        controlThread2.start();

    }
}

class ControlThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+",i:"+i);
            try {
                if (getName() != "刘备")
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
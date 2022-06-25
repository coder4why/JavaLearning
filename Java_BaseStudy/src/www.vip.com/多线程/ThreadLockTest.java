package www.vip.com.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock：
 * 提供了比使用synchronized方法和语句可以获得的更广泛的锁定操作；
 * void lock()：获得锁
 * void unlock()：释放锁
 * <p>
 * Lock是接口，不能直接实例化，这里直接采用它的实现类ReentrantLock来实例化；
 */
public class ThreadLockTest {
    public static void main(String[] args) {

        SellTicket sellTicket = new SellTicket();

        Thread thread = new Thread(sellTicket, "窗口1");
        Thread threa1 = new Thread(sellTicket, "窗口2");
        Thread threa2 = new Thread(sellTicket, "窗口3");

        thread.start();
        threa1.start();
        threa2.start();

    }
}

class SellTicket implements Runnable {
    private int tickects = 1000;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                if (tickects > 0) {
                    System.out.println(Thread.currentThread().getName() + ",剩余：" + tickects);
                    tickects--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
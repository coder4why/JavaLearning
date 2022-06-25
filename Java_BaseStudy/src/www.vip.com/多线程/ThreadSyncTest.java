package www.vip.com.多线程;

/**
 * 线程同步：
 *    需求：某电影院有100张票，有3个窗口，请设计一个程序完成卖票；
 */
public class ThreadSyncTest {

    public static void main(String[] args) {

        TicketSells ticketSalls = new TicketSells();
        Thread thread1 = new Thread(ticketSalls,"窗口1");
        Thread thread2 = new Thread(ticketSalls,"窗口2");
        Thread thread3 = new Thread(ticketSalls,"窗口3");

        /**
         *  如果线程调用的run()方法，Thread.currentThread().getName()的值将为main；
         *  如果线程调用的start()方法，Thread.currentThread().getName()的值将为设置的名称；
         */
        thread1.start();
        thread2.start();
        thread3.start();

    }

}
class TicketSells implements Runnable{

    private int numbers = 100;
    @Override
    public void run() {
        while (numbers>=0){

            System.out.println(Thread.currentThread().getName()+",剩余："+numbers);
            numbers--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("票已卖光！");

    }
}

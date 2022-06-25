package com.bjsxt.com.多线程.生产者消费者;

/**
 * Java中多线程的生产者消费者模式：
 *     1.生产者线程用于生产数据；
 *     2.消费者线程用于使用数据；
 *  为了解藕生产者和消费者关系，通常采用共享的数据区域，就是一个仓库；
 *      1.生产者生产数据之后直接放置在数据共享区，并不需要关心消费者行为；
 *      2.消费者只需要从共享数据区去获取数据，并不需要关心生产者的行为；
 */
/**
 * 为了体现生产和消费过程中的等待和唤醒，Java提供了几个方法：
 *      void wait()：导致当前线程等待，直到另一个线程调用该对象 的notify()或者notifyAll()方法；
 *      void notify()：唤醒正在等待对象监视器的单个线程；
 *      void notifyAll()：唤醒正在等待对象监视器的所有线程；
 */
/**
 * 案例：
 * 奶箱类（Box）：定义一个成员变量，表示第x瓶奶，提供存储和获取牛奶的操作；
 * 生产者类（producer）:实现Runnable接口，重写run()方法，调用存储牛奶的操作；
 * 消费者（Customer）：实现Runnable接口，重写run()方法，调用获取牛奶的操作；
 * 测试类（ThreadModeTest）:
 *      main方法实现的逻辑：
 *          1.创建奶箱对象，这是共享数据区域；
 *          2.创建生产者对象，把奶箱对象作为构造方法参数传递，因为这个类中要调用存储牛奶的操作；
 *          3.创建消费者对象，把奶箱对象作为构造方法参数传递，因为这个类中要调用获取牛奶的操作；
 *          4.创建两个线程对象，分别把生产者对象和消费者对象作为参数传入构造方法；
 *          5.启动线程；
 */
public class ThreadModeTest {

    public static void main(String[] args) {

        Box box = new Box();
        Producer producer = new Producer(box);
        Customer customer = new Customer(box);

        Thread producerThread = new Thread(producer,"生产者");
        Thread customerThread = new Thread(customer,"消费者");

        producerThread.start();
        customerThread.start();

    }

}

class Box{
    int index;
    private boolean state = false; //设置容器中是否有牛奶
    synchronized void put(int index){

        //如果容器Box中有牛奶，则等待消费者消费；
        if (state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //容器中没有牛奶，生产一瓶；
        this.index = index;
        System.out.println("送奶工将第"+index+"瓶奶送入奶箱");
        //设置容器的状态值为true；
        state = true;

        //通知消费者消费牛奶；
        notifyAll();

    }
    synchronized int get(){

        //如果容器中没有牛奶，等待生产者生产：
        if (!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("用户将第"+index+"瓶奶取出使用");

        //容器中有牛奶，消费者消费了，设置容器状态为false；
        state = false;
        //通知生产者已消费；
        notifyAll();

        return this.index;
    }
}

class Producer implements Runnable{

    Box box;
    Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        //生产牛奶
        for (int i = 1; i < 6; i++) {
            box.put(i);
        }
    }
}

class Customer implements Runnable{

    Box box;
    Customer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        //消费牛奶
       while (true){
           int index = box.get();
           if (index == 5){
               //结束生产、消费模式
               break;
           }
       }

    }
}
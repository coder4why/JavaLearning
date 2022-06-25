package www.vip.com.多线程;

/**
 * Java中线程优先级的设置：
 *      1.public final int getPriority(): 返回此线程的优先级
 *      2.public final void setPriority(int newPriority)：更改此线程的优先级
 */
/**
 * 线程调度：(在Java中使用 '抢占式调度模型')
 *     1.分时调度模型：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用CPU的时间片；
 *     2.抢占式调度模型：优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机
 *       选择一个，优先级高的线程获取的CPU时间片相对多一些；
 */
/**
 *  多线程程序执行的随机性：
 *      CPU在某一个时刻只能执行一条指令，线程只有得到CPU时间片，也就是使用权，才可以执行指令；
 *  所以说多线程程序的执行是有随机性的，因为谁抢占CPU的使用权是不确定的；
 */
public class ThreadPriorityTest {

    public static void main(String[] args) {

        PriorityThread priorityThread = new PriorityThread("普快");
        /**
         *  线程优先级数值范围为： 1(最低) - 10(最高) 的int类型；
         *  不设置优先级，优先级默认为5；
         *  优先级越高，CPU优先调度的可能性更高，不代表优先级高的任务全部执行完再执行下一个线程
         */
        priorityThread.setPriority(Thread.MIN_PRIORITY);

        PriorityThread priorityThread1 = new PriorityThread("飞机");
        priorityThread1.setPriority(Thread.MAX_PRIORITY);

        priorityThread.start();
        priorityThread1.start();

    }

}
class PriorityThread extends Thread{

    PriorityThread(String name){
        super(name);
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"，优先级："+getPriority()+",i="+i);
        }
    }
}

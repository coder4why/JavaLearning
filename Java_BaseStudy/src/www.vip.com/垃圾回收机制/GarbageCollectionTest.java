package www.vip.com.垃圾回收机制;

/**
 * Java中的垃圾回收机制:
 *      1.发现无用的对象;
 *      2.回收无用的对象;
 * 垃圾回收算法：
 *      1.引用计数法；（循环引用容易造成内存泄露）
 *          堆中的每一个对象都有一个引用计数；
 *          被引用一次，计数加1，被引用变量值变为null，则计数减1；
 *          直到计数为0，则表示变成无用对象，被回收机制回收；
 *      2.引用可达法（根搜索算法）
 */

/**
 * 通用的分代垃圾回收机制：
 *      不同对象的生命周期是不一样的，因此不同生命周期的对象可以采取不同的回收算法，
 *   以提高回收效率；
 *      我们将对象分为三种状态：年轻代、年老代、持久代；
 *      JVM将堆内存划分为Eden、Survivor和Tenured/Old空间；
 *      Eden、Survivor存储年轻代；
 *      Tenured/Old存储年老代；
 *      方法区(静态区)存储持久代；
 */

/**
 * 1.Minor GC:
 *      用于清理年轻代区域，Eden满了就会触发一次Minor GC，清理无用对象，将有用对象copy到Survivor1、
 *   Survivor2区域（这两个区，大小空间也相同，同一时刻Survivor1和Survivor2只有一个在用，一个为空）；
 * 2.Major GC:
 *      用于清理老年代区域；
 * 3.Full GC:
 *      用于清理年轻代、年老代区域，成本较高，会影响系统性能；
 */

/**
 * 1.新创建的对象绝大部分分配到Eden内存中；
 * 2.当Eden满了（达到一定比例）以后，不能创建新的对象，则触发垃圾回收机制（GC），
 *   将无用对象清理掉，然后剩余对象copy到Survivor内存中，如S1，同时清空Eden区域；
 * 3.当Eden再次满了，则会将Survivor S1区中的不能清空的对象存储到另一个Survivor中，如S2；
 *   同时将Eden区中的不能清空的对象，也copy到S1中，保证Eden和S1均被清空；
 * 4.重复多次（默认15次），Survivor中没有被清理的对象，则会复制到老年代Old（Tenured）中；
 * 5.当Old区满了，则会触发一个一次完整的垃圾回收机制（FullGC）,之前新生代的垃圾回收称为(MinorGC)
 */
/**
 * 触发Full GC的几种可能：
 *    1.年老代Old/Tenured被写满；
 *    2.持久代被写满；
 *    3.System.gc()被显式调用（程序建议GC调用，GC启不启动由垃圾回收机制来安排）；
 *    4.上一次GC之后Heap的各域分配策略动态变化；
 */
public class GarbageCollectionTest {

    public static void main(String[] args) {

    }

}

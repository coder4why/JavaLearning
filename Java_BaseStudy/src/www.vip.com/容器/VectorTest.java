package www.vip.com.容器;

import java.util.Vector;

/**
 * Vector：
 *      底层是用数组实现的List，相关的方法都加了同步检查；
 *      线程安全，效率低；
 *      indexOf方法加了synchronized同步标记；
 *  如何选用ArrayList、LinkedList、Vector？
 *      1.需要线程安全时，用Vector；
 *      2.不存在线程安全问题时，并且查找较多用ArrayList（一般使用它）；
 *      3.不存在线程安全问题时，增加或删除元素较多用LinkedList;
 */
public class VectorTest {

    public static void main(String[] args) {

        Vector<String> test = new Vector<>();
        test.add("Java");
        test.add("JavaScript");
        test.add("Swift");
        test.add("Objective-C");
        test.add("Kotolin");
        test.add("Flutter");
        test.add("Python");
        test.add("React-Native");
        test.add("HTML-CSS");
        test.add("Vue");

        System.out.println(test);
        test.remove(1);
        test.add(5," Node.js");
        Vector<String> testOne = new Vector<>();
        testOne.add("从入门到放弃");
        test.addAll(testOne);

        System.out.println(test);

    }

}

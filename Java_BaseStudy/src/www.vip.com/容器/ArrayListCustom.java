package www.vip.com.容器;
/**
 * ArrayList :
 *      底层是用数组实现的存储；
 *      特点：
 *          查询效率高，增删效率底，线程不安全；
 *          *** 增删效率高，使用LinkedList；线程安全使用Vector ***
 *
 *      数组的长度是有限的，ArrayList可以存放任意长度的对象，长度不受限制；
 */

import java.util.Arrays;

/**
 * 自定义实现一个ArrayList ： 体会底层原理
 */
public class ArrayListCustom {

    private Object[] elementData;
    private int size;

    private static final int  DEFAULT_CAPACITY = 10;

    public  ArrayListCustom(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object obj){
        elementData[size++] = obj;
    }

    @Override
    public String toString() {
        return "ArrayListCustom{\n" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public ArrayListCustom(int capacity){
        elementData = new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayListCustom arrayList = new ArrayListCustom(20);
        arrayList.add("aa");
        arrayList.add("bb");
        System.out.println(arrayList.toString());
    }

}






package www.vip.com.函数式接口;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *  函数式接口作为方法的返回值：
 *  需求：
 *      1.定义一个类，在类中提供两个方法
 *          一个是Comparator<String> getComparator(),方法返回值Comparator是一个函数式接口；
 *          一个方法是main方法，在祝方法中调用getComparator方法；
 */
public class OMGInterfaceReturnTest {

    private static Comparator<String> getComparator(){

        /** 匿名内部类的写法：*/
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        };

        /** Lambda表达式的写法：*/
        /** 如果方法的返回值是一个函数式接口，我们可以使用Lambda表达式作为结果返回*/
        Comparator<String> comparator = (o1,o2)-> o1.length()-o2.length();
        return comparator;

    }

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("c");
        arrayList.add("bb");
        arrayList.add("dddd");

        System.out.println("排序前："+arrayList);

        /** 系统排序：*/
        Collections.sort(arrayList);
        System.out.println("排序后-System："+arrayList);

        /** 自定义排序：*/
        Collections.sort(arrayList,getComparator());
        System.out.println("排序后-Custom："+arrayList);

    }
}

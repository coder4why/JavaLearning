package com.bjsxt.com.容器;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * 容器 Collection：
 *      装其他对象或基本数据类型的一个对象；
 *      数组本身也是一个容器；
 *
 *      Collection两个子接口:
 *          List：有序、可重复的容器，List中的每个元素都有索引标记，可通过索引访问元素；
 *              List常用的实现类有3个：ArrayList、LinkedList和Vector；
 *          Set：无序且不可重复，不可添加重复元素；
 *
 */
public class CollectionTest {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<String>();
        list.add("Shang");
        list.add("Hai");

        System.out.println(list.toString());

        /**
         *  Collection两个子接口List和Set ：
         *      List：有序
         *      Set：无序
         */
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> numbers1 = new ArrayList<Integer>();
        /**
         //单个容器操作：
         * add : 添加元素
         * size : 元素个数
         * isEmpty : 判断容器是否为空
         * contains : 是否包含元素
         * remove ： 删除元素
         * sort ：容器元素排序
         * clear ：清空所有元素
         * indexOf ：获取指定元素第一次出现的索引位置，未找到（不包含）返回-1；
         * lastIndexOf: 获取指定元素最后一次出现的索引位置，未找到（不包含）返回-1；
         * get ：获取索引位置的元素；

         //两个容器的操作：
         * containsAll : 是否包含另一个容器所有元素
         * removeAll : 从一个容器里面移除另一个容器里面的都包含的公共元素；
         * equals : 判断两个容器是否相等
         * addAll：添加另一个容器所有元素
         * retainAll : 取本容器和容器contain中都包含的元素，移除非交集元素；
         */
        //添加元素
        numbers.add(99);
        numbers.add(66);
        numbers.add(120);
        //顺序插入
        numbers1.add(1001);
        //索引插入
        numbers.add(1,2020);

        /**
         * indexOf：获取指定元素第一次出现的索引位置，未找到（不包含）返回-1；
         * lastIndexOf: 获取指定元素最后一次出现的索引位置，未找到（不包含）返回-1；
         */
        int index = numbers.indexOf(2020);
        int lastIndex = numbers.lastIndexOf(2022);

        //获取索引位置的元素：
        Integer num = numbers.get(2);
        System.out.println("2号位："+num);

        //容器排序
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
        //判断容器是否相等
        System.out.println(numbers.equals(numbers1));

        //容器元素个数
        System.out.println(numbers.size());
        //判断容器是否为空
        System.out.println(numbers.isEmpty());
        System.out.println(numbers);
        //判断容器是否包含某个元素
        System.out.println("是否包含元素："+numbers.contains(100));
        //判断容器是否包含另一个容器里面的所有元素
        System.out.println("是否包含容器："+numbers.containsAll(numbers1));
        //容器添加另一个容器的所有元素
        numbers.addAll(numbers1);
        //添加容器元素到指定索引
        numbers1.addAll(1,numbers);
        System.out.println(numbers);
        System.out.println(numbers1);

        numbers1.add(1314);
        /**
         * 从一个容器里面移除另一个容器里面的都包含的公共元素；
         */
        numbers1.removeAll(numbers);
        System.out.println("numbers1:"+numbers1);
        //按索引移除容器元素
        numbers.remove(0);
        System.out.println(numbers);
        //清空容器
        numbers.clear();
        System.out.println(numbers);

        Collection<String> contain1 = new ArrayList<>();
        contain1.add("ShangHai");
        contain1.add("Jia Ding");

        Collection<String> contain = new ArrayList<>();
        contain.add("ShangHai");
        //取本容器和容器contain中都包含的元素，移除非交集元素；
        contain1.retainAll(contain);
        System.out.println(contain1);
        System.out.println(contain);

    }


}

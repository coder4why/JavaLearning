package com.bjsxt.com.迭代器;
import java.util.*;

/**
 * 迭代器：
 *      为我们提供了统一的遍历容器的方式遍历容器元素（List、Set、Map）；
 */

public class InteratorTest {

    //迭代器遍历List：
    public static void searchList(){

        List<String> lists = new ArrayList<>();
        lists.add("任贤齐");
        lists.add("刘德华");
        lists.add("周杰伦");
        lists.add("林俊杰");

        /**
         *  Collection的iterator()，返回一个迭代器
         *
         *   hasNext(): 判断是否还有下一个元素
         *   next()：获取下一个元素
         */
        for (Iterator<String> iter = lists.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }

    }
    //迭代器遍历Set：
    public static void searchSet(){
        Set<String> sets = new HashSet<>();
        sets.add("任贤齐--");
        sets.add("刘德华--");
        sets.add("周杰伦--");
        sets.add("林俊杰--");

        /**
         *  Collection的iterator()，返回一个迭代器
         *
         *   hasNext(): 判断是否还有下一个元素
         *   next()：获取下一个元素
         */
        for (Iterator<String> iter = sets.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    //迭代器遍历Map：
    public static void searchMap(){

        System.out.println("Map迭代器方式一-----------");
        Map<String,Integer> maps = new HashMap<>();
        maps.put("方文山",1);
        maps.put("习近平",2);
        maps.put("胡锦涛",3);
        maps.put("温家宝",4);

        /**
         * Map遍历方式一：
         *    Map遍历跟Set、List的小区别；
         *      先获取entrySet()：获取的是由key、value组成的List数组；
         *      在根据entrySet()获取迭代器；
         *      最后遍历；
         */
        Set<Map.Entry<String ,Integer>> sets = maps.entrySet();
        System.out.println(sets);
        System.out.println("遍历1------");
        for (Iterator<Map.Entry<String,Integer>> iterator = sets.iterator();iterator.hasNext();){
            Map.Entry<String,Integer> next = iterator.next();
            System.out.println(next);
        }

        System.out.println("Map迭代器方式二-----------");
        /**
         * Map遍历方式二：
         *    Map遍历跟Set、List的小区别；
         *      先获取keySet()：获取的是由所有key组成的list数组
         *      在根据keySet()数组获取迭代器；
         *      最后遍历；
         */
        Set keys = maps.keySet();
        System.out.println(keys);
        System.out.println("遍历2------");
        for (Iterator iterator = keys.iterator();iterator.hasNext();){
            Object key = iterator.next();
            Integer next = maps.get(key);
            System.out.println(""+key+next);
        }

    }

    //另一种遍历方式：while循环
    public static void searchWithDiff(){

        Set<String> sets = new HashSet<>();
        sets.add("樊玉芳");
        sets.add("我爱你");
        sets.add("你爱我吗？");
        sets.add("爱的");

        Iterator<String> iterator = sets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if (iterator.next() == "爱的"){
                /**
                 * 如果要遍历时，删除集合中的元素，建议使用这种方式
                 */
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

        searchList();
        searchSet();
        searchMap();
        searchWithDiff();

    }

}

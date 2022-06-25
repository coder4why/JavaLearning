package com.bjsxt.com.Collections工具类;

import java.util.*;

/**
 *  Collections：
 *      提供了对Set、List、Map进行排序、填充、查找元素的辅助方法；
 *      1.sort(List) ： 对List内的元素排序，规则是按照升序排列；
 *      2.shuffle(List) ：对List容器内的元素进行随机排列；
 *      3.reverse(List) ：对List容器内的元素进行逆序排列；
 *      4.fill(List,Object) : 用一个特定的对象重写整个List容器；
 *      5.binarySearch(List,Object) : 对于顺序的List容器，采用折半查找的方式查找特定对象；
 */
public class CollectionsTest {

    public static void doList(){
        List<String> lists = new ArrayList<String>();
        lists.add("1.白蛇传说");
        lists.add("3.大话西游");
        lists.add("2.笑傲江湖");
        lists.add("4.武林外传");

        //随机排列
        Collections.shuffle(lists);
        System.out.println(lists);
        //排序:升序
        Collections.sort(lists);
        System.out.println(lists);
        //逆序
        Collections.reverse(lists);
        System.out.println(lists);
        //binarySearch:二分法查找list中的元素，找不到返回负数
        System.out.println(Collections.binarySearch(lists,"张三"));
        System.out.println(Collections.binarySearch(lists,"4.武林外传"));

    }

    public static void doSet(){
        Set<String> sets = new HashSet<String>();
        sets.add("新三国");
        sets.add("水浒传");
        sets.add("西游记");
        sets.add("红楼梦");


    }

    public static void doMap(){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("阿里巴巴",1);
        map.put("腾讯",2);
        map.put("百度",3);
        map.put("字节跳动",4);
    }


    public static void main(String[] args) {
        doList();
        doSet();
        doMap();
    }

}

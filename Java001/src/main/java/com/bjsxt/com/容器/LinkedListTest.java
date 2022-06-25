package com.bjsxt.com.容器;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *  LinkedList : 链表 LinkedList继承List接口，
 *               List继承Colletion接口，Collection有的方法LinkedList都有；
 *       底层：用双向链表实现的存储；
 *       特点：查询效率低，增删效率高，线程不安全；
 */
public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<String> links = new LinkedList<>();
        links.add("Hello");
        links.add("ShangHai");

        LinkedList<String> lists = new LinkedList<>();
        lists.add("Ni Hao");
        lists.add("JiaDingqu");

        LinkedList<String> tests = new LinkedList<>();
        tests.addAll(links);
        tests.addAll(0,lists);

        System.out.println(tests.toString());

    }

}

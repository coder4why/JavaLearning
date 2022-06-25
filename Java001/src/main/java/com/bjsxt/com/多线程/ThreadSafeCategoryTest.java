package com.bjsxt.com.多线程;

import java.util.*;

/**
 * Java中线程安全的几个类：
 *      StringBuffer：
 *          线程安全，可变的字符串；
 *          JDK5开始，被StringBuilder代替，通常应该使用StringBuilder，因为它支持所有相同的操作
 *          但它更快，因为它不执行同步（底层实现没有synchroized锁）；
 *      Vector：
 *          Vector实现了线程安全，ArrayList没有实现线程安全，ArrayList效率更高；
 *      Hashtable：
 *          Hashtable实现了线程安全，HashMap没有实现线程安全，HashMap效率更高；
 */
public class ThreadSafeCategoryTest {

    public static void main(String[] args) {

        /**
         * Vetor、Hashtable在实际应用中，通常不直接使用，而是通过Collections类来产生一个线程安全的对象；
         */
        /** 产生一个线程安全的List */
        List lists = Collections.synchronizedList(new ArrayList<String>());

        /** 产生一个线程安全的Map类 */
        Map map = Collections.synchronizedMap(new HashMap<String,Integer>());

    }

}

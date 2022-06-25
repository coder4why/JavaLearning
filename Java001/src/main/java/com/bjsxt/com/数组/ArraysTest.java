package com.bjsxt.com.数组;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {

        int[] a = {10,2,3};
        System.out.println(a.toString());
        //数组转字符串输出
        System.out.println(Arrays.toString(a));

        //sort：自动排序（从小到大）
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //查找元素的索引：没找到返回负数
        int index = Arrays.binarySearch(a,3);
        System.out.println(index);


    }

}

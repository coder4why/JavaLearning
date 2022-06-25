package com.bjsxt.com.内存分析;

class Analyses{
    String test;
}
//内存分析
//类存储在方法区
public class MallocAnalyse {

    //对象属性存放在堆；
    public String testStr;
    String malloc;

    //方法存储在栈中；public修饰为外部访问；
    public void testMe(){
        //"我是一个对象方法" 字符串将村粗在方法区；
        // printf方法存储在栈中；
        System.out.printf("对象方法:"+this.testStr);
    }

    //main方法存储在栈中；
    public static void main(String[] args) {

        //mac对象存储在堆中；
        MallocAnalyse mac = new MallocAnalyse();
        //"测试单元"、"测试数据"存储在方法区；
        mac.testStr = "测试单元";
        mac.malloc = "测试数据";
        mac.testMe();

        /**
          Java虚拟机内存分为三类：
             1.栈stack、堆heap、方法区method area;
          栈的特点：
            1.栈描述的是方法执行的内存模型，每个方法被调用都会创建一个栈帧（存储局部变量、操作数、方法出口等）；
            2.JVM 为每个线程创建一个栈，用于存放该线程执行方法的信息（实际参数、局部变量等）；
            3.栈属于线程私有，不能实现线程间的共享；
            4.栈的存储特性是"先进后出，后进先出";
            5.栈是由系统自动分配，速度快！栈是一个连续的内存空间！
         堆的特点：
            1.堆用于存储创建好的对象和数组（数组也是对象）；
            2.JVM只有一个堆，被所有线程共享；
            3.堆是一个不连续的内存空间，分配 灵活，速度慢！
         方法区（又叫静态区）特点：
            1.JVM只有一个方法区，被所有线程共享；
            2.方法区实际也是堆，只是用于存储类、常量相关的信息！
            3.用来存放程序中永远不变或唯一的内容（类信息[class对象]、静态常量、字符串常量等）
         */

    }

}

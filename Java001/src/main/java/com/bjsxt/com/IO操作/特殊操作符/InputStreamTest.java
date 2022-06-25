package com.bjsxt.com.IO操作.特殊操作符;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *  标准输入流：InputStream
 *      该流已经打开，准备提供输入数据；通常，该流对应于键盘输入；
 *  标准输出流：PrintStream
 *      该流已经打开并准备好接受输出数据；通常，此流对应于显示输出；
 *
 *  InputStream和PrintStream都属于系统System类中的两个静态的成员变量；
 *
 **/
public class InputStreamTest {

    public static void main(String[] args) throws IOException {

//        InputStream inputStream = System.in;
//        int by;
//        while ((by=inputStream.read())!=-1){
//            System.out.print((char)by);
//        }

        //如何把字节流转换成字符流
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //使用字符流能不能够一次读取一行数据呢？可以
        //但是，一次读取一行数据的方法是字符缓冲输入流的特有方法；

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个字符串：");
        System.out.println("你输入的字符串是："+bufferedReader.readLine());
        System.out.println("请输入一个数字：");
        System.out.println("你输入的数字是："+Integer.parseInt(bufferedReader.readLine()));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        System.out.println(scanner.nextLine());


    }

}

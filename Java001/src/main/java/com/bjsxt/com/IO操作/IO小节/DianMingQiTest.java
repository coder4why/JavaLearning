package com.bjsxt.com.IO操作.IO小节;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * 需求：点名器
 *      文件里面存储了某个班级的学生姓名，每个学生姓名占一行，要求通过程序实现随机点名器；
 */
public class DianMingQiTest {

    static void sayStudentsName() throws IOException {

        ArrayList<String> students = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest1.txt"));
        String len;
        while ((len = bufferedReader.readLine())!=null){
            students.add(len);
        }
        bufferedReader.close();

        Random random = new Random();
//        int index = Math.abs(random.nextInt())%(students.size());
        int index = random.nextInt(students.size());

        String name = students.get(index);
        System.out.println(name);


    }

    public static void main(String[] args) throws IOException{

        sayStudentsName();

    }

}

package com.bjsxt.com.IO操作.IO小节;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 需求：
 *      把学生信息（学号、姓名、年龄、居住地）写入到文本文件；
 *      要求每个学生的信息作为一行数据；
 *
 */
public class ListToFileAdvancedTest {

    private static class Student{

        int id;
        String name;
        int age;
        String address;
        Student(int id,String name,int age,String address){
            this.id = id;
            this.name = name;
            this.age = age;
            this.address = address;
        }

        @Override
        public String toString() {
            return
                    "   " + id +
                    "   " + name +
                    "   " + age +
                    "   " + address;
        }
    }

    static void saveStudentsInfos() throws IOException{

        Student ljj = new Student(1,"林俊杰",38,"中国香港");
        Student zjl = new Student(2,"周杰伦",40,"中国台湾");
        Student xsy = new Student(3,"小沈阳",39,"辽宁铁岭");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(ljj);
        students.add(zjl);
        students.add(xsy);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/bufferedTest.txt"));
//        bufferedWriter.newLine();
//        bufferedWriter.write("   学号   姓名   年龄   地址");
//        bufferedWriter.newLine();
        for (Student student :
                students) {
            String message = student.toString();
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();

    }

    public static void main(String[] args) throws IOException {
        saveStudentsInfos();
    }


}

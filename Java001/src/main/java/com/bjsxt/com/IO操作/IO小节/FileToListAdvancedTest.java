package com.bjsxt.com.IO操作.IO小节;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 文件到集合：
 *     把文本文件中的数据读取到集合中，并遍历集合；
 *     要求：文件中每一行数据是一个学生对象的成员变量值；
 *
 *     学生信息： 1 林俊杰 38 中国香港
 *
 */
public class FileToListAdvancedTest {

    static class Student{
        int id;
        String name;
        int age;
        String address;

        @Override
        public String toString() {
            return "学生信息：{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    '}';
        }

        static Student stringToMe(String message){

            Student student = new Student();
            String[] mes = message.split("   ");
            int id = Integer.parseInt(mes[1]);
            String name = mes[2];
            int age = Integer.parseInt(mes[3]);
            String address = mes[4];
            student.id = id;
            student.name = name;
            student.age = age;
            student.address = address;
            return student;

        }
    }

    static void fileToList() throws IOException{

        ArrayList<Student> students = new ArrayList<Student>();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("./src/com/bjsxt/com/IO操作/测试文件/bufferedTest.txt")
        );
        String message;
        while ((message = bufferedReader.readLine())!=null){
            Student  student =  Student.stringToMe(message);
            students.add(student);
        }

        bufferedReader.close();

        for (Student std :
                students) {
            System.out.println(std.toString());
        }

    }


    public static void main(String[] args) throws IOException {

        fileToList();

    }

}

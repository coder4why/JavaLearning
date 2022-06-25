package com.bjsxt.com.构造器;

public class Student {

    String name ;
    String address;
    int age;
    int score;
    Computer comp;

    //不带参数的构造函数
    Student(){
    }

    //带参数的构造函数
    Student(String name,String address,int age,int score,Computer comp){
        this.name = name;
        this.score = score;
        this.address = address;
        this.age = age;
        this.comp = comp;
    }

    //类方法：
    static Student initMe(String name,String address,int age,int score,Computer comp){
        Student std = new Student();
        std.name = name;
        std.address = address;
        std.age = age;
        std.score = score;
        std.comp = comp;
        return std;
    }

    //对象（实例）方法
    void descriptionMe(){
        System.out.printf("-------------------------\n");
        System.out.printf(
                "姓名:"+name+'\n'+"家庭住址:"+address+"\n"+"年龄:"+age+"\n"+"总分:"+score+"\n"+"电脑品牌:"+comp.brand+"\n"
        );
    }

    public static void main(String[] args) {

        Computer copm = new Computer();
        copm.brand = "Dell";
        Student std = Student.initMe("小高","湖北省黄冈市",28,750,copm);
        std.descriptionMe();

        Computer comp = new Computer();
        comp.brand = "MacBook Pro";
        Student newStd = new Student("小虎","中国香港",30,700,comp);
        newStd.descriptionMe();

    }

}

class Computer {
    String brand;
}
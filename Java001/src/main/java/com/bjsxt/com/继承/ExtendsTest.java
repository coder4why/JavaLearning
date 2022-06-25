package com.bjsxt.com.继承;

public class ExtendsTest {

    public static void main(String[] args) {
        Student std = new Student("北京尚学堂","高琪");
        std.sleep();
        std.play();

        //instanceof : 判断某个对象是否是某个类对象
        boolean isPerson = std instanceof Person ;
        System.out.println(isPerson);
        boolean isStudent = std instanceof Student ;
        System.out.println(isStudent);
        boolean isObject = std instanceof Object ;
        System.out.println(isObject);

        Person per = new Person("gaiqi");
        boolean isStud = per instanceof Student ;
        System.out.println(isStud);

    }
}

class Person{
    String name;
    //private:修饰的方法或者成员变量只能当前类访问，子类无法访问
    private String address;
    Person(String name){
        this.name = name;
    }
    void sleep(){
        System.out.println(name+"在睡觉");
    }
    //private:修饰的方法或者成员变量只能当前类访问，子类无法访问
    private void goHome(){
        System.out.println(name+"回家了");
    }
}

//继承关键字：extends （Java里面只能单继承，不能多继承）
class Student extends Person{
    String school;
    void play(){
        System.out.println(name+"在"+school+"玩游戏");
    }
    Student(String school,String name){
        super(name);
        this.school = school;
    }

}

package com.bjsxt.com.构造器;

public class ConstructorTest {

    public static void main(String[] args) {

        /**
         *  创建一个对象的四步：
         *      1.分配对象空间，并将对象成员变量初始化为0或者null；
         *      2.执行属性值的显式初始化；
         *      3.执行构造方法；
         *      4.返回对象的地址给相关变量
         */
        Person person1 = new Person("小高","清华大学");
        Person person2 = new Person("小宋","北京大学");
//        Person person3 = new Person();
        person1.outputMsg();
        person2.outputMsg();

    }

}


class Person{

    String name;
    String school;

    //this不能使用在Static方法中；
    public Person(String name){
        this.name = name;
    }
    //构造方法名称和类名称必须保持一致
    //构造器不能定义返回值类型（返回值的类型肯定是本类），不能在构造器里使用return返回某个值；
    public Person(String _name,String _school){
        //构造方法的第一句总是super(),未添加则编译时自动添加；
//        name = _name;
//        school = _school;
        this(_name); //public Person(String name)
        //this本质表示创建好的对象地址；在构造方法调用前，对象已经创建，因此在构造方法中也可以使用this表示当前对象
//        this.name = _name;
        this.school = _school;

    }

    //如果没有定义构造器，编译器会自动定义一个无参的构造器，如果已定义则编译器不会自动添加！
    public Person(){
        System.out.printf("调用了我");
    }

    //对象方法
    public void outputMsg(){
        System.out.printf("\n"+name+","+school);

    }

}
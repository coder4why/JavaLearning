package com.bjsxt.com.存储表格数据;

import java.util.*;

/**
 * 使用容器存储表格数据
 */
public class SaveExcelDataTest {
    public static void main(String[] args) {

        Personable zhangsan = new Personable(10001,19,"张三",1800,"2020.1.1");
        Personable lisi = new Personable(10002,21,"李四",4800,"2019.2.1");
        Personable wangwu = new Personable(10003,30,"王五",800,"2021.3.1");

        //Map存储数据
        Map<Integer,Personable> personDatas = new HashMap<Integer,Personable>();
        personDatas.put(1,zhangsan);
        personDatas.put(2,lisi);
        personDatas.put(3,wangwu);

        for (Integer k:personDatas.keySet()
        ) {
            System.out.println("Map---:"+personDatas.get(k).toString());
        }
        //List存储数据
        List<Personable> tableDatas = new ArrayList<Personable>();
        tableDatas.add(zhangsan);
        tableDatas.add(lisi);
        tableDatas.add(wangwu);

        for (Personable k:tableDatas
        ) {
            System.out.println("List---:"+k.toString());
        }

        //Set存储数据；
        Set<Personable> tableSets = new HashSet<Personable>();
        tableSets.add(zhangsan);
        tableSets.add(lisi);
        tableSets.add(wangwu);
        for (Personable k:tableSets
        ) {
            System.out.println("Set---:"+k.toString());
        }



    }

}

/**
 * javabean对象：
 *      属性 方法
 */
class Personable {
    int id;
    int age;
    String name;
    double salary;
    String date;
    /**
     * 一个完整的javabean对象：
     *     要有set()和get()方法，已经一个形参为空的构造器
     */
    Personable(){}
    Personable(int id,int age,String name, double salary,String date){
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.date = date;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", date='" + date + '\'';
    }
}
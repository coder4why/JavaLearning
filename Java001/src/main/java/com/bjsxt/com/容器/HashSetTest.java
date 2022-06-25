package com.bjsxt.com.容器;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set的使用：继承自Collection
 *      Set：无序不可重复；（List有序可重复）
 *      无序：指Set中的元素没有索引，只能遍历查找；
 *      不可重复：指不允许加入重复的元素，更确切的讲，
 *          新元素如果和Set中的某一个元素通过equals方法对比为true，则不能加入；
 *      Set中也只能放入一个null元素，不能多个；
 *      实现类：HashSet（常用）和TreeSet（不常用）等;
 */
public class HashSetTest {
    public static void main(String[] args) {

        Set<String> sets = new HashSet<>();
        sets.add("我");
        sets.add("是");
        sets.add("一");
        sets.add("只");

        //相同元素不可重复加入
        sets.add("小");
        sets.add("小");

        sets.add("鸟");
        sets.add(null);
        sets.add(null);
        //Set元素add后，无序排列；
        //[一, null, 我, 只, 是, 小, 鸟]
        System.out.println(sets);

        sets.remove(null);
        System.out.println(sets);

        Set<String> sets1 = new HashSet<>();
        sets1.add("任贤齐");
        sets1.add("谢霆锋");
        sets.add("金城武");

        sets.addAll(sets1);
        System.out.println(sets);

        sets.removeAll(sets1);
        sets.clear();

        TreeSetImp.treeSetTest();

    }
}

//HashSet: 无序不可重复
//TreeSet：有序不可重复，自增排列
class TreeSetImp {

    public static void treeSetTest() {

        Set<String> treeSets = new TreeSet<>();
        treeSets.add("Hello");
        treeSets.add("World");
        treeSets.add("Hello");
        treeSets.add("BeiJing");
        treeSets.add("ShenZheng");

        //[BeiJing, Hello, ShenZheng, World]
        System.out.println(treeSets);

        TreeSetEmp emp1 = new TreeSetEmp(1,"gaoqi1",10000);
        TreeSetEmp emp2 = new TreeSetEmp(2,"gaoqi2",8000);
        TreeSetEmp emp3 = new TreeSetEmp(3,"gaoqi3",5000);
        TreeSetEmp emp4 = new TreeSetEmp(4,"gaoqi4",7000);
        TreeSetEmp emp5 = new TreeSetEmp(5,"gaoqi5",5000);

        Set<TreeSetEmp>  empSets = new TreeSet<>();
        empSets.add(emp1);
        empSets.add(emp2);
        empSets.add(emp3);
        empSets.add(emp4);
        empSets.add(emp5);

        for (TreeSetEmp e:empSets
             ) {
            System.out.println(e.toString());
        }

    }

}
class TreeSetEmp implements Comparable<TreeSetEmp>{

    int id;
    double salary;
    String name;
    TreeSetEmp(int id , String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'';
    }

    @Override
    public int compareTo(TreeSetEmp o) {

        if (this.salary > o.salary){
            return 1;
        }else if(this.salary < o.salary){
            return  -1;
        }else {
            if (this.id > o.id){
                return 1;
            }else {
                return -1;
            }
        }
    }
}
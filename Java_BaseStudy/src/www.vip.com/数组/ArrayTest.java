package www.vip.com.数组;

import java.lang.reflect.Array;

/**
 * Java数组是相同类型数据的有序集合；
 *     通过下标索引访问；
 *     数组变量属于引用类型，数组就属于对象，数组的元素属于成员变量；
 */
public class ArrayTest {
    public static void main(String[] args) {
        //一、数组的声明方式两种：
        //1.方式一
        int[] numbers = {1,2,3};
        //2.方式二
        double nums[] = {1.0,2.0,3.0};

        //对象数组；
        PersonModel[] models = new PersonModel[2]; //设置数组的长度
        for (int i = 0; i < 2 ; i++) {
            PersonModel model = new PersonModel("高琪"+(i+1),i+1);
            models[i] = model;
        }
        for (int i = 0; i < models.length; i++) {
            System.out.println(models[i].name);
        }

        //二、数组的三种初始化方式：默认初始化、静态初始化、动态初始化
        //1.静态初始化
        int a[] = {1,2,3};
        PersonModel b[] = {new PersonModel("gaoqi",10)};
        //2.默认初始化:默认给数组的元素进行赋值，赋值规则跟成员变量默认赋值规则一致
        double d[] = new double[10];
        //3.动态初始化
        String strs[] = new String[2];
        strs[0] = "Hello";
        strs[1] = "Java";

        //三、数组的遍历
        //for循环
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
        //foreach循环:m是元素，a是数组
        for (int m:a
             ) {
            System.out.println("forEach："+m);
        }
    }
}

class PersonModel{
    String name;
    int age;
    PersonModel(String name,int age){
        this.name =  name;
        this.age = age;
    }
}
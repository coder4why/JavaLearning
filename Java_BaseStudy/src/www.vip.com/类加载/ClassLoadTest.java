package www.vip.com.类加载;

/**
 * 类加载：
 *        当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过类的加载，类的连接，
 *     类的初始化这三个步骤来对类进行初始化；如果不出现意外的话，JVM将会连续完成这三个步骤，
 *     所以有时也把这三个步骤统称为类加载或者类初始化；
 * 类的加载：
 *      就是指将class文件读入内存，并为之创建一个java.lang.Class对象；
 *      任何类被使用时，系统都会为之建立一个java.lang.Class对象；
 * 类的连接：
 *      验证阶段：用于检验被加载的类是否有正确的内部结构，并和其他类协调一致；
 *      准备阶段：负责为类的类变量分配内存，并设置默认初始化值；
 *      解析阶段：将类的二进制数据中的符号引用替换为直接引用；
 * 类的初始化：
 *      在该阶段，主要是对类变量进行初始化；
 *      初始化步骤：
 *          1.假如该类还未被加载和连接，则程序先加载和连接该类；
 *          2.假如该类的直接父类还未被初始化，则先初始化其直接父类；
 *          3.假如类中有初始化语句，则系统依次执行这些初始化语句；
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JVM三种类加载机制：
 *      全盘负责、父类委托、缓存机制；
 */
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException {

        /** 获取类 */
        Class<?> aClass = Class.forName("www.vip.com.类加载.StudentTest");

        /**
         * 获取类的构造器：
         *      getConstructors()：只能获取到public修饰的公共构造方法；
         *      getDeclaredConstructors():可以获取到所有的构造方法（不管是private、default、public）；
         *
         */
        Constructor[] cons = aClass.getConstructors();
        for (Constructor c:cons
             ) {
            System.out.println(c);
        }
        System.out.println("--------------------");
        Constructor<?>[] constructors = aClass.getDeclaredConstructors();
        for (Constructor c :
                constructors) {
            System.out.println(c);
        }
        System.out.println("--------------------");

        /**
         * 获取类的构造器：
         *      getDeclaredConstructor():获取到任意修饰符修饰的构造方法，返回构造器
         *      getConstructor():获取到public修饰符修饰的构造方法，返回构造器
         */
        Constructor constructor = aClass.getDeclaredConstructor(String.class,int.class);
        /** 使用暴力反射*/
        constructor.setAccessible(true);
        /** 使用默认构造函数，构建类的对象*/
        //Object object = constructor.newInstance();

        /**
         * 通过指定的构造函数，构建类的对象；
         * 如果构造函数为private修饰的，那么需要对构造器使用暴力反射；
         *      constructor.setAccessible(true);
         */
        Object object = constructor.newInstance("林青霞",30); //参数类型要与构造器参数类型一致；

        /**
         * 获取成员变量并赋值：
         *      getDeclaredField(String arg):获取到任意修饰符修饰的成员变量
         *      getField(String arg):获取到public修饰符修饰的成员变量
         */
        Field ageFiled = aClass.getDeclaredField("age");
        ageFiled.setAccessible(true);
        /**
         *  如果Filed对应的属性为private修饰的，那么需要对Filed对象使用暴力反射；
         *      ageFiled.setAccessible(true);
         */
        ageFiled.set(object,30);

        Field nameFiled = aClass.getField("name");
        nameFiled.set(object,"胡先生");

        Field addressField = aClass.getDeclaredField("address");
        addressField.setAccessible(true);
        addressField.set(object,"上海嘉定");

        System.out.println(object);

        System.out.println("===========================");

        /** 调用类的对象方法*/
        /**
         * getMethods():获取当前类、父类、超类的所有public修饰的方法；
         * getDeclaredMethods()：获取当前类、父类、超类的所有方法；
         */
        Method[]  methods = aClass.getMethods();
        Method[] deMethods = aClass.getDeclaredMethods();

        /**
         * getMethod():获取当前类的public方法；
         * getDeclaredMethod()：获取当前类的任意方法；
         */
        /** 1.无参无返回值**/
        Method showOne = aClass.getMethod("showOne");
        showOne.invoke(object);

        Method showTwo = aClass.getDeclaredMethod("showTwo");
        showTwo.setAccessible(true);
        /**
         * Method对应的方法为private修饰的方法，则使用暴力反射；
         *      showTwo.setAccessible(true);
         */
        showTwo.invoke(object);

        Method showThree = aClass.getDeclaredMethod("showThree");
        showThree.invoke(object);

        /** 2.有参数无返回值*/
        Method showFour = aClass.getDeclaredMethod("showFour",String.class);
        showFour.invoke(object,"上海");

        Method showFive = aClass.getDeclaredMethod("showFive", String.class);
        showFive.setAccessible(true);
        showFive.invoke(object,"中国");

        /** 3.有参数有返回值*/
        Method showEight = aClass.getDeclaredMethod("showEight", String.class);
        showEight.setAccessible(true);
        Object address = showEight.invoke(object,"上海市嘉定区");
        System.out.println(address);


    }
}

class StudentTest{

    public String name;
    private int age;
    private String address;

    StudentTest(){}
    public StudentTest(String name){
        this.name = name;
    }
    private StudentTest(String name,int age){
        this.name = name;
        this.age = age;
    }
    StudentTest(String name,int age,String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void showOne(){
        System.out.println("方法---1");
    }

    private void showTwo(){
        System.out.println("方法---2");
    }

    void showThree(){
        System.out.println("方法---3");
    }

    public void showFour(String name){
        System.out.println(name);
    }

    private void showFive(String address){
        System.out.println(address);
    }

    void showSix(int age){
        System.out.println(age);
    }

    public String showSeven(int age){
        return String.valueOf(age);
    }

    private String showEight(String address){
        return address+"-----000";
    }

    String showNine(String name){
        return name+"-----111";
    }

    @Override
    public String toString() {
        return "StudentTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}


package com.bjsxt.com.Lambda表达式;
/**
 * Lambda表达式和匿名内部类的区别：
 *    1.所需类型不同：
 *      a.匿名内部类：可以是接口，也可以是抽象类，还可以是具体类；
 *      b.Lambda表达式：只能是接口；
 *    2.使用限制不同：
 *      a.如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类；
 *      b.如果接口中多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式；
 *    3.实现原理不同：
 *      a.匿名内部类：编译之后，产生一个单独的.class字节码文件；
 *      b.Lambda表达式：编译之后，没有产生一个单独的.class字节码文件,对应的字节码会在运行的时候动态产生；
 */
public class LambdaAndSystemTest{

    private static void useSayWords(SayWords sayWords){
        sayWords.show();
        System.out.println("---------------------------");
    }

    private static void useWho(Who who){
        who.method();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static void useStudents(Students students){
        students.study();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * 方法一：使用匿名内部类：
     */
    private static void useNewCategory(){
        /** 使用匿名内部类：接口实现*/
        useSayWords(new SayWords() {
            @Override
            public void show() {
                System.out.println("使用匿名内部类");
            }

//            @Override
//            public void show1() {
//                System.out.println("使用匿名内部类实现接口的多个方法");
//            }
        });

        /**使用匿名内部类：抽象类 */
        useWho(new Who() {
            @Override
            void method() {
                System.out.println("我是一个小学生");
            }
        });

        /** 使用匿名内部类：重写类的方法 */
        useStudents(new Students(){
            @Override
            void study() {
                System.out.println("使用匿名内部类重写方法");
            }
        });
    }

    /**
     * 使用Lambda表达式：
     */
    private static void useLambda(){

        /**
         * 如果接口有多个方法，不能使用Lambda表达式，但是可以使用匿名内部类；
         */
        useSayWords(()-> System.out.println("使用Lambda表达式实现01"));

        //class类不能使用Lambda表达式；

    }


    public static void main(String[] args) {
//        useNewCategory();
        useLambda();

    }

}

interface SayWords{
   void show();
//   void show1();
}
abstract class Who{
    abstract void method();
}
class Students{
    void study(){
        System.out.println("爱生活,爱Java");
    }
}
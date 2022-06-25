package com.bjsxt.com.Lambda表达式;

/**
 * Lambda表达式格式：
 * 格式：(形参)->{ 代码块 }
 * 形参：如果有多个参数，参数之间用逗号隔开；没有参数，留空即可；
 * ->: 由英文中划线和大于符号组成，固定写法；代表指向动作；
 * 代码块：是我们具体要做的事情，也就死以前我们写的方法体内容；
 * <p>
 * Lambad表达式的使用前提：
 * 1.有一个接口；
 * 2.接口中有且仅有一个抽象方法；
 */

/**
 * Lambda表达式的省略规则：
 *     1.参数类型可以省略，但是有多个参数的情况下，不能只省略一个；
 *     2.如果参数有且仅有一个，那么小括号可以省略；
 *     3.如果代码块只有一行，那么可以省略大括号和分号，同时return也可以省略；
 */
public class LambdaTest {

    private static void useEatable(Eatable e) {
        e.eat();
    }

    private static void birdFly(Bird bird){
        bird.fly("快飞呀！");
    }

    private static void  whichCar(Car car){
        String band = car.whichBand(100000,20000);
        System.out.println("我开"+band);
    }

    public static void main(String[] args) {

        //使用多线程在控制台输出一句话：
        new Thread(() -> {
            System.out.println("我是用Lambda表达式写的一个实现");
        }).start();

        //使用接口实现类输出：
        Eatable e = new EatableImp();
        useEatable(e);

        //使用匿名内部类输出：
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("匿名内部类");
            }
        });

        /**
         * 1、Lambda表达式：无参数，无返回值
         */
        useEatable(()->{

            System.out.println("使用Lambda表达式来实现");

        });

        /**
         * 2、Lambda表达式：带参数，无返回值
         */
        birdFly(new Bird() {
            @Override
            public void fly(String destination) {
                System.out.println(destination+"，飞到了北京");
            }
        });
        birdFly((String s)->{
            System.out.println("大雁，"+s);
        });

        /**
         * 3、Lambda表达式：带参数，带返回值；
         */
        whichCar((int a,int b)->{
            if (a+b<200000){
                return "奥迪";
            }else if(a<=400000) {
                return "奔驰";
            }else {
                return "宝马";
            }
        });

        /**
         * 4、Lambda表达式省略模式：参数的类型可以省略，
         *   多个参数的情况下，不能只省略一个；
         */
        whichCar((a,b)->{
            if (a+b<200000){
                return "奥迪";
            }else if(a<=400000) {
                return "奔驰";
            }else {
                return "宝马";
            }
        });
        /**
         * 5.Lambda表达式省略模式：
         *      如果只有一个参数，参数类型可以省略，参数外部的小括号可以省略：
         */
        birdFly(s->{
            System.out.println("大雁----，"+s);
        });

        /**
         * 6.Lambda表达式省略模式：
         *      如果代码快只有一行代码，,可以省略大括号和分号；
         */
        birdFly(s->
            System.out.println("大雁+++++++，"+s)
        );

        /**
         * 7.Lambda表达式省略模式：
         *      如果代码快只有一行代码，,可以省略大括号和分号；
         *      如果代码块有return，return也要省略掉；
         */
        whichCar((a,b)-> "奥迪-------");
    }

}

interface Eatable {
    //无参方法：
    abstract void eat();
}
class EatableImp implements Eatable {
    @Override
    public void eat() {
        System.out.println("吃什么吃！");
    }
}
interface Bird{
    abstract void fly(String destination);
}
interface Car{
    abstract String whichBand(int a,int b);
}


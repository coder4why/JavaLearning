package com.bjsxt.com.if语句;

//流程控制语句 if-else
public class JudgeTest {

    public static void main(String[] args) {
        /**
         * 快捷键：
         *      souf -> System.out.printf("");
         *      psvm -> public static void main(String[] args)
         *
         */
        // double a = Math.random(); //生成一个0到1的随机数
        int b = 1 + (int)((Math.random()) * 6); //生成一个1-6之间的数字
        System.out.println(b);
        if (b<=2){
            System.out.println("摇了一个小数");
        }else if(b>2 && b<=3){
            System.out.println("摇了一个中位数");
        }else {
            System.out.printf("摇了一个大数");
        }

        biaoqianCode();

    }

    //无形参无返回值的函数：
    static void biaoqianCode(){
        int sum = 0;
        //带标签的语句
        cycle: for (int i = 0; i < 10; i++) {
            if (i%2==0){
                continue cycle; //跳转到标签行
            }else {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}


//Java里面的 class 类名称必须大写,每个Class都有一个main方法
public class Welcome {

    //成员变量：定义在类内部、方法外部；属于当前类对象
    int age = 0; //成员变量（实例变量）
    //静态变量：定义在类内部，static修饰；属于当前类；
    static String name = "小高"; //静态变量

    public static void main(String[] args /*这是main函数的注释*/) {
        //局部变量：定义在方法或者语句块内部；属于当前方法或者语句块
        int number = 0; //局部变量
        System.out.println(number);
        System.out.println("开始学Java!");
        //调用其他函数：
        Hello.main(null);
    }
}

class Hello{

    protected static void main(String[] args) {
        //测试变量的声明和初始化:变量在使用前需要初始化，Java没有默认值；
        // int age;
        // String name;
        // System.out.println(age);
        System.out.println("主函数调用了我-Hello");
        showWords();
    }

    private static void showWords(){
        System.out.println("要说技术哪家强，\n当属中国尚学堂。\n学堂一支穿云箭，\n万水千山来相见。");
    }
}

/**
 * Java对大小写敏感；如果出现了 大小写拼写错误，程序无法运行；
 * public class 类名称 必须与文件名称一致；Welcome.java 类名称为Welcome
 * public为访问修饰符，用于控制程序的其他部分对这段代码的访问级别；
 * class的意思是类，Java是面向对象的语言 ，所有的代码必须位于类里面；
 * 一个源文件中最多只能声明一个public的类，其他类的个数不限，如果源文件中包含了
   一个public的类，源文件名必须与public的类名相同，且以".java"为扩展名；
 * 一个源文件可以包含多个类class；
 * 使用javac 正确编译后的源文件，会得到相应的字节码文件，编译器为每个类生成独立的字节码文件，
   且将字节码文件自动命名为类的名称且且以“.class”为扩展名；
 * main方法是Java程序的入口方法；
 * **/

 /**
  * Java中的标识符命名规则：不以数字为开头，可以以字母、中文、美元符号、下划线开头等；命名常用驼峰命名；
    表示类名的标识符首字母大写，变量和方法名称首字母小写；
 **/
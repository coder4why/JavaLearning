package www.vip.com.Java基础;

public class MethodTest {

    public static void main(String[] args) {

        TestClass cls = new TestClass();
        cls.init();
        //传入方法的实际数据，称为实参；
        // 参数传递：基本数据类型的传递是值的copy，引用数据类型的传递是对象的copy，但指向的是同一个对象
        cls.init(10,20);
        cls.init(10,20,30);
        cls.init(10.0,20);
        cls.init(10,20.0);

        long d1 = System.currentTimeMillis();
        System.out.println(d1);
        cls.diguiMethod();
        long d2 = System.currentTimeMillis();
        System.out.println(d2-d1);

        //
        System.out.printf("开始循环");
        cls.cycleMethod();
    }

}

class TestClass{

    /*
        方法的重载：
            方法名称相同、形参类型或者个数不同，构成重载；
            方法名称相同，形参类型相同，形参名称不同的，不构成重载；
            方法名称相同，形参类型相同，返回值类型不同的，不构成重载（调用时无法区分哪个方法）
     */

    //Method 1：
    void init(){
        System.out.println("原始构造函数");
    }

    //overload:
    //方法重载1：有形参的函数；
    void init(int a,int b){
        int sum = a + b;
        System.out.println("方法重载1："+sum);
    }

    //方法重载2：有形参的函数；
    void init(int a,int b,int c){
        int sum = a + b + c;
        System.out.println("方法重载2："+sum);
    }

    //方法重载3：有形参的函数；
    void init(double a,int b){
        double sum = a + b;
        System.out.println("方法重载3："+sum);
    }

    //方法重载4：有形参的函数；
    void init(int a,double b){
        double sum = a + b;
        System.out.println("方法重载4："+sum);
    }

    static int a = 100;
    //递归函数：自己调自己
    void diguiMethod(){
        a--;
        System.out.println("递归:"+(10-a)+"次");
        if (a==5){
            return;
        }else {
           diguiMethod();
        }
    }

    static int b = 100;
    void cycleMethod(){
        long d1 = System.currentTimeMillis();
        System.out.println(d1);
        for (int i = 0; i < b; i++) {
            if (i==5){
                break;
            }else {
                System.out.println("递归:"+i+"次");
            }
        }
        long d2 = System.currentTimeMillis();
        System.out.println(d2-d1);

    }

}
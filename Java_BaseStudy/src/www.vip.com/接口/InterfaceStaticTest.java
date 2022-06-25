package www.vip.com.接口;

/**
 * 接口Interface中的静态static方法：
 *      格式：
 *          public static 返回值类型 方法名(参数列表){}
 * 接口实现类，不能访问Interface接口中static修饰的方法；
 * 接口实现类，可以访问Interface接口中static修饰的属性；
 */
public class InterfaceStaticTest {

    public static void main(String[] args) {

        System.out.println(OurInterface.doWhat(1));

        OurIMP ourIMP = new OurIMP();
        /** 接口实现类，不能访问Interface接口中static修饰的方法；*/
        // OurIMP.doWhat(1);
        /** 接口实现类，可以访问Interface接口中static修饰的属性； */
        System.out.println(OurIMP.id);

        ourIMP.doSomething();
        ourIMP.missWho();

    }

}

interface OurInterface {

    static int id = 1000;

    void doSomething();

    default void missWho(){
        System.out.println("想念谁？");
    }

    /** 接口中的静态方法，接口具体实现类不能访问调用 */
    static String doWhat(int i){

        return "Java学习册——"+i;

    }

}

class OurIMP implements OurInterface{

    @Override
    public void doSomething() {
        System.out.println("你们干了什么？");
    }

}
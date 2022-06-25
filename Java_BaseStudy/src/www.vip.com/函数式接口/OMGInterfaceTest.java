package www.vip.com.函数式接口;

/**
 * 函数式接口：
 *     有且仅有一个抽象方法的接口；
 *     Java中的 函数式编程体现就是Lambda表达式，所以函数式接口就是可以适用于Lambda使用的接口；
 *  只有确保接口中有且仅有一个抽象方法，Java中的Lambda才能顺利的进行推导；
 */
public class OMGInterfaceTest {

    public static void main(String[] args) {

        OmgInterface omg = ()-> System.out.println("函数式接口");
        omg.show();

    }
}

/**
 * @FunctionalInterface：用来标记一个interface为函数式接口
 *    只要保证接口中有且仅有一个抽象方法，该接口就是函数式接口，@FunctionalInterface标记
 * 就可以省略，但是通常建议加上该注解；
 */
@FunctionalInterface
interface OmgInterface{
    void show();
}



package www.vip.com.函数式接口;

/**
 * 函数式接口作为参数：
 * 需求：
 *    1.定义一个类(RunnableDemo)，在类中提供两个方法；
 *      一个方法是，startThread(Runnable r)，r是一个函数式接口；
 *      一个方法是main方法，在main方法中调用 startThread方法；
 */
public class OMGInterfaceParamasTest {

    private static void startThread(BMWApi api){
        api.show();
    }
    public static void main(String[] args) {

        BMWApi api =  new BMWApi() {
            @Override
            public void show() {
                System.out.println("宝马公司")  ;
            }
        };

        BMWApi bmwApi =  ()-> System.out.println("BMW-宝马公司");

        startThread(api);
        startThread(bmwApi);

        /** 如果方法的参数是一个函数式接口，我们可以使用Lambda表达式作为参数传递 */
        startThread(()->System.out.println("Audi-奥迪公司"));

    }

}

@FunctionalInterface
interface BMWApi{
    void show();
}

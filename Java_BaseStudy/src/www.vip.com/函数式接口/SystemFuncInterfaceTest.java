
package www.vip.com.函数式接口;
import java.util.function.Supplier;

/**
 * 常用的函数式接口：
 *    Java 8在java.util.function包下预定义了大量的函数式接口供我们使用；
 *    重点来学习下面的4个接口：
 *      Supplier<T>接口：
 *          1.包含一个无参的方法； T get()获得结果；
 *          2.该方法不需要参数，它会按照某种实现逻辑（由Lambda表达式实现）返回一个数据；
 *          3.Supplier<T> 接口也被称为生产型接口，如果我们指定了接口的泛型是什么类型，
 *            那么接口中get方法就会产生什么类型的数据供我们使用；
 *      Customer接口；
 *      Predicate接口；
 *      Function接口；
 */
public class SystemFuncInterfaceTest {

    private static String getString(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {

        String lqx = getString(()->"林青霞");
        System.out.println(lqx);
        SupplierTest.main();
        
    }

}

class SupplierTest{

    private static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    public static void main() {
        
        int[] arr = {20,19,22,30,100,99};
        int maxInt = getMax(()->{
            int  max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]>max){
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println(maxInt);
        
    }

}
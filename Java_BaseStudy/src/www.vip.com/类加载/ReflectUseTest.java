package www.vip.com.类加载;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectUseTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(9);
        numbers.add(20);
        numbers.add(100);

        /** 使用反射往Integer类型的数组里面添加字符串类型 */
        Class cClass = ArrayList.class;
        Method add = cClass.getDeclaredMethod("add",Object.class);
        add.invoke(numbers,"hello");
        add.invoke(numbers,"world");
        add.invoke(numbers,"java");

        System.out.println(numbers);


    }


}

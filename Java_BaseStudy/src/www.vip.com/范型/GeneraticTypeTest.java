package www.vip.com.范型;
import java.util.Date;
/**
 * 范型：
 *    帮助我们建立类型安全的集合
 */
public class GeneraticTypeTest {
    /**
     * 范型应用：
     */
    public static <T> void showMe(T t){
        System.out.println(t);
    }
    public static void main(String[] args) {
        showMe("I Love You");
        showMe(100);
        showMe(new Date());

        Person<String> person = new Person<>();
        person.showMe("类的范型");
        person.me = "I want you";

        Person<Integer> person1 = new Person<>();
        person1.showMe(100);
        person1.me = 10086;
        System.out.println(person.me);
        System.out.println(person1.me);

    }
}

class Person<T>{
    T me;
    public void showMe(T t){
        System.out.println(t);
    }
}
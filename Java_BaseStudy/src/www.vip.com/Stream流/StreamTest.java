package www.vip.com.Stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream流初体验：
 *    1.创建一个集合，存储多个字符串；
 *    2.把集合中所有以"张"开头的元素存储到一个新的集合；
 *    3.把"张"开头的集合中的长度为3的元素存储到一个新的集合；
 *    4.遍历上一步得到的集合；
 */
public class StreamTest {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("张曼玉");
        names.add("张柏芝");
        names.add("林黛玉");
        names.add("章子怡");
        names.add("张敏");
        names.add("周慧敏");
        names.add("张无忌");

        List<String> secondNames = new ArrayList<>();
        for (String name:names) {
            if (name.startsWith("张")){
                System.out.println(name);
                secondNames.add(name);
            }
        }

        System.out.println("-----------------------");
        List<String> thirdNames = new ArrayList<>();
        for (String name:secondNames) {
            if (name.length() == 3){
                thirdNames.add(name);
            }
        }

        for (String n:thirdNames) {
            System.out.println(n);
        }

        System.out.println("======Stream流的使用=====");
        names.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(
                s-> System.out.println(s)
        );

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Stream<String> streamNames = names.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3);
        streamNames.forEach(System.out::println);

    }

}

package www.vip.com.Stream流;

/**
 * Stream流的生成方式：
 *    1.生成流：
 *       通过数据源(集合、数组等)生成流：list.stream()；
 *    2.中间操作：
 *       一个流后面可以跟随0个或者多个中间操作，其目的主要是打开流，做出某种程度的数据过滤/映射，
 *    然后返回一个新的流，交给下一个操作使用；
 *        filter():
 *              用于对流中的数据进行过滤；
 *        limit(long maxSize):
 *              返回此流中的元素组成的流，截取前指定参数个数的数据（截取0->limitSize个元素）；
 *        skip(long n):
 *              跳过指定参数个数的数据(跳过0->n个长度的数据)，返回由该流的剩余元素组成的流；
 *        static Stream concat(Stream a,Stream b)：
 *              合并 a 和 b 两个流为一个流；
 *        distinct()：
 *              返回由该流的不同元素(根据Object.equals(Object))组成的流；
 *        sorted()：
 *              返回由此流的元素组成的流，根据自然顺序排序；
 *        sorted(Comparator comparator)：
 *              返回由该流的元素组成的流，根据提供的Comparator进行排序；
 *        map(Function mapper)：
 *              返回由给定函数应用于此流的元素的结果组成的流；
 *        IntStream mapToInt(ToIntFunction mapper):
 *                  mapToDouble(ToIntFunction mapper):
 *              返回一个IntStream其中包含将给定函数应用于此流的元素的结果
 *         collect():
 *              Stream流的收集操作（把Stream流的元素收集到集合Collection中）；
 *
 *    3.终结操作：
 *        一个流只能有一个终结操作，当这个操作执行后，流就被使用"光"了，无法再被操作，所以这必定
 *     是流的最后一个操作；如:forEach();
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Stream流的常见生成方式：
 *    1.Collection体系的集合可以使用默认方法stream()生成流；
 *          default Stream<T> stream()；
 *    2.Map体系的集合间接的生成流：
 *    3.数组可以通过Stream接口的静态方法of(T values)生成流；
 */
public class StreamFuncTest {

    /** 生成流 */
    private static void createStream(){

        /**Collection体系的集合*/
        List<String> list = new ArrayList<>();
        list.add("上海");
        list.add("北京");
        Stream<String> stringStream = list.stream();

        Set<String> stringSet = new HashSet<>();
        stringSet.add("南京");
        stringSet.add("苏州");
        Stream<String> stringStream1 = stringSet.stream();

        /** Map体系的集合*/
        Map<String,Object> map = new HashMap<>();
        map.put("name","小芳芳");
        map.put("age",18);
        map.put("city","武汉");

//        Stream<String> keyStream = map.keySet().stream();
//        Stream<Object> valueStream = map.values().stream();

        /** entrySet() 返回一个Set<K,V> Collection集合 */
        Stream<Map.Entry<String, Object>> mapStream = map.entrySet().stream();
        mapStream.forEach(System.out::println);

        /**
         * 数组可以通过Stream接口的静态方法of(T values)生成流;
         *    也可以通过Arrays.stream(T[])方法生成流；
         */
        String[] strings = new String[2];
        Stream<String> stream = Stream.of(strings);
        Stream<String> stream1 = Stream.of("shanghai","beijing");
        Stream<Integer> stream2 = Stream.of(1,2,3);

        Stream<String> arrayStream = Arrays.stream(strings);

    }

    /** filter() : 条件筛选 */
    private static void filterStream(){

        List<String> list = new ArrayList<>();
        list.add("SHNAGHAI");
        list.add("SHENZHENG");
        list.add("GUANGZHOU");
        list.add("WUHAN");
        list.add("XIANGGUANG");
        list.stream().filter(s-> s.startsWith("S")).forEach(System.out::println);
        list.stream().filter(s-> s.startsWith("S")).filter(s->s.length()>8).forEach(System.out::println);

    }

    /** limit(long maxSize)：从0截取maxSize个元素组成新流*/
    private static void limitStream(){
        List<String> list = new ArrayList<>();
        list.add("SHNAGHAI");
        list.add("SHENZHENG");
        list.add("GUANGZHOU");
        list.add("WUHAN");
        list.add("XIANGGUANG");

        Stream<String> stream = list.stream();
        Stream<String> limitStream = stream.limit(2);
        limitStream.forEach(System.out::println);

    }

    /** skip(long n)：从第n个索引开始截取元素组成新流*/
    private static void skipStream(){
        List<String> list = new ArrayList<>();
        list.add("SHNAGHAI");
        list.add("SHENZHENG");
        list.add("GUANGZHOU");
        list.add("WUHAN");
        list.add("XIANGGUANG");

        Stream<String> stream = list.stream();
        Stream<String> skipStream = stream.skip(2);
        skipStream.forEach(System.out::println);

    }

    /** Stream.concat(a,b)：合并两个流的元素组成新流*/
    private static void concatStream(){
        List one = new ArrayList<>();
        one.add("SHNAGHAI");
        one.add("SHENZHENG");
        one.add(false);
        one.add(100);
        List<String> two = new ArrayList<>();
        two.add("GUANGZHOU");
        two.add("WUHAN");
        two.add("XIANGGUANG");

        Stream<String> oneStream = one.stream();
        Stream<String> twoStream = two.stream();
        Stream concatStream = Stream.concat(oneStream,twoStream);
        concatStream.forEach(System.out::println);

    }

    /** distinct()：返回该流中的不同元素组成的新流*/
    private static void distinctStream(){
        List list = new ArrayList<>();
        list.add("SHNAGHAI");
        list.add("SHENZHENG");
        list.add("GUANGZHOU");
        list.add("WUHAN");
        list.add("XIANGGUANG");
        list.add(100);
        list.add(false);
        list.add(1.00);
        list.add("XIANGGUANG");

        Stream stream = list.stream();
        Stream distinctStream = stream.distinct();
        distinctStream.forEach(System.out::println);
    }

    /** distinct()：返回该流中的不同元素组成的新流*/
    private static void sortedStream(){
        List list = new ArrayList<>();
        list.add(100);
        list.add(99);
        list.add(88);
        list.add(111);
        list.add(121);
        list.add(100);
        list.add(1);
        list.add(1000);
        Stream stream = list.stream();
//        Stream sortedStream = stream.sorted();
//        Stream comparatorStream = stream.sorted(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Integer ob1 = (Integer)o1;
//                Integer ob2 = (Integer)o2;
//                return ob1 > ob2 ? -1:1;
//            }
//        });
        Stream comparatorStream = stream.sorted((s1,s2)-> (int)s1>(int)s2 ?-1:1);
        comparatorStream.forEach(System.out::println);

    }

    /** map()：返回给定函数应用于此流的元素的结果组成的新流*/
    private static void mapStream() {
        List list = new ArrayList<>();
        list.add(100);
        list.add(99);
        list.add(88);
        list.add(111);
        list.add(121);
        list.add(100);
        list.add(1);
        list.add(1000);
        Stream stream = list.stream();

        /** 将集合中的元素通过map指定函数转化为新的元素输出 */
//        stream.sorted().map(s->String.valueOf(s)+"-a").forEach(System.out::println);
        /** 将集合中的Integer元素通过mapToDouble指定函数 转化为Double类型输出 */
        DoubleStream doubleStream = stream.sorted().mapToDouble(s->Double.valueOf((int)s));

        /** IntStream、DoubleStream中的sum()方法 对Stream中的所有元素求和*/
//        double sum = doubleStream.sum();
//        System.out.println(sum);
        /** Stream中的count()方法：统计Stream中的元素个数 */
//        stream.count();
        doubleStream.forEach(System.out::println);;


    }

    /**
     * Stream流的collect方法：
     *    R collect(Collector collector)
     *    工具类Collectors提供了具体的收集方法 ：
     *      toList():把元素收集到List集合中；
     *      toSet()：把元素收集到Set集合中；
     *      toMap():把元素收集到Map集合中；
     */
    private static void collectStream(){
//        List list = new ArrayList<>();
//        list.add(88);
//        list.add(111);
//        list.add(1);
//        list.add(1000);
//        Stream stream = list.stream();
//
//        List list1 = (List) stream.collect(Collectors.toList());
//        System.out.println(list1);

//        HashSet list2 = (HashSet) stream.collect(Collectors.toSet());
//        System.out.println(list2);

        Map<String,Object> testMap = new HashMap<>();
        testMap.put("city","shanghai");
        testMap.put("code","10086");
        testMap.put("address","上海");
        Stream<Map.Entry<String,Object>> mapStream = testMap.entrySet().stream();
        mapStream.forEach(System.out::println);

    }


    public static void main(String[] args) {
        createStream();
        System.out.println("-------------------");
        filterStream();
        System.out.println("+++++++++++++++++++");
        limitStream();
        System.out.println("-------------------");
        skipStream();
        System.out.println("+++++++++++++++++++");
        concatStream();
        System.out.println("-------------------");
        distinctStream();
        System.out.println("+++++++++++++++++++");
        sortedStream();
        System.out.println("-------------------");
        mapStream();
        System.out.println("+++++++++++++++++++");
        collectStream();
    }

}

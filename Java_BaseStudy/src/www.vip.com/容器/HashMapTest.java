package www.vip.com.容器;

import java.util.HashMap;
import java.util.Map;

/**
 * Map：
 *     是用来存储键值对的，Map中的键值对通过键来标识，所有键值对对象不能重复；
 *     Map接口的实现类有HashMap、TreeMap、HashTable、Properties等；
 *          1.HashMap底层实现采用了哈希表，这是一种非常重要的数据结构；
 *          2.哈希表 的基本结构是"数组+链表"；
 *          3.HashMap：线程不安全，效率高，允许key或者value为null；
 *            HashTable:线程安全，效率低，不允许key或者value为null；
 *          4.HashMap和HasHTable用法几乎一样，底层实现几乎一样，只不过HashTable的
 *            方法添加了synchronized关键字确保线程同步检查，效率较低；
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        /**
         * Map接口的常用方法：
         *      1.put(Object key,Object value)：存放键值对
         *      2.get(Object key)：根据key获取value；
         *      3.remove(Object  key):根据key移除键值对
         *      4.containsKey(Object key)：Map容器是否包含key所对应的键值对
         *      5.containsValue(Object value)：Map容器是否包含value所对应的键值对
         *      6.size():Map容器键值对的个数；
         *      7.isEmpty()：Map容器是否为kong；
         *      8.putAll(Map map):将map的所有键值对存放到容器中；
         *      9.clear():清空本Map所有的键值对；
         */

        //添加键值对
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);

        //判断Map容器是否为空
        System.out.println(map.isEmpty());

        //判断是否包含One为key的键值对；
        System.out.println(map.containsKey("One"));
        //判断是否包含1为Value的键值对；
        System.out.println(map.containsValue("1"));

        //根据key查询value：
        Integer value = map.get("One");
        System.out.println(value);

        //获取Map容器的键值对个数：
        System.out.println(map.size());

        //移除键值对
        map.remove("Three");
        map.remove("Two",2);
        System.out.println("MapOne:"+map);

        Map<String,Integer> secMap = new HashMap<>();
        secMap.put("Four",4);
        secMap.put("Five",5);
        secMap.put("Six",6);
        secMap.put("Seven",7);

        //添加另一个集合的所有键值对
        map.putAll(secMap);

        /**
         * 再次添加已包含的键值对:
         *      key相同，value将覆盖；One:1 --> One:11
         *      未包含key，将新增键值对；
         */
        map.put("One",11);
        System.out.println("Map:"+map);

        //清空Map集合
        map.clear();
        System.out.println("Final:"+map);

        //对象Model
        Employee m1 = new Employee(1,"高琪1","5000");
        Employee m2 = new Employee(2,"高琪2","7000");
        Employee m3 = new Employee(3,"高琪3","9000");

        Map<Integer,Employee> employeeMap = new HashMap<>();
        employeeMap.put(1,m1);
        employeeMap.put(2,m2);
        employeeMap.put(3,m3);
        Employee employee = employeeMap.get(2);
        employee.printMessage();
    }

}

class Employee{
    int id;
    String name;
    String salary;
    Employee(int id, String name,String salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void printMessage(){
        System.out.println(this.id+","+this.name+","+this.salary);
    }
}
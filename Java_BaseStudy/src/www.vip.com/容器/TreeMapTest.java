package www.vip.com.容器;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap的使用：
 *      TreeMap和HashMap都是Map接口的实现类；
 *      TreeMap是红黑二叉树的典型实现；
 *      TreeMap不常用，HashMap常用；
 *      HashMap的效率高于TreeMap，在需要排序的Map时，才选用TreeMap；
 */
public class TreeMapTest {

    public static void main(String[] args) {

        Map<Integer,String> map = new TreeMap<>();
        map.put(2,"高琪2");
        map.put(1,"高琪1");
        map.put(3,"高琪3");

        //TreeMap 内部自动按照key递增的方式排序：输出为1，2，3排序

        for (Integer key:map.keySet()
             ) {
            System.out.println(key+"----"+map.get(key));
        }

        Map<String,String> mapStrings = new TreeMap<>();
        mapStrings.put("010BB","高琪2");
        mapStrings.put("---AA","高琪1");
        mapStrings.put("xxx-DD","高琪3");

        //TreeMap 内部自动按照key递增的方式排序：输出为字符串的大小排序
        for (String key:mapStrings.keySet() //keySet() 获取map中的所有keys数组
        ) {
            System.out.println(key+"----"+mapStrings.get(key));
        }

        Emp m1 = new Emp(1,"高琪1",10000);
        Emp m2 = new Emp(2,"高琪2",9000);
        Emp m3 = new Emp(3,"高琪3",12000);
        Emp m4 = new Emp(4,"高琪4",10000);
        Map<Emp,String> newMaps = new TreeMap<>();
        newMaps.put(m1, "A");
        newMaps.put(m2, "B");
        newMaps.put(m3, "C");
        newMaps.put(m4, "D");
        for (Emp p:newMaps.keySet()
             ) {
            System.out.println(p.id+","+p.name+","+p.salary);
        }
    }

}
class Emp implements Comparable<Emp> {
    int id;
    String name;
    double salary;
    Emp(int id,String name,double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * 返回值：
     *      0：表示等于      this的属性值 == o的属性值
     *      负数：表示小于    this的属性值 < o的属性值
     *      正数：表示大于    this的属性值 > o的属性值
     */
    @Override
    public int compareTo(Emp o) {
        //按照Salary来排序：
        if (this.salary > o.salary) {
            return 1;
        } else if (this.salary < o.salary) {
            return -1;
        } else {
            if (this.id>o.id){
                return 1;
            }else {
                return -1;
            }
        }
    }
}
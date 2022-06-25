package www.vip.com.Stream流;

import www.vip.com.容器.ArrayListCustom;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *   Stream流的练习：
 *      现在有两个ArrayList集合，分别存储6名男演员名称和6名女演员名称，要求完成如下操作：
 *          1.男演员只要名字为3个字的前三人；
 *          2.女演员只要姓林的，并且不要第一个；
 *          3.把过滤后的男演员和女演员姓名合并到一起；
 *          4.把上一步操作后的元素作为构造方法的参数创建演员对象，遍历数据；
 */
public class StreamExceriseTest {

    public static void main(String[] args) {

        ArrayList<String> boys = new ArrayList();
        boys.add("林更新");
        boys.add("易洋千玺");
        boys.add("汤姆克鲁斯");
        boys.add("黄晓明");
        boys.add("古天乐");
        boys.add("梁朝伟");

        ArrayList<String> girls = new ArrayList();
        girls.add("古力娜扎");
        girls.add("林依轮");
        girls.add("林心如");
        girls.add("章子怡");
        girls.add("刘亦菲");
        girls.add("迪丽热巴");

        Stream<String> boyStreams = boys.stream().filter(s->s.length()==3).limit(3);
        Stream<String> girlStreams = girls.stream().filter(s->s.startsWith("林")).skip(1);

        Stream<String> actorStreams = Stream.concat(boyStreams,girlStreams);

        actorStreams.forEach(s->{

            Actor actor = new Actor(s);
            System.out.println(actor.toString());

        });

    }

}

class Actor{

    String name;
    Actor(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
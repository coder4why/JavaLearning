package www.vip.com.DAO;

/**
 * DAO的理念：
 * 是使用中间类，实现业务与数据分离操作；
 * DAO层：
 *      DAO层叫数据访问层，全称为data access object，属于一种比较底层，
 *      比较基础的操作，具体到对于某个表的增删改查，也就是说某个DAO一定是
 *      和数据库的某一张表一一对应的，其中封装了增删改查基本操作，建议DAO只做原子操作，增删改查;
 * Service层：
 *      Service层叫服务层(业务层)，被称为服务，粗略的理解就是对一个或多个DAO进行的再次封装，
 *      封装成一个服务，所以这里也就不会是一个原子操作了，需要事物控制。
 * Controler层：
 *      Controler负责请求转发，接受页面过来的参数，传给Service处理，接到返回值，再传给页面。
 * 总结：
 *      个人理解DAO面向表，Service面向业务。后端开发时先数据库设计出所有表，然后对每一张表
 *      设计出DAO层，然后根据具体的业务逻辑进一步封装DAO层成一个Service层，对外提供成一个服务。
 */
public class DAOTest {
    public static void main(String[] args) throws InterruptedException {

        long beg = System.currentTimeMillis();
        /** 增*/

//        for (int j = 0; j < 10; j++) {
//            Thread.sleep(1000);
//            Person person = new Person("张三" + (j), j % 100, "上海市", j * 500.0 + 3000);
//            DaoIMP.insert(person);
//
//        }

//        DaoIMP.closeAll();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - beg) + "ms");

        /** 删*/
//        Person person = new Person("张三"+0,0+10,"上海市",0*100.0+3000);
//        DaoIMP.delete(person);

        /** 改*/
//        Person person = new Person("张三"+1,88,"上海市嘉定区",10*100.0+3500);
//        DaoIMP.update(person);

        /** 查*/
        for (Person p:DaoIMP.selectAll()
             ) {
            System.out.println(p.toString());
        }

    }
}

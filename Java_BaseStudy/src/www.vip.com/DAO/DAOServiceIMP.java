package www.vip.com.DAO;

/**
 * Service层：
 *      Service层叫服务层(业务层)，被称为服务，粗略的理解就是对一个或多个DAO进行的再次封装，
 *      封装成一个服务，所以这里也就不会是一个原子操作了，需要事物控制。
 */
public class DAOServiceIMP {

    /** 注册个人信息到DAO：一个业务功能由多个DAO操作组成（查询->插入）*/
    public static void register(Person p){
        /** 1.查询用户是否存在*/
        Person person = DaoIMP.selectPerson(p.name);
        if (person == null){
            /** 2.不存在，新增*/
            DaoIMP.insert(p);
        }else {
            /** 3.存在，返回已注册*/
            System.out.println("用户已注册");
        }
    }

}

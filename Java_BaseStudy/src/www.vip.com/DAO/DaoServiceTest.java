package www.vip.com.DAO;

public class DaoServiceTest {
    public static void main(String[] args) {

        Person person = new Person("胡先生",20,"上海市",10000.0);
        DAOServiceIMP.register(person);

    }
}

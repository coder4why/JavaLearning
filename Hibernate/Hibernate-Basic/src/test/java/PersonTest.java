import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import orm.hibernate.Entity.Person;

public class PersonTest {

    private SessionFactory factory;
    @Before
    public void init(){
        Configuration configure = new Configuration().configure();
        factory = configure.buildSessionFactory();
    }

    @Test
    public void testSave(){

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person(1,"长老山","上海嘉定",20);
        session.save(person);
        transaction.commit();

        session.close();

    }

    @Test
    public void testSelect(){

        Session session = factory.openSession();

        Person person1 = session.get(Person.class, 2);
        System.out.println(person1);

        session.close();

    }

    @Test
    public void testUpdate(){

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        person.setId(1);
        Person person1 = session.get(Person.class, 2);

        person1.setName("大张伟");
        session.save(person1);
        System.out.println(person1);
        transaction.commit();
        session.close();

    }

    @Test
    public void testDelete(){
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setId(1);
        session.delete(person);

        transaction.commit();

        session.close();

    }

}

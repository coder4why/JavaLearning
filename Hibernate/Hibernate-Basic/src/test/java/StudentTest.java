import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import orm.hibernate.Entity.Student;

public class StudentTest {

    private static SessionFactory factory;
    @Before
    public void  init(){
        Configuration configure = new Configuration().configure();
        factory = configure.buildSessionFactory();
    }

    @Test
    public void testSave(){
        Student student = new Student("大先生",20,"18050402");
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    @Test
    public void testSelect(){
        Session session = factory.openSession();
        Student student = session.get(Student.class, 1);
        System.out.println(student);
        session.close();
    }
    @Test
    public void testUpdate(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 1);
        student.setName("小樊樊");
        session.save(student);
        System.out.println(student);
        transaction.commit();
        session.close();
    }
    @Test
    public void testDelete(){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, 1);
        session.delete(student);
        transaction.commit();
        session.close();
    }

}

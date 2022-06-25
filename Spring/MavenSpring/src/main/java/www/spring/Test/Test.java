package www.spring.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.spring.Entity.Student;
import www.spring.Entity.Teacher;
import www.spring.SpringFactory.IocFactory;
import www.spring.SpringFactory.SpringFactory;


public class Test {

    @org.junit.Test
    public void test() {
        SpringFactory factory = new SpringFactory();
        Student student = (Student) factory.testSpringFactory("student");
        student.doWhat();

        Teacher teacher = (Teacher) factory.testSpringFactory("teacher");
        teacher.doWhat();

        System.out.println("----------------------");

        System.out.println("----使用Spring-IoC 来实现依赖----");
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        IocFactory iocFactory = (IocFactory)context.getBean("iocFactory");
        Student student1 = iocFactory.getStudent();
        student1.doWhat();
        iocFactory.getTeacher().doWhat();

    }

}

package www.spring.SpringFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.spring.Entity.Student;
import www.spring.Entity.Teacher;

/**
 * Spring IoC（Inversion of Control）：控制反转
 *    反转了依赖关系的满足方式，由之前的自己创建依赖对象，变为由工厂推送（变主动为被动，即反转）；
 *    解决了具有依赖关系的组件之间的强耦合，使得项目形态更加稳健；
 */
public class IocFactory {

    private Student student;
    private Teacher teacher;

    public IocFactory() {}
    public Object testIocFactory(String name){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        return context.getBean(name);
    }

    @Test
    /** 使用Spring Set注入：*/
    public void testMine(){
        IocFactory factory = (IocFactory) testIocFactory("iocFactory");
        System.out.println(factory);
    }

    @Test
    /** 使用Spring Set注入*/
    public void test_set(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Student student = (Student) context.getBean("student1");
        System.out.println(student);
    }

    @Test
    /** 使用Spring自动注入：autoWrite = byName(同类型、同属性名称自动赋值)、byType(同类型属性自动赋值)*/
    public void test_auto_set(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        IocFactory iocFactory = (IocFactory) context.getBean("autoFactory");
        System.out.println(iocFactory);
    }

    @Test
    /** 使用Spring构造注入：*/
    public void test_constructor_set(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Teacher teacher = (Teacher) context.getBean("teacher1");
        System.out.println(teacher);
    }

    public Student getStudent() { return student; }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}

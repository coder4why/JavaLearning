package www.spring.SpringFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.spring.Entity.Animal;
import www.spring.Entity.School;

public class PractiseFactory {
    private School school1;
    private Animal animal;

    public School getSchool1() {
        return school1;
    }

    public void setSchool1(School school1) {
        this.school1 = school1;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public PractiseFactory() {
    }

    @Test
    /** 1、Spring Set注入：属性赋值*/
    public void spring_set(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/practise-context.xml");
        School school = (School) context.getBean("school");
        System.out.println(school);
    }

    @Test
    /** 2.Spring Constructor 构造注入：构造方法赋值*/
    public void spring_constructor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/practise-context.xml");
        School school = (School) context.getBean("school1");
        System.out.println(school);
    }

    @Test
    /** 3.Spring autoWrite ： 自动赋值*/
    public void spring_autoWrite(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/practise-context.xml");
        PractiseFactory factory = (PractiseFactory) context.getBean("autoWriteSet");
        System.out.println(factory);
    }

    @Test
    /** 4.Spring Bean获取的对象默认为单例对象 */
    /**
     *  使用scope属性，设置bean创建的对象是否为单例对象:
     *  默认值为singleton(创建单例);
     *  prototype:每次创建一个新对象
     */
    public void isSingletonBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-singleton.xml");
        Animal animal = (Animal) context.getBean("animal");
        Animal animal1 = (Animal) context.getBean("animal");
        Animal animal2 = (Animal) context.getBean("animal");

        System.out.println(animal);
        System.out.println(animal1);
        System.out.println(animal2);

    }

}

package www.spring.SpringFactory;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.spring.Entity.Animal;

public class MyFactoryBean implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        Animal animal = new Animal();
        animal.setAge(20);
        animal.setName("大佬来了");
        return animal;
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Test
    /**
     *    使用Spring工厂创建FactoryBean对象时，根据id获取对象实际调用的是该类的getObject()方法返回的对象；
     * 此处获取的对象为Animal类型；
     */

    /**
     *     Spring工厂创建后，会将Spring配置文件中的所有对象都创建完成（饿汉式）；
     *  提高程序运行效率，避免多次IO，减少对象创建时间。（概念接近连接池，一次性创建好，使用时直接获取）
     */
    public void test_factory_bean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/factory-bean.xml");
        /** 1、根据id创建类对象，实际调用的是类的getObject()实例方法 */
        Animal object = (Animal) context.getBean("myFactoryBean");
        System.out.println(object);
        /** 2.使用 &id 获取类对象本身 */
        MyFactoryBean factoryBean = (MyFactoryBean) context.getBean("&myFactoryBean");
        System.out.println(factoryBean);
    }

}

package www.spring.SpringFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFactory {

    public SpringFactory() {}

    public Object testSpringFactory(String name){

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        return context.getBean(name);

    }

}

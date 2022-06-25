package demo.Config;

import demo.Entity.Person;
import demo.Entity.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 一、注解分为两类：
 *
 *  1、一类是注册Bean：
 *      @Component , @Repository , @Controller ,@Service , @Configration
 *      这些注解都是把你要实例化的对象转化成一个Bean，放在IoC容器中，等你要用的时候，
 *      它会和@Autowired , @Resource配合到一起，把对象、属性、方法完美组装。
 *
 *  2、一类是使用Bean：
 *      即是把已经在xml文件中配置好的Bean拿来用，完成属性、方法的组装；
 *      比如@Autowired , @Resource，可以通过byTYPE（@Autowired）、byNAME（@Resource）的方式获取Bean；
 *
 */
@Configuration
public class ConfigYml {

    @Bean
    @ConfigurationProperties(prefix = "person")
    /**配置文件名称与Person属性名称一致，将自动完成属性值的映射；*/
    public Person getPerson(){ return new Person(); }

    @Bean
    @ConfigurationProperties(prefix = "student")
    /**配置文件名称与Person属性名称一致，将自动完成属性值的映射；*/
    public Student getStudent(){ return new Student(); }

}

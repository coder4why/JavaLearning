package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RootApplication {
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class,args);
    }
}

/**
 * spring-boot 读取application.properties的高级用法:
 *      1.创建application.properties；
 *      2.创建实体类，类属性名称与properties文件保持一直；
 *      3.创建@Configuration注解类；
 *      4.创建@Bean注解方法，返回实体对象，方法体内直接使用无参构造方法，返回对象；
 *      对创建函数添加@ConfigurationProperties注解（设置perfix）；
 *      5.创建Controller，注解为@RestController;
 *      6.在Controller里，使用@Autowired注解，声明@Bean方法对象属性；
 *      7.函数调用，读取属性，完成映射；
 * */

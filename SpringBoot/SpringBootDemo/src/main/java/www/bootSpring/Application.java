package www.bootSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("SpringBoot工程入口函数");
        SpringApplication.run(Application.class,args);
    }

}

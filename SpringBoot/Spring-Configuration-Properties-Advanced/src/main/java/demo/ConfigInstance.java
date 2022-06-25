package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigInstance {

    @Bean
    @ConfigurationProperties(prefix = "person")
    public Person getPerson(){
        return new Person();
    }

    @Bean
    @ConfigurationProperties(prefix = "student")
    public Student getStudent(){
        return new Student();
    }

}



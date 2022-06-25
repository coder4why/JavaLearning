package demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("config.properties")
public class ConfigProperties {
    /**数据库属性：*/
    @Value("${database.driver}")
    private String driver;

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    /**Person类对象*/
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;

    @Value("${person.city}")
    private String city;

    @Value("${person.isMarried}")
    private boolean isMarried;

    @Bean
    public Person getPerson(){
        Person person = new Person(name, city, age, isMarried);
        return person;
    }

    @Bean
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

}

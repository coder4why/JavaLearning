package www.bootSpring;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

//    @Value("${jdbc.driver}")
//    String driver;
//
//    @Value("${jdbc.url}")
//    String url;
//
//    @Value("${jdbc.username}")
//    String username;
//
//    @Value("${jdbc.password}")
//    String password;
//
//    /** 创建Springboot对象*/
//    @Bean
//    public DataSource getDatasource(){
//
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(driver);
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//        return druidDataSource;
//    }

}

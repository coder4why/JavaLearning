package www.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class ConfigController {
    @Autowired
    private DataSource dataSource;

    @GetMapping("show")
    private String showWhat(){
        System.out.println(dataSource);
        return "Application.properties配置读取成功";
    }

}

package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class ConfigController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Person zhangYiXing;

    @GetMapping("show")
    private String showME(){
        System.out.println(dataSource);
        System.out.println(zhangYiXing);
        return "@Value配置spring-bean成功";
    }

}

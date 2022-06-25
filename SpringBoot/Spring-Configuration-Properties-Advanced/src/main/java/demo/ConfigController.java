package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Person yaoMing;

    @Autowired
    private Student daMing;

    @GetMapping("show")
    private String showYM(){
        System.out.println(yaoMing);
        return "Spring-boot高阶用法，实现配置文件到对象的映射\n"+"\n"+daMing.toString();
    }

}

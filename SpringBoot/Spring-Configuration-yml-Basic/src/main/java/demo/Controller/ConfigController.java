package demo.Controller;

import demo.Entity.Person;
import demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Person yaoMing;

    @Autowired
    private Student daZW;

    /**
     * 1.项目中同时包含application.yml和application.properties文件，
     *   并且属性相同，系统会默认读取application.properties属性值；
     * 2.如果项目中同时包含了application.properties、application.yml和application-*.yml文件，且在application.yml中激活了application-*.yml文件，
     *   同时application-*.yml中包含了与application.properties、application.yml和application-*.yml相同的属性和prefix，则系统默认读取application-*.yml
     *   里面的属性；
     */
    @Value("${person.name}")
    private String name;

    @GetMapping("yml")
    private String showMe(){
        System.out.println(yaoMing);
        System.out.println(daZW);
        System.out.println(name);
        return yaoMing.toString()+"\n"+daZW.toString()+"\n"+name;
    }


}

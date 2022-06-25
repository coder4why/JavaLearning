package www.bootSpring;

import org.springframework.web.bind.annotation.*;

@RestController
public class BootController {

    //http://localhost:8080/hello
    @GetMapping("hello")
    public String getMessage(){
        return "Hello Spring Boot";
    }

    //http://localhost:8080/init?username=jack&password=123
    @RequestMapping(value = "init",method = RequestMethod.GET,params = {"username","password"})
    public String getResponse(){
        return "init Spring Boot";
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    String getUserByJson(@RequestBody String username){
        return "index is " + username;
    }

}

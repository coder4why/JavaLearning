package www.mall.Personal.Service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import www.mall.Personal.Dao.PersonalDao;

import java.util.Map;

@RestController
public class PersonalService {

    private static PersonalDao personalDao;
    static {
        personalDao = new PersonalDao();
    }

//    @Autowired
//    public DataSource dataSource;

    /** 获取个人中心用户数据*/
    @PostMapping("mine")
    public Map getMineData(@RequestParam("user_id") String user_id) {
        return personalDao.getMineData(user_id);
    }

    /** 注册账号*/
    @PostMapping("register")
    public Map registerAccount(
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            @RequestParam("vertifyCode") String code){

        return personalDao.registerAccount(account,password,code);

    }

    /** 登录账号*/
    @PostMapping("login")
    public Map login(
            @RequestParam("account") String account,
            @RequestParam("password") String password) {

        return personalDao.login(account,password);

    }

    /** 修改密码*/
    @PostMapping("resetPassword")
    public Map resetPassword(
            @RequestParam("account") String account,
            @RequestParam("password") String newPassword) {

        return personalDao.resetPassword(account,newPassword);

    }

}

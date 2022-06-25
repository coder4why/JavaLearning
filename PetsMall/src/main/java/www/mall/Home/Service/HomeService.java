package www.mall.Home.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import www.mall.Home.Dao.HomeDao;

import java.util.Map;

@RestController
public class HomeService {

    private static HomeDao homeDao;
    static {
        homeDao = new HomeDao();
    }

//    @Autowired
//    public DataSource dataSource;

    @GetMapping("homeInfo")
    public Map getHomeInfo(){
        return homeDao.getHomeDatas();
    }

}

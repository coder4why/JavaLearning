package www.mall.PetCircle.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import www.mall.PetCircle.Dao.CircleDao;

import java.util.Map;

@RestController
public class CircleService {

//    @Autowired
//    public DataSource dataSource;

    private static CircleDao circleDao;
    static{
        circleDao = new CircleDao();
    }

    @PostMapping("mylikes")
    public Map getMylikePets(@RequestParam("user_id") String user_id){

        return circleDao.getLikePets(user_id);

    }

    @GetMapping("recommendPets")
    public Map getRecommentPets(){
        return circleDao.getRecommentPets();
    }

    @PostMapping("addLike")
    public Map addLike(@RequestParam("user_id") String user_id,@RequestParam("owner_id") String owner_id){
        return circleDao.addLike(user_id,owner_id);
    }

}

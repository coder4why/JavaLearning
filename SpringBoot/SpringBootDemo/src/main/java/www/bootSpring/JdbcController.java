package www.bootSpring;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    /**
     * 往SpringBoot里面写入对象
     */
    @Autowired
    private DataSource dataSource;

    @GetMapping("source")
    public Map show() throws SQLException {
        System.out.println("😂---------😂"+dataSource);
        Connection connection = dataSource.getConnection();
        String querySQL = "select * from University";
        PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("👌---------👌"+resultSet);
        List<University> universities = new ArrayList<University>();
        while (resultSet.next()){

            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            Integer level = resultSet.getInt("level");
            Integer studentsCount = resultSet.getInt("studentsCount");
            Integer teachersCount = resultSet.getInt("teachersCount");
            University university = new University(name, address, level, teachersCount, studentsCount);
            universities.add(university);
        }

//        University qinghua = new University("清华大学","北京海淀区",985,12000,34500);
//        University beida = new University("北京大学","北京丰台区",985,13000,36000);
//        universities.add(qinghua);
//        universities.add(beida);

        Map response = new HashMap();
        response.put("code",200);
        response.put("message","成功");
        response.put("body", JSONObject.toJSON(universities));

        return response;

    }

}

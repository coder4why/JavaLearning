package www.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import www.Entity.Order;
import www.Entity.User;
import www.dao.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    private static SqlSessionFactory sessionFactory;
    @Before
    public void initSqlSession(){

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("multiMapperConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void selectOne(){

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = (User) mapper.selectOne("马云");
        System.out.println(user);
        for (Order o :
                user.getOrders()) {
            System.out.println(o);
        }
        sqlSession.close();
    }

    @Test
    public void selectAll(){

        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
        for (User o :
                users) {
            System.out.println(o);
        }
        sqlSession.close();
    }


}

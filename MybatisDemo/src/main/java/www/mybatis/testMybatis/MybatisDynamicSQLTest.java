package www.mybatis.testMybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import www.mybatis.Entity.University;
import www.mybatis.dao.UniversityDynamicSQLDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisDynamicSQLTest {

    private static SqlSessionFactory factory = null;
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            factory = build;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_where_if(){

        SqlSession sqlSession = factory.openSession();
        UniversityDynamicSQLDao mapper = sqlSession.getMapper(UniversityDynamicSQLDao.class);
        University university = (University) mapper.selectOne("南开大学", "天津市海新区", null);
        sqlSession.close();
        System.out.println(university);

    }

    @Test
    public void test_where_foreach(){

        SqlSession sqlSession = factory.openSession();
        UniversityDynamicSQLDao mapper = sqlSession.getMapper(UniversityDynamicSQLDao.class);

        List<String> names = new ArrayList<String>();
        names.add("南开大学");
        names.add("浙江大学");
        names.add("清华大学");
        names.add("香港大学");
        List<University> list = (List<University>) mapper.selectNames(names);
        sqlSession.close();
        System.out.println(list);

    }
}

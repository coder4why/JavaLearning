package www.mybatis.testMybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import www.mybatis.Entity.University;
import www.mybatis.dao.UniversityMybatisDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** 1、使用Mybatis代理模式，实现DAO操作，定义interface，Mapper.xml文件指定 namespace为协议路径，id为协议方法名称，即可*/
public class MyBatisProxyTest {

    private static SqlSessionFactory sessionFactory = null;
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void proxy_insert(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMybatisDao<University> dao = sqlSession.getMapper(UniversityMybatisDao.class);

        University university = new University("香港科技大学","中国香港",985,12200,1500);
        int insert = dao.insert(university);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void proxy_delete(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMybatisDao mapper = sqlSession.getMapper(UniversityMybatisDao.class);
        int delete = mapper.delete("香港科技大学");
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void proxy_update(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMybatisDao mapper = sqlSession.getMapper(UniversityMybatisDao.class);
        University university = new University("香港科技大学","香港紫金山",985,12200,1500);
        mapper.update(university);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void proxy_selectOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMybatisDao mapper = sqlSession.getMapper(UniversityMybatisDao.class);
        University university = (University) mapper.selectOne("香港科技大学");
        System.out.println(university);
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMybatisDao mapper = sqlSession.getMapper(UniversityMybatisDao.class);
        List<University> list = mapper.selectAll();
        System.out.println(list);
        sqlSession.close();
    }


}

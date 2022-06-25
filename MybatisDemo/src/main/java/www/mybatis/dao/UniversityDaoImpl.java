package www.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import www.mybatis.Entity.University;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** 1、使用传统的DAO模式，实现DAO操作*/
public class UniversityDaoImpl implements UniversityDao<University>{
    private static SqlSessionFactory sessionFactory = null;
    static{
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int insert(University university) {
        SqlSession sqlSession = sessionFactory.openSession();
        int res = sqlSession.insert("university.insert",university);
        sqlSession.commit();
        sqlSession.close();
        return res;
    }

    public int delete(String name) {
        SqlSession sqlSession = sessionFactory.openSession();
        int res = sqlSession.delete("university.delete", name);
        sqlSession.commit();
        sqlSession.close();
        return res;
    }

    public int update(University university) {
        SqlSession sqlSession = sessionFactory.openSession();
        int res = sqlSession.update("university.update", university);
        sqlSession.commit();
        sqlSession.close();
        return res;
    }

    public University selectOne(String name) {
        SqlSession sqlSession = sessionFactory.openSession();
        University university = sqlSession.selectOne("university.selectUniversity", name);
        sqlSession.close();
        return university;
    }

    public List<University> selectAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<University> universities  = sqlSession.selectList("university.selectAll");
        sqlSession.close();
        return universities;
    }

}

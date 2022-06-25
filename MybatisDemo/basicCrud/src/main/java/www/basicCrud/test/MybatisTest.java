package www.basicCrud.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import www.basicCrud.Dao.TeacherClassMapper;
import www.basicCrud.Dao.TeacherMapper;
import www.basicCrud.Dao.UniversityLevelMapper;
import www.basicCrud.Dao.UniversityMapper;
import www.basicCrud.Entity.Classes;
import www.basicCrud.Entity.Teachers;
import www.basicCrud.Entity.University;
import www.basicCrud.Entity.UniversityLevel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private static SqlSessionFactory sessionFactory = null;
    @Before
    public void before() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("basicMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    }

    @Test
    public void insert(){
        University university = new University("西北工业大学","陕西西安",985,12306,989);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        int insert = mapper.insert(university);
        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    public void delete(){
        SqlSession sqlSession = sessionFactory.openSession(true);
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        int delete = mapper.delete("西北工业大学");
        System.out.println(delete);
        sqlSession.close();
    }

    @Test
    public void update(){
        University university = new University("西北工业大学","陕西咸阳",985,12306,989);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        int update = mapper.update(university);
        System.out.println(update);
        sqlSession.close();
    }

    @Test
    public void selectOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        University university = mapper.selectOne("香港大学");
        System.out.println(university);
        sqlSession.close();
    }

    @Test
    public void selectOnlyOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityLevelMapper mapper = sqlSession.getMapper(UniversityLevelMapper.class);
        UniversityLevel universityLevel = mapper.selectOnlyOne("清华大学");
        System.out.println(universityLevel);
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        List<University> list = mapper.selectAll();
        for (University u :
                list) {
            System.out.println(u);
        }
        sqlSession.close();
    }


    @Test
    public void select_985(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityMapper mapper = sqlSession.getMapper(UniversityMapper.class);
        List<University> universities = mapper.selectLevel("985");
        for (University u :
                universities) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void select985(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityLevelMapper mapper = sqlSession.getMapper(UniversityLevelMapper.class);
        UniversityLevel level = mapper.selectOne("985");
        System.out.println(level);
        for (University u:level.universities
             ) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void selectQingHua(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityLevelMapper mapper = sqlSession.getMapper(UniversityLevelMapper.class);
        UniversityLevel universityLevel = mapper.selectUniversity("清华大学");
        System.out.println(universityLevel);
        sqlSession.close();
    }

    @Test
    public void selectAllLevels(){
        SqlSession sqlSession = sessionFactory.openSession();
        UniversityLevelMapper mapper = sqlSession.getMapper(UniversityLevelMapper.class);
        List<UniversityLevel> list = mapper.selectAll();
        for (UniversityLevel u : list) {
            System.out.println(u.level+":"+u.universities.size());
        }
        sqlSession.close();
    }

    @Test
    public void selectAllClasses(){
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherClassMapper mapper = sqlSession.getMapper(TeacherClassMapper.class);
        List<Classes> list = mapper.selectAll();
        for (Classes u : list) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void selectOneClasses(){
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherClassMapper mapper = sqlSession.getMapper(TeacherClassMapper.class);
        List<Classes> list = mapper.selectOneClass(2);
        for (Classes u : list) {
            System.out.println(u);
        }
        sqlSession.close();
    }

    @Test
    public void selectAllTeachers(){
        SqlSession sqlSession = sessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teachers> list = mapper.selectAllTeachers();
        for (Teachers u : list) {
            System.out.println(u);
        }
        sqlSession.close();
    }
}

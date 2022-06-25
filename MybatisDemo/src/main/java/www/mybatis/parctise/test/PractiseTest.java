package www.mybatis.parctise.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import www.mybatis.parctise.Entity.Student_Rec;
import www.mybatis.parctise.dao.PractiseDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PractiseTest {
    private static SqlSessionFactory sessionFactory = null;
    private static int pageSize = 1;
    static {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("./practise/PractiseMapperConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_insert(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        Student_Rec student_rec = new Student_Rec("我是小胡啊","上海嘉定区",20,new Date());
        int insert = mapper.insert(student_rec);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void test_delete(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        int delete = mapper.delete("我是小胡啊");
        System.out.println(delete);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test_update(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        Student_Rec student_rec = new Student_Rec("我是小胡啊","上海黄埔区",19,new Date());
        int update = mapper.update(student_rec);
        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test_selectOne(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        Student_Rec student_rec = (Student_Rec) mapper.selectOne("我是小胡啊");
        System.out.println(student_rec);
        sqlSession.close();

    }

    @Test
    public void test_selectMore(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        List<Student_Rec> list = mapper.selectMore("我是小胡啊",null);
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void test_selectMoreWithList(){

        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        List<String> names = new ArrayList<String>();
        names.add("我是小胡啊");
        names.add("小老头");
        names.add("小老伴");
        List<Student_Rec> list = mapper.selectMoreWithList(names);
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void test_selectAll(){

        PageHelper.startPage(pageSize++,3);
        SqlSession sqlSession = sessionFactory.openSession();
        PractiseDao mapper = sqlSession.getMapper(PractiseDao.class);
        List<Student_Rec> list = mapper.selectAll();
        for (Student_Rec s:list
             ) {
            System.out.println(s);
        }
        PageInfo<Student_Rec> pageInfo = new PageInfo<Student_Rec>(list);
        System.out.println("当前页数："+pageInfo.getPageNum());
        System.out.println(list);
        sqlSession.close();

    }


}

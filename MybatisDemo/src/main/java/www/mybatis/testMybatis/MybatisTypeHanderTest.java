package www.mybatis.testMybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import www.mybatis.Entity.RecordEmp;
import www.mybatis.dao.RecordEmpDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTypeHanderTest {
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
    public void insert(){

        SqlSession sqlSession = sessionFactory.openSession();
        RecordEmpDao mapper = sqlSession.getMapper(RecordEmpDao.class);
        RecordEmp emp = new RecordEmp("小芳","20200302","15971902073",new Date());
        int insert = mapper.insert(emp);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void selectOne(){
        SqlSession sqlSession = sessionFactory.openSession();
        RecordEmpDao mapper = sqlSession.getMapper(RecordEmpDao.class);
        RecordEmp emp = (RecordEmp) mapper.selectOne("20200302");
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void selectAll(){

        SqlSession sqlSession = sessionFactory.openSession();
        RecordEmpDao mapper = sqlSession.getMapper(RecordEmpDao.class);

        PageHelper.startPage(1,3);

        List<RecordEmp> list = mapper.selectAll();
        PageInfo<RecordEmp> pageInfo = new PageInfo<RecordEmp>(list);
        /** 下一页页码*/
        int nextPage = pageInfo.getNextPage();
        /** 上一页页码*/
        int prePage = pageInfo.getPrePage();
        /** 当前页码查询个数*/
        int pageSize = pageInfo.getPageSize();
        /** 当前页面*/
        int pageNum = pageInfo.getPageNum();
        /** 总页数*/
        int pages = pageInfo.getPages();
        /** 数据库记录总条数*/
        long total = pageInfo.getTotal();
        List<RecordEmp> list1 = pageInfo.getList();
        /** 当前页查询的其实行数*/
        long startRow = pageInfo.getStartRow();
        /** 当前页查询的结束行数*/
        long endRow = pageInfo.getEndRow();

        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        int navigatePages = pageInfo.getNavigatePages();

        System.out.println("--------------------------");
        for (RecordEmp emp :
                list) {
            System.out.println(emp);
        }
        sqlSession.close();
    }

}

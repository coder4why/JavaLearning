package www.mybatis.testMybatis;

import org.junit.Test;
import www.mybatis.Entity.University;
import www.mybatis.dao.UniversityDaoImpl;

import java.util.List;
/** 1、使用传统的DAO模式，实现DAO操作*/
public class MybatisTraditionTest {
    private static UniversityDaoImpl universityDao = new UniversityDaoImpl();
    @Test
    public void insert(){
        University university = new University("上海交通大学","中国上海",985,22200,1800);
        int insert = universityDao.insert(university);
        System.out.println(insert);
    }

    @Test
    public void delete(){
        int delete = universityDao.delete("上海交通大学");
        System.out.println(delete);
    }

    @Test
    public void update(){
        University university = new University("山东大学","山东青岛",985,10086,1345);
        int update = universityDao.update(university);
        System.out.println(update);
    }

    @Test
    public void selectOne(){
        University university = universityDao.selectOne("香港大学");
        System.out.println(university);
    }

    @Test
    public void selectAll(){
        List<University> universities = universityDao.selectAll();
        System.out.println(universities);

    }

}

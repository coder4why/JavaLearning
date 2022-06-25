package www.mybatis.testMybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;
import www.mybatis.Entity.University;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** Mybatis默认不提交事务，如果需要执行更新数据库操作（插入、修改、删除），需要调用commit()方法，手动提交事务*/
public class MybatisTest {
    private static SqlSessionFactory build;
    static {
        try {
            /** 读取配置文件 */
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
            /** 读取配置文件 */
            build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertUniversity(){
        University university = new University("中山大学","中国广州",985,33568,1233);
        SqlSession sqlSession = build.openSession();
        int res = sqlSession.insert("university.insert",university);
        if (res == 1){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void delete(){
        SqlSession sqlSession = build.openSession();
        int res = sqlSession.delete("university.delete","中国农业大学");
        if (res == 1){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void update(){
        University university = new University("中国科学技术大学","中国安徽",985,10000,1200);
        SqlSession sqlSession = build.openSession();
        int res = sqlSession.update("university.update",university);
        if (res == 1){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        /** 创建Session实例 */
        SqlSession sqlSession = build.openSession();
        List<University> universities = sqlSession.selectList("university.selectAll");
        System.out.println(universities);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void selectUniversity(){
        /** 创建Session实例：使用默认session不提交，需要手动提交，更新操作数据才能持久化到数据库中 */
        SqlSession sqlSession = build.openSession();
        /** 设置事务自动提交*/
        //  build.openSession(true);
        University university = sqlSession.selectOne("university.selectUniversity","清华大学");
        System.out.println(university);
        sqlSession.commit();
        sqlSession.close();

    }



}

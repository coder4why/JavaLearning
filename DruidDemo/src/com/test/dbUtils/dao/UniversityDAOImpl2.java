package com.test.dbUtils.dao;

import com.dao.druid.dao.UniversityDAO;
import com.dao.druid.entity.University;
import com.dao.druid.tool.DriudUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UniversityDAOImpl2 implements UniversityDAO<University>{

    private QueryRunner queryRunner = new QueryRunner(DriudUtils.getDataSouce());

    @Override
    public void insert(University university) {
        String sql = "insert into University(name,address,level,studentsCount,teachersCount)values(?,?,?,?,?)";
        Object[] objects = {
                university.getName(),university.getAddress(),university.getLevel(),
                university.getStudentsCount(),university.getTeachersCount()
        };
        excuteSQL(sql,objects);
    }

    private void excuteSQL(String sql,Object... args){
        try {
            int result = queryRunner.update(sql,args);
            System.out.println(result == 1 ?"操作成功":"操作失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(University university) {
        String sql = "delete from University where name = ?";
        excuteSQL(sql,university.getName());
    }

    @Override
    public void update(University university) {
        String sql = "update University set address = ?,level = ?,studentsCount = ?,teachersCount = ? where name = ?";
        Object[] objects = {
                university.getAddress(),university.getLevel(),university.getStudentsCount(),
                university.getTeachersCount(), university.getName()
        };
        excuteSQL(sql,objects);
    }

    @Override
    public University select(String name) {

        String sql = "select * from University where name = ?";
        try {
           University university = queryRunner.query(sql, new BeanHandler<University>(University.class) ,name);
           return university;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public List<University> selectAll() {
        String sql = "select * from University";
        try {
            List<University> universitys = queryRunner.query(sql, new BeanListHandler<University>(University.class));
            return universitys;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return null;
    }

    @Override
    public int updateException(University university) throws SQLException {
        return 0;
    }

    @Override
    public void closeAll(PreparedStatement p, Connection connection) {

    }
}

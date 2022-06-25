package com.dao.druid.dao;

import com.dao.druid.entity.University;
import com.dao.druid.tool.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UniversityDAOImpl implements UniversityDAO<University>,DruidRowMapper<University> {

    private static DbUtils<University> dbUtils = new DbUtils<>();

    /** 创建University MySQL表*/
    static {

        String createSQL = "CREATE TABLE if NOT EXISTS University(" +
                "id integer unsigned auto_increment," +
                "name VARCHAR(30) UNIQUE NOT NULL," +
                "address VARCHAR(100) NOT NULL, " +
                "level int NOT NULL," +
                "studentsCount int NOT NULL ," +
                "teachersCount int NOT NULL ," +
                "PRIMARY KEY(id)" +
                ")engine=InnoDB DEFAULT charset=utf8";

        dbUtils.createTable(createSQL);

    }

    @Override
    public void insert(University university) {

        String sql = "insert into University(name,address,level,studentsCount,teachersCount)values(?,?,?,?,?)";
        Object[] objects = {
                university.getName(),university.getAddress(),university.getLevel(),
                university.getStudentsCount(),university.getTeachersCount()
        };

       excuteSQL(sql,objects);

    }

    private void excuteSQL(String sql,Object...objects){
        int result = dbUtils.commonSQL(sql,objects);
        System.out.println(result == 1 ? "执行成功":"执行失败" );
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
    public int updateException(University university) throws SQLException {
        String sql = "update University set address = ?,level = ?,studentsCount = ?,teachersCount = ? where name = ?";
        Object[] objects = {
                university.getAddress(),university.getLevel(),university.getStudentsCount(),
                university.getTeachersCount(), university.getName()
        };
        int result = dbUtils.commonSQLException(sql,objects);
        System.out.println(result == 1 ? "执行成功":"执行失败" );
        return result;
    }

    @Override
    public void closeAll(PreparedStatement p, Connection connection) {
        dbUtils.closeAll(p,connection);
    }

    @Override
    public University select(String name) {

        String sql = "select * from University where name = ?";
        List<University> list = dbUtils.commonQuery(sql, new UniversityDAOImpl() ,name);
        if (list.isEmpty() == false){
            return list.get(0);
        }
        return null;
    }


    @Override
    public List<University> selectAll() {

        String sql = "select * from University";
        List<University> universities = dbUtils.commonQuery(sql,new UniversityDAOImpl(),null);

        return universities;

    }

    @Override
    public University getRow(ResultSet resultSet) {

        try {
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int teachersCount = resultSet.getInt("teachersCount");
            int studentsCount = resultSet.getInt("studentsCount");
            int level = resultSet.getInt("level");
            University university = new University(name,address,level,studentsCount,teachersCount);
            return university;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}

package com.servletPRG.test.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DbUtils<T> {

    private static QueryRunner queryRunner = null;
    static {
        queryRunner = new QueryRunner(DbTool.getDataSource());
        try {
            initConfigs();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /** 创建数据库，然后建表*/
    private static void initConfigs() throws SQLException {

        String createEmployee = "CREATE TABLE if NOT EXISTS Employee(" +
                "id INT PRIMARY KEY auto_increment," +
                "empID VARCHAR(20) NOT NULL," +
                "name VARCHAR(20) NOT NULL,age INT NOT NULL,salary DOUBLE NOT NULL)engine=InnoDB DEFAULT charset=utf8";
        queryRunner.execute(createEmployee,null);

        String createEmpManager = "CREATE TABLE if NOT EXISTS EmpManager(" +
                "id INT PRIMARY KEY auto_increment," +
                "username VARCHAR(20) NOT NULL," +
                "password VARCHAR(20) NOT NULL)engine=InnoDB DEFAULT charset=utf8";
        queryRunner.execute(createEmpManager,null);

    }

    /** 增删改操作 */
    public int commonSQL(String sql,Object... args){

        int result = 0;
        try {
            result = queryRunner.update(sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;

    }

    /** 单个或多个查询操作 */
    public List<T> select(String sql,T cls,Object obj){

        try {
            List<T> list = null;
            if (obj != null){
                list = queryRunner.query(sql, new BeanListHandler<T>((Class<? extends T>) cls.getClass()),obj);
            }else {
                list = queryRunner.query(sql, new BeanListHandler<T>((Class<? extends T>) cls.getClass()));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

}

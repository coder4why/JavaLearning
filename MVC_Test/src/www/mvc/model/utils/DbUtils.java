package www.mvc.model.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DbUtils<T>{

    private static QueryRunner queryRunner = null;
    private static Connection connection = null;
    static {
        try {
            queryRunner = new QueryRunner(DbTool.getDataSource());
            connection = queryRunner.getDataSource().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void begin(){
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void commit(){
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void close(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /** 增删改操作*/
    public int commonSQL(String sql,Object...args){

        int result = 0;
        try {
            begin();
           result = queryRunner.update(sql,args);
           commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            rollback();
        }
        return result;

    }

    /** 查询单个或者所有*/
    public List<T> select(String sql,T t,Object...args){

        List<T> list = null;
        if (args == null){
            try {
                begin();
               list = queryRunner.query(sql,new BeanListHandler<T>((Class<? extends T>) t.getClass()));
               commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                rollback();
            }
        }else {
            try {
                begin();
                list = queryRunner.query(sql,new BeanListHandler<T>((Class<? extends T>) t.getClass()),args);
                commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                rollback();
            }
        }
        return list;

    }

}

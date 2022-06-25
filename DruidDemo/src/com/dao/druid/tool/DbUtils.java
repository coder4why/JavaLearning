package com.dao.druid.tool;

import com.dao.druid.dao.DruidRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于Druid，SQL操作通用工具类
 */
public class DbUtils<T> {

    /**
     * 创建表格
     */
    public int createTable(String sql) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int result = 0;
        try {
            connection = DriudUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(preparedStatement, connection);
        }

        return result;

    }

    /**
     * 插入、删除、更新数据
     */
    public int commonSQL(String sql, Object... args) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int result = 0;
        try {
            connection = DriudUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(preparedStatement, connection);
        }

        return result;

    }

    /**
     * 插入、删除、更新数据: 抛出异常
     */
    public int commonSQLException(String sql, Object... args) throws SQLException {

        Connection connection = DriudUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        int result = preparedStatement.executeUpdate();

        closeAll(preparedStatement,connection);

        return result;

    }


    /**
     * 查询数据
     */
    public List<T> commonQuery(String sql, DruidRowMapper rowMapper, Object... args) {

        List<T> lists = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = DriudUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                T t = (T) rowMapper.getRow(resultSet);
                lists.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(preparedStatement, connection);
        }

        return lists;
    }

    public void closeAll(PreparedStatement preparedStatement, Connection connection) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

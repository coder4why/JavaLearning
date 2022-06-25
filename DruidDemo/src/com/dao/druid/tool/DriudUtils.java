package com.dao.druid.tool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DriudUtils {

    private static DruidDataSource ds;

    static {

        Properties properties = new Properties();
        try {
            InputStream inputStream = DriudUtils.class.getResourceAsStream("./druid.properties");
            properties.load(inputStream);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            //通过连接池获得连接对象
            connection = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println(connection);
        return connection;
    }

    public static DruidDataSource getDataSouce(){
        return ds;
    }


}

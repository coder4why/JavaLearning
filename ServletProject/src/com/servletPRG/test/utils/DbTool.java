package com.servletPRG.test.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 数据库连接类*/
public class DbTool {

    private static DruidDataSource druidDataSource = null;

    static {
        try {
            InputStream inputStream = DbTool.class.getResourceAsStream("./db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static DataSource getDataSource(){
        return druidDataSource;
    }


}

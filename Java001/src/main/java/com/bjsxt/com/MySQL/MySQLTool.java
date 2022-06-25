
package com.bjsxt.com.MySQL;
import java.sql.*;

public class MySQLTool {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/MySQLDB?useUnicode=true&characterEncoding=utf8";

    private static final String USER = "root";
    private static final String PASS = "1234";

    public static Object[] getMySqlObj() throws Exception{
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库...");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("实例化Statement对象...");
        Statement stmt = conn.createStatement();

        Object[] objects = new Object[2];
        objects[0] = stmt;
        objects[1] = conn;
        return objects;

    }

}


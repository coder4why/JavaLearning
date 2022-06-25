package www.vip.com.JDBC;

import www.vip.com.MySQL.MySQLTool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC的核心思想：
 *        Java中定义了访问数据库的接口，可以为多种关系型数据库提供统一的访问方式，
 *     由数据库厂商提供驱动实现类（Driver数据库驱动）；
 */
/**
 * PreparedStatement的作用：
 *      1.安全，避免SQL注入问题；
 *      2.预编译SQL语句，效率高；
 *      3.可以动态的填充数据，执行多个同构的SQL语句；
 */
/**
 *    JDBC中的所有参数都由？符号占位，这称为参数标记，
 * 在执行SQL语句之前，必须为每个参数提供值；
 */
public class JDBCTest {

    public static void main(String[] args) throws Exception {

        Object[] objects = MySQLTool.getMySqlObj();
        Connection connection = (Connection)objects[1];

        String sqlString = "select * from Students where age = ? and name = ?";

        /** 预编译SQL语句 */
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
        System.out.println(preparedStatement);

        /** 使用动态参数绑定 SQL语句: 为占位符赋值*/
        preparedStatement.setInt(1,520);   //age = 520
        preparedStatement.setString(2,"我爱你"); //name = 我爱你

        System.out.println(preparedStatement);

        /** 执行SQL语句，并接收结果 */
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("查询成功");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}

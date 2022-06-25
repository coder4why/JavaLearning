package www.vip.com.MySQL;

import java.sql.*;

public class MySQLTest {

    public static void main(String[] args) throws Exception {

        Object[] objects = MySQLTool.getMySqlObj();
        Statement stmt = (Statement)objects[0];
        Connection conn = (Connection) objects[1];

        String sql = "select * from Students order by age;";
        String delete = "delete from Students where name like '张老五%'";
        stmt.execute(delete);
        for (int i = 2; i < 3; i++) {
            int age = (20 + i);
            String name = "张老五" + i;
            /**
             * Java中SQL语句中插入变量：
             *      字符串类型 ' " + 变量名称 + " '；
             *      其他类型： " + 变量名称 + "
             */
            String studentStr = "insert into Students(name,age)values('" + name + "'," + age + " )";
            stmt.execute(studentStr);

            boolean isMerried = i % 2 == 0;
            int workYear = i + 3;
            double salary = i * 200.0 + 3000.0;
            String address = "湖北武穴" + i;
            String teacherName = "刀郎" + i;
            String teacherStr = "insert into Teachers(name,workYear,salary,address,isMerried)values(" +
                    "'" + teacherName + "'," + workYear + "," + salary + ",'" + address + "'," + isMerried + " " +
                    ")";
            stmt.execute(teacherStr);

        }

        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            System.out.println("姓名：" + name + ",年龄：" + age);
        }
        resultSet.close();
        stmt.close();
        conn.close();

    }

}

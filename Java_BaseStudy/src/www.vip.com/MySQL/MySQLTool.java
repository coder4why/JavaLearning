
package www.vip.com.MySQL;
import java.sql.*;
/**
 * ThreadLocal：
 *    可以将整个线程（单线程）中，存储一个共享值；
 *    线程拥有一个类似Map的属性，键值对结构<ThreadLocal对象,值>
 * ThreadLocal应用：
 *    一个线程共享一个ThreadLocal，在整个流程中任一环节可以存值或取值；
 */
public class MySQLTool {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/MySQLDB?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    private static final String USER = "root";
    private static final String PASS = "1234";

    /** 类加载，执行一次*/
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** 获取Connection对象 */
    public static Connection getConnection(){
        Connection conn = threadLocal.get();
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                threadLocal.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                return conn;
            }
        }
        return conn;
    }

    /** 开启事务连接 */
    public static void begin(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /** 提交整个事务连接 */
    public static void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
           closeConnection();
        }
    }

    /** 回滚整个事务*/
    public static void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
           closeConnection();
        }
    }

    /** 关闭Connection事务连接*/
    public static void closeConnection(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.close();
            /**  移除已关闭Connection对象 */
            threadLocal.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Object[] getMySqlObj() throws Exception{

        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            threadLocal.set(conn);
        }
        Statement stmt = conn.createStatement();
        /**
         * Statement 增删改（DML操作）:使用executeUpdate()
         * Statement 查询（DQL操作） :使用 execute()
         */
        Object[] objects = new Object[2];
        objects[0] = stmt;
        objects[1] = conn;
        return objects;

    }


}


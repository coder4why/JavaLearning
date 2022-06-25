package www.vip.com.DAO;

import www.vip.com.MySQL.MySQLTool;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * DAO层：
 *      DAO层叫数据访问层，全称为data access object，属于一种比较底层，
 *      比较基础的操作，具体到对于某个表的增删改查，也就是说某个DAO一定是
 *      和数据库的某一张表一一对应的，其中封装了增删改查基本操作，建议DAO只做原子操作，增删改查;
 */
public class DaoIMP {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement =  null;
    private static ResultSet resultSet = null;

    static {
        try {
            loadConnection();
            createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loadConnection(){
        try {
            Object[] objects = MySQLTool.getMySqlObj();
            connection = (Connection) objects[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPerson() throws Exception {

        String sql = "create table if not exists Person(" +
                "id integer unsigned auto_increment," +
                "name varchar(20) unique not null," +
                "age integer not null," +
                "address varchar(50) not null," +
                "salary double not null," +
                "date varchar(50) not null," +
                "primary key(id)" +
                ")engine=InnoDB default charset=utf8;";

        preparedStatement = connection.prepareStatement(sql);
        int res = preparedStatement.executeUpdate();
        System.out.println(res!=0?"数据库创建成功":"数据库创建失败");
        closeAll();

    }

    /** 增*/
    static void insert(Person person) {
        try {
            loadConnection();
            String insertSql = "insert into Person(name,age,address,salary,date)values(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, person.name);
            preparedStatement.setInt(2, person.age);
            preparedStatement.setString(3, person.address);
            preparedStatement.setDouble(4, person.salary);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String dateString = simpleDateFormat.format(date);

            preparedStatement.setString(5, dateString);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            closeAll();

        }

    }

    /** 删*/
    static void delete(Person person) {

        String deleteSQL = "delete from Person where name = ?";
        try {
            loadConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1, person.name);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll();
        }

    }

    /** 改*/
    static void update(Person person) {

        String updateSQL = "update Person set age = ?,address = ?,salary = ? where name = ?";
        try {
            loadConnection();
            preparedStatement = connection.prepareStatement(updateSQL);

            preparedStatement.setInt(1,person.age);
            preparedStatement.setString(2,person.address);
            preparedStatement.setDouble(3,person.salary);
            preparedStatement.setString(4,person.name);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll();
        }

    }

    static Person selectPerson(String name){

        String querySQL = "select * from Person where name = ?";

        try {
            loadConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                int age = resultSet.getInt("age");
                String date = resultSet.getString("date");
                System.out.println(date);
                Person person = new Person(name,age,address,salary);
                return person;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }

    /** 查*/
    static ArrayList<Person> selectAll(){

        ArrayList<Person> personArrayList = new ArrayList<>();
        String querySQL = "select * from Person";
        try {
            loadConnection();
             preparedStatement = connection.prepareStatement(querySQL);
             resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){

                 String name = resultSet.getString("name");
                 String address = resultSet.getString("address");
                 double salary = resultSet.getDouble("salary");
                 int age = resultSet.getInt("age");
                 String date = resultSet.getString("date");
                 System.out.println(date);
                 Person person = new Person(name,age,address,salary);
                 personArrayList.add(person);

             }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll();
        }
        return personArrayList;

    }

    static void closeAll() {

        try {
            if (resultSet != null){
                resultSet.close();
            }
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

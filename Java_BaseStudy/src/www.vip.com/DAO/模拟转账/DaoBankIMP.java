package www.vip.com.DAO.模拟转账;

import www.vip.com.JDBC.DateUtils;
import www.vip.com.MySQL.MySQLTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 转账DAO层：
 */
public class DaoBankIMP {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static void loadConnection() {
        try {
            connection = MySQLTool.getConnection();;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** 创建数据表*/
    static {

        String createSQL = "CREATE TABLE if NOT EXISTS Bank_Service(" +
                "id integer unsigned auto_increment," +
                "name VARCHAR (50) NOT NULL ," +
                "bank_id VARCHAR(50) UNIQUE NOT NULL," +
                "bank_money DOUBLE NOT NULL," +
                "register_date VARCHAR(50) NOT NULL," +
                "PRIMARY KEY (id) " +
                ")engine=InnoDB DEFAULT charset=utf8";

        try {
            loadConnection();
            preparedStatement = connection.prepareStatement(createSQL);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            closeAll();
        }

    }

    /** 写入一条用户信息*/
    public static int insert(PersonAccount p){

        try {
            String insertSQL = "INSERT INTO Bank_Service(name,bank_id,bank_money,register_date)VALUES(?,?,?,?)";
            loadConnection();
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1,p.name);
            preparedStatement.setString(2,p.bank_id);
            preparedStatement.setDouble(3,p.bank_money<0?0:p.bank_money);
            preparedStatement.setString(4, DateUtils.getCurrentTime());
           int result = preparedStatement.executeUpdate();
           return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
//            closeAll();
        }

        return 0;

    }

    /** 删除（销毁）一条用户信息*/
    public static int delete(String bank_id){

        try {
            String deleteSQL = "DELETE FROM Bank_Service WHERE bank_id = ?";
            loadConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1,bank_id);
            int result = preparedStatement.executeUpdate();
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
//            closeAll();
        }

        return 0;
    }

    /**  更新账户信息（不能更改银行卡号）*/
    public static int update(PersonAccount p) throws SQLException {

        try {
            String updateSQL = "UPDATE Bank_Service SET name = ?,bank_money = ? WHERE bank_id = ?";
            loadConnection();
            preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1,p.name);
            preparedStatement.setDouble(2,p.bank_money);
            preparedStatement.setString(3,p.bank_id);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            int result = preparedStatement.executeUpdate();
//            closeAll();
            return result;

        }

    }

    /** 查询一条用户信息（根据银行卡号）*/
    public static PersonAccount selectPerson(String bank_id){

        try {
            String deleteSQL = "SELECT * FROM Bank_Service WHERE bank_id = ?";
            loadConnection();
            preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setString(1,bank_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double bank_money = resultSet.getDouble("bank_money");
                PersonAccount personAccount = new PersonAccount(name,bank_id,bank_money);
                return personAccount;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
//            closeAll();
        }
        return null;

    }

    public static void closeAll() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                MySQLTool.closeConnection();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

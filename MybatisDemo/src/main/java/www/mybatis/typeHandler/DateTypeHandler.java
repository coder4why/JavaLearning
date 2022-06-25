package www.mybatis.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    /** 将Date类型的数据转换成long类型，写入数据库*/
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i,date.getTime());
    }

    /** 从数据库读取long类型的数据转换成java的Date类型 */
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Long time = resultSet.getLong(s);
        return new Date(time);
    }
    /** 从数据库读取long类型的数据转换成java的Date类型 */
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }
    /** 从数据库读取long类型的数据转换成java的Date类型 */
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}

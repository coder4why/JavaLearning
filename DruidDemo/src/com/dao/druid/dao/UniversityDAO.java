package com.dao.druid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface UniversityDAO<T> {

    void insert(T t);
    void delete(T t);
    void update(T t);
    T select(String name);
    List<T> selectAll();

    int updateException(T t) throws SQLException;
    void closeAll(PreparedStatement p, Connection connection);

}

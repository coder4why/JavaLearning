package com.dao.druid.dao;

import java.sql.ResultSet;

public interface DruidRowMapper<T> {
    T getRow(ResultSet resultSet);
}

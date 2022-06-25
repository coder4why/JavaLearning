package com.servlet.session.practise.dao.impl;

import com.dao.druid.tool.DriudUtils;
import com.servlet.session.practise.dao.LoginDao;
import com.servlet.session.practise.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao<User> {

    private QueryRunner queryRunner = new QueryRunner(DriudUtils.getDataSouce());

    @Override
    public User select(String name) {

        String  sql = "select * from Users where name = ?";
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class) ,name);
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }
}

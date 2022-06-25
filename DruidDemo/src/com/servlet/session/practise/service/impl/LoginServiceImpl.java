package com.servlet.session.practise.service.impl;

import com.servlet.session.practise.dao.impl.LoginDaoImpl;
import com.servlet.session.practise.entity.User;
import com.servlet.session.practise.service.LoginService;

public class LoginServiceImpl implements LoginService<User> {

    private LoginDaoImpl loginDao = new LoginDaoImpl();

    @Override
    public User select(String name, String password) {

        User user = loginDao.select(name);
        if (user != null){
            if (user.getPassword().equals(password)){
                //返回验证通过，可登录的用户：
                return user;
            }
        }
        return null;

    }
}

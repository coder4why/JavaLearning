package com.servlet.session.practise.dao;

public interface LoginDao<T> {

    T select(String name);

}

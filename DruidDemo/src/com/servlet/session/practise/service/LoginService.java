package com.servlet.session.practise.service;

public interface LoginService<T> {

    T select(String name,String password);

}

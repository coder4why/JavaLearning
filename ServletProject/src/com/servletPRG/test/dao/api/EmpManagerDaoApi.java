package com.servletPRG.test.dao.api;

public interface EmpManagerDaoApi<T> {

    T select(String name,String password);

}

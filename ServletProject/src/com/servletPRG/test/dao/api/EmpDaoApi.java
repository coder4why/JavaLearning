package com.servletPRG.test.dao.api;

import java.util.List;

public interface EmpDaoApi<T> {

    int insert(T t);
    int delete(T t);
    int update(T t);
    T select(String uniquID);
    List<T> selectAll();

}

package com.dao.druid.service;
import java.util.List;

public interface UniversityService<T> {

    void insert(T t);
    void delete(T t);
    void update(T t);
    T select(String name);
    List<T> selectAll();

    /** 交流学习*/
    void exchangeStudents(T a,T b,int number);

}

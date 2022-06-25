package com.servletPRG.test.service.api;

import java.util.List;

public interface EmpServiceApi<T> {

    int registerEmp(T t);
    int deleteEmp(T t);
    int updateEmp(T t);

    /** 单个或全部查询*/
    T selectEmp(String uniqueID);
    List<T> selectAll();

}

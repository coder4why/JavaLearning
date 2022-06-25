package com.servletPRG.test.dao.impl;

import com.servletPRG.test.dao.api.EmpManagerDaoApi;
import com.servletPRG.test.entity.EmpManager;
import com.servletPRG.test.utils.DbUtils;

import java.util.List;

public class EmpManagerDaoApiImpl implements EmpManagerDaoApi<EmpManager> {

    private DbUtils<EmpManager> dbUtils = new DbUtils<>();
    @Override
    public EmpManager select(String name, String password) {

        String sql = "select * from EmpManager where username = ?";
        EmpManager empManager = new EmpManager();
        List<EmpManager> empManagers = dbUtils.select(sql,empManager,name);
        if (empManagers.isEmpty() == false && empManagers.size()>0){
            empManager = empManagers.get(0);
            boolean isVaild = empManager.getPassword().equals(password);
            if (isVaild){
                return empManager;
            }
        }
        return null;

    }
}

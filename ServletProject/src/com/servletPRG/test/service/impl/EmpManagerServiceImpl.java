package com.servletPRG.test.service.impl;

import com.servletPRG.test.dao.impl.EmpManagerDaoApiImpl;
import com.servletPRG.test.entity.EmpManager;

public class EmpManagerServiceImpl {

    private EmpManagerDaoApiImpl empManagerDaoApi = new EmpManagerDaoApiImpl();
    public boolean isManager(EmpManager manager){

        EmpManager manager1 = empManagerDaoApi.select(manager.getUsername(),manager.getPassword());
        return manager1 != null;

    }

}

package com.servletPRG.test.service.impl;

import com.servletPRG.test.dao.impl.EmpDaoApiImpl;
import com.servletPRG.test.entity.Employee;
import com.servletPRG.test.service.api.EmpServiceApi;

import java.util.List;

public class EmpServiceApiImpl implements EmpServiceApi<Employee> {

    private EmpDaoApiImpl daoApi = new EmpDaoApiImpl();
    @Override
    public int registerEmp(Employee employee) {

        /** 先查询 再注册*/
        Employee employee1 = daoApi.select(employee.getEmpID());
        if (employee1 != null){
            System.out.println("该用户已注册");
            return 0;
        }else{
            return daoApi.insert(employee);
        }

    }

    @Override
    public int deleteEmp(Employee employee) {

        return daoApi.delete(employee);

    }

    @Override
    public int updateEmp(Employee employee) {
        return daoApi.update(employee);
    }


    @Override
    public Employee selectEmp(String uniqueID) {

        return daoApi.select(uniqueID);

    }

    @Override
    public List<Employee> selectAll() {
        return daoApi.selectAll();
    }
}

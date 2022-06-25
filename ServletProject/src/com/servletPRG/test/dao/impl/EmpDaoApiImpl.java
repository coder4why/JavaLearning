package com.servletPRG.test.dao.impl;

import com.servletPRG.test.dao.api.EmpDaoApi;
import com.servletPRG.test.entity.Employee;
import com.servletPRG.test.utils.DbUtils;

import java.util.List;

public class EmpDaoApiImpl implements EmpDaoApi<Employee> {

    private DbUtils<Employee> dbUtils = new DbUtils<>();

    @Override
    public int insert(Employee employee) {

        String sql = "insert into Employee(empID,name,age,salary)values(?,?,?,?)";
        Object[] params = {employee.getEmpID(),employee.getName(),employee.getAge(),employee.getSalary()};

        return dbUtils.commonSQL(sql,params);

    }

    @Override
    public int delete(Employee employee) {

        String sql = "delete from Employee where empID = ?";
        Object[] params = {employee.getEmpID()};

        return dbUtils.commonSQL(sql,params);

    }

    @Override
    public int update(Employee employee) {

        String sql = "update Employee set name = ?,age = ?,salary = ? where empID = ?";
        Object[] params = {employee.getName(),employee.getAge(),employee.getSalary(),employee.getEmpID()};

        return dbUtils.commonSQL(sql,params);

    }

    @Override
    public Employee select(String uniquID) {

        String sql = "select * from Employee where empID = ?";
        Employee employee = new Employee();
        List<Employee> employees = dbUtils.select(sql,employee,uniquID);
        if (employees.isEmpty() == false && employees.size()>0){
            return employees.get(0);
        }
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        String sql = "select * from Employee";
        Employee employee = new Employee();
        List<Employee> employees = dbUtils.select(sql,employee,null);
       return employees;
    }
}

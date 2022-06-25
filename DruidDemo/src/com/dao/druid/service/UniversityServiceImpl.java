package com.dao.druid.service;

import com.dao.druid.dao.UniversityDAOImpl;
import com.dao.druid.entity.University;
import com.test.dbUtils.dao.UniversityDAOImpl2;
import java.util.List;

public class UniversityServiceImpl implements UniversityService<University>{

    /** 使用自定义的dbutils 进行DAO操作*/
    private static UniversityDAOImpl daoIMP = new UniversityDAOImpl();
    /** 使用Apache的dbutils 进行DAO操作*/
    private static UniversityDAOImpl2 daoImpl2 = new UniversityDAOImpl2();

    @Override
    public void insert(University university) {
        /** 先查询再插入*/
        University university1 = daoImpl2.select(university.getName());
        if (university1 != null){
            System.out.println("该学校已记录");
        }else {
            daoImpl2.insert(university);
        }
    }

    @Override
    public void delete(University university) {
        daoImpl2.delete(university);
    }

    @Override
    public void update(University university) {
        daoImpl2.update(university);
    }

    @Override
    public University select(String name) {
        return daoImpl2.select(name);
    }

    @Override
    public List<University> selectAll() {
        return daoImpl2.selectAll();
    }

    @Override
    public void exchangeStudents(University a, University b, int number) {

        /** 查询两个学校是否记录，记录可交换*/
        University aU = daoIMP.select(a.getName());
        University bU = daoIMP.select(b.getName());

        if (aU!=null && bU!=null){

            aU.setStudentsCount(aU.getStudentsCount()-number);
            bU.setStudentsCount(bU.getStudentsCount()+number);

            int aResult = 0;
            int bResult = 0;
            try {
                aResult = daoIMP.updateException(aU);
//                int x = 10/0;
                bResult = daoIMP.updateException(bU);

            } catch (Exception throwables) {
                throwables.printStackTrace();
                System.out.println("抛出异常");

            }
        }

    }
}

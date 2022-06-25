package com.dao.druid.view;

import com.dao.druid.entity.University;
import com.dao.druid.service.UniversityServiceImpl;

import java.sql.SQLException;

public class DruidTest {

    private static UniversityServiceImpl service = new UniversityServiceImpl();
    public static void main(String[] args) throws SQLException {

        University qinghua = new University("清华大学","北京市海淀区",985,35000,8000);
        University beida = new University("北京大学","北京市昌平区",985,55660,11000);
        University naikai = new University("南开大学","天津市海新区",985,45660,6400);
        University fudan = new University("复旦大学","上海市长宁区",985,22660,1700);
        University wuhan = new University("武汉大学","武汉市武昌区",985,34660,9300);
        University zheda = new University("浙江大学","杭州市西湖区",985,29660,8400);

        /** 插入*/
        service.insert(qinghua);
        service.insert(beida);
        service.insert(naikai);
        service.insert(fudan);
        service.insert(wuhan);
        service.insert(zheda);

        qinghua.setStudentsCount(385566);
        /** 更新*/
        service.update(qinghua);

        /** 查询单个*/
        University university = service.select("北京大学");
        System.out.println(university);

        System.out.println("-------------------------");
        /** 查询所有*/
        for (University u:service.selectAll()
             ) {
            System.out.println(u);
        }

        /** 删除*/
//        service.delete(beida);

    }
}

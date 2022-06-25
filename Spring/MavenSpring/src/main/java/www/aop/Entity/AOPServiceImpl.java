package www.aop.Entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPServiceImpl implements AOPService {
    @Override
    public void insertMsgs() {
//        System.out.println("开始操作数据库");
        System.out.println("插入一条数据");
    }

    @Override
    public void deleteMsgs() {
//        System.out.println("开始操作数据库");
        System.out.println("删除一条数据");
    }

    @Override
    public void updateMsgs() {
//        System.out.println("开始操作数据库");
        System.out.println("更新一条数据");
    }

    @Override
    public void queryMsgs() {
//        System.out.println("开始操作数据库");
        System.out.println("查询一条数据");
    }

    @Test
    /** AOP 实现动态代理*/
    public void test_aop_before_proxy(){

        ApplicationContext context = new ClassPathXmlApplicationContext("/aop-proxy.xml");

        /** 通过目标的id 获取的是代理对象*/
        AOPService aopService = (AOPService) context.getBean("aopService");
        aopService.insertMsgs();
        aopService.deleteMsgs();
        aopService.updateMsgs();
        aopService.queryMsgs();

    }

}

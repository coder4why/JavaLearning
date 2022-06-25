package www.aop.Entity.practise;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PractiseServiceImpl implements PractiseService {
    @Override
    public void insertInfo() {
        System.out.println("插入数据");
    }

    @Override
    public void deleteInfo() {
        System.out.println("删除数据");
    }

    @Override
    public void updateInfo() {
        System.out.println("更新数据");
    }

    @Override
    public void queryInfo() {
        System.out.println("查询数据");
    }

    @Test
    public void test_practise_aop_proxy(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/practise-aop-proxy.xml");
        PractiseService service = (PractiseService) context.getBean("practiseService");
        service.insertInfo();
        service.updateInfo();
        service.deleteInfo();
        service.queryInfo();
    }

}

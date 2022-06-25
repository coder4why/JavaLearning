package www.aop.Entity.pointCut;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.aop.Entity.pointCut.Entity.Person;
import java.util.List;

public class PointCutServcieImpl implements PointCutService<Person> {
    @Override
    public Integer insert(Person person) {
        System.out.println("插入一个人");
        return 1;
    }

    @Override
    public Integer delete(Person person) {
        System.out.println("删除一个人");
        return 1;
    }

    @Override
    public Integer update(Person person) {
        System.out.println("更新一个人");
        return 1;
    }

    @Override
    public Person select(String name) {
        System.out.println("查询一个人");
        return null;
    }

    @Override
    public List<Person> selectAll() {
        System.out.println("查询所有人");
        return null;
    }

    @Test
    public void test_diff_point_cut_proxy(){

        ApplicationContext context = new ClassPathXmlApplicationContext("/pointCut-aop-proxy.xml");;
        PointCutService service = (PointCutService) context.getBean("pointCut");
        service.insert(null);
        service.delete(null);
        service.update(null);
        service.select(null);
        service.selectAll();

    }

}

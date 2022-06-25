package www.spring.Entity;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycle {
    private String name;

    public LifeCycle() {
        System.out.println("调用构造方法！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 SetName 方法！");
        this.name = name;
    }

    public void init_qf(){
        System.out.println("调用初始化方法！");
    }

    @Test
    /** 单例对象的生命周期：工厂启动时bean标签对象被创建*/
    public void test_singleton_lifeCycle(){

        /** 工厂对象生成，工厂对象对应的bean文件中的所有单例对象，被一同创建；多例对象，则使用时被创建*/
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("singleton-lifeCycle.xml");
        LifeCycle lifeCycle = (LifeCycle) context.getBean("lifeCycle");
        System.out.println("++++++++++++++++++++++");
        System.out.println(lifeCycle);

        /** 工厂对象关闭，由工厂创建的对象随之销毁 */
        context.close();
        System.out.println("---------------------");
        System.out.println("name："+lifeCycle.name);

        /** 工厂已关闭，无法在使用工厂生产对象（无法再获取对象）*/
       try{
           LifeCycle lifeCycle1 = (LifeCycle) context.getBean("lifeCycle");
           System.out.println(lifeCycle1);
           System.out.println("name："+lifeCycle.name);

       }catch (Exception exception){

       }

    }

    @Test
    /** 多例对象的生命周期：使用时bean标签对象被创建*/
    public void test_prototype_lifeCycle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/prototype-lifeCycle.xml");
        LifeCycle lifeCycle = (LifeCycle) context.getBean("lifeCycle");
        System.out.println("++++++++++++++++++++++");
        System.out.println(lifeCycle);

        /** 工厂对象关闭，由工厂创建的对象随之销毁 */
        context.close();
        System.out.println("---------------------");
        System.out.println("name："+lifeCycle.name);

        /** 工厂已关闭，无法在使用工厂生产对象（无法再获取对象）*/
        try{
            LifeCycle lifeCycle1 = (LifeCycle) context.getBean("lifeCycle");
            System.out.println(lifeCycle1);
            System.out.println("name："+lifeCycle.name);

        }catch (Exception exception){

        }
    }

}

package www.proxy.Entity;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理*/
public class AutoProxyTest {

    @Test
    /** 动态代理：方式1(系统Proxy)*/
    public void use_auto_proxy(){
        final FDService fdService = new FDServiceImpl();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是动态代理");
                fdService.zufang();
                return fdService;
            }
        };

        System.out.println("------------------");
        FDService proxy = (FDService)Proxy.newProxyInstance(fdService.getClass().getClassLoader(),fdService.getClass().getInterfaces(),invocationHandler);
        proxy.zufang();

    }
    /** 动态代理：方式2(CGLib)*/
    @Test
    public void use_cglib_proxy(){

        final FDService service = new FDServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FDServiceImpl.class);
        enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("使用CGLib构建代理");
                service.zufang();
                return null;
            }
        });

        System.out.println("=++++++++++++++++++++++++=");
        FDService service1 = (FDService) enhancer.create();
        service1.zufang();;

    }


}

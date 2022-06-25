package www.aop.Entity;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AfterReturningAdvice:数据库操作结束");
        System.out.println("--------------------------------");
    }
}

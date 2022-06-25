package www.aop.Entity.pointCut;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class PointCutAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("数据库操作结束！");
    }
}

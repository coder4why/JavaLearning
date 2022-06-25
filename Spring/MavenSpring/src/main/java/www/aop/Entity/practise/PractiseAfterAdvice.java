package www.aop.Entity.practise;

import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

/** 后置通知*/
public class PractiseAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("PractiseAfterAdvice:数据库操作结束");
        System.out.println("--------------------------------");
    }
}

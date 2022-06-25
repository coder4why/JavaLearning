package www.aop.Entity.practise;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/** 前置通知*/
public class PractiseBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("PractiseBeforeAdvice:开始操作数据库");
    }
}

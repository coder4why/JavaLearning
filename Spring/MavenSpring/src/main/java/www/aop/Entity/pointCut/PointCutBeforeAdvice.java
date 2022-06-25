package www.aop.Entity.pointCut;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class PointCutBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("开始操作数据库");
    }
}

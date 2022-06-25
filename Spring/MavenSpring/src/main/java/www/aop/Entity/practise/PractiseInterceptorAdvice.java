package www.aop.Entity.practise;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/** 环绕通知：在原始业务方法指向前和执行结束都执行一遍*/
public class PractiseInterceptorAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("MethodInterceptor:环绕通知开始表演！");
        Object object = methodInvocation.proceed();
        System.out.println("MethodInterceptor:环绕通知结束表演！");
        return object;

    }
}

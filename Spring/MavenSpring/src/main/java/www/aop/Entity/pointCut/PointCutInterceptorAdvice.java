package www.aop.Entity.pointCut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PointCutInterceptorAdvice  implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕通知开始干活！");
        Object object = methodInvocation.proceed();
        System.out.println("环绕通知结束干活！");
        System.out.println("---------------");
        return object;
    }
}

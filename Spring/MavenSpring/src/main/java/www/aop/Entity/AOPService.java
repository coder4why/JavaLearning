package www.aop.Entity;

/** Spring AOP（面向切面编程）：就是通过动态代理类为原始类的方法添加辅助功能 */
public interface AOPService {

    public void insertMsgs();
    public void deleteMsgs();
    public void updateMsgs();
    public void queryMsgs();

}

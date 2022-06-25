package www.mall.DbConfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DbSessionFactory {
    /**
     * 对保存实例的变量添加volatile的修饰
     */
    private volatile static DbSessionFactory instance = null;

    private DbSessionFactory() {}

    private SqlSessionFactory sessionFactory = null;
    private void initSession()  {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static DbSessionFactory getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (DbSessionFactory.class) {
                //再次检查实例是否存在，如果不存在才真的创建实例
                if (instance == null) {
                    instance = new DbSessionFactory();
                    instance.initSession();
                }
            }
        }
        return instance;

    }

}
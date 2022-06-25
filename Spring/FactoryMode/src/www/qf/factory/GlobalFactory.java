package www.qf.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalFactory {

    private static Properties properties = new Properties();
    public GlobalFactory() {
    }

    /** 生成工厂对象*/
    public GlobalFactory(String path) {
       try {
           InputStream inputStream = GlobalFactory.class.getResourceAsStream(path);
           properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 造对象*/
    public Object getBean(String name) {

        Object object = null;
        try {
            /** 获取类名称*/
            String p = properties.getProperty(name);
            /** 反射：根据类名称，生成类对象*/
            Class cls = Class.forName(p);
            /** 反射：根据类对象，生成对象*/
            object = cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;

    }

}

package com.bjsxt.com.IO操作.特殊操作符.对象序列化;

import com.bjsxt.com.IO操作.特殊操作符.PrintStreamTest;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertyTest {

    /**
     * Properties的常规使用：
     */
    protected static void normalUse(){

        Properties properties = new Properties();
        /**
         *  setProperty只能设置String类型的Key、Value
         *  put可以设置任意Object类型的Key、Value
         */
        properties.put("language","Java");
        properties.put("version",1.0);
        properties.put("isUpload",false);
        properties.put(true,100.0);

        /**
         * setProperty：设置集合的 键和值，都是String类型
         * getProperty：根据key获取对应的值；
         */
        properties.setProperty("name","HuXianSheng");
        properties.setProperty("age","22");

        String name = properties.getProperty("name");

        /**
         * keySet() 获取所有键key的集合；
         * get(key) : 根据key获取value值
         */
        for (Object key :
                properties.keySet()) {
            System.out.println("key="+key+",value="+properties.get(key));
        }

        System.out.println("=============================");
        /**
         * stringPropertyNames:
         *      从该属性列表中返回一个不可修改的键集；
         *      其中键及其对应的值是字符串,自动过滤Value不为String类型的键值对；
         */
        Set<String> stringNames = properties.stringPropertyNames();

        for (String myKey:stringNames) {
            System.out.println(myKey+":"+properties.getProperty(myKey));
        }

    }

    /**
     * Properties集合与IO流的结合使用
     */
    protected static void propertiesAndIO() throws IOException{

        /**
         * void load(InputStream inStream)：从输入字节流读取属性列表（键和元素对）
         * void load(Reader reader)：从输入字符流读取属性列表（键和元素对）
         * void store(OutputStream out,String commnents)：
         *      将此属性列表（键和元素对）写入此Properties表中，以适合于使用load(InputStream)
         *      方法的格式写入输出字节流；
         * void store(Writer writer,String commnents)：
         *      将此属性列表（键和元素对）写入此Properties表中，以适合于使用load(Reader)
         *      方法的格式写入输出字符流；
         */

        /**
         * 需求：
         *      1.把集合中的数据保存到文件；
         *      2.把文件中的数据输出到集合；
         */
        saveProperties();
        System.out.println("=============================");
        readProperties();

    }

    /**
     *  1.把集合中的数据保存到文件；
     */
    protected static void saveProperties() throws IOException {

        Properties properties = new Properties();

        properties.put("学号","1001");
        properties.put("姓名","胡先生");
        properties.put("age","10");
        properties.put("isMax","0");

        FileWriter fileWriter = new FileWriter(
                PrintStreamTest.ROOT_PATH+"propertiesStore.txt"
        );

        /**
         * store()：方法只能存储所有键值对为String类型的Properties对象,到文件
         */
        properties.store(fileWriter,null);


    }

    /**
     *  2.把文件中的数据输出到集合；
     */
    protected static void readProperties() throws IOException{

        Properties properties = new Properties();
        FileReader fileReader = new FileReader(
                PrintStreamTest.ROOT_PATH+"propertiesStore.txt"
        );
        /**
         * load():读取文件中的键值对及其属性值，返回到Properties对象中；
         */
        properties.load(fileReader);
        for (Object key:properties.keySet()
             ) {
            System.out.println(key+":"+properties.get(key));
        }

    }

    public static void main(String[] args) throws IOException{

        normalUse();
        propertiesAndIO();

    }


}

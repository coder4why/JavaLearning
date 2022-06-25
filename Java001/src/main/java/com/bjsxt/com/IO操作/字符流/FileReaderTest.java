package com.bjsxt.com.IO操作.字符流;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileReader:
 *      用于读取字符文件的便捷类
 * FileWriter:
 *      用于写入字符文件的便捷类
 */
public class FileReaderTest {

    //写入
    static String reader() throws IOException {

        FileReader fileReader = new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt");
        char[] chars = new char[8192];
        int len;

        String result = "";
        while ((len = fileReader.read(chars))!=-1){
            String item = new String(chars,0,chars.length);
            result += item;
            System.out.println(item);
        }
        fileReader.close();

        return result;

    }

    //输入
    static void writer(String  str) throws IOException{

        FileWriter fileWriter = new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/可惜没有如果.txt");
        fileWriter.write(str);
        fileWriter.close();

    }

    //边读边写
    static void readAndWrite() throws IOException{
        FileReader fileReader = new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt");
        FileWriter fileWriter = new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/林俊杰.txt");
        char[] chars = new char[8192];
        int len;
        while ((len = fileReader.read(chars))!=-1){
            fileWriter.write(chars);
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        writer(reader());
        readAndWrite();
    }

}

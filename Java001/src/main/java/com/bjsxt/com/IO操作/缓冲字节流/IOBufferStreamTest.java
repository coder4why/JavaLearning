package com.bjsxt.com.IO操作.缓冲字节流;

import java.io.*;

/**
 *  BufferStream:字节缓冲流
 *      BufferOutputStream:
 *          该类实现缓冲输出流，通过设置这样的输出流，应用程序可以向底层输出流写入字节，而不必为写入的每个字节导致底层系统的调用；
 *      BufferInputStream:
 *          该类将创建一个内部缓冲区数组，当从流中读取或跳过字节时，内部缓冲区将根据需要从所包含的输入流中重新填充，一次很多个字节；
 *
 */
public class IOBufferStreamTest {

    //读取字节缓冲流：
    static void readBufferd() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/谢霆锋.txt");
        BufferedInputStream  inputStream = new BufferedInputStream(fileInputStream);

        byte[] bys = new byte[8192];
        int len;
        while ((len = inputStream.read(bys)) != -1){
            System.out.println(new String(bys,0,len));
        }
        inputStream.close();

    }

    //写入字节缓冲流
    static void writeBufferd() throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/bufferedTest.txt");
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);

        outputStream.write("谢霆锋--谢谢你的爱".getBytes());
        outputStream.write("\n林俊杰--可惜没有如果".getBytes());
        outputStream.close();

    }

    public static void main(String[] args) throws IOException{

        /**
         * 为什么BufferedStream对象的构造方法需要的是字节流，而不是具体的文件或者 路径呢？
         *     因为字节缓冲流仅仅提供缓冲区，而真正的读写数据还得依靠基本的字节流对象进行操作；
         */
        readBufferd();
        writeBufferd();

    }
}

package com.bjsxt.com.IO操作.特殊操作符;

import java.io.*;

/**
 * 字符缓冲输入流、输出流
 *      复制文件；
 */
public class BufferedRWTest {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(PrintStreamTest.ROOT_PATH+"林俊杰.txt")
        );

        PrintWriter printWriter = new PrintWriter(new FileWriter(PrintStreamTest.ROOT_PATH+"printWriter01.txt"));
        String line;
        while ((line=bufferedReader.readLine())!=null){
            printWriter.println(line);
        }
        printWriter.close();
        bufferedReader.close();

    }

}

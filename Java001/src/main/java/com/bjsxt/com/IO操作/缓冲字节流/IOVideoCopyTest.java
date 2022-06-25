package com.bjsxt.com.IO操作.缓冲字节流;

import java.io.*;

/**
 * 需求：
 *    视频复制（四种方式）；
 *        1.基本字节流一次读写一个字节    (累计耗时:61597ms)
 *        2.基本字节流一次读写一个字节数组 (累计耗时:46ms)
 *        3.缓冲字节流一次读写一个字节    (累计耗时:462ms)
 *        4.缓冲字节流一次读写一个字节数组 (累计耗时:29ms)
 *    测试结果效率：
 *        1.缓冲字节流效率高于基本字节流
 *        2.一次读写一个字节数组效率高于一次读写一个字节；
 */
public class IOVideoCopyTest {

    //视频复制：方式4，缓冲字节流一次读写一个字节数组,累计耗时:29ms
    static void copyVideoStyle4() throws IOException {

        long start = System.currentTimeMillis();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("/Users/hupingkang/Desktop/Basic.mp4")
        );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/BasicCopy.mp4")
        );

        byte[] bys = new byte[8192];
        int len;
        while ((len = bufferedInputStream.read(bys))!=-1){
            bufferedOutputStream.write(bys,0,len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");

    }

    //视频复制：方式3，缓冲字节流一次读写一个字节,累计耗时:462ms
    static void copyVideoStyle3() throws IOException {

        long start = System.currentTimeMillis();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("/Users/hupingkang/Desktop/Basic.mp4")
        );
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/BasicCopy.mp4")
        );

        int len; //当前读取字节的数值；
        while ((len = bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");

    }
    //视频复制：方式2，基本字节流一次读写一个字节数组,累计耗时:46ms
    static void copyVideoStyle2() throws IOException {

        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream("/Users/hupingkang/Desktop/Basic.mp4");
        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/BasicCopy.mp4");

        byte[] bys = new byte[8192];
        int len;
        while ((len = fileInputStream.read(bys))!=-1){
            fileOutputStream.write(bys,0,len);
        }

        fileInputStream.close();
        fileOutputStream.close();

        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");

    }

    //视频复制：方式1，基本字节流一次读写一个字节,累计耗时:61597ms
    static void copyVideoStyle1() throws IOException {

        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("/Users/hupingkang/Desktop/Basic.mp4");
        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/BasicCopy.mp4");

        int len;
        while ((len = fileInputStream.read())!=-1){
            fileOutputStream.write(len);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");

    }


    public static void main(String[] args) throws IOException {

        copyVideoStyle3();

    }

}

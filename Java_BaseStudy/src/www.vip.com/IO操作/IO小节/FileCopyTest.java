package www.vip.com.IO操作.IO小节;

import www.vip.com.IO操作.特殊操作符.PrintStreamTest;

import java.io.*;

/**
 * 字节输出流拷贝视频文件
 */
public class FileCopyTest {

    public static void main(String[] args) {

        try {

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(PrintStreamTest.ROOT_PATH + "BasicCopy.mp4"));

            //字节输出流：
            BufferedOutputStream printStream = new BufferedOutputStream(new FileOutputStream(PrintStreamTest.ROOT_PATH + "Flutter.mp4"));

            byte[] bytes = new byte[8192];
            int len;

            while ((len = bufferedInputStream.read(bytes)) != -1) {
                printStream.write(bytes,0,bytes.length);
            }
            printStream.close();
            bufferedInputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }

}

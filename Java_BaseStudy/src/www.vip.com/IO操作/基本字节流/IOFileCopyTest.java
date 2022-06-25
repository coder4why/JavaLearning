package www.vip.com.IO操作.基本字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 复制文本文件：
 *     复制：先从源文件读取，再写入新文件；
 */
public class IOFileCopyTest {

    //读取结果：
    static String readFile() throws IOException {

        FileInputStream inputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/因为爱所以爱.txt");

        byte[] bytes = new byte[1024 * 4];
        int len = inputStream.read(bytes);
        String result = new String(bytes);

        inputStream.close();

        return result;

    }

    //将结果写入：
    static void writeOutput(String txt) throws IOException {

        FileOutputStream  outputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/谢霆锋.txt");

        byte[] bytes = txt.getBytes();
        outputStream.write(bytes);

        outputStream.close();

    }


    public static void main(String[] args) throws IOException {

        //方式一：
//        String result = readFile();
//        writeOutput(result);

        //方式二：此种方式可以复制任意格式，任意大小的文件：
        FileInputStream inputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/因为爱所以爱.txt");
//        FileInputStream inputStream = new FileInputStream("/Users/hupingkang/Desktop/iOS屏幕录制与截图技术要点.pdf");

        FileOutputStream  outputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/谢霆锋.txt");

        int by;
        while ((by=inputStream.read())!=-1){
            outputStream.write(by);
        }

        inputStream.close();
        outputStream.close();

    }
}

package www.vip.com.IO操作.特殊操作符;

import java.io.IOException;
import java.io.PrintStream;

/**
 *  标准输入流：InputStream
 *      该流已经打开，准备提供输入数据；通常，该流对应于键盘输入；
 *  标准输出流：PrintStream
 *      该流已经打开并准备好接受输出数据；通常，此流对应于显示输出；
 *
 *  InputStream和PrintStream都属于系统System类中的两个静态的成员变量；
 *
 **/

/** 字节打印流 **/
public class PrintStreamTest {

    public static String ROOT_PATH = "./src/com/bjsxt/com/IO操作/测试文件/";

    public static void main(String[] args) throws IOException {

        PrintStream printStream = System.out;
        printStream.println(false);
        printStream.println("上海");
        printStream.println(100.0);
        printStream.println('c');
        printStream.println(0x111);

        /** PrintStream写入文本 **/
        PrintStream printStream1 = new PrintStream(ROOT_PATH+"printStream.txt");

        /**
         *  使用write方法写数据，查看时会自动转码
         *  使用print、println方法写数据，查看时，数据原样输出
         */
        printStream1.write(97);

        printStream1.println();
        printStream1.println("你好，上海");
        printStream1.println(true);
        printStream1.println('c');
        printStream1.println(1000);

        printStream.close();
        printStream1.close();


    }
}

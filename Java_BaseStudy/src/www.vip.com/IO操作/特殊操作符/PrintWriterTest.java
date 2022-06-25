package www.vip.com.IO操作.特殊操作符;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrintWriter：字符打印流
 *
 */
public class PrintWriterTest {

    public static void main(String[] args) throws IOException {

//        PrintWriter printWriter = new PrintWriter(PrintStreamTest.ROOT_PATH+"printWriter.txt");

        PrintWriter printWriter = new PrintWriter(new FileWriter("PrintStreamTest.ROOT_PATH+\"printWriter.txt\""),true);
        printWriter.write(10086);
        printWriter.write('c');
        printWriter.write("你好");
        printWriter.write(100);
        printWriter.write(""+100.0);
        printWriter.flush();
        printWriter.println();
        printWriter.println("---------------------");
        printWriter.println();
        printWriter.println(100);
        printWriter.println("你好，Java");
        printWriter.println(false);
        printWriter.println('a');

        printWriter.close();

    }

}

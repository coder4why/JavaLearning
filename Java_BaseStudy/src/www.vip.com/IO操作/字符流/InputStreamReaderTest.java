package www.vip.com.IO操作.字符流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    /**
     * InputStreamReader:将文件内容读取字节转化字符
     *   方式一： 一次读取一个字符数组：(累计耗时:0ms)
     */
    static void inputTestChars() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/字符流.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

        char[] chars = new char[1024];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }

        inputStreamReader.close();

        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");
    }

    /**
     * InputStreamReader:将文件内容读取字节转化字符
     *   方式二： 一次读取一个字符：(累计耗时:4ms)
     */
    static void inputTestChar() throws IOException {

        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/字符流.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        int len;
        while ((len = inputStreamReader.read()) != -1){
            System.out.print((char)len);
        }

        inputStreamReader.close();
        long end = System.currentTimeMillis();
        System.out.println("累计耗时:"+(end-start)+"ms");
    }

    public static void main(String[] args) throws IOException {
        inputTestChar();
        inputTestChars();
    }

}

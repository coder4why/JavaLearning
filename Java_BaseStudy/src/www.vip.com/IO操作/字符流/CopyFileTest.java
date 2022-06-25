
package www.vip.com.IO操作.字符流;
import java.io.*;

/**
 * 需求：
 *      复制java文件
 */
public class CopyFileTest {

    static String readFile() throws IOException {

        String javaString = "";
        FileInputStream fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/字符流/IOEncodeTest.java");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        char[] chars = new char[8192];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            javaString += (new String(chars));
        }

        inputStreamReader.close();
        fileInputStream.close();

        return javaString;
    }

    static void writeFile(String java) throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/IOEncodeTest_Copy.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(java);
        outputStreamWriter.close();
        fileOutputStream.close();

    }

    //边读边写
    static void operators() throws IOException{

        FileInputStream fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/IOEncodeTest_Copy.txt");
        InputStreamReader inputStreamReader =  new InputStreamReader(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/IOEncodeTest_Copy01.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        char[] chars = new char[8192];
        int len;
        while ((len = (inputStreamReader.read(chars)))!=-1){
            outputStreamWriter.write(chars);
        }

        fileOutputStream.close();
        fileInputStream.close();
        fileInputStream.close();
        inputStreamReader.close();

    }

    public static void main(String[] args) throws IOException {

//        writeFile(readFile());

        operators();
    }

}

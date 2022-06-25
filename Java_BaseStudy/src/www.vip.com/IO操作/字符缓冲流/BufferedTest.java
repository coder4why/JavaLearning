package www.vip.com.IO操作.字符缓冲流;

import java.io.*;

public class BufferedTest {

    //读文件：
    static String reader() throws IOException {
        FileReader fileReader = new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        char[] chars = new char[1024];
        int len;
        String result = "";
        while ((len = bufferedReader.read(chars))!=-1){
            String item = new String(chars,0,chars.length);
            System.out.println(item);
        }
        fileReader.close();
        bufferedReader.close();
        return result;
    }

    //写文件：
    static void writer(String str) throws IOException{
        FileWriter fileWriter = new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/林俊杰-可惜没有如果.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(str);
        fileWriter.close();
        bufferedWriter.close();
    }

    //边写边读
    static void readAndWrite() throws IOException{
        FileReader fileReader = new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/林俊杰-可惜没有如果.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        char[] chars = new char[1024];
        int len;
        while ((len = bufferedReader.read(chars))!=-1){
            bufferedWriter.write(chars);
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {
            writer(reader());
            readAndWrite();
    }

}

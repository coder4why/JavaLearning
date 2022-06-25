package www.vip.com.IO操作.字符缓冲流;


import java.io.*;

/**
 * 字符缓冲流特有功能：
 *      1.BuffererWriter:
 *          void newLine():
 *               写一行分隔符，行分隔符字符串由系统属性定义
 *              （window: \r\n,Linux:\n，Mac:\r）
 *      2.BufferedReader:
 *          public String readLine()：
 *              读一行文字。结果包含行的内容的字符串，不包含任何行终止字符；
 *              如果流的结尾已经达到，则为null；
 */
public class BufferedMethodTest {

    //写一行数据
    static void writeNewLine() throws IOException{
        FileWriter fileWriter = new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/bufferedMethod.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("BufferedMethod:"+(i+1));
            /**  写一行分隔符 **/
            bufferedWriter.newLine();
        }

        /**
         * 释放资源的时候，优先关闭缓冲流BufferedWriter对象，再关闭文件流FileWriter对象
         */
        bufferedWriter.close();
        fileWriter.close();

    }

    //读一行数据
    static void readLine() throws IOException{

        FileReader fileReader = new FileReader("./src/com/bjsxt/com/IO操作/测试文件/bufferedMethod.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        /*
        for (int i = 0; i < 11 ; i++) {
            String line = bufferedReader.readLine();
            System.out.println(line);
        }
        */

        String line;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();
        fileReader.close();

    }

    //边读边写
    static void readAndWrite() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/com/bjsxt/com/IO操作/测试文件/bufferedMethod.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/bufferedREADME.txt"));

        String line;
        while ((line = bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            //刷新
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();

    }

    public static void main(String[] args) throws IOException {
        writeNewLine();
        readLine();
        readAndWrite();
    }

}

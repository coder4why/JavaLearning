package www.vip.com.IO操作.基本字节流;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流读数据：
 *      一次读一个字节数组数据；
 *      需求：
 *          1.读取文文本文件，从控制台输出；
 *          2.复制图片；
 */
public class IOReadTest {

    //需求1：读取文文本文件，从控制台输出；
    static void consoleTxt() throws IOException {

        //1.创建数据流对象
        FileInputStream inputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/谢霆锋.txt");

        //bys:记录每次读取的字节内容；
        byte[] bys = new byte[1024];//1024及其整数倍
        //len:记录每次读取的字节长度；
        int len;
        //累计读取的文本字符串：
        String result = "";
        while ((len=inputStream.read(bys))!=-1){
            result += new String(bys,0,len);
//            System.out.println(new String(bys,0,len));
        }
        System.out.println(result);

        //3.关闭数据流
        inputStream.close();

    }

    //2.需求：完成图片的复制
    static void copyImage() throws IOException{

        FileInputStream inputStream = new FileInputStream("/Users/hupingkang/Desktop/sds.jpg");
        FileOutputStream outputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/sds-1.jpg");

        byte[] bys = new byte[1024];
        int len;
        while ((len = inputStream.read(bys))!=-1){
            outputStream.write(bys,0,len);
        }

        inputStream.close();
        outputStream.close();

    }

    public static void main(String[] args)  throws IOException {

        consoleTxt();
        copyImage();

    }

}

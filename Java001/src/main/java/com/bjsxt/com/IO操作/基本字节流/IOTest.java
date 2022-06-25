package com.bjsxt.com.IO操作.基本字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO操作：
 *      IO：输入/输出（Input/Output）
 *      流：是一种抽象概念，是对数据传输的总称；也就是说数据在设备间的传输称为流，流的本质是数据传输；
 */
public class IOTest {

    public static void outputTest() throws IOException {
//
//        char next = '\n';
//        System.out.println((int)next); //10

        /**
         * FileOutputStream:文件输出流用于将数据写入File
         *      name:用于写入File后的文件保存全路径；
         *
         *  以下初始化方法做了三件事情：
         *      1.调用系统功能创建了文件；
         *      2.创建了字节输出流对象；
         *      3.让字节输出流对象指向创建好的文件；
         */
        //此方法将覆盖写入:append == false，将覆盖写入，append == true，将在文末追加写入
        FileOutputStream fos = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/歌词.txt",false);
        //此方法将追加写入：
        //FileOutputStream appendFos = new FileOutputStream("outputStream.txt",true);
        /**
         * 将指定的字节写入文件输出流的三个方法:
         *      write(int b)：
         *          一次写一个字节数据（int b为对应的char类型字符int值）；
         *      write(byte[] b)：
         *          将b.length字节从指定的字节数组写入此文件输出流，一次写一个字节数组数据
         *      write(byte[] b,int off,int len)：
         *          off:为字节数组b中写入文件流的起始位置，len：为从off位置开始，写入文件流的off后面字节长度；
         *          将len字节从指定的字节数组开始，从偏移量off开始写入 文件输出流；
         *          一次写一个字节数组的部分数据；
         */
       /*
        //写入0-10
        for (int i = 48; i <= 57; i++) {
            fos.write(i);
        }
        fos.write(10);
        //写入26个英文小写字母
        for (int i = 97; i < 123; i++) {
            fos.write(i);
            if ((i-90) == 13 || (i-90) == 20 || (i-90) == 26 ||  (i-90) == 32){
        //插入换行符
                fos.write(10);
            }
        }

        fos.write(10);
        */

        /**
         * 如何将字符串写入硬盘文件：
         *      1.string.getBytes()：将字符串转换成bytes数组
         *      2.使用输出流对象，调用write方法，传入bytes数组，即可将字符串写入硬盘文件
         */

        String yourString =
                "  《可惜没有如果》 \n\t\t\t--- 林俊杰\n"+
                "  假如把犯得起的错\n  能错的都错过\n  应该还来得及去悔过\n" +
                "  假如没把一切说破\n  那一场小风波\n  将一笑带过\n" +
                "  在感情面前\n  讲什么自我\n  要得过且过\n" +
                "  才好过\n  全都怪我\n  不该沉默时沉默\n" +
                "  该勇敢时软弱\n  如果不是我\n  误会自己洒脱\n" +
                "  让我们难过\n  可当初的你\n  和现在的我\n" +
                "  假如重来过\n  倘若那天\n  把该说的话好好说\n" +
                "  该体谅的不执着\n  如果那天我\n  不受情绪挑拨";
        byte[] yourBytes = yourString.getBytes();
        System.out.println("字节数组长度:"+yourBytes.length);
        /** 实测 数据会乱码，且数据丢失 */
//        fos.write(yourBytes,0,bytes.length);
        /** 实测正常 **/
        fos.write(yourBytes);
        /**
         * 字节流写入数据的两个小问题：
         *      1.字节流写数据如何实现换行？
         *          window换行符：\r\n
         *          linux 换行符：\n
         *          mac 换行符:   \r (实测\n正常)
         *      2.字节流写数据如何实现追加写入呢？
         *         调用 public FileOutputStream(String name, boolean append)方法，传入append:true；
         *     *** 创建文件输出流以指定的名称写入文件，如果第二个参数为true，则字节将写入文件的末尾而不是开头；***
         *         FileOutputStream appendFos = new FileOutputStream("outputStream.txt",true);
         */

        /**
         * 文件操作最后都要释放资源：
         *    void close():关闭此文件输出流 并释放与此流相关联的任何系统资源；
         */
        fos.close();

    }

    public static void inputTest() throws IOException {

        /**
         * FileInputStream:文件输入流用于将数据读取到内存
         *      name:用于读取File时的文件读取路径；
         */
        FileInputStream input = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/因为爱所以爱.txt");

        //调用字节输入流对象的读数据方法：
        byte[] bytes = new byte[1024 * 4]; //通常传入1024的整数倍
        // int read(byte b[]):从 该输入流读取最多b.length个字节的数据到一个字节数组
        int len = input.read(bytes);
        String readString = new String(bytes);
        System.out.println(readString);

//        int txtLen;
//        byte[] bys = new byte[1024];
//        while ((txtLen = input.read(bys)) != -1){
//            System.out.print(new String(bys,0,txtLen));
//        }

        input.close();

    }


    public static void main(String[] args) throws IOException {

        /**
         * 流的分类：
         *    一般来说，IO流的分类是按照 数据类型 来分的；
         *    1.按方向【重点】：
         *      输入流：将存储设备（如硬盘）中的内容读入到内存中；
         *      输出流：将内存中的内容写入到存储设备中；
         *    2.按单位：
         *      （读得懂的文件使用字符流，读不懂的文件使用字节流）；
         *       (如果不知道使用那种类型的流，就使用字节流，字节流是万能的流)；
         *      字节流：以字节为单位，可以读写所有数据；
         *          字节输入流、字节输出流；
         *      字符流：以字符为单位，只能读写文本数据；
         *          字符输入流、字符输出流；
         *    3.按功能：
         *      节点流：具有实际传输数据的读写功能；
         *      过滤流：在节点流的基础之上增强功能；
         *    4.字节流的父类（抽象类）：
         *      InputStream: 字节输入流的所有类的超类
         *      OutputStream:字节输出流的所有类的超类
         */

        outputTest();//输出到硬盘
        inputTest(); //读取到内存


    }


}

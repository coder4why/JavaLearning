package com.bjsxt.com.IO操作.字符流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字节流写数据的五种方式：
 *      1.write(int c) : 一次写入一个字符
 *      2.write(char[] cbuf)：一次写入一个字符数组
 *      3.write(char[] cbuf,int off,int len): 一次写入字符数组的一部分
 *      4.write(String str) : 一次写入一个字符串
 *      5.write(String str,int off,int len) :一次写入一个字符串的一部分
 */
public class OutputStreamWriterTest {

    static final String news = "\n原标题：“港独”分子欲在爱尔兰买地“建城”，但爱尔兰并不傻\n" +
            "\n" +
            "　　根据英国《泰晤士报》报道，香港一个名叫高广垣的地产商在过去几个月里一直在与爱尔兰官方沟通，希望能在爱尔兰的土地上建立一个所谓的“自治城市”，好让那些在中国香港待不下去的“港独”分子和反内地分子“集体移民”到这个“新家园”。\n" +
            "\n" +
            "　　但尴尬的是，爱尔兰方面却并不愿意解决这个“英国的麻烦”。\n" +
            "\n" +
            "　　这个在爱尔兰买地“建城”的事情，是一个名叫高广垣的香港地产商最初在今年1月提出的。\n" +
            "\n" +
            "　　从当时“乱港媒体”《苹果日报》对他的报道，以及今年5月高广垣本人亲自在其他“乱港媒体”上发表的文章来看，这个靠赚内地人的钱发家的高广垣，骨子里却对内地存在强烈的歧视，不仅将中国对香港的依法管辖说成是干涉和收紧香港人的自由，还格外怀念上世纪七、八十年代他在内地的家人不惜冒着生命危险也要偷渡去的香港的场景。";

    /**
     * 方式一：
     *      一次写入一个字符：累计耗时：4ms
     */
    static void styleOne() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/write.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");

        char[] chars = news.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            outputStreamWriter.write(chars[i]);
        }
        outputStreamWriter.flush(); //字符刷新流； //刷新写入的文档文件
        outputStreamWriter.close();

    }
    /**
     * 方式二：
     *      一次写入一个字符数组：累计耗时：1ms
     */
    static void styleTwo() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/write.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");

        char[] chars = news.toCharArray();
        outputStreamWriter.write(chars);
        outputStreamWriter.flush(); //字符刷新流； //刷新写入的文档文件
        outputStreamWriter.close();

    }
    /**
     * 方式三：
     *      一次写入一个字符数组的一部分：累计耗时：1ms
     */
    static void styleThress() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/write.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");

        char[] chars = news.toCharArray();
        outputStreamWriter.write(chars,0,chars.length);
        outputStreamWriter.flush(); //字符刷新流； //刷新写入的文档文件
        outputStreamWriter.close();

    }
    /**
     * 方式四：
     *      一次写入一个字符串：累计耗时：1ms
     */
    static void styleFour() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/write.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        outputStreamWriter.write(news);
        outputStreamWriter.flush(); //字符刷新流； //刷新写入的文档文件
        outputStreamWriter.close();

    }

    /**
     * 方式五：
     *      一次写入一个字符串的一部分：累计耗时：1ms
     */
    static void styleFive() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/write.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
        outputStreamWriter.write(news,0,news.length());
        outputStreamWriter.flush(); //字符刷新流； //刷新写入的文档文件
        outputStreamWriter.close();

    }

    public static void main(String[] args) throws IOException  {

        long start = System.currentTimeMillis();

        styleOne();
        styleTwo();
        styleThress();
        styleFour();
        styleFive();

        long end = System.currentTimeMillis();
        System.out.println("累计耗时："+(end-start)+"ms");

    }
}

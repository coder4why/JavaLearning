package com.bjsxt.com.IO操作.字符流;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 字符流中的编码解码问题：
 *     1.字符流抽象基类：
 *       Reader：字符输入流的抽象类
 *       Writer：字符输出流的抽象类
 *     2.字符流中和编码解码问题相关的两个类：
 *       InputStreamReader:读取文件输出为字符；
 *       OutputStreamWriter:将字符输出到文件；
 */

public class IOStringEncodedTest {



    /**
     * OutputStreamWriter:将字符输出到文件；
     */
    static void outputTest() {

        OutputStreamWriter outputStreamWriter = null;
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("./src/com/bjsxt/com/IO操作/测试文件/字符流.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
            outputStreamWriter.write("\n当美国官员离开领事馆时，人群表现出的激动更是无法抑制。\n" +
                    "文章描述道，美国人离开之际，大批中国警察正努力地维持现场秩序，避免人群靠得太近，\n" +
                    "并制止“任何挑衅行为或过于明显的喜悦行为”。社交媒体上一段现场视频还显示，\n" +
                    "一名男子甚至直接从阳台上挂出一面巨大的中国国旗，对着街道大喊着“中国”。\n");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (outputStreamWriter != null){
                    outputStreamWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException{

       outputTest();
    }

}

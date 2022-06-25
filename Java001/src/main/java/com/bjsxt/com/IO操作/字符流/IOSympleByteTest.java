package com.bjsxt.com.IO操作.字符流;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *  1.为什么会出现字符流？
 *      由于字节流操作中文不是特别方便，Java提供了字符流；
 *  2.字符流 = 字节流 + 编码表；
 *  3.用字节流复制文本文件时，文本文件也会有中文，但是没问题，为什么？
 *      原因是最终底层操作会自动进行字节拼接成中文，如何识别是中文的呢？
 *    （是因为汉字在存储的时候，无论选择哪一种编码存储，第一个字节都是负数）；
 *
 *  4.编码与解码：
 *      编码：按照某种规则，将字符存储到计算机中；
 *      解码：按照某种规则，将字符从计算机中解析显示出来；
 *     （按照A编码存储，必须按照A编码解析，这样才能正常解析显示，否则会导致乱码；）
 *
 */
/**
 * 字符串中的编码解码问题：
 *   编码：
 *      1.byte[] getBytes():
 *          使用平台默认的字符集将该String编码为一系列字节，将结果存储到新的字节数组中；
 *      2.byte[] getBytes(String charsetName):
 *          使用特定的字符集将该String编码为一系列字节，将结果存储到新的字节数组中；
 *   解码：
 *      1.String(byte[] bytes):通过使用平台的默认字符集解码指定的字节数组来构造新的String；
 *      2.String(byte[] bytes,String charsetName):通过指定的字符集解码指定的 字节数组来构造新的String；
 */

public class IOSympleByteTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String china = "中国";
        System.out.println(Arrays.toString(china.getBytes()));

        //china.getBytes():使用的UTF-8编码，此处使用GBK解码，输出为乱码；
        String zhongGuo = new String(china.getBytes(),"GBK");
        System.out.println(zhongGuo);

        String zhongGuoGBK = new String(china.getBytes("GBK"),"GBK");
        System.out.println(zhongGuoGBK);

        String zhongGuoUTF8 = new String(china.getBytes("UTF-8"),"UTF-8");
        System.out.println(zhongGuoUTF8);

        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("./src/com/bjsxt/com/IO操作/测试文件/因为爱所以爱.txt");
            byte[] bytes = new byte[8192];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                //设置解码方式：
                System.out.println(new String(bytes,0,len,"UTF-8"));
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                }
            }
        }

    }

}

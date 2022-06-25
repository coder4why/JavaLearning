package com.bjsxt.com.IO操作.字符流;

import java.io.IOException;
import java.util.Arrays;

/**
 * 需求：字节流读文本文件数据
 */
public class IOEncodeTest {

    public static void main(String[] args) throws IOException {

        /** 一次读取一个字节：
         *      一个汉字存储：
         *          如果是GBK编码，占用2个字节；
         *          如果是UTF-8编码，占用3个字节；
         *      所以读取中文输出，会有乱码；
         */

        String china = "中国";
        System.out.println(Arrays.toString(china.getBytes()));

        //china.getBytes():使用的UTF-8编码，此处使用GBK解码，输出为乱码；
        String zhongGuo = new String(china.getBytes(),"GBK");
        System.out.println(zhongGuo);

        String zhongGuoGBK = new String(china.getBytes("GBK"),"GBK");
        System.out.println(zhongGuoGBK);

        String zhongGuoUTF8 = new String(china.getBytes("UTF-8"),"UTF-8");
        System.out.println(zhongGuoUTF8);

        String zhong = "中";
        System.out.println(Arrays.toString(zhong.getBytes()));

        String guo = "国";
        System.out.println(Arrays.toString(guo.getBytes()));

        //设置编码方式：
        String hpk = "中国";
        //charsetName:默认为UTF-8;
        byte[] gbk = hpk.getBytes("GBK");
        System.out.println(Arrays.toString(gbk));

        byte[] uft8 = hpk.getBytes("UTF-8");
        System.out.println(Arrays.toString(uft8));


    }

}

package com.bjsxt.com.IO操作.IO小节;

import javax.annotation.processing.Filer;
import java.io.FileReader;
import java.io.IOException;

/**
 * JDK7以后的 try...catch...finally的改进版,没有finally
 *      try(异常对象代码){
 *
 *      }catch(IOException e){
 *
 *      }
 *
 * JDK9以后的 try...catch...finally的改进版,没有finally
 *  *      try(异常对象;异常对象){
 *  *
 *  *      }catch(IOException e){
 *  *
 *  *      }
 */

public class TryCatchAdvancedTest {


    private static void baseThrows() throws IOException{
        FileReader fileReader = new FileReader("");
        fileReader.close();
    }

    /** 老版本的try...catch...finally **/
    private static void oldTryCatch(){
        FileReader fileReader = null;
        try{

            fileReader = new FileReader("");
            fileReader.read();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try{
                    fileReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }

    /** JDK7的改进版：异常对象在try语句后面，不需要throws异常 **/
    private static void jdk7TryCatchFinally(){

        /** 不再需要手动调用close() 方法，系统将自动释放资源 **/
//        try(FileReader fileReader = new FileReader("");){
//            fileReader.read();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }

    /** JDK9的改进版:异常对象在try语句外面，依然需要throws异常 **/
    private static void jdk9TryCatchFinally() throws IOException{

        FileReader fileReader1 = new FileReader("");
        FileReader fileReader2 = new FileReader("");

        /** 不再需要手动调用close() 方法，系统将自动释放资源 **/
//        try(fileReader1;fileReader2;){
//            fileReader1.read();
//            fileReader2.read();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }

    public static void main(String[] args) {

        try {
            baseThrows();
        }catch (IOException e){
            e.printStackTrace();
        }

        oldTryCatch();
        jdk7TryCatchFinally();

        try {
            jdk9TryCatchFinally();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}

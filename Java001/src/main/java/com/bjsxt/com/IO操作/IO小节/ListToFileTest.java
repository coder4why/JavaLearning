package com.bjsxt.com.IO操作.IO小节;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListToFileTest {

    static void listToFile() throws IOException {

        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            datas.add("林俊杰：0"+(i+1));
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/com/bjsxt/com/IO操作/测试文件/ioTest1.txt"));
        for (String e:datas
             ) {
            bufferedWriter.write(e);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();

    }

    public static void main(String[] args) throws  IOException{
        listToFile();
    }

    

}

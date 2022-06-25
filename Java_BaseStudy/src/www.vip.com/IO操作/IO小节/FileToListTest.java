package www.vip.com.IO操作.IO小节;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件到集合
 */
public class FileToListTest {

    static void fileToList() throws IOException {

        ArrayList<String> lrcs = new ArrayList<String>();
        BufferedReader fileReader = new BufferedReader(new FileReader("./src/com/bjsxt/com/IO操作/测试文件/ioTest.txt"));
        String line;
        while((line = fileReader.readLine()) != null){
            lrcs.add(line);
        }
        fileReader.close();
        for (String lrc :
                lrcs) {
            System.out.println(lrc);
        }

    }

    public static void main(String[] args) throws IOException {

        fileToList();


    }

}

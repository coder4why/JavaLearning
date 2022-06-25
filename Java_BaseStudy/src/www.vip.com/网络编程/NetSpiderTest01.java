package www.vip.com.网络编程;
import java.io.*;
import java.net.URL;

/**
 * 网络爬虫：
 *
 */
public class NetSpiderTest01 {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.jd.com");

        InputStream inputStream = url.openStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/hupingkang/Desktop/jd.txt"));
        byte[] bytes = new byte[8192];
        int len;
        while ((len = inputStream.read(bytes))!=-1){
            String res = new String(bytes,0,len);
            bufferedWriter.write(res);
        }
        bufferedWriter.close();
        inputStream.close();

    }
}

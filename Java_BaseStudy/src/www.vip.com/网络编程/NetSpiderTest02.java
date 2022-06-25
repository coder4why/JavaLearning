package www.vip.com.网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 模拟浏览器请求，爬取数据；
 */
public class NetSpiderTest02 {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.dianping.com/");
        //下载资源：
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:79.0) Gecko/20100101 Firefox/79.0");

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8")
        );
        String msg = null;
        while ((msg = bufferedReader.readLine())!=null){
            System.out.println(msg);
        }
        bufferedReader.close();

    }



}

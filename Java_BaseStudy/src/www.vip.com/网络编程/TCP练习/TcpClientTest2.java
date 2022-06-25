package www.vip.com.网络编程.TCP练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据来自键盘录入；
 */
public class TcpClientTest2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null){

            if (line.equals("886")){
                bufferedReader.close();
                break;
            }

            Socket socket = new Socket("hudeMacBook-Pro.local",10020);
            socket.getOutputStream().write(line.getBytes());

            socket.close();

        }
    }

}

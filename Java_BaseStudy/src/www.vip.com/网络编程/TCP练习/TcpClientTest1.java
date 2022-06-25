package www.vip.com.网络编程.TCP练习;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP编程：
 *      客户端发送数据，接收服务器反馈；
 */
public class TcpClientTest1 {

    public static void main(String[] args) throws IOException {

        //public Socket(String host, int port)
        Socket socket = new Socket("10.10.1.63",10006);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("TCP协议客户端发送数据".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[8192];
        int len;
        String response = "";
        while ((len = inputStream.read(bytes))!=-1){
            String res = new String(bytes,0,len);
            response += res;
        }

        System.out.println("客户端已接收到响应："+response);

        socket.close();


    }

}

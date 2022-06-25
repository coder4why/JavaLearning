package www.vip.com.网络编程.TCP发送接收数据;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP接收数据：
 *     1.创建服务器端的Socket对象（ServerSocket）
 *     2.获取输入流，读数据，并把数据显示在控制台
 *     3.释放资源；
 */
public class TCPReceivedTest {

    public static void main(String[] args) throws IOException {

        /** 1.创建服务器端的Socket对象（ServerSocket） */
        ServerSocket serverSocket = new ServerSocket(8192);

        /** 2.调用accept()方法 监听socket连接并接受连接 */
        Socket socket = serverSocket.accept();

        /** 3.获取输入流，读数据，并把数据显示在控制台 */
        InputStream inputStream =  socket.getInputStream();

        byte[] bytes = new byte[8192];
        int len;
        String response = "";
        while ((len = inputStream.read(bytes))!=-1){
            String msg = new String(bytes,0,len);
            response += msg;
        }
        System.out.println("接收报文："+response);
        /** 3.释放资源； */
        serverSocket.close();
        socket.close();

    }

}

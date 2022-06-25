package www.vip.com.网络编程.TCP发送接收数据;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP发送数据：
 *    1.创建客户端socket对象；
 *    2.获取输出流，写数据；
 *    3.释放资源；
 */
public class TCPSendTest {

    public static void main(String[] args) throws IOException {

        //public Socket(InetAddress address, int port)
        //创建 流套接字并将其连接到指定IP地址的指定端口号；
//        InetAddress inetAddress = InetAddress.getByName("hudeMacBook-Pro.local");
//        Socket socket = new Socket(inetAddress,8192);
        //public Socket(String host, int port)
        /** 1.创建客户端socket对象；*/
        Socket socket = new Socket("hudeMacBook-Pro.local",8192);
        /** 2.获取输出流，写数据；*/
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我正在使用TCP协议发送数据".getBytes());
        /** 3.释放资源；*/
        socket.close();

    }

}

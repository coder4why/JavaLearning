package com.bjsxt.com.网络编程;

/**
 * 网络端口：设备上应用程序的唯一标识；
 * 端口号：
 *      用两个字节表示的整数，取之范围为0-65535；其中0-1023之间的端口号用于一些知名的网络服务和应用，
 *      普通的应用程序需要使用1024以上的端口号，如果端口号被另外一个服务或者应用所占用，
 *    会导致当前应用程序启动失败；
 */

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 协议：连接和通信的规则被称为网络通信协议；
 *      A.UDP协议（User Datagram Protocal）：
 *         也叫用户数据报协议，UDP是无连接通信协议，即在数据传输时，数据的发送和接收端不建立逻辑连接，
 *      简单的说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就发出数据；
 *      同样接收端在收到数据时，也不会向发送端反馈是否收到数据；
 *      使用UDP协议消耗资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输；
 *      在传输重要数据时，不建议使用UDP协议，UDP协议在传输时会丢包；
 *      B.TCP协议（传输控制协议）：
 *          TCP协议是面向连接的传输协议，即在传输数据之前，在发送端和接收端建立逻辑连接，然后在传输数据，
 *      数据传输可靠无差错，每次连接的创建都需要 "三次握手";
 *
 *      三次握手：
 *          1.客户端想服务器发送连接请求，等待服务器确认；
 *          2.服务器向客户端回送一个响应，通知客户端收到了连接请求；
 *          3.客户端再次向服务端发送确认信息，确认连接；
 *
 *     完成三次握手，连接建立后，客户端和服务器可以发送数据传输；
 *
 */
public class NetPortTest {

    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("localhost",8080);
        int port = socketAddress.getPort();
        InetAddress address = socketAddress.getAddress();
        String hostName = socketAddress.getHostName();
        String hostString = socketAddress.getHostString();
        System.out.println(port);
        System.out.println(address);
        System.out.println(hostName);
        System.out.println(hostString);



    }


}

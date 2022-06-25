package www.vip.com.网络编程.UDP发送接收数据;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP通信程序练习：
 * 1.UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束；
 * 2.UDP接收数据：因为接收端不知道发送端什么时候停止发送，故使用死循环；
 */

public class UdpExcersiseReceived {

    private static void receiveData() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(12345);

        while (true){
            byte[] bytes = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
            datagramSocket.receive(datagramPacket);
            byte[] response = datagramPacket.getData();
            String responseString = new String(response, 0, datagramPacket.getLength());
            System.out.println("接收数据：" + responseString);
        }

    }

    public static void main(String[] args) throws IOException {
        receiveData();
    }

}

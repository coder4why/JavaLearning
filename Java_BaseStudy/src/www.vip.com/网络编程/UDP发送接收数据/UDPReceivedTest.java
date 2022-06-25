package www.vip.com.网络编程.UDP发送接收数据;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceivedTest {

    /**
     * UDP接收数据：
     *      1.创建一个接收端的socket对象（DatagramSocket）；
     *      2.创建一个数据包，用于接收数据；
     *      3.调用DatagramSocket对象的方法接收数据；
     *      4.解析数据包，并把数据在控制台显示；
     *      5.关闭接收端；
     */
    static void receviedData() {

        /** 1.声明接收端对象 */
        DatagramSocket datagramSocket = null;
        try {
            /** 接收端的端口号要与发送端相同；*/
            int port = 10086;
            /** 2.初始化接收端对象，并保持端口号与发送端相同 */
            datagramSocket = new DatagramSocket(port);
            byte[] bytes = new byte[1024];
            /** 3.创建接收端接收包对象，设置接收字节数组与接收字节数组长度 */
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            /** 4.接收端对象接收数据 */
            datagramSocket.receive(datagramPacket);
            /** 5.调用接收端包对象getData()方法接收数据 */
            byte[] receviedBytes =  datagramPacket.getData();
            /** 6.datagramPacket.getLength():设置接收报文的长度 */
            System.out.println("接收端接收内容：\n{\n"+
                    new String(receviedBytes,0,datagramPacket.getLength())
                    +"}"
            );

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null){
                /** 7.关闭接收端对象 */
                datagramSocket.close();
            }
        }

    }

    public static void main(String[] args) {
        receviedData();
    }


}

package www.vip.com.网络编程.UDP发送接收数据;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

public class UDPSendTest {
    /**
     * UDP发送数据：
     *      1.创建发送端的Socket对象（DatagramSocket）；
     *      2.创建数据，并把数据打包；
     *      3.调用DatagramSocket对象的方法发送数据；
     *      4.关闭发送端；
     */
    static void udpSendData(){
        /** 1.声明发送端对象 */
        DatagramSocket datagramSocket = null;
        try {
            /** 2.完成发送端对象的初始化 */
            datagramSocket = new DatagramSocket();
            /** 3.准备要发送的数据 */
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("code","200");
            hashMap.put("message","请求成功");
            hashMap.put("body","恭喜了，你成功的接收了我的收据");

            String sendString = "";
            for (String key: hashMap.keySet()
                 ) {
                String mes = key+":"+hashMap.get(key)+"\r\n";
                sendString += mes;
            }
            byte[] hashBytes = sendString.getBytes();
            int length = hashBytes.length;
            /** 4.创建发送端的IP地址和端口号 */
            InetAddress inetAddress = InetAddress.getByName("hudeMacBook-Pro.local");
            int port = 10086;
            /** 5.将发送端要发送的数据打包，并生成发送端包对象 */
            DatagramPacket datagramPacket = new DatagramPacket(hashBytes,length,inetAddress,port);
            /** 6.发送数据 */
            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (datagramSocket != null){
                /** 7.关闭发送端对象 */
                datagramSocket.close();
            }
        }

    }
    public static void main(String[] args) {
        udpSendData();
        System.out.println("数据已发送");
    }
}

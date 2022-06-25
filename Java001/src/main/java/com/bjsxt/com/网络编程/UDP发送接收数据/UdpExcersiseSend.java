package com.bjsxt.com.网络编程.UDP发送接收数据;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

/**
 * UDP通信程序练习：
 *    1.UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束；
 *    2.UDP接收数据：因为接收端不知道发送端什么时候停止发送，故使用死循环；
 */
public class UdpExcersiseSend {

    private static void sendData(){
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            System.out.println("请输入发送内容：");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if ("886".equals(line)){
                    break;
                }
                InetAddress inetAddress = InetAddress.getByName("hudeMacBook-Pro.local");
                int port = 12345;
                byte[] bytes = line.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,inetAddress,port);
                datagramSocket.send(datagramPacket);

            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null){
                datagramSocket.close();
            }
        }
    }

    public static void main(String[] args) {
            sendData();
    }

}

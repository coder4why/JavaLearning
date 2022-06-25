package com.bjsxt.com.网络编程.TCP练习;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class TcpServerTest2 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10020);
        InputStream inputStream = serverSocket.accept().getInputStream();
        byte[] bytes = new byte[8192];
        int len;
        String response = "";
        while ((len = inputStream.read(bytes))!=-1){
            response += (new String(bytes,0,len));
        }
        System.out.println(response);
        serverSocket.close();

    }


}

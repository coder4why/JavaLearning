package com.bjsxt.com.网络编程.TCP练习;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerTest1 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10006);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[8192];
        int len;
        String response = "";
        while ((len = inputStream.read(bytes))!=-1){
            String res = new String(bytes,0,len);
            response += res;
        }
        System.out.println("服务器已接收："+response);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端已接收到客户端数据".getBytes());

        serverSocket.close();
//        socket.close();

    }
}

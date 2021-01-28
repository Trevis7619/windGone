package com.trevis.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class NetApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(NetApplication.class, args);

        //服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(5555);

        while(true){
            //获取到请求的客户端对象的socket;accept方法会阻塞知道收到消息
            Socket socket = serverSocket.accept();
            //获取输入流
            InputStream inputStream = socket.getInputStream();
            //将输入流读到字节数组中
            byte[] buffer = new byte[1024];
            inputStream.read(buffer);
            //打印内容
            System.out.println(new String(buffer));
            //服务端读取客户端成功后会写给客户端
            socket.getOutputStream().write("服务端收到数据了,谢谢".getBytes());
            //关闭流
            socket.close();
        }
    }

}

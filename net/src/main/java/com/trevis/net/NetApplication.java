package com.trevis.net;

import cn.hutool.core.thread.NamedThreadFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class NetApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(NetApplication.class, args);



        //自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 2, TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(5), new NamedThreadFactory("trevis", false)
                , new ThreadPoolExecutor.CallerRunsPolicy());

        //服务端ServerSocket
        ServerSocket serverSocket = new ServerSocket(5555);

        while(true){
            //获取到请求的客户端对象的socket;accept方法会阻塞知道收到消息
            Socket socket = serverSocket.accept();

            threadPoolExecutor.execute(()->{
                //获取输入流
                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //将输入流读到字节数组中
                byte[] buffer = new byte[1024];
                try {
                    inputStream.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //打印内容
                System.out.println(new String(buffer));

                //服务端读取客户端成功后会写给客户端
                try {
                    socket.getOutputStream().write("服务端收到数据了,谢谢".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //关闭流
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
    }

}

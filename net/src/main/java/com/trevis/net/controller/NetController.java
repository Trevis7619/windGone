package com.trevis.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *@author chenyijie
 *@Date  2021/1/21 10:00 下午
 */
@Controller
@RequestMapping("net")
public class NetController {

    @GetMapping("send")
    public void init() throws IOException {
        //创建客户端socket对象绑定服务器地址
        Socket socket = new Socket("127.0.0.1",5555);
        //构造输出流
        OutputStream out = socket.getOutputStream();
        //输出流写输出
        out.write("你好服务器".getBytes());
        //
        InputStream in  = socket.getInputStream();
        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println(new String(bytes));
        //关闭通信
        out.close();
    }

    @GetMapping("receive")
    public void receive() throws IOException {

        Socket socket = new Socket("127.0.0.1",8080);
        socket.getInputStream().toString();
    }
}

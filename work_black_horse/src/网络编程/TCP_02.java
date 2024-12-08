package 网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Frank
 * @date 2024/11/01/15:00
 */
/*
网络通信架构:
    C/S：客户端-服务端
    P2P：个人-个人
    B/S：浏览器-服务端
java中用于客户端和服务端通信要依赖Socket/ServerSocket[利用TCP]
    通过Socket产生IO流来进行网络通信
    客户端Socket：[需要手动关闭]
        1、先找到计算机IP
        2、再找到端口号
        3、按照TCP协议进行IO流的数据收发
    服务端ServerSocket：
        1、绑定程序端口号

Java.net.Socket: [实现了自动关闭，可以放在try的小括号内 InputStream in = s.getInputStream();
            FileOutputStream file = new FileOutputStream("src/案例/TCP上传文件/" + UUID.randomUUID().toString().replace("-", "") + ".jpg");

            byte[] buf = new byte[1024];
            int l = -1;
            while ((l = in.read(buf)) != -1) {
                file.write(buf, 0, l);
            }

            System.out.println("Server上传完成！");

            //反馈
            OutputStream out = s.getOutputStream();
            out.write("上传成功！\n".getBytes(StandardCharsets.UTF_8));]
    创建对象：
        public Socket(String address,int port) 创建对象 参数为：ip，端口号
    方法：
        OutputStream getOutputStream() 基于Socket对象获取网络输出流
        InputStream getInputStream() 基于Socket对象获取网络输入流
        InetAddress getInetAddress() 获取IP对象
        setSoTimeout(int time); 设置超时的时间
        isConnected() 查看是否来链接成功
        shutdownOutput() 告诉服务器发送完成
        close() 关闭链接
Java.net.ServerSocket:
    创建对象：
        public ServerSocket(int port)
    方法：
        Socket accept() 监听客户端链接，并接受来链接，并返回Socket对象
        InputStream getInputStream()  获取网络输入流
        close() 服务器一般不会关闭
 */


public class TCP_02 {
    public static void main(String[] args) {

    }

    public static void main1(String ip, int port) throws IOException {
        Socket net = new Socket(ip, port);
        OutputStream op = net.getOutputStream();
        op.write("hello,你好啊".getBytes(StandardCharsets.UTF_8));
        net.close();
        op.close();
    }

    public static void main2(String ip, int port) throws Exception {
        ServerSocket ss = new ServerSocket(port);
        Socket ss2 = ss.accept();
        System.out.println(ss2.getInetAddress().getHostAddress() + "连接成功...");
        InputStream o1 = ss2.getInputStream();
        InputStreamReader isr = new InputStreamReader(o1);
        char[] buffer = new char[10];
        int len = 0;
        while ((len = isr.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));
        }
        o1.close();
        ss2.close();
        ss.close();

    }

}
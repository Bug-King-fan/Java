package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Frank
 * @date 2024/11/01/14:33
 */

/*
网络编程常配合多线程使用
网络三要素：IP 端口 协议
IP:
    本地回环地址：127.0.0.1
    IPV4: 4 个字节，每个字节是一组
    IPV6: 16 个字节，两字节是一组,通常用冒分16进制表示2001:D88:0:23:8:800:200C:417A[每部分前导0可省略]

    Java提供了网络编程的包：java.net
        java.net.InetAddress类：IP地址
            static InetAddress getByName(String host) 在给定主机名的情况下获取InetAddress对象
            static InetAddress getByAddresst(byte[] add) 在给定IP的情况下获取InetAddress对象
            static InetAddress getLocalHost() 获取本机的InetAddress
            static InetAddress getLoopbackAddress() 获取本机的回环地址
            String getHostAddress() 获取IP地址字符串
            String getHostName() 获取IP地址的主机名
端口：
    用两个字节表示，取值[0，65535]  其中0~1023被用于一些知名网络服务或应用
通信协议：
    TCP：传输控制协议[面向连接的 提供可靠传输服务的协议]
        面向有链接、数据安全不易丢失、数据大小没有限制、传输速度慢
    UDP：用户数据报协议[面向无连接的 不提供可靠传输服务的协议]
        面向无连接、数据大小限制64k以内、数据不安全易丢失、传输速度快
 */

public class 网络三要素_01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
package 案例.TCP三握手通讯;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Frank
 * @date 2024/11/01/16:10
 */
public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress ia = InetAddress.getLoopbackAddress();
        String ip = ia.getHostAddress();
        Socket socket = new Socket(ip, 9091);

        OutputStream out = socket.getOutputStream();
        out.write("友商是傻逼！".getBytes(StandardCharsets.UTF_8));

        System.out.println("发送成功！");

        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        char[] buff = new char[1024];
        int l = isr.read(buff);
        String msg = new String(buff, 0, l);
        System.out.println("客户端接收服务器发送信息:" + msg);

        isr.close();
        in.close();
        out.close();
        socket.close();

    }
}
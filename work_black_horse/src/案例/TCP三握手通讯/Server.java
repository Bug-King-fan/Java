package 案例.TCP三握手通讯;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Frank
 * @date 2024/11/01/16:10
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9091);
        Socket s = server.accept();
        System.out.println(s.getInetAddress().getHostAddress() + "客户端链接成功...");

        InputStream in = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(in);
        char[] buffer = new char[1024];
        int len = isr.read(buffer);
        String msg = new String(buffer, 0, len);
        System.out.println("服务器接收客户端发送信息:" + msg);

        OutputStream ou = s.getOutputStream();
        ou.write("服务器接收到信息，响应信息...".getBytes(StandardCharsets.UTF_8));
        System.out.println("服务器响应成功！");

        isr.close();
        in.close();
        s.close();
    }
}
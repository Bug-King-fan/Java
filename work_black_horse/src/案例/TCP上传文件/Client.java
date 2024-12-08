package 案例.TCP上传文件;

/**
 * @author Frank
 * @date 2024/11/01/16:40
 */


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Frank
 * @date 2024/11/01/16:10
 */
public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress ia = InetAddress.getLoopbackAddress();
        String ip = ia.getHostAddress();
        Socket socket = new Socket(ip, 9091);

        OutputStream ou = socket.getOutputStream();
        FileInputStream file = new FileInputStream("src/流IO/19.jpg");
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = file.read(buffer)) != -1) {
            ou.write(buffer, 0, len);
        }
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //BufferedReader的readLine以换行符未结束标记
        String msg = br.readLine();
        System.out.println("服务器反馈数据" + msg);

        br.close();
        file.close();
        ou.close();
        socket.close();

    }
}
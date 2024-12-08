package 案例.TCP上传文件;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Frank
 * @date 2024/11/01/16:45
 */
//为了防止书数据覆盖，可使用UUID类中 UUID.randomUUID()方法随机生成字符串 但是会包含 '-' 需要用replace()替换

public class Server {
    public static void main(String[] args) {

        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(20);

        ServerSocket server = null;
        try {
            server = new ServerSocket(9091);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try (Socket s = server.accept();) {

                System.out.println(s.getInetAddress().getHostAddress() + "客户端链接成功...");

                //开启新线程处理任务
                pool.execute(new Task(s));

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

class Task implements Runnable {
    private Socket s;

    public Task() {

    }

    public Task(Socket serverSocket) {
        this.s = serverSocket;
    }

    @Override
    public void run() {

        try (InputStream in = s.getInputStream();
             FileOutputStream file = new FileOutputStream("src/案例/TCP上传文件/" + UUID.randomUUID().toString().replace("-", "") + ".jpg");
             OutputStream out = s.getOutputStream();
        ) {
            byte[] buf = new byte[1024];
            int l = -1;
            while ((l = in.read(buf)) != -1) {
                file.write(buf, 0, l);
            }

            System.out.println("Server上传完成！");

            //反馈

            out.write("上传成功！\n".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
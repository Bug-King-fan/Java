package 流IO;

import java.io.*;
import java.util.Arrays;

/**
 * @author Frank
 * @date 2024/10/28/17:49
 */

/*
IO体系下，java提供了高效流[缓冲流(仅仅提供了一个缓冲区)](提高读写速率)
    读文件类流：BufferedInputStream
    写文件类流：BufferedOutputStream
均需要借助字节输入流完成构造
BufferedInputStream is = new BufferedInputStream(new FileInputStream(src))
BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dest))

 */

public class IO字节缓冲区流_04 {
    public static void main(String[] args) {
        if (false) {
            //15ms
            String src = "src\\流IO\\file\\查重.docx";
            String dest = "src\\流IO\\file\\查重_copy.docx";
            main1(src, dest);
        } else {
            //3ms
            String src = "src\\流IO\\file\\查重.docx";
            String dest = "src\\流IO\\file\\查重_copy.docx";
            main2(src, dest);
        }

    }

    public static void main1(String src, String dest) {
        long start = System.currentTimeMillis();
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[10];
            while (is.read(buffer) != -1) {
                os.write(buffer, 0, buffer.length);
                Arrays.fill(buffer, (byte) 32);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    public static void main2(String src, String dest) {
        long start = System.currentTimeMillis();

        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer = new byte[10];
            while (is.read(buffer) != -1) {
                os.write(buffer, 0, buffer.length);
                Arrays.fill(buffer, (byte) 32);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

}
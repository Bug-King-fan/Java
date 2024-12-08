package 流IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Frank
 * @date 2024/10/24/17:56
 */

/* 注意： 通常throws不可取的，应使用try-with-resources 如使用详见TryCatch()
字节流写/读数据步骤： (OutputStream为抽象类，不能直接创建对象)
    1.创建字节输出流对象
        如果文件不存在，就创建。
        如果存在就会清空内容。
        FileOutputStream fos = new FileOutputStream(path); 每次创建会清空内容
        FileOutputStream fos = new FileOutputStream(path,true); 每次创建不会清空内容，追加写入
        FileInputStream fos = new FileInputStream(path);
    2.调用字节输出流对象中的方法写数据
        写出的整数，实际上写出的时整数在ASCII码表上对应的字符
        读数据是读文件中数据的码表值a->97
    3.释放资源
        每次使用完必须释放！！！

换行： Windows: \r\n  Linux: \n  Mac: \r

方法：
    write(int b) 一次写一个字节数据
    write(byte[] b) 一次写一个字节数组
    write(byte[] b,int off,int len) 一次写一个字节数组的一部分
    read(byte[] b,int off,int len) 一次读一个字节数组的一部分
    read() 一次读一个字节数据，当读不到数据时返回-1
    read(byte[] b) 一次读一个字节数组存放到b数组中,当读不到数据时返回-1

 */

public class 字节流_02 {
    public static void main(String[] args) throws IOException {
        //创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("src\\流IO\\file\\a.txt");
        //写数据
        fos.write(97);
        fos.write('B');
        fos.write('\n');
        //getBytes()将字符串转换为字节数组
        fos.write("IT黑马程序员\n".getBytes(StandardCharsets.UTF_8));
        fos.write("黑马程序员\n".getBytes(StandardCharsets.UTF_8), 3, 6);
        //释放资源
        fos.close();
        //追加
        FileOutputStream f = new FileOutputStream("src\\流IO\\file\\a.txt", true);
        f.write("\n追加".getBytes(StandardCharsets.UTF_8));
        f.close();

        //字节输入流
        FileInputStream fis = new FileInputStream("src\\流IO\\file\\a.txt");
        //读第一个、第二个字符
        int ch = fis.read();
        System.out.println((char) ch);
        int ch2 = fis.read();
        System.out.println((char) ch2);
        fis.close();
        System.out.println("________________________________");
        //案例
        copyTxt("src\\流IO\\19.jpg");
    }

    public static void copyTxt(String path) throws IOException {
        InputStream fis = new FileInputStream(path);
        OutputStream fos = new FileOutputStream("src\\流IO\\file\\19_copy.jpg");
        int da = 0;
        while ((da = fis.read()) != -1) {
            fos.write(da);
        }
        fis.close();
        fos.close();
    }

    public static void tryCatch() {
        //外部声明赋null
        InputStream fis = null;
        OutputStream fos = null;
        try {
            fis = new FileInputStream("src\\流IO\\19.jpg");
            fos = new FileOutputStream("src\\流IO\\file\\19_copy.jpg");
            int da = 0;
            while ((da = fis.read()) != -1) {
                fos.write(da);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally { //必须关闭资源
            //close也需要try catch
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
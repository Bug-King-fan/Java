package 流IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Frank
 * @date 2024/10/30/15:06
 */

/*
字符流：以字符为单位对文件进行读写操作  【内置缓冲区(相当于一个数组)】
    字符流 = 字节流 + 编码
工作原理：
    利用转换流实现字节流和字符流之间转换
    文件->字节流->InputStreamReader->FileReader->内存->FileWriter->OutputStreamWriter->字节流
flush(): 把缓冲区的数据写入到文件
    刷新缓存区，还可以继续写数据
close():
    关闭流，释放资源。关闭前会调用flush()
    字符输出流：[Writer] 子类常用的有FileWrite
        创建对象：
            Writer w = new FileWriter("d:\\a.txt"); 覆盖写入
            Writer w = new FileWriter("d:\\a.txt",true); 追加写入
        方法：
            write(int c) 写入一个字符
            write(char[] cbuf) 写入字符数组
            write(char[] cbuf,int off,int len) 写入字符数组的一部分
            write(String str) 写入字符串
            write(String str,int off,int len) 写入字符串的一部分

    字符输入流： [Reader] 子类常用的有FileReader
        创建对象：
            Reader r = new FileReader("d:\\a.txt");
        方法：
            int read() 读取一个字符，返回字符数据的编码值
            int read(char[] cbuf) 读取字符数组，返回实际读取的字符个数

 */

public class 字符流_07 {
    public static void main(String[] args) {
        try (Writer w = new FileWriter("src/流IO/file/b.txt");
             FileReader fr = new FileReader("src/流IO/file/a.txt")) {
            w.write("Hello World\n", 1, 5);
            w.write('\n');
            w.write('黑');
            w.write('马');
            System.out.println((char) fr.read());
            char[] buf = new char[2];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
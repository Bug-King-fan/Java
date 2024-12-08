package 流IO;

/**
 * @author Frank
 * @date 2024/10/30/15:36
 */

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
IO体系下，java提供了高效流[缓冲流(仅仅提供了一个缓冲区)](提高读写速率)
    读文件类流：BufferedReader
    写文件类流：BufferedWriter
均需要借助字节输入流完成构造
BufferedReader is = new BufferedReader(new FileReader(src))
BufferedWriter os = new BufferedWriter(new FileWriter(dest))
BufferedWriter os = new BufferedWriter(new FileWriter(dest,true))追加写入

特有方法：
    newLine()写一个行分隔符
    readLine()读取一行，不包含换行符，读到末尾返回null
 */

public class IO字符缓冲区流_08 {
    public static void main(String[] args) {

    }

    //处理纯文本文件！！！
    public static void copyFile(String src, String dest) {
        try (BufferedReader is = new BufferedReader(new FileReader(src));
             BufferedWriter os = new BufferedWriter(new FileWriter(src))) {
            char[] buf = new char[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取number.txt 排序后重新写入文本
    public static void sortFile(String src, String dest) {
        try (BufferedReader is = new BufferedReader(new FileReader(src));
             BufferedWriter os = new BufferedWriter(new FileWriter(dest))) {
            String s = is.readLine();
            //空格切割
            String[] line = src.split(" ");
            Stream<String> st = Stream.of(line);
            List<Integer> l = st.map((o) -> {
                return Integer.parseInt(o);
            }).sorted((o1, o2) -> {
                return o1 - o2;
            }).collect(Collectors.toList());
            System.out.println(l);   //[11,22,33,44,55]
            String ans = l.toString();
            ans = ans.substring(1, ans.length() - 1);
            ans.replace(",", " ");
            os.write(ans);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
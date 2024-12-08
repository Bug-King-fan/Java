package 流IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author Frank
 * @date 2024/10/31/11:27
 */

/*
作用：
    1、再写入数据后自动换行
    2、通常用于日志的记录。
PrintStream:[没有文件自动创建路径]
    创建对象：
        public PrintStream(String path)
    方法：
        println(数据) 换行
        print(数据) 不换行
 */

public class 打印流_11 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("src/流IO/file/打印流_11.txt");
        ps.println("hello");
        ps.print("world");
        ps.print("java");
        //记录日志：
        //改变System.out的输出方式
        System.setOut(ps);
        System.out.println();
        System.out.println("日志信息");
        ps.close();
    }
}
package 异常;
/**
 * @author Frank
 * @date 2024/10/15/10:42
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
throw + 异常类型
    一旦方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，
    此对象满足throws后异常类型时，就会被抛出。异常代码后的代码将不会执行。
 */

public class throw_03 {
    public static void main(String[] args) {
        try {
            meth2();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Over!");
        }
    }

    //编译时异常，添加throws 异常类型可通过编译
    public static void meth1() throws FileNotFoundException, IOException, FileNotFoundException {
        File file = new File("hello.txt");
        //未处理 异常: java.io.FileNotFoundException
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }

    //IOException   为父类
    public static void meth2() throws IOException {
        meth1();
    }

}
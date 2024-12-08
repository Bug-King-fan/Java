package 异常;

import java.util.Scanner;

/**
 * @author Frank
 * @date 2024/10/15/10:29
 */
/*
异常：Error（系统及别错误） Exception（运行时异常、编译时异常）
1、异常体系结构
    java.lang.Throwable
        ---java.lang.Error---
        ---java.lang.Exception---
           ---编译时异常（checked）
              ---IOException
                 ---FileNotFoundException
              ---ClassNotFoundException
           ---运行时异常（unchecked）
              ---NullPointerException
              ---ArrayIndexOutOfBoundsException
              ---ClassCastException
              ---NumberFormatException
              ---InputMismatchException
              ---ArithmeticException
 */

public class 异常_01 {
    public static void main(String[] args) {

    }
    //以下是编译时异常
//    public void test7() {
//        File file = new File("hello.txt");
//        //未处理 异常: java.io.FileNotFoundException
//        FileInputStream fis = new FileInputStream(file);
//        int data = fis.read();
//        while (data != -1) {
//            System.out.println((char) data);
//            data=fis.read();
//        }
//        fis.close();
//    }


    //以下是运行时异常
    //NullPointerException
    public void test1() {
        int[] arr = null;
        System.out.println(arr[3]);
    }

    //ArrayIndexOutOfBoundsException
    public void test2() {
        int[] arr = new int[10];
        System.out.println(arr[11]);
    }

    //ClassCastException
    public void test3() {
        Object str = new Date();
        String s2 = (String) str;
    }

    //NumberFormatException
    public void test4() {
        String s = "123abc";
        int num = Integer.parseInt(s);
    }

    //InputMismatchException
    public void test5() {
        Scanner cin = new Scanner(System.in);
        int score = cin.nextInt();
        //cin >> abc;
    }

    //ArithmeticException
    public void test6() {
        int a = 5;
        int b = 0;
        System.out.println(a / b);
    }
}

class Date {
}

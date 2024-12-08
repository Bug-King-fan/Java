package 异常;

/**
 * @author Frank
 * @date 2024/10/15/10:45
 */
/*
在最外层抛异常！！！main 其他方法throws
自定义异常：(方法内部使用)
    运行时异常：
        1、定义一个异常类继承RuntimeException
        2、重写构造器
        3、通过throw new 自定义异常类("xxxxx")来创建异常对象并抛出。
        注意：编译阶段不报错，提醒不强烈，运行时才可能出现！！！
    编译时异常：
        1、定义一个异常类继承Exception
        2、重写构造器
        3、通过throw new 自定义异常类("xxxxx")来创建异常对象并抛出。
        注意：编译阶段就报错，且方法上必须用throws声明！！！
方法重写规则：
        子类重写的方法抛出的异常类型(小于等于)父类被重写的方法所抛出的异常类型

 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class 自定义异常_04 {
    public static void main(String[] args) throws MyException2 {
        //方法1：
        if (true) {
            throw new MyException("自定义异常");
        }
        //方法2：
        try {
            throw new MyException("自定义异常");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("后续代码");
        System.out.println("-------------");
        //编译时异常
        menth();

    }

    private static void menth() throws MyException2 {
        throw new MyException2("编译时异常");
    }

    public void display(SuperClass2 s) {
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }

}

class SuperClass2 {
    public void method() throws IOException {

    }
}

class SubClass2 extends SuperClass2 {
    @Override
    public void method() throws FileNotFoundException, IOException {

    }
}

class MyException extends RuntimeException {
    public MyException(String msg) {
        super(msg);
    }
}

class MyException2 extends Exception {
    public MyException2(String msg) {
        super(msg);
    }
}
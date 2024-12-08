package 线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Frank
 * @date 2024/10/25/10:49
 */

/*
线程和main都是交替运行的

比较创建线程的两种方式：
开发中：优先选择：实现Runnable接口的方式
原因：1.实现的方式没有类的单继承性的局限性
     2.实现的方式更适合来处理多个线程有共享数据的情况
共享数据：多个线程共同操作同一个数据（变量或对象）的情况

联系：public class Thread implements Runnable
相同点：两种方式都需要重写run()，将线程要执行的逻辑声明在run()中
 */

/*
创建对象：
    1. 继承Thread类
        重写run()方法
    2. 实现Runnable接口:
        重写run()方法，把实现了Runnable接口的类作为参数传递给Thread类的构造器，并调用start()方法启动线程。
    3. 实现Callable<T> 接口   必须使用线程池使用
        任务处理步骤：
            1、创建线程池
            2、实现Callable<T>接口任务, 重写call()方法
            3、创建Callable任务对象
            4、调用线程池submit方法提交任务
                <T> Future<T> submit(Callable<T> task) 提交Callable任务给线程池
            5、通过get方法获取返回值
                Future 中 .get()  通过Future获取返回值
        重写call()方法，把实现了Callable接口的类作为参数传递给线程池的submit()方法，并调用get()方法获取返回值
        Future接口
            1.可以对Runnable和Callable任务的执行结果进行取消、查询是否完成、获取结果等
            2.FutureTask是Future接口的唯一实现类
            3.FutureTask同时实现了Runnable和Future接口，既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值

 */

public class 多线程入门_01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("Thread继承线程");
        myThread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }

        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();

        //Callable
        ExecutorService es = Executors.newFixedThreadPool(10);
        MyThread4 myThread4 = new MyThread4();
        Future<Integer> future = es.submit(myThread4);
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        es.shutdown();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

}

class MyThread4 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += Integer.valueOf(i);
        }
        return sum;
    }
}

package 线程;

import java.util.concurrent.*;

/**
 * @author Frank
 * @date 2024/10/25/18:46
 */

/*
问题引入：
    在高并发中，每个线程如果执行很短的任务就结束，频繁创建、销毁线程极大的消耗了系统资源，占用时间
    如果大量线程执行，设计上下文切换，会极大损耗CPU资源。
引入线程池：
    一个具有多个线程的容器，其中的线程看了一反复使用。
线程池使用大致流程：
    1、创建线程池，并指定线程开启数量。
    2、提交任务给线程，线程池中线程会获取任务、进行处理。
    3、任务完成后，不会销毁，而是返回线程池中，等待下一个任务执行。
    4、如果线程池中所以线程都被占用，提交的任务需要等待线程池中的线程。
线程池的体系结构：
java.util.concurrent.Executor：负责线程的使用与调度的根接口
    |--**ExecutorService 子接口：线程池的主要接口
        |--ThreadPoolExecutor 线程池的实现类
        |--
ScheduledExecutorService 子接口：负责线程的调度
            |--ScheduledThreadPoolExecutor：继承ThreadPoolExecutor，实现ScheduledExecutorService
工具类：Executors
ExecutorService Executor.newFixedThreadPool(n)：创建固定大小的线程池
ExecutorService Executor.newCachedThreadPool()：缓存线程池，线程池的数量不固定，可以根据需求自动更改数量
ExecutorService Executor.newSingleThreadExecutor()：创建单个线程池。线程池中只有一个线程
ExecutorService Executor.newScheduledThreadPool(n)：创建固定大小的线程，可以延迟或定时的执行任务

ExecutorService  真正的线程池接口。常见子类ThreadPoolExecutor
void execute(Runnable command)：执行任务/命令，没有返回值，一般用来执行Runnable
<T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般用来执行Callable
void shutdown()：关闭连接池
newSingleThreadExecutor()：创建单个线程池。线程池中只有一个线程
单个线程池，保证线程池中的线程是唯一的，用来保证任务按照指定顺序执行
ScheduledExecutorService newScheduledThreadPool()：创建固定大小的线程，可以延迟或定时的执行任务

好处：
    提高响应速度（减少了创建新线程的时间）
    降低资源消耗（重复利用线程池中线程，不需要每次都创建）
    便于线程管理

corePoolSize：核心池的大小
maximumPoolSize：最大线程数
keepAliveTime：线程没有任务时最多保持多长时间后会终止

创建线程方法四：线程池
 */

public class 线程池_06 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //ThreadPoolExecutor 是ExecutorService的实现类 通过强转可以调用ThreadPoolExecutor的方法
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service.execute(new NumberThread1()); // 适合适用于Runnable
        //service.submit(); // 适合使用于Callable
//        Future<Integer> fu = service.submit(Callable);
//        System.out.println(fu.get());
        service.execute(new NumberThread2());

        //设置线程池属性 ThreadPoolExecutor对象
        service1.setCorePoolSize(15);
        service1.setKeepAliveTime(1, TimeUnit.HOURS);
        service1.setMaximumPoolSize(20);
        service.shutdown(); // 关闭连接池
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
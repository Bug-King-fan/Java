package 线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Frank
 * @date 2024/10/25/11:35
 */

/*
java为了解决线程安全问题，提供了同步机制
同步：
    1、同步代码块
        synchronized(同步监视器[锁对象，可以是任意对象]){
            多条语句操作共享数据的代码
        }
    2、同步方法
        synchronized 修饰的方法会被同步，而且锁对象是方法的调用者
        例如：public synchronized void m(){}
        注意：1、同步代码块可以锁定指定代码；同步方法锁定整个方法所有代码
             2、同步代码块可以指定做对象  ；同步方法不能指定锁对象（但存在默认锁对象）
             3、对于非static方法，同步锁是this[当前对象锁]
             4、对于static方法，同步锁是类对象(类名.Class)
    3、同步锁(推荐使用) (jdk5后)
        [Lock是接口不能实例化，这里采用他的实例化类ReentrantLock来实例化]
        lock() 获取锁
        unlock() 释放锁
            Lock与synchronized的区别：
                1.Lock是一个接口，synchronized是Java中的关键字
                2.Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一直等待下去
                3.Lock可以判断锁的状态，synchronized不行
                4.Lock有多个条件锁，synchronized只有一个
                5.Lock支持公平锁和非公平锁，synchronized只支持非公平锁
                6.Lock是代码级别的锁，synchronized是JVM级别的锁
 */

public class 线程同步_03 {
    public static void main(String[] args) {
        int flag = 3;
        if (flag == 1) {
            SellTickets sell = new SellTickets();
            Thread t1 = new Thread(sell, "窗口1");
            Thread t2 = new Thread(sell, "窗口2");
            Thread t3 = new Thread(sell, "窗口3");
            t1.start();
            t2.start();
            t3.start();
        } else if (flag == 2) {
            SellTickets2 sell = new SellTickets2();
            Thread t1 = new Thread(sell, "窗口1");
            Thread t2 = new Thread(sell, "窗口2");
            Thread t3 = new Thread(sell, "窗口3");
            t1.start();
            t2.start();
            t3.start();
        } else {
            SellTickets3 sell = new SellTickets3();
            Thread t1 = new Thread(sell, "窗口1");
            Thread t2 = new Thread(sell, "窗口2");
            Thread t3 = new Thread(sell, "窗口3");
            t1.start();
            t2.start();
            t3.start();
        }
    }
}

//同步代码块处理：
class SellTickets implements Runnable {
    private static int tickets = 1000;
    //锁对象是任意的
    final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (tickets <= 0) {
                    break;
                }
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "出售了" + tickets + "号票");
                    tickets--;
                }
            }
        }
    }
}

//同步方法处理：
class SellTickets2 implements Runnable {
    private static int tickets = 1000;

    private static synchronized void mod2() {
        if (tickets > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出售了" + tickets + "号票");
            tickets--;
        }
    }

    @Override
    public void run() {
        while (true) {
            if (tickets <= 0) {
                break;
            }
            mod();
        }
    }

    private synchronized void mod() {
        if (tickets > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出售了" + tickets + "号票");
            tickets--;
        }
    }
}

//锁处理：
class SellTickets3 implements Runnable {
    private static int tickets = 1000;

    Lock l = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            l.lock();
            if (tickets <= 0) {
                break;
            }
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售了" + tickets + "号票");
                tickets--;
            }
            l.unlock();
        }
    }
}
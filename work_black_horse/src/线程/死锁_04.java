package 线程;

/**
 * @author Frank
 * @date 2024/10/25/12:33
 */
/*
当两个西安城对两个不同的锁对象具有循环依赖时，大概率出现死锁。
如何避免：
    不适用锁的嵌套
线程一：
{
    synchronized(A){
        synchronized(B){
        }
    }
 }
 线程二：
 {
    synchronized(B){
        synchronized(A){
        }
    }
 }
 */

public class 死锁_04 {
    public static void main(String[] args) {
        String A = "筷子A";
        String B = "筷子B";
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (A) {
                        System.out.println("拿到了A，等待B...");
                        synchronized (B) {
                            System.out.println("拿到了B,开吃...");
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "小黑").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (B) {
                        System.out.println("拿到了B，等待A...");
                        synchronized (A) {
                            System.out.println("拿到了A,开吃...");
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "小白").start();
    }
}

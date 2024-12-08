package 线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Frank
 * @date 2024/10/25/12:44
 */

/*
线程的状态：
    java.lang.Thread.State中枚举了六种：
        NEW 新建状态
        RUNNABLE 运行状态
        BLOCKED 阻塞状态
        WAITING 等待状态
        TIMED_WAITING 延时等待状态
        TERMINATED 终止状态

 */
/*
线程通信例子：使用两个线程打印1-100.线程1，线程2交替打印
sleep() wait() yield()区别
sleep()方法：
    1.是Thread类中的方法
    2.可以使得调用该方法的线程进入阻塞状态
    3.时间一到，线程进入就绪状态
    4.抛出InterruptedException异常
    5.不会释放同步监视器

wait()方法：      //无限等待，不会自动唤醒等待主动唤醒
wait(long time)  //有限等待，时间到达自动唤醒
    1.是Object类中的方法
    2.可以使得调用该方法的线程进入阻塞状态
    3.必须使用在同步代码块或同步方法中
    4.释放同步监视器

yield()方法： // 使得当前线程让出CPU，但是让出的时间不确定
    1.是Thread类中的方法
    2.可以使得调用该方法的线程进入就绪状态
    3.时间一到，线程进入就绪状态
    4.不会释放同步监视器

notify()方法： //唤醒任一个线程
    1.是Object类中的方法
    2.唤醒一个线程
    3.必须使用在同步代码块或同步方法中
    4.释放同步监视器

notifyAll()方法：
    1.是Object类中的方法
    2.唤醒所有线程
    3.必须使用在同步代码块或同步方法中
    4.释放同步监视器

说明：
1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中
2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
否则会出现IllegalMonitorStateException异常

sleep()方法和wait()方法的异同：
1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
2.不同点：1)两个方法声明的位置不同：Thread类中声明sleep()方法，Object类中声明wait()方法
         2)调用的要求不同：sleep()方法可以在任何需要的场景下调用，wait()方法必须使用在同步代码块或同步方法中
         3)对于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()方法不会释放锁，wait()方法会释放锁

注意使用细节：
    等待和唤醒方法，都必须使用锁对象调用
    等待和唤醒方法，应使用相同的锁对象调用
    必须放在synchronized代码块或者synchronized方法中，使用锁调用。

 */

public class 线程的状态_05 {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number, "线程1");
        Thread thread2 = new Thread(number, "线程2");
        Thread thread3 = new Thread(number, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                this.notify(); // 唤醒一个线程
                //notifyAll(); // 唤醒所有线程

                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        this.wait();
                        //wait会释放锁，而sleep不会释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

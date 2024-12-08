package 线程;

/**
 * @author Frank
 * @date 2024/10/25/11:14
 */

/*
方法：
    1、start()：启动当前线程；调用当前线程的run()
    2、run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
    3、currentThread()：静态方法，返回执行当前代码的线程
    4、getName()：获取当前线程的名字
    5、setName()：设置当前线程的名字
    6、yield()：释放当前cpu的执行权
    7、join()：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
    8、stop()：已过时。当执行此方法时，强制结束当前线程
    9、sleep(long milli_time)：让当前线程“睡眠”指定的milli_time毫秒。在指定的milli_time毫秒时间内，当前线程是阻塞状态
    10、isAlive()：判断当前线程是否存活
    11、线程的优先级：
        MAX_PRIORITY：10
        MIN_PRIORITY：1
        NORM_PRIORITY：5
        getPriority()：获取线程的优先级
        setPriority(int p)：设置线程的优先级
说明：高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下被执行

 */

public class Thread方法_02 {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        //设置线程名方法一
        t1.setName("线程一");
        //设置线程优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        //设置线程名方法二
        MyThread3 t2 = new MyThread3("线程二");
        t2.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + " " + i);
            }
            if (i == 20) {
                try {
                    //加载线程直到该线程执行完毕
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread3 extends Thread {
    public MyThread3(String name) {
        super(name);
    }

    public MyThread3() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + " " + i);
            }
            if (i == 20) {
                try {
                    //设置线程休眠
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (i % 20 == 0) {
                //释放当前cpu的执行权
                Thread.yield();
            }

        }
    }
}
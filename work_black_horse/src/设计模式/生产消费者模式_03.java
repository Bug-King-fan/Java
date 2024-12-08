package 设计模式;

/**
 * @author Frank
 * @date 2024/10/25/18:11
 */

/*
情景：
    消费者：
        1、判断桌子是否有汉堡
        2、如果没有就等待
        3、如果有就开吃
        4、吃完之后叫醒等待生产者，汉堡总数减 1
    生产者：
        1、判断桌子是否有汉堡
        2、如果有就等待
        3、如果没有就生产
        4、叫醒消费者开吃
 */

public class 生产消费者模式_03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Consume(), "消费者");
        Thread t2 = new Thread(new Produce(), "生产者");
        t1.start();
        t2.start();
    }
}

class Hamburger {
    public static final Object lock = new Object();
    public static int number = 0;
}

class Produce implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Hamburger.lock) {
                if (Hamburger.number == 0) {
                    System.out.println(Thread.currentThread().getName() + "：没有食物，生产中...");
                    Hamburger.number = 1;
                    Hamburger.lock.notify();
                } else {
                    System.out.println(Thread.currentThread().getName() + ":还有食物，可以摸鱼...");
                    try {
                        Hamburger.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consume implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Hamburger.lock) {
                if (Hamburger.number == 0) {
                    System.out.println(Thread.currentThread().getName() + ":没有汉堡等待ing...");
                    try {
                        Hamburger.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ":开吃...");
                    Hamburger.number--;
                    Hamburger.lock.notify();
                }
            }
        }
    }
}


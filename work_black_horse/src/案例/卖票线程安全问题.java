package 案例;

/**
 * @author Frank
 * @date 2024/10/25/11:38
 */

/*
出现了线程安全问题：0、-1号票，同时售卖重复票
 */

public class 卖票线程安全问题 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SellTickets(), "窗口1");
        Thread t2 = new Thread(new SellTickets(), "窗口2");
        Thread t3 = new Thread(new SellTickets(), "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTickets implements Runnable {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售了" + tickets-- + "号票");
            }else{
                break;
            }
        }
    }
}
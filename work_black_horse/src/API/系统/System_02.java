package API.系统;

/**
 * @author Frank
 * @date 2024/10/08/18:51
 */

//只学两个 exit() 退出Java虚拟机  currentTimeMillis() 返回系统毫秒值 nanoTime() 返回系统纳秒值
public class System_02 {
    public static void main(String[] args) {
        //指从1970年1月1日00:00:00到现在的毫秒值 1s=1000ms
        System.out.println(System.currentTimeMillis());
//        System.exit(0);
//        System.out.println("Hello World!");
        //测试代码性能  最优2s内反馈
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间: " + (endTime - startTime) + "ms");
    }
}
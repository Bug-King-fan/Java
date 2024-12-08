package API.系统;

import java.io.IOException;

/**
 * @author Frank
 * @date 2024/10/08/18:59
 */
/*
(1) getRuntime()：该方法用于返回当前应用程序的运行环境对象。
(2) Process exec(String command)：该方法用于根据指定的路径执行对应的可执行文件。
(3) long freeMemory()：该方法用于返回Java虚拟机中的空闲内存量，以字节为单位。
(4) long maxMemory()：该方法用于返回Java虚拟机试图使用的最大内存量。
(5) long totalMemory()：该方法用于返回Java虚拟机中的内存总量。
(6) exit(status)：该方法用于终止当前应用程序。
(7) long availMemory()：该方法用于返回Java虚拟机试图使用的可用内存量。
(8) int avalableProcessors()：该方法用于返回Java虚拟机可用的处理器数。
 */
public class RunTime_01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("E:\\微信\\WeChat\\WeChat.exe");
        Thread.sleep(3000);
        long freeMemory = runtime.freeMemory();
        System.out.println("Java虚拟机中的空闲内存量:" + freeMemory / 1024 / 1024 + "MB");
        long maxMemory = runtime.maxMemory();
        System.out.println("Java 虚拟机试图使用的最大内存量:" + maxMemory / 1024 / 1024 + "MB");
        long totalMemory = runtime.totalMemory();
        System.out.println("Java虚拟机中的内存总量:" + totalMemory / 1024 / 1024 + "MB");
        int i = runtime.availableProcessors();
        System.out.println("Java虚拟机可用的处理器数:" + i);
        process.destroy();
    }
}
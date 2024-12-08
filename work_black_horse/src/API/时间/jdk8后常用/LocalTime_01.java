package API.时间.jdk8后常用;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Frank
 * @date 2024/10/13/15:21
 */
public class LocalTime_01 {
    public static void main(String[] args) {
        LocalTime lt = LocalTime.now();
        System.out.println(lt);
        LocalTime of = LocalTime.of(10, 59, 59);
        System.out.println(of);
        System.out.println(lt.getHour());//9 获取当前时间的小时
        System.out.println(lt.getMinute());//51 获取当前时间的分钟
        System.out.println(lt.getSecond());//11 获取当前时间的秒
        //格式化
        LocalTime getTime = LocalTime.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("HH-mm-ss");
        System.out.println(getTime.format(f1));//16-27-08
    }
}
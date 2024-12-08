package API.时间.jdk8后常用;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author Frank
 * @date 2024/10/13/15:22
 */
/*
* LocalDateTime中parse方法:static LocalDateTime parse(String text, DateTimeFormatter formatter)
 */

public class LocalDateTime_03 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime lof = LocalDateTime.of(2024, 10, 10, 10, 9, 59);
        System.out.println(lof);
        System.out.println(ldt.getYear());//2021 获取当前年份
        System.out.println(ldt.getMonth().getValue());//4 获取当前月
        System.out.println(ldt.getDayOfMonth());//6 获取当前日
        System.out.println(ldt.getHour());//9 获取当前时
        System.out.println(ldt.getMinute());//51 获取当前分
        System.out.println(ldt.getSecond());//11 获取当前秒
        System.out.println(ldt.getDayOfYear());//96 今天是今年的第几天
        System.out.println(ldt.getDayOfWeek().getValue());//2 今天是星期几
        //格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH");
        System.out.println(localDateTime.format(f2));//2021.04.06-10:04
        //解析时间String->LocalDateTime
        String str = "2021.04.06-10:04";
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm");
        LocalDateTime ldt2 = LocalDateTime.parse(str, f1);
        System.out.println(ldt2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //设置时区
        LocalDateTime ldy = LocalDateTime.now();
        OffsetDateTime date =ldy.atOffset(ZoneOffset.ofHours(+8));
        System.out.println(date.toString());//2021-04-06T10:55:09.599+08:00
    }
}
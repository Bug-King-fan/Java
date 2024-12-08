package API.时间.jdk8后常用;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Frank
 * @date 2024/10/13/15:10
 */
/*
使用静态方法now()获取当前系统时间
使用静态方法of()获取指定时间对象
DateTimeFormatter 格式化时间 静态方法ofPattern()返回格式化的DateTimeFormatter对象
再用LocalDate类对象的format(DateTimeFormatter对象)方法输出
日期操作 会返回新的对象
   withYear()  withMonth()  withDayOfMonth() withDayOfYear() 直接修改某个信息，返回新日期对象
   plusYears()  plusMonths()  plusDays()  plusWeeks()  plusHours()  plusMinutes()  plusSeconds()  plusNanos() 把某个信息增加多少
   minusYears()  minusMonths()  minusDays()  minusWeeks()  minusHours()  minusMinutes()  minusSeconds()  minusNanos() 把某个信息减少多少
   equals() isBefore() isAfter() 判断是否相等，相等返回true，否则返回false


 */
public class LocalDate_01 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        LocalDate of = LocalDate.of(2024, 10, 10);
        System.out.println(of);
        System.out.println(ld.getYear());
        System.out.println(ld.getMonthValue());
        System.out.println(ld.getDayOfMonth());
        System.out.println(ld.getDayOfWeek().getValue());//getValue转化为数字
        //格式化
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(localDate.format(f1));
        //修改
        LocalDate ld2 = ld.withYear(2015);
        System.out.println(ld2);
        //日期操作
        LocalDate ld3 = ld.plusYears(1);
        System.out.println(ld3);
        LocalDate ld4 = ld.minusMonths(1);
        System.out.println(ld4);
        //判断
        if (ld3.equals(ld4)) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
        if (ld3.isBefore(ld4)) {
            System.out.println("ld3在ld4之前");
        } else {
            System.out.println("ld3在ld4之后");
        }

    }
}
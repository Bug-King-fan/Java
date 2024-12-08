package API.时间.jdk8后常用;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Frank
 * @date 2024/10/13/17:19
 */
public class 三者间转化_04 {
    public static void main(String[] args) {
        //LocalDateTime转换为LocalDate、LocalTime
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = ldt.toLocalDate();
        LocalTime lt = ldt.toLocalTime();
        System.out.println(ld);
        System.out.println(lt);
        //LocalDate、LocalTime合并位LocalDateTime
        LocalDateTime ldt2 = LocalDateTime.of(ld.withYear(2021), lt);

        System.out.println(ldt2);
    }
}
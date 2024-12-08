package API.时间.jdk8前;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Frank
 * @date 2024/10/12/10:48
 */
/*
y 年
M 月
d 日
H 时
m 分
s 秒
E 星期几
a 上午/下午
如 yyyy年MM月dd日 HH:mm:ss E
构造：
    SimpleDateFormat_10(String 格式)
方法：
    format(Date date) 将日期转换为字符串日期
    format(long time) 将毫秒值转换为日期
    parse(String str) 将字符串日期转换为Date类
    da.after(da2)
    da.before(da2)
 */

public class SimpleDtaeFormat_02 {
    public static void main(String[] args) throws ParseException {
        String str = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E").format(new Date().getTime());
        System.out.println(str);

        Date str1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E").parse("2024年10月10日 10:10:10 星期三");
        System.out.println(str1);
    }
}






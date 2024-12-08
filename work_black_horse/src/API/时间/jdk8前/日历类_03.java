package API.时间.jdk8前;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Frank
 * @date 2024/10/12/11:30
 */

/*
public static Calendar getInstance() 获取当前日历对象
public int get(int field) 获取日历中某个字段信息
public void set(int field, int value) 设置日历中某个字段信息
public void add(int field, int amount) 增加/减少日历中某个字段信息
public final Date getTime() 获取日历对象
public long getTimeInMillis() 获取时间毫秒值
public final void setTime(Date date) 设置日历对象
注意：
    日历类中月是从0开始
 */

public class 日历类_03 {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);

        //getTime()
        Date date = calendar.getTime();
        System.out.println(date);

        //getTimeInMillis()
        //获取时间毫秒值方法：System.currentTimeMillis() date.getTime()
        long time = calendar.getTimeInMillis();
        System.out.println(time);

        //set(int field, int value) 设置日历中某个字段信息
        calendar.set(Calendar.YEAR, 2015);
        System.out.println(calendar.getTime());

        //add(int field, int amount) 增加/减少日历中某个字段信息
        calendar.add(Calendar.YEAR, 1);
        System.out.println(calendar.getTime());

        //例将2023年9月10日加一个月
        String s="2023年09月10日";
        Date d1=new SimpleDateFormat("yyyy年MM月dd日").parse(s);
        calendar.setTime(d1);
        calendar.add(Calendar.MONTH, 1);
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime()));
    }
}
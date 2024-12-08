package API.时间.jdk8前;

import java.util.Date;

/**
 * @author Frank
 * @date 2024/10/12/10:39
 */
public class Data_01 {
    public static void main(String[] args) {
        //获取当前系统时间
        Date da = new Date();
        System.out.println(da);
        //将毫秒值转换为日期 CST时区
        Date da1 = new Date(0);
        System.out.println(da1);
        //类中常用方法
        //获取当前系统时间的毫秒值
        long time = da.getTime();
        System.out.println(time);
        //将da代表的时间，修改为指定毫秒值对应的时间
        da.setTime(1000);
        System.out.println(da);
    }
}
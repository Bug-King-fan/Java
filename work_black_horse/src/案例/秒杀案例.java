package 案例;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Frank
 * @date 2024/10/12/11:04
 */
public class 秒杀案例 {
    public static void main(String[] args) throws ParseException {
        //秒杀开始时间
        String startTime = "2024-10-12 00:00:00";
        String endTime = "2024-10-12 00:10:00";
        //下单时间
        String person1 = "2024-10-12 00:01:39";
        String person2 = "2024-10-12 00:10:01";
        //判断
        Date d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        Date d3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(person1);
        Date d4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(person2);
        isOK(d1, d2, d3);
        isOK(d1, d2, d4);
    }
     public static void isOK(Date startTime, Date endTime, Date person){
        if (person.after(startTime) && person.before(endTime)) {
            System.out.println("秒杀成功");
        } else {
            System.out.println("秒杀失败");
        }
    }
}

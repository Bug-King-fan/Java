package Advanced.面向对象;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Frank
 * @date 2024/09/18/17:41
 */

//类名调用static函数，调用方便，节约内存！
public class 验证码_02 {
    private static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        String code = CodeUtils.createCode(5);
        System.out.println("请输入验证码：" + code);
        String co = cin.next();
        if (co.equalsIgnoreCase(code)) {
            System.out.println("验证码正确");
        } else {
            System.out.println("验证码错误");
        }
    }
}

class CodeUtils {

    //构造函数私有化，避免外部直接创建对象，静态函数避免创建对象，从而造成的内存浪费
    private CodeUtils() {
    }

    public static String createCode(int n) {
        String code = "";
        String str = "a2678b67cde3350871336ij346klm571qrs4tu325dsx1yzAB4CD0EF3GH88IJ8K2LM46NO4PQ25RST5U345VWX3YZ0123456789";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(str.length());
            code = code + str.charAt(index);
        }
        return code;
    }
}

package Advanced.面向对象;

import java.util.Objects;

/**
 * @author Frank
 * @date 2024/09/29/11:13
 */
public class Objects类_14 {
    public static void main(String[] args) {
        //Objects类的equals方法，可以有效防止空指针异常
        //Objects类的isnull方法、notnull方法 返回boolean
        //String的equals方法，在遇见null的时候会返回异常
        String s1 = "abc";
        String s2 = null;
        //异常，必须是 null.equals()才会抛
//        System.out.println(s2.equals(s1));
        System.out.println(Objects.equals(s1, s2));
        System.out.println(Objects.isNull(s2));
        System.out.println(Objects.nonNull(s2));

    }
}
package 基础;

/**
 * @author Frank
 * @date 2024/09/15/16:54
 */
public class 类型转化_04 {
    public static void main(String[] args) {
        //自动类型转化
        //(byte,short,char) -> int -> long -> float -> double
        byte a = 12;
        int b = a;
        System.out.println(b);
        //强制类型转化 慎用或不用！！！！可能会超出范围
        byte f = 3;
        int c = 12;
        byte d = (byte) (c + f);
        System.out.println(d);

        f = 127;
        c = 4;
        d = (byte) (c + f);
        System.out.println(d);
    }
}
package API.字符串;

import java.util.StringJoiner;

/**
 * @author Frank
 * @date 2024/10/08/18:23
 */

/*
    StringJoiner类用来进行字符串拼接处理，其可以在初始化的时候指定分隔符和前缀后缀；
属性:
    prefix：拼接后的字符串前缀
    delimiter：拼接时的字符串分隔符
    suffix：拼接后的字符串后缀
    value：拼接后的值
    emptyValue：空值的情况，value为null时返回
方法:
    setEmptyValue()：设置空值
    toString()：转换成String
    add()：添加字符串
    merge():从另一个StringJoiner合并
    length()：长度（包括前后缀）

 */
public class StringJoiner_02 {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("-");
        sj.add("hello");
        sj.add("world");
        System.out.println(sj.toString());
        //加前后缀
        StringJoiner sj2 = new StringJoiner("-", "[", "]");
        sj2.add("java");
        sj2.add("cpp");
        System.out.println(sj2.toString());
        //长度
        System.out.println(sj2.length());
        //拼接两StringJoiner
        sj.merge(sj2);
        System.out.println(sj.toString());
        //设置空值
        StringJoiner stringJoiner3=new StringJoiner("*");
        stringJoiner3.setEmptyValue("123456");
        System.out.println(stringJoiner3.length());//6
        System.out.println(stringJoiner3);//123456
    }
}
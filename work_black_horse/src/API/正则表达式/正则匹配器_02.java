package API.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Frank
 * @date 2024/10/13/18:37
 */

/*
Matcher:
    find() 匹配数据，如果匹配到一个内容就返回true
    group() 获取匹配到的内容
    group(int group) 获取指定索引[即第几个括号的部分]分组的匹配内容  : ([a-z]{2,}) @ (\\w{2,}) ((\\.[a-z]{2,7}){1,2})
Pattern:
    Pattern.compile(regex).matcher(data);
    compiled 指定匹配规则
    matcher 匹配数据
String字符串替换、切割：
    replaceAll(String regex, String replacement)
    String[] split(String regex)
 */

public class 正则匹配器_02 {
    public static void main(String[] args) {
        String data = "来黑马程序员学Java,\n" +
                "电话:18666666666,18677777777" +
                "来电邮箱:1866666666@qq.com" +
                "座机电话:010-88888888，010-99999999" +
                "来电邮箱:18777777@qq.com";
        String regex = "([0-9]{3,4}-)?[0-9]{7,8}";

        Matcher matcher = Pattern.compile(regex).matcher(data);
        while (matcher.find()) {
            String s = matcher.group();
            System.out.println(s);

        }

        String s1="古力娜扎3253246按时吃饭2354aa33蚂蚱黑";
        String s2=s1.replaceAll("\\w+","-");
        System.out.println(s2);
        String[] s3=s1.split("\\w+");
        System.out.println(s3.length);
        for (var s : s3) {
            System.out.println(s);
        }
    }
}
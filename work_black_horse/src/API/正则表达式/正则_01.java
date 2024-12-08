package API.正则表达式;

/**
 * @author Frank
 * @date 2024/10/13/17:33
 */
/*
检查qq号是否符合规则：
    不能以0开头 String中startsWith(String prefix)检测是否以此为前缀
    长度为6-20位
    必须全部是数字
正则：
    String中提供了matches(String regex)方法，用于检测字符串是否与给定的正则表达式匹配
    规则：
        字符类：[] 匹配中括号内的任意"单个字符"
             [abc] 只能是 a 或 b 或 c
             [^abc] 除了 a b c 以外的所有字符
             [a-zA-Z] 匹配所有大小写字母
             [a-d|m-p] 匹配 a-d 或者 m-p
             [a-z&&[^bc]] a-z 中除了 b c 以外的所有字符
             [a-z&&[^m-p]] a-z 中除了 m-p 以外的所有字符
        数量词：
             X?      X匹配0次或者1次
             X*      X匹配0次或者多次
             X+      X匹配1次或者多次
             X{n}    X匹配出现n次
             X{n,}   X匹配出现n次或者多次
             X{n,m}  X匹配出现n次到m次
        预定义字符类： 只匹配"单个字符"
                .    匹配任何字符
                \d   匹配任何数字 [0-9]
                \D   匹配任何非数字 [^0-9]
                \w   匹配任何字母或数字 [a-zA-Z0-9]
                \W   匹配任何非字母或数字 [^a-zA-Z0-9]
                \s   匹配任何空白字符 [\s]
                \S   匹配任何非空白字符 [^\s]
        其他常用符号：
                (?i)  忽略大小写 对其后面的忽略，若对单个字符，需要再用括号括起来
                ()    分组

 */


public class 正则_01 {
    public static void main(String[] args) {
        if (check("123456")) {
            System.out.println("符合规则");
        } else {
            System.out.println("不符合规则");
        }
        if (check2("0123456")) {
            System.out.println("符合规则");
        } else {
            System.out.println("不符合规则");
        }
        //正则
        System.out.println("e".matches("[a-c|f-z]"));
        System.out.println("a123".matches("\\w*"));
        System.out.println("abc".matches("(?i)abc"));
        System.out.println("Abc".matches("(?i)abc"));
        //忽略作用于bc忽略大小写
        System.out.println("abC".matches("a(?i)bc"));
        //仅有b忽略大小写
        System.out.println("abC".matches("a((?i))bc"));
        System.out.println("Ayq".matches("((?i)[a-z]{3})|\\d{3}"));
        //必须以“我爱”开头，中间至少出现一次编程，编程后面必须有一次“666”
        System.out.println("我爱编程编程666666".matches("我爱(编程)+(666)+"));
    }

    public static boolean check(String s) {
        if (s == null || s.startsWith("0") || s.length() < 6 || s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean check2(String s) {
        return s.matches("[1-9]\\d{5,19}");
    }

    public static void checkPhone(String phone) {
        if (phone.matches("1[3-9]\\d{9}")) {
            System.out.println("手机号格式正确");
        } else {
            System.out.println("手机号格式不正确");
        }
    }

    public static void checkEmail(String email) {
        if (email.matches("\\w{2}@\\w{2,10}(\\.[a-zA-z]){1,2}")) {
            System.out.println("邮箱格式正确");
        } else {
            System.out.println("邮箱格式不正确");
        }
    }
}
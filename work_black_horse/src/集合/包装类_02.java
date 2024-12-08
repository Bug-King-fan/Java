package 集合;

/**
 * @author Frank
 * @date 2024/09/25/16:12
 */

/*
    基本类型        包装类
    byte     -      Byte
    short    -      Short
    int      -      Integer
    long     -      Long
    float    -      Float
    double   -      Double
    char     -      Character
    boolean  -      Boolean
可以解决:
    1、String类型和7种基本类型(除char--str.charAt(i))的转化 : "1234"-》(int) 1234
    2、再连接数据库时，包装类可以存放null数据
如何使用：
    1、包装类支持自动拆箱装箱。
注意：
    1、包装类有享元设计模式，常用的几个值直接从常量池获取（不会创建对象）
        处float、double外都有常量池：
            整数【-128,127】
            boolean [true,false]
            char [1,127]
 */

/*
    方法：
        1、valueOf方法 ：将基本类型转化为包装类
            Integer i = Integer.valueOf(x)
        2、parseXxxx方法：将字符串转化为基本类型
            int i = Integer.parseInt(x)
        3、toString方法：将基本类型转化为字符串
            String s = Integer.toString(x)
        4、xxxvalue方法：将包装类转化为基本类型
            int x = i.intValue()
    作用：
        能直接使用该类型最大最小值：
            Integer.MIN_VALUE
            Integer.MAX_VALUE
        能直接使用该类型最大最小值的方法
            Integer.min(x,y)
            Integer.max(x,y)
        能直接使用该类型的方法
            Integer.toBinaryString(x)
            Integer.toHexString(x)
            Integer.toOctalString(x)
        泛型只能使用引用数据类型
            ArrayList<Integer> list = new ArrayList<>();

 */


public class 包装类_02 {
    public static void main(String[] args) {
        //自动装箱,包装类可以为空，但相加时要注意空指针异常
        Integer a = 10;
        Integer c = null;
        if (a != null && c != null) {
            System.out.println(a + c);
        }
        int b = a;
        //数值转化字符串（2种）
        String str = a + "";
        String str1 = String.valueOf(a);
        System.out.println(str);
        System.out.println(str1);
        //字符串转数值 (类型.parseXxxx(x))
        String pi = "3.1415";
        double ans = Double.parseDouble(pi);
        //或包装类思想
        double te = Double.valueOf(pi);
        System.out.println("*********");
        Integer num1 = 10;
        Integer num2 = 10;
        System.out.println(num1.hashCode() + " " + num2.hashCode());

    }
}
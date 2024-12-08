package 基础;

/**
 * @author Frank
 * @date 2024/09/15/23:10
 */
/*
    算数运算符 + - * / % ++ --  (自增自减隐含了强制类型转化)
    赋值运算符 = += -= *= /= %=  如 a+=b 等价于 a=(a的类型)(a+b)
    比较运算符 == != > < >= <=  成立返回true，不成立返回false
    逻辑运算符 && || !   成立返回true，不成立返回false  (逻辑运算符的优先级高于比较运算符)!!
                        特别的 && || 都是短路运算，如果第一个条件不成立，第二个条件就不会运算
    三元运算符 判断?真:假   如gcd(a,b) return a==0?b:gcd(b,a%b)
    位运算符 & | ^ ~ << >> >>>(无符号右移)

 */

public class 运算符_05 {
    public static void main(String[] args) {
        int a = 11, b = 3;
        System.out.println(a + "" + b);
        int x = 10;
        int y = x++ + x;
        int z = x++ + y * --x + ++y / x--;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        byte d = 10;
        d++; //相当于  d=(byte)(d+1);
        //d = d + 1;  1 是int
        System.out.println(d);

        // +号 再输出语句中有连接符的意思  (没有字符串参与就是加号，有字符串，且在其两边的位置是连接符)
        //字符串做完链接后还是一个字符串
        int q = 10;
//        11
//        11abc
//        abcq1
//        194abc
        System.out.println(q + 1);
        System.out.println(q + 1 + "abc");
        System.out.println("abc" + 'q' + 1);
        //'a'是字符，中间加号做加法
        System.out.println('a' + 'a' + "abc");


    }
}
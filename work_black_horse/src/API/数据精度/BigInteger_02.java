package API.数据精度;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Frank
 * @date 2024/10/10/17:57
 */
/*
Java的BigInteger是一个用来表示任意长度的整数的类，可以表示整数的值范围从负无穷到正无穷。
    BigInteger底层存储方式BigInteger是通过int数组来存储大整数的。
    每个int元素都代表四个字节，即32位的二进制数。
    BigInteger中的int数组是按照从低位到高位的顺序存储的，
    也就是说，int数组的第一个元素存储了大整数的最低位，最后一个元素存储了大整数的最高位。
    因为这个原因，当我们进行加法、减法、乘法或除法等操作时，需要从低位向高位进行遍历计算。
    同时，因为int类型的最大值为2^31-1，
    所以BigInteger能够表示的最大整数位数就是2147483647 / 4 = 536870912位。
 */

/*
构造：
    public BigInteger(int num , Random rnd)   	获取随机大整数，范围：【0-2^num - 1】
    public BigInteger(String val)   	        获取指定的大整数
    public BigInteger(String val , int radix) 	获取指定进制的大整数
    public static BigInteger valueOf(long val) 	静态方法获取BigInteger的对象
方法:
    public BigInteger add(BigInteger val)         	加法
    public BigInteger subtract(BigInteger val) 	    减法
    public BigInteger multiply(BigInteger val)      乘法
    public BigInteger divide(BigInteger val)        除法，获取商
    public BigInteger[] divideAndRemainder(BigInteger val)    	除法，获取商和余数
    public booleanequals(Object x)               	比较是否相同
    public BigInteger pwo(int exponent)  	        次幂
    public BigInteger max/min(BigInteger val)	    返回较大值/较小值
    public int intValue(BigInteger val)            	转为int类型整数，超出范围数据有误

 */

public class BigInteger_02 {
    public static void main(String[] args) {
        //构造
        BigInteger b1 = new BigInteger(4, new Random());//0-15
        System.out.println(b1);
        // 获取一个指定的大整数
        BigInteger b2 = new BigInteger("2165465413216513165");
        System.out.println(b2);
        // 获取一个指定进制的大整数
        BigInteger b3 = new BigInteger("071", 8);  // 二进制
        BigInteger b4 = new BigInteger("100", 10); // 十进制
        System.out.println(b3 + "\n" + b4);
// 静态方法获取BigInteger的对象
//     1、能表示的范围较小，在long的取值范围之内
//     2、在内部对常用的数字（-16~16）进行了优化,提前把-16 ~ 16先创建号BigInteger的对象，如果多次获取不会重新创建新的
        BigInteger b5 = BigInteger.valueOf(1000L);
        System.out.println(b5);
    }
}
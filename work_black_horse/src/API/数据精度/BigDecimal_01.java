package API.数据精度;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Frank
 * @date 2024/10/09/16:03
 */

/*
方法：
    valueOf()：创建一个参数所指定的数值的对象
    add()：相加
    subtract()：相减
    multiply()：相乘
    divide(另一个BigDecimal对象)：相除
    divide(另一个BigDecimal对象,精确几位,舍入模式)：相除
        BigDecimal.ROUND_UP	保留n位小数，第(n+1)位数字大于0则进1
        BigDecimal.ROUND_DOWN	保留n位小数，后面的小数位直接舍弃
        BigDecimal.ROUND_CEILING	如果 BigDecimal 是正数则做 ROUND_UP 操作；负数则做 ROUND_DOWN 操作（取附近较大的数）
        BigDecimal.ROUND_FLOOR	如果 BigDecimal 是正数则做 ROUND_DOWN 操作；负数则做 ROUND_UP 操作（取附近较小的数）
        BigDecimal.ROUND_HALF_UP	四舍五入
        BigDecimal.ROUND_HALF_DOWN	同 ROUND_HALF_UP，区别仅在于第(n+1)位数字等于5且后面小数位全为0时会舍而不是入
        BigDecimal.ROUND_HALF_EVEN	四舍六入，五看前一位是偶数就舍，奇数就入
        BigDecimal.ROUND_UNNECESSARY	不保留n位小数，如果第(n+1)位起存在小数位且不为0就抛异常：java.lang.ArithmeticException
    remainder()：取余
    intValue()：取整数
    longValue()：取长整数
    floatValue()：取单精度
    doubleValue()：取双精度
    setScale(精度,舍入模式)：设置精度
    divideAndRemainder()：返回一个 BigDecimal 数组，返回数组中包含两个元素，第一个元素为两数相除的商，第二个元素为余数
    compareTo()：比较大小 1,0,-1
    equals()：比较相等 true，false
注意：
BigDecimal底层存储方式
    把数据看成字符串，遍历得到里面的每一个字符，把这些字符在ASCII码表上的值，都存储到数组中。
    例如：BigDecimal bd = new BigDecimal(0.01);
               [48 , 46 , 48 , 49]

 */

public class BigDecimal_01 {
    public static void main(String[] args) {
        // 创建一个参数所指定整数值的对象
        BigDecimal num = new BigDecimal(13);
        // 创建一个参数所指定双精度值的对象（不建议采用） 无法做到精确计算
        BigDecimal num2 = new BigDecimal(5.34);
        System.out.println(num2);
        // 使用类的静态方法valueOf()创建一个参数所指定的数值的对象
        // valueOf内部先将其转化为字符串(toString())，在进行转化
        BigDecimal num3=BigDecimal.valueOf(5.34);
        System.out.println(num3);
        // 创建一个参数所指定以字符串表示的数值的对象
        BigDecimal num4 = new BigDecimal("5");
        System.out.println(num4);
        //相加 add
        BigDecimal sum=num.add(num4);
        System.out.println(sum);
        //相减 subtract
        BigDecimal sub=num.subtract(num4);
        System.out.println(sub);
        //相乘 multiply
        BigDecimal mul=num.multiply(num4);
        System.out.println(mul);
        //相除 divide
        BigDecimal div=num.divide(num4);
        System.out.println(div);
        //相除 divide
        BigDecimal div2=num.divide(num4,2, RoundingMode.HALF_UP);
        System.out.println(div2);
        //取余 remainder
        BigDecimal rem=num.remainder(num4);
        System.out.println(rem);
        //取整数 intValue
        int val=num.intValue();
        System.out.println(val);
        //取长整数 longValue
        long val2=num.longValue();
        System.out.println(val2);
        //取单精度 floatValue
        float val3=num.floatValue();
        System.out.println(val3);
        //取双精度 doubleValue
        double val4=num.doubleValue();
        System.out.println("val4:"+val4);
        //设置精度 setScale
        BigDecimal val5=num.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(val5);
        //divideAndRemainder() 返回一个 BigDecimal 数组，返回数组中包含两个元素，第一个元素为两数相除的商，第二个元素为余数
        BigDecimal num6 = new BigDecimal(11);
        BigDecimal num7 = new BigDecimal(3);
        BigDecimal[] results = num6.divideAndRemainder(num7);
        System.out.println(results[0]); // 3
        System.out.println(results[1]); // 2


    }
}
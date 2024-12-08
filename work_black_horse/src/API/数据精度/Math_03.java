package API.数据精度;

/**
 * @author Frank
 * @date 2024/10/08/18:39
 */
public class Math_03 {
    public static void main(String[] args) {
        /* 静态常量 */
        // 常量E
        Object a = null;
        a = Math.E;
        System.out.println("E 常量的值: " + a);

        // 常量PI
        Object b = null;
        b = Math.PI;
        System.out.println("PI 常量的值: " + b);

        /* 三角函数 */
        // 角度 --> 弧度 toRadians()
        double x = 45; // 45°  45° -->  PI / 4
        System.out.println("45°转换为弧度：" + Math.toRadians(x));
        System.out.println(Math.PI / 4);

        double y = 180;
        System.out.println("180°转换为弧度：" + Math.toRadians(y));
        System.out.println(Math.PI);

        // 弧度 --> 角度 toDegrees()
        double z = 0.7853981633974483; // PI / 4 -->  45°
        System.out.println("0.7853981633974483转换为角度" + Math.toDegrees(z));

        // 正弦函数sin()
        double degrees = 45.0;
        double radians = Math.toRadians(degrees);
        System.out.println("45° 的正弦值: " + Math.sin(radians));

        // 余弦函数cos()
        System.out.println("45° 的余弦值: " + Math.cos(radians));

        // 反正弦值asin()
        System.out.println("45° 的反正弦值: " + Math.asin(radians));

        // 反余弦值acos()
        System.out.println("45° 的反余弦值: " + Math.acos(radians));

        // 正切值tan()
        System.out.println("45° 的正切值: " + Math.tan(radians));

        // 反正切值atan() atan2()
        double m = 45;
        double n = 30;
        System.out.println("45° 的反正切值1: " + Math.atan(radians)); // atan()
        System.out.println("反正弦值2: " + Math.atan2(m, n)); // atan2() 坐标系表示角的反正切值

        /* 指数函数 */
        double p = 8;
        double q = 3;

        // exp()
        System.out.println("e的8次幂: " + Math.exp(p)); // e^8

        // pow()
        System.out.println("8的3次幂: " + Math.pow(p, q)); // 8^3

        // sqrt()
        System.out.println("8的平方根: " + Math.sqrt(p));

        // cbrt()
        System.out.println("8的立方根: " + Math.cbrt(p)); // 2

        // log()
        System.out.println("ln(8): " + Math.log(p)); // ln(8)

        // log10()
        System.out.println("log10(8): " + Math.log10(p)); // log10(8)

        /* 取整 */
        double d = 100.675;
        double e = 100.500;

        // 上取整  ceil()
        System.out.println("ceil(100.675): " + Math.ceil(d));

        // 下取整  floor()
        System.out.println("floor(100.675): " + Math.floor(d));

        // 最近的整数  rint()
        System.out.println("rint(100.675): " + Math.rint(d));
        System.out.println("rint(100.500): " + Math.rint(e));

        // 四舍五入的整数  round()
        System.out.println("round(100.675): " + Math.round(d));
        System.out.println("round(100.500): " + Math.round(e));

        /* 其他 */
        // min() 最小
        System.out.println("min(): " + Math.min(2, 10));

        // max() 最大
        System.out.println("max(): " + Math.max(2, 10));

        // random() 返回一个随机数
        System.out.println("random(): " + Math.random());

        // abs() 绝对值
        System.out.println("abs(): " + Math.abs(-5));
    }
}

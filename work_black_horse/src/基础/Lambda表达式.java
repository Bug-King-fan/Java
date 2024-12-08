package 基础;

import java.util.Arrays;

interface A {
    void show();
}

interface S {
    void sum(int a, int b);
}

/**
 * @author Frank
 * @date 2024/10/14/17:56
 */
/*
Lambda规则：
    (被重写方法参数列表)->{被重写方法的方法体}
注意：lambda只能简化函数式接口（接口中有且仅有1个抽象方法的接口）的匿名内部类！！！
     lambda能简化方法体内只有一条语句的静态方法调用,且需前后参数一致 （如 a -> System.out.println(a); -> System.out::println）
     lambda能简化方法体内只有一条语句的实力方法调用,且需前后参数一致 Monster::show
     lambda能简化特定类型的方法引用，方法体内只有一行实例方法的调用，且前面参数列表中的第一个元素作为方法的主调
        后面的所有参数都是作为该实例方法的参数。 如：
                Arrays.sort(names,new .....(o1,o2) {return o1.compareToIgnoreCase(o2);})
                简化为：
                Arrays.sort(names,(o1,o2) -> o1.compareToIgnoreCase(o2));
省略：
    1、参数类型可是省略，当参数只有一个的时候()和参数类型都可以省略(如 a -> {println(a);})
    2、当方法体内只有一条语句的时候，{}和return、;号一起省略(如 a -> println(a))
 */
public class Lambda表达式 {
    public static void main(String[] args) {
        //简化代码
        Integer[] arr = {1, 9, 3, 7, 5};
        Arrays.sort(arr, (o1, o2) -> {
            return o1 - o2;
        });
        System.out.println(Arrays.toString(arr));

        //简化接口的实现
        A a = () -> {
            System.out.println("hello");
        };
        a.show();

        System.out.println("-------------------");

        //函数的参数列表内匿名对象的使用
        Sum((int c, int b) -> {
            System.out.println(c + b);
        });

        //定义函数
        // 使用 Lambda 表达式计算两个数的和
        MathOperation addition = (int n, int b) -> {
            return n + b;
        };
        int result = addition.operation(5, 3);
        System.out.println("5 + 3 = " + result);
    }

    public static void Sum(S s) {
        s.sum(10, 20);
    }

    interface MathOperation {
        int operation(int a, int b);
    }
}

package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/21/17:42
 */

/*
abstract  可以修饰类，方法(没有方法体，只有方法签名)
    注意：普通类不能定义抽象方法！
    抽象类特点:
        1、抽象类不能创建对象，只能子类继承它实现
        2、一个类继承抽象类，必须实现抽象类中的所有抽象方法，否则这个类也被定义为抽象类
 */

public class 抽象类_10 {
    public static void main(String[] args) {

    }
}

abstract class Demo {
    private static String schoolNmae;
    private String name;

    public Demo() {
        System.out.println("Demo");
    }

    public static void print2() {
        System.out.println("hello2");
    }

    public abstract void test();

    public void print() {
        System.out.println("hello");
    }

}


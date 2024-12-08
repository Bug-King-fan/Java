package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/20/11:20
 */
/*
构造器会先调用父类，后调用子类
    一旦自己声明了构造器，jvm不会给你提供默认的构造器
构造器可以调用本类、父类其他构造器
 */



public class 构造器_07 {
    public static void main(String[] args) {
        B1 b = new B1();
        System.out.println("*********");
        B1 b2 = new B1(1, 2);
    }
}

class A1 {
    public A1() {
        System.out.println("父类构造器A1");
    }

    public A1(int a) {
        //默认存在一行 super(); 即先调用父类空参构造
        System.out.println("子类构造器A1(int a)");
    }
}

class B1 extends A1 {
    public B1() {
        //默认存在一行 super(); 即先调用父类空参构造
        //代表调用父类有参构造
        super(1);

        System.out.println("子类构造器B1");
    }

    public B1(int a) {
        //默认存在一行 super(); 即先调用父类空参构造
        System.out.println("子类构造器B1(int a)");
    }

    public B1(int a, int b) {
        this(a, b, 10);
        //如果有其他操作，必须让调用其他构造器在最前面！！！
        //对this的调用必须是构造器中的第一个语句，且super()和this()不能同时出现在一个构造器内
        System.out.println("B1(int a,int b)");
    }

    public B1(int a, int b, int c) {
        System.out.println("子类构造器B1(" + a + "," + b + "," + c + ")");
    }

}

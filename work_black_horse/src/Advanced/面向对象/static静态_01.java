package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/16/15:17
 */
/*
    静态成员变量
        static修饰类成员变量时，在计算机里只有一份，全部类对象共享,也可以用类名直接调用，也可以用对象调用
    静态成员方法
        static修饰类方法时，可以用类名直接调用此方法 ：StaticInof.show(); 也可以对象调用
 */



public class static静态_01 {
    public static void main(String[] args) {
        StaticInof.show();
        StaticInof st = new StaticInof("张三");
        st.show();
        StaticInof.show();
    }
}

class StaticInof {

    //静态成员变量
    public static String name = "默认";

    public StaticInof(String name) {
        this.name = name;
    }


    //静态方法
    public static void show() {
        System.out.println(name);
    }

}

class StaticFact {
    //类变量
    public static String name;
    //实例变量
    public int age;

    //类方法
    public static void show() {
        System.out.println("static");
    }

    //1、类方法(static)可以直接访问类变量/方法，不可以访问实例变量/方法
    public static void test01() {
        System.out.println(name);
        show();
//        System.out.println(age);
//        mod();
    }

    public static void test04() {
//        System.out.println(this.name);
        show();
//        System.out.println(age);
//        mod();
    }

    //实例方法
    public void mod() {
        System.out.println("非static");
    }

    //2、实例方法(非static)可以直接访问实例变量/方法，也可以访问类变量/方法
    public void test02() {
        System.out.println(name);
        show();
        System.out.println(age);
        mod();
    }

    //实例方法(非static)可以出现this关键字，类方法不可以出现this关键字
    public void test03() {
        System.out.println(this.name);
        show();
        System.out.println(age);
        mod();
    }
}

class Stu {
    //静态代码块
    //类加载时自动运行，静态代码块只执行一次（初次加载类时）
    //作用：完成类的初始化
    static {
        System.out.println("static 666");
    }

    public String name;

    //成员代码块
    //每次创建对象时，就会执行实例代码块，并在构造器(构造方法)前执行！
    //作用：完成对象的初始化
    {
        System.out.println("666");
    }

    public Stu() {
        System.out.println("构造函数");
    }

    public Stu(String name) {
        this.name = name;
    }

}


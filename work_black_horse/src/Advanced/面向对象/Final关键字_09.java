package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/21/12:03
 */

/*
final 代表最终，可以修饰 (类(不能被继承)、方法(非构造方法)、变量(数值不可更改)、参数列表(常量不可更改))
常量： static final 修饰的成为常量  通常全大写，如果有多个单词用下划线隔开 ctrl+shift+u
 */

public class Final关键字_09 {
    static final double PI = 3.1415926;

    public static void main(String[] args) {
        int age = 18;
        setAge(age);

        // st指向地址前后发生变化
        Student st = new Student();
        st = new Student();

        // st指向地址不可更改  , 但是st1的属性值可以更改
        final Student st1 = new Student();
//      无法将值赋给 final 变量 'st1'
//        st1 = new Student();
    }


    static void setAge(final int age) {
//        无法将值赋给 final 变量 'age'
//        age = 20;
    }
}

final class A2 {

    public final String name = "必须有默认值";

    public A2() {

    }

    public A2(String name) {
//        无法将值赋给 final 变量 'name'
//        this.name = name;
    }

    //final修饰的方法不能被重写
    public final void mod() {

    }

}

//无法从final 'Advanced.面向对象.A2' 继承
//class B2 extends A2 {
//    public B2() {
//        super("必须有默认值");
//    }
//}

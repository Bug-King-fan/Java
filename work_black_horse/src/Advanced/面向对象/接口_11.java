package Advanced.面向对象;

interface A3 {
    public static final String NAME = "老六";
//    public String NAME = "老六";  两个等价，不写static final也默认拥有的
//    String NAME = "老六";    等价


    //接口中的成员方法都是抽象方法（jdk8前），默认都是public abstract修饰
    public abstract void show();

}

interface A4 {
    //jdk8以后新增default关键字,不用强制重写default修饰的方法
    public default void show3(){
        show4();
    }
    //jdk9后出现的
    private void show4(){
        System.out.println("show3()default内重复代码");
    }
    //静态方法
    static void show5(){
        System.out.println("static show5()");
    }


    public abstract void show2();

    public abstract void show();
}

//接口可以多继承
interface A5 extends A3, A4 {

}

/**
 * @author Frank
 * @date 2024/09/22/10:09
 */

//接口关键字：interface
//内部之定义两部分： 成员变量（全是常量,默认public static final修饰） 和 成员方法（抽象，默认public abstract 修饰）
/*
注意事项：
    1、接口不能创建对象
    2、子类实现用implements,且必须重写接口中的抽象方法
    3、接口可以多继承!!!(重名抽象方法，可以当成一个，只需实现一个)
接口的好处：
    1、弥补了类只能单继承的缺点，一个类可以实现多个接口
    2、程序面向接口编程，更加规范,更便于切换、添加业务
jdk8后新增接口特性：
    1、jdk8以后新增default关键字,不用强制重写default修饰的方法
    2、jdk9后出现的可以添加私有方法，本类中使用
    3、jdk9后出现的可以添加静态方法，接口名.静态方法()使用 ，不可以用对象调用！！！
接口与接口之间是继承关系，接口与类是实现关系！！！
    接口与接口可以多继承！！
注意：
    1、一个接口可以继承多个接口，但是如果接口出现方法名冲突的（即返回值不同时，重载没问题），不支持多继承
    2、一个类可以实现多个接口，但是如果接口出现方法名冲突的，不支持多实现，只能重写一个
    3、一个类继承了父类又实现了接口，父类和接口有同名默认(default)方法，则优先使用父类的
    4、一个类实现多个接口，多个接口中存在同名默认方法，可以不冲突，重写即可
 */

public class 接口_11 {
    public static void main(String[] args) {
        B3 b3 = new B3();
        b3.show();
        b3.show2();
        b3.show3();
        A4.show5();
    }
}

class B3 implements A3, A4 {
    @Override
    public void show() {
        System.out.println("B3show()");
    }

    @Override
    public void show2() {
        System.out.println("B3show2()");
    }

}
package 设计模式;

/**
 * @author Frank
 * @date 2024/09/22/9:58
 */

/*
公共代码在基类定义，特有的声明为抽象方法
注意：！！！建议使用final修饰模板方法（共有的）！！！防止子类重写
 */

public class 模板方法模式_02 {
    public static void main(String[] args) {
        test(new A());
        System.out.println("**************");
        test(new B());
    }

    public static void test(Base a) {
        a.sing();
    }
}

abstract class Base {
    public final void sing() {
        System.out.println("开始唱歌");
        goSing();
        System.out.println("结束唱歌");
    }

    public abstract void goSing();
}

class A extends Base {
    @Override
    public void goSing() {
        System.out.println("A唱歌");
    }
}

class B extends Base {
    @Override
    public void goSing() {
        System.out.println("B唱歌");
    }
}

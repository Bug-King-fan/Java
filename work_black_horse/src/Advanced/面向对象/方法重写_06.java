package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/20/10:44
 */

//方法重写采用就近原则！！！  （子类重写父类的必须方法名相同，形参列表相同！）
//添加@Override是复写父类方法！！！
//    注意：复写子类访问权限必须大于或等于父类权限！

//重写的方法，返回值必须和原来相同或范围更小！！！
//    私有方法和静态方法不能被重写

//同样子类成员变量也遵循就近原则！！！

public class 方法重写_06 {
    public static void main(String[] args) {
        Zi1 z = new Zi1();
        z.method();
        z.method1();
        z.method2();
        System.out.println("******************");
        System.out.println(z);
        System.out.println("******************");
        z.test();
    }
}

class Fu1 {
    public int age = 0;
    public void method2() {
        System.out.println("父类方法method2");
    }

    public void method1() {
        System.out.println("父类方法method1");
    }

    public void method() {
        System.out.println("父类方法");
    }
}

class Zi1 extends Fu1 {
    public int age = 10;

    @Override
    public void method() {
        System.out.println("子类方法");
    }

    public void method1() {
        System.out.println("子类方法method1");
    }

    @Override
    public String toString() {

        return "年龄是：" + this.age;
    }

    public void test(){
        //局部变量
        int age=100;
        System.out.println(age);
        //打印本对象的age
        System.out.println(this.age);
        //打印父类对象的age
        System.out.println(super.age);
    }

}

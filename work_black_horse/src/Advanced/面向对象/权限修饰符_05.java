package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/19/16:11
 */

/*
  修饰符     本类中      同一个包下子类       同一个包下非子类          不同包下子类       不同包下的非子类
private       √             ❌                 ❌                   ❌                 ❌
缺省           √             √                   √                   ❌                 ❌
protected     √             √                   √                    √                  ❌
public        √             √                   √                    √                   √
static        √             √                   √                    ❌                 ❌


 */


public class 权限修饰符_05 {
    public static void main(String[] args) {
        A a = new A();
        //protected 可以访问
        System.out.println(a.age);
        //Object 是祖宗，任何类都是Obj的子类
        System.out.println(a instanceof Object);

    }
}

class A {
    protected int age;

    public A() {
        this.age = 18;
    }

}




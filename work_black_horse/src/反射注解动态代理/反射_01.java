package 反射注解动态代理;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Frank
 * @date 2024/11/10/14:56
 */

/*
反射：[一种 类的解剖技术]
    反射是指对于任意Class类，在运行时都可以直接得到这个类全部部分
    在运行时，可以得到这个类的构造器对象：Constructor
    在运行时，可以得到这个类的成员方法对象：Method
    在运行时，可以得到这个类的成员变量对象：Field
 */
/*
    反射获取Class对象：
        1、Class<T> cls = 类名.class
        2、Class<T> cls = Class.forName("类全限定名[带有包名的类]")
        3、Class<T> cls = 对象名.getClass()
    反射获取Constructor对象：
        1、Constructor<T> cs = 类名.class.getConstructor(指定构造参数类型)  返回单个public的构造器
        2、Constructor<T> cs = 类名.class.getDeclaredConstructor(指定构造参数类型) 返回单个构造器包括私有
        1、Constructor<T>[] cs = 类名.class.getConstructors() 返回所有public的构造器
        2、Constructor<T>[] cs = 类名.class.getDeclaredConstructors() 返回所有构造器包括私有
    利用构造器创建对象：
        1、T t = cs.newInstance(参数列表)
        2、cs.setAccessible(true) 取消权限检查，使得可以调用私有构造器
    反射获取Method对象：
        1、Method m = 类名.class.getMethod("方法名",指定方法参数类型)
        2、Method m = 类名.class.getDeclaredMethod("方法名",指定方法参数类型)
        1、Method[] ms = 类名.class.getMethods()   获取的方法包含父类 仅public
        2、Method[] ms = 类名.class.getDeclaredMethods()  获取的方法只是本类的 包含私有
    Object Method.invoke(Object obj,Object... args)
        参数1：obj对象调用此方法
        参数2：调用方法传递的参数
        返回值：调用方法的返回值
    m.setAccessible(true) 取消权限检查，使得可以调用私有方法
    反射获取Field对象：
        1、Field f = 类名.class.getField("成员变量名")
        2、Field f = 类名.class.getDeclaredField("成员变量名")
        1、Field[] fs = 类名.class.getFields()
        2、Field[] fs = 类名.class.getDeclaredFields()
    void set(Object obj,Object val) 赋值
    Object get(Object obj) 获取
 */

public class 反射_01 {
    @Test
    public void test() throws Exception {
        //获取Class对象
        Class<u> cls = u.class;
        //获取构造器
//        Constructor<u> cs = cls.getConstructor(String.class, int.class);
        Constructor<u> cs = cls.getConstructor();
        //创建对象
//        u u1 = cs.newInstance("李四",2);
        u u1 = cs.newInstance();
        //赋值
        u1.setId(1);
        u1.setName("张三");
        //打印
        System.out.println(u1);
    }

    @Test
    public void test2() throws Exception {
        //获取Class对象
        Class<u> cls = u.class;
        //获取构造器
        Constructor<u> cs = cls.getDeclaredConstructor(String.class);
        //创建对象
        cs.setAccessible(true);
        u u1 = cs.newInstance("李四");
        //打印
        System.out.println(u1);
    }

    @Test
    public void test3() throws Exception {
        //获取Class对象
        Class<u> cls = u.class;
        Method m = cls.getMethod("run");
        m.invoke(new u("王五",98));
    }

    @Test
    public void test4() throws Exception {
        //获取Class对象
        Class<u> cls = u.class;
        Field f = cls.getDeclaredField("name");
        f.setAccessible(true);
        u u1 = new u("李四",123);
        f.set(u1,"张三");
        System.out.println(u1);
    }


}

class u {
    private String name;
    private int id;

    public u(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private u(String name) {
        this.id = 0;
        this.name = name;
    }

    public u() {

    }

    public void run() {
        System.out.println(name + "再走路。。。");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "u{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
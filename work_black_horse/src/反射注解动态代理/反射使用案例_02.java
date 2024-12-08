package 反射注解动态代理;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Frank
 * @date 2024/11/10/15:57
 */
public class 反射使用案例_02 {
    @Test
    public void test() throws Exception {
        Properties p = new Properties();
        p.load(this.getClass().getClassLoader().getResourceAsStream("eat.properties"));
        //反射
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");
        //加载类
        Class cls = Class.forName(className);
        Constructor con = cls.getConstructor();
        //获取方法
        Method m = cls.getMethod(methodName);
        m.invoke(con.newInstance());
    }
}

class Dog {
    public void eat() {
        System.out.println("狗吃肉");
    }

    public void sleep() {
        System.out.println("狗睡觉");
    }
}

class cat {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void sleep() {
        System.out.println("猫睡觉");
    }
}
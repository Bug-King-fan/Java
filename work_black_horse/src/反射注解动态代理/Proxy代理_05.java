package 反射注解动态代理;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface userServer {
    public boolean login(String name, String password);
}

/**
 * @author Frank
 * @date 2024/11/10/16:42
 */

/*
要求：
    1、被代理类必须实现接口
    2、创建被代理对象，交给代理对象

Proxy类：
    静态方: newProxyInstance(类加载器，被代理类所有实现的接口数组，处理器)
 */

public class Proxy代理_05 {
    @Test
    public void test() {
        //创建对象
        userServer userServer = new UserServiceImpl();
        //创建代理对象【处理器是接口，需要实现接口】
//        Class[] interfaces = new Class[]{userServer.class, Serializable.class}; 可以，以下是简化代码
        Class[] interfaces = userServer.getClass().getInterfaces();


        userServer proxy = (userServer) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                interfaces, new MyInvocationHandler(userServer));

        //调用代理对象
        boolean login = proxy.login("admin", "123456");
        System.out.printf("登录结果：%b", login);
    }
}

class UserServiceImpl implements userServer {
    @Override
    public boolean login(String name, String password) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
}

//处理器实现
class MyInvocationHandler implements InvocationHandler {
    private userServer userServer=null;

    public MyInvocationHandler(userServer userServer) {
        this.userServer = userServer;
    }
/*
    proxy: 代理对象[不用管]
    method: 被代理对象的方法
    args: 成员方法的参数
    return: 方法的返回值
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.currentTimeMillis();

        Object o = method.invoke(userServer, args);

        long end = System.currentTimeMillis();
        System.out.println(method.getName() + "耗时:" + (end - start) + "ms");

        return o;
    }
}
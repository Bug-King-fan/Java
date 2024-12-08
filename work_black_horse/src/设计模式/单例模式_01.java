package 设计模式;

/**
 * @author Frank
 * @date 2024/09/18/18:45
 */
public class 单例模式_01 {
    public static void main(String[] args) {

    }
}

//懒汉模式
class Singleton {
    //2、私有化属性
    private static Singleton A;

    //1、私有化构造器
    private Singleton() {
    }

    //3、提供一个公共的静态方法
    public static Singleton getA() {
        if (A == null) {
            A = new Singleton();
        }
        return A;
    }
}

//饿汉模式
class lazySingleton {
    //2、提供一个私有变量，并赋值
    private static final lazySingleton A = new lazySingleton();

    //1、私有化构造器
    private lazySingleton(){

    }

    //3、提供一个公共的静态方法
    public static lazySingleton getA(){
        return A;
    }
}


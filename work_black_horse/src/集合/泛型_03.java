package 集合;

import java.util.ArrayList;

interface Stu<t> {
    boolean add(t a);
}

//泛型类 :当类中有属性不确定是什么类型是，可以使用泛型类
//public class 类名<泛型名,...>{
//
//}
//在创建对象时， 类名<泛型名具体类型,...> 对象名 = new 类名<泛型名具体类型,...>()

/**
 * @author Frank
 * @date 2024/09/26/12:02
 */

/*
泛型是java中用于保存类型的（一种类型参数）！！！
泛型是在代码编写时的技术，在代码运行时泛型被擦除！！！
泛型的使用：
    1、泛型类
    2、泛型接口
    3、泛型方法
注意：
    1、泛型不存在多态（父类引用不可以引用子类(以下报错):Arraylist<Person> s= new Arraylist<student>()）
       但在语法定义层面，可以使用通配符：？ 来表示任意类型 ：Arraylist<?> s= new Arraylist<student>()
    2、受限泛型的使用：泛型下限：? super 类型   泛型上限：? extends 类型
        下限只能支持传递的类型及其所有父类型，上限只能支持传递的类型及其子类型


 */

public class 泛型_03 {
    public static void main(String[] args) {
        St<Integer, String> s = new St<Integer, String>();
        s.setAge(10);
        s.setName("张三");
        System.out.println(s);
        System.out.println("**************");
        Text3.test();
    }
}

//泛型接口： 当不确定某个方法使用什么参数类型、或者返回值什么类型，可以用泛型
//public interface 接口名<泛型名,...>{
//     public abstract boolean add(类型名 a);
//}
//子类编写时，要确定泛型类型  Or  子类编写时未确定泛型类型，则子类也变成泛型类,在创建对象时明确类型

class St<x, t> {
    private x age;
    private t name;

    public void setAge(x age) {
        this.age = age;
    }

    public void setName(t name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "St{" + age + " ," + name + " }";
    }
}

class Text implements Stu<Integer> {
    @Override
    public boolean add(Integer a) {
        return false;
    }
}

class Text2<T> implements Stu<T> {
    @Override
    public boolean add(T a) {
        return false;
    }
}


//泛型方法： 当不确定方法使用什么参数类型、或者返回值什么类型，可以用泛型
//public [static] <泛型名,...> 返回值类型 方法名(泛型 参数类型,...){}
//如 public static T[] void sort(T[],compare){
//子类编写时，要确定泛型类型  Or  子类编写时未确定泛型类型，则子类也变成泛型类,在创建对象时明确类型

class Text3 {
    public static <T> void PrintArray(T[] arr) {
        for (T a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void test() {
        Integer[] arr = {1, 2, 3, 4};
        PrintArray(arr);
    }
}

//受限的泛型
//需求show1只接受父类型，show2只接收子类型
class Text4 {
    public static void te() {
        ArrayList<Number> lis1 = new ArrayList<>();
        show1(lis1);
        ArrayList<Object> lis2 = new ArrayList<>();
        show1(lis2);
        ArrayList<Integer> lis3 = new ArrayList<>();
        show2(lis3);
    }

    //接收Number及其父类型
    public static void show1(ArrayList<? super Number> list) {

    }

    //接收Number及其子类型
    public static void show2(ArrayList<? extends Number> list) {

    }

}

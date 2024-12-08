package 集合;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @author Frank
 * @date 2024/10/17/14:55
 */

/*
TreeSet 底层是红黑树 ：排序(默认升序)、不重复、无索引
    可自定义排序方法:
            方法一：自定义类中实现Comparable接口，重写里卖弄的compareTo方法
            方法二：通过调用TreeSet的构造器，设置Comparator对象（public TreeSet(Comparator<?super E>comparator)）
 */

public class TreeSet_08 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Hello");
        ts.add("hello");
        ts.add("hallo");
        System.out.println(ts);
        System.out.println("___________");
        //方法一：
        TreeSet<Pe> ps = new TreeSet<>();
        ps.add(new Pe(18, "a"));
        ps.add(new Pe(18, "b"));
        ps.add(new Pe(30, "c"));
        System.out.println(ps);
        System.out.println("___________");
        //方法二：自定义类中实现Comparable接口，重写里卖弄的compareTo方法
//        TreeSet<Pe> pss = new TreeSet<>(new Comparator<Pe>() {
//            @Override
//            public int compare(Pe o1, Pe o2) {
//                var temp = o2.age - o1.age;
//                return temp == 0 ? o2.name.compareTo(o1.name) : temp;
//            }
//        });
        //lambda简化
        TreeSet<Pe> pss = new TreeSet<>(((o1, o2) -> {
            var temp = o2.age - o1.age;
            return temp == 0 ? o2.name.compareTo(o1.name) : temp;
        }));
        pss.add(new Pe(18, "a"));
        pss.add(new Pe(18, "b"));
        pss.add(new Pe(30, "c"));
        System.out.println(pss);
    }
}

class Pe implements Comparable<Pe> {
    public int age;
    String name;

    public Pe(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Pe o) {
        //大->小
        var temp = o.age - this.age;
        return temp == 0 ? o.name.compareTo(this.name) : temp;
    }

    @Override
    public String toString() {
        return "Pe{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pe pe = (Pe) o;
        return age == pe.age && Objects.equals(name, pe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

}

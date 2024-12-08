package 集合;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author Frank
 * @date 2024/10/17/10:01
 */

/*
无序：是指存储顺序和获取顺序不一致
HashSet TreeSet : 无序（自动排序）、不重复、无索引
LinkedHashSet : 有序、不重复、无索引、
Set无特有方法
    公共方法：add remove contains isEmpty size ToArray
 */

/*
二叉搜索树：左边放小于的值，右边是大于的值，等于的值不放
平衡二叉树：左右子树高度差不超过1，尽可能矮化二叉树
红黑树   ：是可以自动平衡的二叉树
 */

/*
HashSet底层原理：
    HashSet底层是哈希表，哈希表是一种增删改查数据，性能都很好的数据结构
（同余数数据会自动挂在老数据下）jdk8后 哈希表 = 数组 + 链表 + 红黑树 (当链表长度超过8，且数组长度 >= 64 ,自动将链表转化为红黑树)
（同余数数据会自动将老数据下拉，新数据接到头部）jdk8前 哈希表 = 数组 + 链表 （默认数组长度16,加载因子0.75，当数组达到默认因子比例(16*0.75)，自动扩容两倍）
注意： 哈希表不会对内容相同的两个对象去重
        可以在类中重写equals和hashCode方法
 */

public class HashSet_06 {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
        s.add(5);
        s.add(2);
        s.add(4);
        s.add(4);
        s.add(1);
        s.forEach((i) -> {
            System.out.println(i);
        });
        System.out.println("___________");
        HashSet<P> s2 = new HashSet<>();
        s2.add(new P(5, "a"));
        s2.add(new P(2, "b"));
        s2.add(new P(4, "c"));
        s2.add(new P(4, "d"));
        s2.add(new P(2, "b"));
        s2.forEach((p) -> {
            System.out.println(p);
        });
        P p = new P(5, "a");
        P p2 = new P(5, "a");
        System.out.println(p.equals(p2));
        System.out.println(System.identityHashCode(p));
        System.out.println(System.identityHashCode(p2));
        System.out.println("___________");
        //出现哈希冲突，采用链地址法解决
        HashSet<String> s3 = new HashSet<>();
        s3.add("FB");
        s3.add("Ea");
        System.out.println(s3);
    }
}

class P {
    public int age;
    public String name;

    public P(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "P{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        P p = (P) o;
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
package 集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @author Frank
 * @date 2024/10/20/14:29
 */
/*
Map集合：
    HashMap：无序、不重复、无索引
    LinkedHashMap：有序、不重复、无索引
    TreeMap_11：无序、不重复、无索引
Map共有方法：
    put(key,value) 添加元素 当key存在时，更新value
    size() 获取集合大小
    clear() 清空集合
    isEmpty() 判断集合是否为空
    remove(key) 删除元素
    get(key) 获取元素对应的值
    containsKey(key) 判断集合中是否包含某个key
    containsValue(value) 判断集合中是否包含某个value
    keySet() 获取集合中所有的key
    values() 获取集合中所有的value
    entrySet() 获取集合中所有的元素  返回Entry对象，通过getKey() getValue()获取数据
    getOrDefault(key, default) 如果key存在，返回key对应的value，如果key不存在，返回default
 */

/*
HashMap key不可重复，value可重复
遍历方法：
    方法一：通过keySet获取所有的key，在用get(k)获取值
    方法二：通过entrySet()返回Map.Entry<K,V>对象，通过getKey() getValue()获取数据
    方法三：jdk8后，使用lambda表达式，调用map的forEach(BiConsumer<K,V>)方法。(常用)
 */

/*
HashMap的底层：
（同余数数据会自动挂在老数据下）jdk8后 哈希表 = 数组 + 链表 + 红黑树 (当链表长度超过8，且数组长度 >= 64 ,自动将链表转化为红黑树)
（同余数数据会自动将老数据下拉，新数据接到头部）jdk8前 哈希表 = 数组 + 链表 （默认数组长度16,加载因子0.75，当数组达到默认因子比例(16*0.75)，自动扩容两倍）

 */


public class HashMap_09 {
    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("hello", 1);
        mp.put("java", 2);
        mp.put("world", 2);
        mp.put("C++", 3);
        System.out.println(mp.size());
        System.out.println(mp.get("java"));
        System.out.println(mp.containsKey("hello"));
        System.out.println(mp.containsValue(2));
        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet());
        //遍历方法一：
        for (var k : mp.keySet()) {
            System.out.println(k + " " + mp.get(k));
        }
        System.out.println("______________");
        //遍历方法二：
        Set<Map.Entry<String, Integer>> entries = mp.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println("________________");
        //遍历方法三：
        mp.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + " " + integer);
            }
        });
        System.out.println("________________");
        //简化lambda
        mp.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
        System.out.println("_________________");
        HashMap<P3, Integer> mp2 = new HashMap<>();
        mp2.put(new P3("hello", 1), 1);
        mp2.put(new P3("hello", 1), 2);
        mp2.forEach((k, v) -> {
            System.out.println("{" + k + "," + v + "}");
        });
    }
}

class P3 {
    public String name;
    public int age;

    public P3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重写hashCode和equals方法用于字段相同的时候，认为是同一个对象
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        P3 p3 = (P3) o;
        return age == p3.age && Objects.equals(name, p3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "(" + name + "," + age + ")";
    }
}
package 集合;

import java.util.TreeMap;

/**
 * @author Frank
 * @date 2024/10/22/14:26
 */

/*
TreeMap底层是红黑树。排序同TreeSet。实现Comparable接口，或者构造传入Comparator对象。
 */

public class TreeMap_11 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tm = new TreeMap<>((o1, o2) -> {
            return o2 - o1;
        });
        tm.put(1, 2);
        tm.put(3, 4);
        tm.put(5, 6);
        tm.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
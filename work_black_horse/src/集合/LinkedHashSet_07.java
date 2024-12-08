package 集合;

import java.util.LinkedHashSet;

/**
 * @author Frank
 * @date 2024/10/17/14:46
 */

/*
LinkedHashSet底层仍然采用数组+链表+红黑树实现，但每个元素都额外多了一个双链表的机制记录它前后元素的位置。
    有序、无重复、无索引 头尾指针指向第一个和最后一个插入元素，且元素间都是双向链表确保可以找到顺序
方法同HashSet extern HashSet
 */

public class LinkedHashSet_07 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(5);
        lhs.add(3);
        lhs.add(2);
        lhs.forEach((s) -> {
            System.out.print(s + " ");
        });


    }
}
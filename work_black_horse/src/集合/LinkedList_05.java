package 集合;

import java.util.LinkedList;

/**
 * @author Frank
 * @date 2024/10/17/9:46
 */
/*
LinkedList的常用方法
    add(E o) 	将指定元素追加到此列表的结尾。
    add(int index, E element) 	在此列表中指定的位置插入指定的元素。
    addAll(Collection<? extends E> c) 	追加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序。
    addFirst(E o) 	将给定元素插入此列表的开头。
    addLast(E o) 	将给定元素追加到此列表的结尾。
    get(int index) 	返回此列表中指定位置处的元素。
 	getFirst() 	返回此列表的第一个元素。
 	getLast() 	返回此列表的最后一个元素。
 	set(int index, E element) 	将此列表中指定位置的元素替换为指定的元素。
 	remove() 	找到并移除此列表的头（第一个元素）。
 	remove(int index) 	移除此列表中指定位置处的元素。
 	removeFirst() 	移除并返回此列表的第一个元素。
 	removeLast() 	移除并返回此列表的最后一个元素。
 	size() 	返回此列表的元素数。
 	clear() 	从此列表中移除所有元素。
 	indexOf(Object o) 	返回此列表中首次出现的指定元素的索引，如果列表中不包含此元素，则返回 -1。
	lastIndexOf(Object o) 	返回此列表中最后出现的指定元素的索引，如果列表中不包含此元素，则返回 -1。
 	toArray() 	以正确顺序返回包含此列表中所有元素的数组。
 	poll() 	移除并返回此列表的第一个元素。
 	peek() 	返回此列表的第一个元素，但不将其从列表中删除。
 	push(E e) 	将指定元素插入此列表的开头。
 	pop() 	移除并返回此列表的第一个元素。
 */

public class LinkedList_05 {
    public static void main(String[] args) {
        LinkedList<Integer> lt = new LinkedList<>();
        lt.add(1);
        lt.addFirst(2);
        lt.addLast(0);
        lt.forEach((s) -> {
            System.out.print(s + " ");
        });
    }
}
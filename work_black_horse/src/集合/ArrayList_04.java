package 集合;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Frank
 * @date 2024/10/15/17:22
 */
/*
Collection<E> 集合体系 ：Collection al = new LinkedList<>();
    公共方法：add remove contains isEmpty size ToArray
List：有序，可重复，有索引
    ArrayList LinkedList
set：无序，不可重复，无索引
    HashSet TreeSet LinkedHashSet

Iterator: 迭代器
    Iterator<String> it = al.iterator();
    boolean hasNext(): 判断是否还有下一个元素
    E next(): 获取下一个元素
    it.remove(): 移除当前元素
 */

/*
ArrayList 和 LinkedList 的区别
    ArrayList: 有序，可重复，有索引
        1、底层是数组初始无参构造创建大小为 0 数组，添加第一个元素数组长度会扩容到10，之后存满后会以1.5倍自动扩容
        2、查询快、删除满、添加效率极低
    LinkedList: 有序，可重复，无索引
        1、底层是双向不循环链表
        2、查询慢、添加删除效率相对高
 */


/*
    add(E element): 向列表尾部添加元素。
    addAll(Collection<? extends E> c): 将另一个集合中的所有元素添加到列表中。
    remove(int index(返回E)/内容(返回boolean)): 移除指定索引位置的元素。
    removeRange(int fromIndex, int toIndex): 移除指定范围内的元素。
    removeAll(Collection<?> c): 移除列表中所有的指定集合的元素。
    set(int index, E element): 替换指定索引位置的元素。
    get(int index): 获取指定索引位置的元素。
    size(): 获取列表的大小。
    clear(): 清空列表中的所有元素。
    isEmpty(): 检查列表是否为空。
    contains(Object o): 检查列表是否包含指定元素。
    indexOf(Object o): 获取元素在列表中的第一个出现位置的索引。
    lastIndexOf(Object o): 获取元素在列表中的最后一个出现位置的索引。
    clone(): 创建一个新的列表副本。
    trimToSize(): 去除ArrayList多余的容量。
    toArray(返回的数组): 将列表转换为数组。
 */

public class ArrayList_04 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("hello");
        al.add("C++");
        al.add("world");
        al.add(1, "java");
        System.out.println(al);
        System.out.println(al.get(0));
        System.out.println("_____________");
        //此时a是局部变量
        for (var a : al) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("______________");
        Iterator<String> it = al.iterator();
        while (it.hasNext()) {
            if (it.next().equals("C++")) {
                it.remove();
            }
        }
        System.out.println(al);
        System.out.println("_____________");
        //lambda表达式
        al.forEach((var x) -> {
            System.out.print(x + " ");
        });
    }

}
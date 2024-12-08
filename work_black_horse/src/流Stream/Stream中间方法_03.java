package 流Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Frank
 * @date 2024/10/22/15:06
 */

/*
中间方法：返回值是Stream类型，可以继续调用stream中间方法
方法：
    filter(Predicate<? super T> predicate)          用于对六种数据进行过滤
        filter相当于一个循环遍历，返回满足条件的元素
    sorted()                                        对元素升序排序
    sorted(Comparator<? super T> comparator)        对元素自定义排序
    limit(long maxSize)                             获取前几个元素
    skip(long n)                                    跳过前几个元素
    distinct()                                      去重
    map(Function<? super T, ? extends R> mapper)    对元素进行加工，返回对应新流
        Function第一个参数是流对象元素的类型，第二个参数是新流对象元素的类型，内部函数返回值是新流对象元素的类型
    concat(Stream a,Stream b)                       合并a，b两个流
 */

public class Stream中间方法_03 {
    public static void main(String[] args) {
        //filter
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰", "张无忌", "周正人", "张强");
//        List<String> li = list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                System.out.println("s=" + s);
//                return s.startsWith("张");
//            }
//        }).toList();
//        System.out.println(li);
        List<String> li = list.stream().filter((s) -> {
            return s.startsWith("张");
        }).collect(Collectors.toList());
        System.out.println(li);

        //sorted
        List<Integer> l1 = new ArrayList<>();
        Collections.addAll(l1, 1, 3, 5, 2, 4, 6, 6);
        List<Integer> l2 = l1.stream().sorted().collect(Collectors.toList());
        System.out.println(l2);
        List<Integer> l3 = l1.stream().sorted((o1, o2) -> {
            return o2 - o1;
        }).collect(Collectors.toList());
        System.out.println(l3);
        //limit
        List<Integer> l4 = l1.stream().limit(3).collect(Collectors.toList());
        System.out.println(l4);
        //skip
        List<Integer> l5 = l1.stream().skip(3).collect(Collectors.toList());
        System.out.println(l5);
        //distinct
        List<Integer> l6 = l1.stream().distinct().collect(Collectors.toList());
        System.out.println(l6);
        //map
        ArrayList<String> lll = new ArrayList<>();
        Collections.addAll(lll, "10", "11", "21", "5");
        List<Integer> ll = lll.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String integer) {
                return Integer.parseInt(integer);
            }
        }).collect(Collectors.toList());
        System.out.println(ll);
        List<Integer> l7 = l1.stream().map((x) -> {
            return x * x;
        }).collect(Collectors.toList());
        System.out.println(l7);
        //concat
        List<Integer> l8 = l1.stream().limit(3).collect(Collectors.toList());
        List<Integer> l9 = l1.stream().skip(4).collect(Collectors.toList());
        List<Integer> l10 = Stream.concat(l8.stream(), l9.stream()).collect(Collectors.toList());
        System.out.println(l10);
    }
}
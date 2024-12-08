package 流Stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Frank
 * @date 2024/10/22/14:55
 */
/*
方法：
    //1、获取流对象
    集合中     default Stream<T> stream() 获取当前集合的流对象
    Arrays类中 public static <T> Stream<T> stream(T[] elements) 获取指定数组的流对象
    Stream类中 public static <T> stream<T> of(T... elements) 获取接收数据的流对象
    public static <T> Stream<T> empty() 返回一个空流
 */
public class Stream获取方法_02 {
    public static void main(String[] args) {

        //1、获取集合的stream对象(双列集合要转化为单列/直接用Entry对象才可以获取Stream流)
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰", "张无忌", "周正人", "张强");
        Stream<String> stream = list.stream();

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 1);
        hm.put(2, 2);
        hm.put(3, 3);
        hm.put(4, 4);
        Stream<Integer> stream2 = hm.values().stream();
        Stream<Map.Entry<Integer, Integer>> stream3 = hm.entrySet().stream();

        //2、获取数组的stream对象
        String[] arr = new String[]{"张三丰", "张无忌", "周正人", "张强"};
        Stream<String> stream4 = Arrays.stream(arr);

        //3、获取接收数据的stream对象
        Stream<String> stream5 = Stream.of("张三丰", "张无忌", "周正人", "张强");
    }
}
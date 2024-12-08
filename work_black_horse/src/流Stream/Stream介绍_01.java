package 流Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Frank
 * @date 2024/10/22/14:36
 */

/*
Stream作用：简化集合、操作数据
Stream的处理步骤：获取流对象，调用方法，收集结果
JDK8开始，Java8引入了新的Stream API 用于操作集合或数组数据，全部支持Lambda表达式。
Stream API 有三个基本概念：流，中间操作器（Mapper），终止操作器（Reducer）。
    中间方法有过滤、排序、去重等。
注意：
    1、在Stream中无法直接修改原集合/数组的数据，Stream知识拷贝了一份数据。
    2、同一个Stream类的对象直接能使用一次。
 */

public class Stream介绍_01 {
    public static void main(String[] args) {
        //任务1：将姓张，且名字为三个字的放入集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰", "张无忌", "周正人", "张强");
        ArrayList<String> ans = new ArrayList<>();
        //传统方法
        for (String s : list) {
            if (s.startsWith("张") && s.length() == 3) {
                ans.add(s);
            }
        }
        ans.forEach(s -> System.out.println(s));
        System.out.println("__________________");
        //Stream流
        List<String> ans2 = list.stream()
                .filter(s -> s.startsWith("张") && s.length() == 3).collect(Collectors.toList());

        ans2.forEach(s -> System.out.println(s));

    }
}
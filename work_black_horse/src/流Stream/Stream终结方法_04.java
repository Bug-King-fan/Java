package 流Stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Frank
 * @date 2024/10/22/18:08
 */

/*
终结方法：不在返回流对象
方法：

    R collect(Collector collector) 把流处理后的结果收集到一个指定的集合去
            (.调用 ,内部可以放收集到哪里[Collector.toList()])
        public static <T> Collector toList() 把元素收集到List集合中
        public static <T> Collector toSet() 把元素收集到Set集合中
        public static <T> Collector toMap(Function keyMapper, Function valueMapper) 把元素收集到Map集合中
    Object[] toArray(IntFunction generator) 把流处理后的结果收集到一个数组去
            (.调用 ，内部放IntFunction对象，重写方法，传递value[有多少对象],new出目标类型数组)
    List<T> toList() 把流处理后的结果收集到一个List集合中(.调用)

    forEach(Consumer<? super T> action) 对此流运算后的元素执行遍历
    count() 返回此流的元素数目
    Optional<T> min(Comparator<? super T> comparator) 返回流中最小元素
    Optional<T> max(Comparator<? super T> comparator) 返回流中最大元素
    Optional<T> findFirst() 返回流中的第一个元素
    Optional<T> findAny() 返回流中的任意元素
    Optional<T> findLast() 返回流中的最后一个元素
        Optional a   a.get()获取值
 */

public class Stream终结方法_04 {
    public static void main(String[] args) {
        //案例：
        List<Monster> monsterList = new ArrayList<>();
        Monster monster1 = new Monster("蜘蛛精", 26, 172.5);
        Monster monster2 = new Monster("紫霞", 23, 167.6);
        Monster monster3 = new Monster("白晶晶", 25, 169.0);
        Monster monster4 = new Monster("牛魔王", 35, 183.3);
        Monster monster5 = new Monster("牛夫人", 34, 168.5);
        monsterList.add(monster1);
        monsterList.add(monster2);
        monsterList.add(monster3);
        monsterList.add(monster4);
        monsterList.add(monster5);

        //1、计算出身高超过168的学生个数
        Long count = monsterList.stream().filter((s) -> {
            return s.getHeight().compareTo(BigDecimal.valueOf(168.0)) > 0;
        }).count();
        System.out.println(count);
        //2、找出身高最高的对象，并输出
        List<Monster> a = monsterList.stream().sorted((o1, o2) -> {
            return o2.getHeight().compareTo(o1.getHeight());
        }).collect(Collectors.toList());
        System.out.println(a);
        Optional<Monster> ans = monsterList.stream().max((o1, o2) -> {
            return o1.getHeight().compareTo(o2.getHeight());
        });
        System.out.println(ans.get());
        //3、找出身高最矮的对象，并输出
        Optional<Monster> ans2 = monsterList.stream().min((o1, o2) -> {
            return o1.getHeight().compareTo(o2.getHeight());
        });
        System.out.println(ans2.get());
        //4、找出身高超过170的对象，并放到一个List中返回
        List<Monster> list = monsterList.stream().filter((s) -> {
            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
        }).collect(Collectors.toList());
        System.out.println(list);
        //5、找出身高超过170的对象，并放到一个set中返回
        Set<Monster> set = monsterList.stream().filter((s) -> {
            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
        }).collect(Collectors.toSet());
        System.out.println(set);
        //6、找出身高超过170的对象，并把名字和身高放到一个Map中返回
//        HashMap<String, BigDecimal> mp =
//        monsterList.stream().filter((s) -> {
//            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
//        }).collect(Collectors.toMap(new Function<Monster, String>() {
//            @Override
//            public String apply(Monster monster) {
//                return monster.getName();
//            }
//        }, new Function<Monster, BigDecimal>() {
//            @Override
//            public BigDecimal apply(Monster monster) {
//                return monster.getHeight();
//            }
//        }));
        Map<String, BigDecimal> mp = monsterList.stream().filter((s) -> {
            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
        }).collect(Collectors.toMap((mo) -> {
            return mo.getName();
        }, (m) -> {
            return m.getHeight();
        }));
        mp.forEach((k, v) -> {
            System.out.print(k + ":" + v + "\t");
        });
        System.out.println();
        //7、找出身高超过170的对象，并放到一个数组中返回
//        Object[] objects = monsterList.stream().filter((s) -> {
//            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
//        }).toArray();

//        Monster[] objects = monsterList.stream().filter((s) -> {
//            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
//        }).toArray(new IntFunction<Monster[]>() {
//            @Override
//            public Monster[] apply(int len) {
//                return new Monster[len];
//            }
//        });

        Monster[] objects = monsterList.stream().filter((s) -> {
            return s.getHeight().compareTo(BigDecimal.valueOf(170.0)) > 0;
        }).toArray((len) -> {
            return new Monster[len];
        });
        System.out.println(Arrays.toString(objects));
    }
}

class Monster {
    private String name;
    private int age;
    private BigDecimal height;

    public Monster(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = BigDecimal.valueOf(height);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}


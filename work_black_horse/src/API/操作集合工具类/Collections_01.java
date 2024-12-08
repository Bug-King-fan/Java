package API.操作集合工具类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Frank
 * @date 2024/10/20/11:56
 */

/*
方法：
    public static <T> boolean addAll(Collection<? super T> c, T... elements)
    public static void shuffle(List<?> list) 打乱List集合顺序
    public static void shuffle(List<?> list, Random random) 打乱List集合顺序
    public static <T> void sort(List<T> list, Comparator<? super T> c) //对list集合进行自定义排序
    public static <T> void sort(List<T> list) //对list集合进行升序排序

 */

public class Collections_01 {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        Collections.addAll(ar, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Collections.shuffle(ar, new Random(System.currentTimeMillis()));
        System.out.println(ar);

        Collections.sort(ar, (o1, o2) -> {
            return o2 - o1;
        });
        System.out.println(ar);

    }
}
package 集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Frank
 * @date 2024/09/22/12:43
 */

/*
负整数： 如果方法返回负整数，表示第一个参数（compareTo 中的 this 或 compare 中的 o1）应该排在第二个参数（compareTo 中的 o 或 compare 中的 o2）之前。
零：    如果方法返回零，表示这两个参数在排序时被视为相等。
正整数： 如果方法返回正整数，表示第一个参数应该排在第二个参数之后。
 */

public class Arrays_01 {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 9, 5};
        int[] arr2 = {1, 6, 3, 9, 5};
        //判断两数组是否相同
        boolean flag = Arrays.equals(arr, arr2);
        System.out.println(flag);
        //用val填充数组
        int[] arr3 = new int[10];
        Arrays.fill(arr3, 1);
        System.out.println(Arrays.toString(arr3));
        //排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //获取最大值
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        //获取最小值
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(min);
        //二分检索查找
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);

        //创建临时的List集合
        List<String> girlList = Arrays.asList("张甜甜", "张亚丽", "任敏", "史碧蓉");
        //全部添加至ArrayList集合中
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(girlList);
        System.out.println(list);

        //通过Arrays工具类的copyOf()复制数组
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("原数组内容：" + Arrays.toString(numbers));
        int[] arr01 = Arrays.copyOf(numbers, 3);
        System.out.println("前三个元素：" + Arrays.toString(arr01));

        int[] numbe = {1, 2, 3, 4, 5, 6, 7};
        int[] target = new int[numbe.length];
        //参数1：原数组
        //参数2：开始复制的位置
        //参数3：目标数组
        //参数4：开始存储的位置
        //参数5：复制的长度（复制的元素个数）
        System.arraycopy(numbe, 0, target, 0, numbe.length);
        System.out.println(Arrays.toString(numbe));
        System.out.println(Arrays.toString(target));

        //返回新数组 copyOfRange(从那个数组拷贝，起始位置，结束位置)
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        int[] arr03 = Arrays.copyOfRange(num, 1, 4);
        System.out.println("指定区间元素：" + Arrays.toString(arr03));


        //自定义排序规则,方法一：
        Integer[] arr5 = {1, 6, 3, 9, 5, 0};
        Arrays.sort(arr5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr5));
        //方法二：在类中实现Comparable接口
        S[] arr6 = {new S(1), new S(6), new S(3), new S(9), new S(5), new S(0)};
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6));

        //setAll(arr,IntoDoubleFunction);
        Double[] arr7 = {1.0, 6.0, 3.0, 9.0, 5.0, 0.0};
        Arrays.setAll(arr7, (int i) -> arr7[i] * 2);
        System.out.println(Arrays.toString(arr7));
    }
}

class S implements Comparable<S> {
    int age;

    public S(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "S{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(S o) {
        return this.age - o.age;
    }

}

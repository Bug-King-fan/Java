package 基础;

import java.util.Random;

/**
 * @author Frank
 * @date 2024/09/16/10:15
 */
/*
注意：变量名(一个指向数组的引用)存放在栈中，而数组存放在堆中！！！
    数组静态初始化:
        数据类型[] 变量名 = new 数据类型[]{数据1,数据2,数据3...};
       简化：数据类型[] 变量名 = {数据1,数据2,数据3...};
    数组动态初始化:
        数据类型[] 变量名 = new 数据类型[长度];  默认值为0、false、null
 */

public class 数组_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] arr3 = new int[3][];
        int[][] arr4 = {{1, 2, 3, 4}, {1, 2, 7}};
        String[] names = {"张三", "李四", "王五", "赵六"};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (String element : names) {
            System.out.print(element + " ");
        }
        System.out.println();
        Random r = new Random();
        int[] ran = new int[5];
        for (int i = 0; i < 5; i++) {
            ran[i] = r.nextInt(100 + 1);
            System.out.print(ran[i] + " ");
        }
        System.out.println("***********");
        for(var a:arr4) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
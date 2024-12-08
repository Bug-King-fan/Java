package 基础;

import java.util.Arrays;

/**
 * @author Frank
 * @date 2024/09/16/10:35
 */
/*
    java中的内存管理：
        堆：用来给new出来的对象开辟空间，这个空间申请的所有空间，都有默认值
        栈：用来给方法开辟空间，存放方法内部申请的变量
        方法区：用来存储.class文件加载到内存的对象
        本地方法栈： 调用其他语言的桥梁
        寄存器： 和cpu打交道
   out:System.identityHashCode(p) 查看对象真是地址
 */

public class 内存_12 {
    public static void main(String[] args) {
        //共享地址
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = arr1;
        System.out.println(Arrays.hashCode(arr1) + " " + Arrays.hashCode(arr2));
        arr2[0] = 143;
        System.out.println(arr1[0]);
        System.out.println("**************");
        //string在字符串相同时，会共享地址
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1.hashCode() + " " + str2.hashCode());
        str2 = str2 + "def";
        System.out.println(str1.hashCode() + " " + str2.hashCode());
        //String在比较值时需要用equals()  str1==str2 是其hash地址比较
        if (str1.equals(str2)) {
            System.out.println("str1=str2");
        } else {
            System.out.println("str1!=str2");
        }
        System.out.println("**************");
        //置换
        int[] arr = {1, 2, 3, 4};
        内存_12 qw = new 内存_12();
        qw.reverse(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("**************");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void reverse(int[] arr) {
        arr[0] = 100;
    }

}
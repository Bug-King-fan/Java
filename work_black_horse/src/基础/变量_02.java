package 基础;

/**
 * @author Frank
 * @date 2024/09/13/11:43
 */

/*
    变量：
        1. 变量命名规则
        只能包含字母、数字、下划线，且不能以数字开头
        2. 变量命名规范
            类名：大驼峰
            变量名：小驼峰
 */

public class 变量_02 {
    public static void main(String[] args) {
        //定义long float 要手动加L/F 默认int 和double
        //long 8字节 64位
        long a = 1000L;
        float b = 1000.0F;
        System.out.println(a);
        System.out.println(b);
        int year = 2003;
        int age = 1;
        System.out.println(year++ + "年的年龄是：" + age++);
        System.out.println(year++ + "年的年龄是：" + age++);
        System.out.println(year++ + "年的年龄是：" + age++);
        System.out.println(year + "年的年龄是：" + age);
    }
}
package 基础;

/**
 * @author Frank
 * @date 2024/09/16/11:20
 */
/*
修饰符 (static) 返回值类型 方法名(参数列表){
    方法体（需要执行的代码）
    return 返回值;
}
 */

public class 方法_13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr));
        int a = 10, b = 20;
        change(a, b);
        System.out.println(a + " " + b);
    }

    public static int sum(int... a) {
        var sum = 0;
        for (var q : a) {
            sum += q;
        }
        return sum;
    }

    public static void change(int a, int b) {
        a = 20;
        b = 30;
    }

    //方法重载 :方法名相同，参数列表不同 (返回值修饰符不管)
    public static void  change(int a,double b){
        a = 20;
        b = 3.5;
    }
    public static void  change(int a,double b,int c){
        a = 20;
        b = 3.5;
    }

}
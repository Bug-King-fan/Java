package 异常;

/**
 * @author Frank
 * @date 2024/10/15/10:42
 */
/*
    祖宗：Exception捕获所有异常
异常处理两种方法：
    1、try-catch-finally
    2、throws + 异常类型

try-catch-finally使用：
try{
    //可能出现异常的代码
} catch (异常类型1 变量名1) {
    //处理异常的方式
} catch (异常类型2 变量名2) {
    //处理异常的方式
} catch (异常类型3 变量名3) {
    //处理异常的方式
}
......
finally {  //可选的
    //一定会执行的代码
}
catch中异常类型如果没有子父类关系，谁声明在上/再下无影响。
catch中异常类型如果有子父类关系，要求子类声明要在父类之上，否则会报错。

常用异常对象处理方式：
1、e1.getMessage() 返回String类型， 返回异常问题
2、e1.printStackTrace() 无返回类型  打印异常日志
 */


public class TryCatch_02 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s = "123abc";
        try {
            System.out.println("执行前");
            int num = Integer.parseInt(s);
            System.out.println("执行中");
        } catch (NumberFormatException e1) {
            System.out.println("出现数值转化异常！");
            System.out.println(e1.getMessage());
            e1.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("数组越界！");
        } finally {
            System.out.println("一定会执行的代码");
        }
        System.out.println("程序结束");
    }
}



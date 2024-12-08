package Advanced.面向对象;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Frank
 * @date 2024/09/22/12:57
 */
public class 内部类_12 {
    public static void main(String[] args) {
        //创建成员内部类
        Person12 p = new Person12();
        Person12.Do pd = p.new Do();
        pd.method();
        System.out.println("********");
        p.method2();
        System.out.println("********");
        Integer[] arr={1,5,9,3,8,0};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;//升序
//                return o2-o1;//降序
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}

class Person12 {
    public int num = 30;

    public void method() {
        //局部内部类
        class AA {

        }
    }

    //匿名内部类:简化代码
    /*
    格式：
        new 类名(){
            重写方法
        }

     使用:
      1:    new 类名(){
                 重写方法
            }.方法名();
      2:    父类引用复制，然后调用
      3:    当作方法的参数传递
      4:    当作方法的返回值使用
     */
    public void method2() {
        new Do() {
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        }.method();
    }

    //成员内部类
    class Do {
        public int num = 20;

        public void method() {
            int num = 10;
            System.out.println(num); //10
            System.out.println(this.num);//20
            System.out.println(Person12.this.num);//30
        }
    }
}

package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/20/12:50
 */

//多态的前提：
//    1、存在继承/实现关系
//    2、存在父类引用指向子类对象
//    3、子类重写了父类的方法
/*
    注意事项：成员变量不存在多态行为

    多态的好处：
        1、实现解耦合 （耦合：修改一个地方的代码，导致另一个地方代码必须修改）
        2、用于函数参数列表的传递，可以直接创建一个对象
        3、定义方法时，父类型作为参数列表，可以接受一切子类对象，便于扩展
    多态的弊端：
        1、多态会不能调用子类的特有方法(编译看左（声明的类型），运行看右（实际类型的）)


instanceof :  A instanceof B  如果A对象是B的子类对象或类对象，返回true 否则返回false
 */
public class 多态_08 {
    public static void main(String[] args) {
        //多态：父类引用可以指向子类引用！ 常用于函数参数列表的传递
        Person p = new Teacher();  //向上转型
        p.run();
//        p.teach();
        System.out.println("*****************");

        test(new Teacher());
        test(new Student());


    }

    public static void test(Person p) {
        //如：Student s = (Student) p
        if (p instanceof Student){
            System.out.println("*****");
            System.out.println("是学生");
        }else if(p instanceof Teacher){
            Teacher t = (Teacher) p;
            t.teach();
        }
        p.run();  //向下转型
        System.out.println(p.name);
    }
}

class Person {

    public String name = "person";

    public void run() {
        System.out.println("人在奔跑");
    }
}

class Student extends Person {
    public String name = "student";

    @Override
    public void run() {
        System.out.println("学生在奔跑");
    }
}

class Teacher extends Person {
    public String name = "teacher";

    @Override
    public void run() {
        System.out.println("教师在奔跑");
    }

    public void teach() {
        System.out.println("教师在教书");
    }
}

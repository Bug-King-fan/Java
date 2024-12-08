package Advanced.面向对象;

/**
 * @author Frank
 * @date 2024/09/29/10:35
 */

/*
深克隆：
    将对象本身开辟新空间，同时对于对象中引用数据类型约会开辟新的空间

浅克隆：
    仅仅将对象本身开辟新空间，对象的引用数据类型对象不会开辟新空间！
 */


public class 克隆_13 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建新对象复制st的属性值
        Address address = new Address();
        Stu2 st1 = new Stu2(10, "张三", address);
        Stu2 st2 = (Stu2) st1.clone();
        System.out.println(st1);
        System.out.println(st2);
    }
}

class Address implements Cloneable {
    private int p;

    @Override
    public String toString() {
        return "@" + Integer.toHexString(hashCode());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Stu2 implements Cloneable {
    private int age;
    private String name;
    private Address ad;

    public Stu2(int age, String name, Address ad) {
        this.age = age;
        this.name = name;
        this.ad = ad;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        //浅拷贝
//        return super.clone();
        //深拷贝
        Stu2 s = (Stu2) super.clone();
        s.ad = (Address) s.ad.clone();
        return s;
    }

    @Override
    public String toString() {
        return "Stu2{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", Address=" + ad +
                '}';
    }
}

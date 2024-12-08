package 流IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Frank
 * @date 2024/10/30/16:17
 */
/*
序列化流又称“对象操作流”：
    对象的序列化是指将对象信息转换为字节序列的过程。
注意：
    1、一个对象要想被序列化，必需实现Serializable接口。
        只要实现了Serializable接口，就会默认添加SerialVersionUID（会随着序列化操作，把其写入文件）
        但从文件读取时会比较流中UID和当前类的UID是否一致，如果不一致，会抛出异常
        只要改代码，写入时UID就会改变。
        """解决方案"""
            手动添加UID：private static final long serialVersionUID = [随意值]L;
    2、当处理多个对象是，需要借助集合实现
    3、如果不想一个成员属性被序列化，只需要添加关键字transient。
    对象操作输入流：
        ObjectInputStream
        创建对象：
            ObjectInputStream(InputStream in)
        方法：
             Object readObject()
    对象操作输出流：[除了写入到文件，还可以进行网络传输对象]
        ObjectOutputStream
        创建对象：
            ObjectOutputStream(OutputStream in)
        方法：
            void writeObject(Object obj)

 */
//Obj序列化流.txt
public class 序列化流_10 {
    public static void main(String[] args) {
        P p1 = new P("张三", 18, 1);
        P p2 = new P("李四", 19, 2);
        List<P> l = new ArrayList<>();
        Collections.addAll(l, p1, p2);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/流IO/file/Obj序列化流.txt"));
             ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("src/流IO/file/Obj序列化流.txt"));) {
            ous.writeObject(l);
//            P p3 = (P) ois.readObject();
//            System.out.println(p3);
            List<P> p3 = (List<P>) ois.readObject();
            p3.forEach((s) -> {
                System.out.println(s);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class P implements Serializable {
    private String name;
    private int age;
    //非序列化部分 transient
    private transient int sex;

    public P() {
    }

    public P(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "name='" + name + ' ' + "age=" + age + ' ' + "sex=" + sex;
    }
}
package 流IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

/**
 * @author Frank
 * @date 2024/10/28/18:37
 */
/*
Properties集合:
    是一个Map体系的集合类(存储数据 key 、 value)
    有跟IO有关的方法
    不需要加泛型，默认存储Obj类型，但工作中只存字符串
基本使用：
    作为集合使用：
        创建对象：
            Properties p = new Properties();
        方法：
            p.setProperty(String key,String value); 设置集合的键值 相当于put方法
            p.getProperty(String key); 获取集合的键值 相当于get方法
            Set<String> p.stringPropertyNames(); 获取集合中的所有key,相当于keySet方法
    结合IO使用：  开发中，通常会用到配置文件[XML文件、Properties文件等]
        创建对象：
            Properties p = new Properties();
        方法：
            p.load(InputStream is);  以字节流的形式，读取配置文件
            p.load(Reader reader);  以字符流的形式，读取配置文件
            p.store(Writer writer,String 注释内容); 以字符流的形式,写入配置文件,参数二为注释
            p.store(OutputStream os,String 注释内容); 以字节流的形式,写入配置文件，参数二为注释
 */

public class Properties集合_导入配置文件1_重点_05 {
    public static void main(String[] args) {
        if (false) {
            main1();
        } else {
            main2();
        }
    }

    public static void main1() {
        Properties p = new Properties();
        p.setProperty("Java", "java进阶课程");
        p.setProperty("MySql", "MySql进阶课程");
        p.setProperty("Hadoop", "Hadoop进阶课程");
        p.setProperty("HBase", "HBase进阶课程");
        p.setProperty("Hive", "Hive进阶课程");
        p.setProperty("HDFS", "HDFS进阶课程");
        System.out.println(p.get("Java"));
        System.out.println("_____________");

        Set<String> set = p.stringPropertyNames();
        set.forEach((s) -> {
            System.out.println(s + " " + p.get(s));
        });
    }

    public static void main2() {

        try (InputStream ios = new FileInputStream("src/流IO/file/05Properties.properties");) {
            Reader reader = new InputStreamReader(ios, StandardCharsets.UTF_8);
            Properties p = new Properties();
            p.load(ios);
            Set<String> set = p.stringPropertyNames();
            set.forEach((s) -> {
                System.out.println(s + " " + p.get(s));
            });
            p.setProperty("Java", "1");
            p.setProperty("MySql", "2");
            p.setProperty("Hadoop", "3");
            p.setProperty("HBase", "4");
            p.setProperty("Hive", "5");
            p.setProperty("HDFS", "6");
            p.store(new FileOutputStream("src/流IO/file/05Properties.properties"), "注释");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
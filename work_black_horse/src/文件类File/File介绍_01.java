package 文件类File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Frank
 * @date 2024/10/22/21:34
 */

/*
File类可以操作硬盘读写数据

获取对象：(文件对象存不存在都可以表示，后期可以通过创建方法创建文件对象)
    public File(String pathname) 根据路径创建文件对象
    public File(String parent, String child) 根据父路径和子路径名字创建文件对象
    public File(File parent, String child)  根据父路径对应文件对象和子路径名字创建文件对象
方法：
    创建方法：
        crateNewFile() 创建文件
        boolean mkdir() 创建文件夹(!!没用 全部用mkdirs())
        boolean mkdirs() 创建单机/多级文件夹
    遍历方法：
        public File[] listFiles() 获取当前目录下所有的“一级文件对象”到一个文件对象数组中返回(重点)
        public String[] list() 获取当前目录下所有的“一级文件名字”到一个字符串数组中返回
        注意：listFiles()：
            1、当主调是文件，或路径不存在时，返回null
            2、当文件时空文件夹时，返回长度为0的数组
            3、当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹（包含隐藏内容）路径放在file数组中返回
            4、当主调文件是一个文件夹，但没有访问权限时，返回null
    其他方法：
        isFile() 判断是否是文件
        isDirectory() 判断是否是文件夹
        delete() 删除文件
        exists() 判断文件是否存在
        length() 获取文件大小,返回字节个数
        long lastModified() 获取文件最后修改时间
        getAbsolutePath() 获取文件绝对路径
        getName() 获取文件名
        getParent() 获取文件父路径
        getParentFile() 获取文件父路径对应的文件对象
 */

public class File介绍_01 {
    public static void main(String[] args) throws IOException {
        File fi = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file\\a.txt");
        System.out.println(fi.getName());
        File fi2 = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file", "a.txt");
        System.out.println(fi2.getName());
        File fi3 = new File(new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file"), "a.txt");
        System.out.println(fi3.getName());

        //相对路径：相对于当前项目的路径（省略项目路径可以不写！！！）
        File fi4 = new File("src\\文件类File\\file\\c.txt");
        fi4.createNewFile();
        Date da = new Date();
        da.setTime(fi4.lastModified());
        String ti = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(da);
        System.out.println(ti);
        System.out.println("________________________");

        //mkdir() 创建文件夹
        File f = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file\\d");
        System.out.println(f.mkdir());
        //mkdirs() 创建多级文件夹
        File ff = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file\\e\\f");
        System.out.println(ff.mkdirs());
        System.out.println("_________________________");
        //listFiles() 获取当前目录下所有的“一级文件对象”到一个文件对象数组中返回
        File[] files = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file").listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("+++++++++++++++++++++++++");
        //list() 获取当前目录下所有的“一级文件名字”到一个字符串数组中返回
        String[] names = new File("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file").list();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("_________________________");
        //exists() 判断文件是否存在
        if (fi.exists()) {
            System.out.println("文件存在");
        }
        //isFile() 判断是否是文件
        if (fi.isFile()) {
            System.out.println("是文件");
        } else {
            System.out.println("不是文件");
        }
        //isDirectory() 判断是否是文件夹
        if (fi.isDirectory()) {
            System.out.println("是文件夹");
        } else {
            System.out.println("不是文件夹");
        }
        //length() 获取文件大小，返回字节个数
        System.out.println(fi.length());
        //getAbsolutePath() 获取文件绝对路径
        System.out.println(fi.getAbsolutePath());
        //getName() 获取文件名
        System.out.println(fi.getName());
        //getParent() 获取文件父路径
        System.out.println(fi.getParent());
        //getParentFile() 获取文件父路径对应的文件对象
        File fi6 = fi.getParentFile();
        System.out.println("_________________________");
        //案例
        int count = fileCount("E:\\JavaCode\\work_black_horse\\src\\文件类File\\file", ".txt");
        System.out.println(count);
    }

    //案例指定目录下查找指定后缀文件个数
    public static int fileCount(String path, String suffix) {
        File f = new File(path);
        File[] files = f.listFiles();
        int count = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(suffix)) {
                count++;
            } else {
                count += fileCount(file.getAbsolutePath(), suffix);
            }
        }
        return count;
    }
}
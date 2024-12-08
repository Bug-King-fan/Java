package 流IO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author Frank
 * @date 2024/10/31/11:40
 */

/*
1、导包：https://commons.apache.org/proper/commons-io
2、移动：将下载的包复制到指定项目的lib【新建】目录下
3、加载：将包加入到项目中[右键，添加为库]

主要学习：IOUtils[针对IO流做读写操作] 、 FileUtils[针对File对象进行读写操作]

IOUtils:
    static int copy(InputStream,OutputStream) 复制文件，适用于 2G 以下文件，返回字节个数
    static long copyLarge(InputStream,OutputStream) 复制文件，适用于 2G 以上文件，返回字节个数

FileUtils：
    static void copyFileToDirectory(final File,final File) 复制文件到另一个目录下
    static void copyDirectoryToDirectory(File,File) 复制目录到另一个目录下
 */

public class Commons_io工具包_12 {
    public static void main(String[] args) {

    }

    //IOUtils
    public static void copy1(String src, String dest) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);
        IOUtils.copy(in, out);
        in.close();
        out.close();
    }

    //FileUtils
    public static void copy2(String src, String dest) throws IOException {
        File f1 = new File(src);
        File f2 = new File(dest);
        FileUtils.copyDirectoryToDirectory(f1, f2);
    }

}
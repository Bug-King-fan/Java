package 流IO;

import java.io.*;

/**
 * @author Frank
 * @date 2024/10/24/18:50
 */

/*
通常Throws不可取的
应使用：(JDK7以后) 此语句确保资源在语句结束时自动关闭，不需要写finally语句块
自动释放资源的前提：实现了AutoCloseable接口
    try(创建流对象语句1 ; 创建流对象语句2 ····· ){
        读写数据
    }catch(Exception e){

    }
 */

public class IO资源处理TryWithResources_03 {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("src\\流IO\\19.jpg");
             OutputStream fos = new FileOutputStream("src\\流IO\\file\\19_copy.jpg");) {
            int d = 0;
            while ((d = in.read()) != -1) {
                fos.write(d);
            }
        } catch (IOException e) {
            throw new RuntimeException("发生异常图片复制失败");
        }
    }

    //复制文件


}
